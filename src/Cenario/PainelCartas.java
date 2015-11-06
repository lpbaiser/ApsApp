package Cenario;

import Jogo.Carta;
import Jogo.Dificuldade;
import Jogo.Jogo;
import Jogo.Persistencia;
import Jogo.Player;
import Jogo.Score;
import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.Timer;

/**
 *
 * @author Leonardo Baiser <lpbaiser@gmail.com>
 * @since 04/11/2015
 */
public class PainelCartas extends JPanel implements ActionListener {

    private int qtdeClique = 0;

    private Carta cartas[] = new Carta[2];
    private int nLinhas = 0;
    private int nColunas = 0;
    private JButton[][] vBtn;
    private Dificuldade d;
    ArrayList<Integer> numeros;
    Score s = new Score();
    private int qtdeAcertos = 0;
    private long start;
    private long finish;

    private Jogo jogo = new Jogo();
    private Player p = new Player();

    Timer t1;

    Listener listener = null;

    public PainelCartas(Dificuldade d) {
        this.d = d;
//        System.out.println("d" + d.getnColunas() + "  li " + d.getnLinhas());

        vBtn = d.geraVetorJButton();
        JButton btn = new JButton();
        GridLayout layout = new GridLayout(d.getnLinhas(), d.getnColunas());
        setLayout(layout);
        for (int i = 0; i < d.getnLinhas(); i++) {
            for (int j = 0; j < d.getnColunas(); j++) {
                btn = vBtn[i][j];
                btn.addActionListener(this);
                add(btn);
            }
        }
        setBackground(Color.BLUE);

        repaint();

        start = System.currentTimeMillis();

    }

    @Override
    public void actionPerformed(ActionEvent e) {
        String action = e.getActionCommand();
        String aux[] = action.split("-");//quebra o valor do action, o action passa uma string que contem numero da carta, linha e coluna do matriz
        int linha = Integer.parseInt(aux[1]);
        int coluna = Integer.parseInt(aux[2]);

        Carta c = new Carta();
        c.setColuna(coluna);
        c.setLinha(linha);
        c.setNumCarta(aux[0]);
        cartas[qtdeClique] = c;
        qtdeClique++;

        ImageIcon icone = new ImageIcon(getClass().getResource("/icones/" + aux[0] + ".png"));
        this.repaint();

        vBtn[linha][coluna].setIcon(icone);

        if (qtdeClique == 2) {
            s.addNumTentativas();

            if (!(cartas[0].getNumCarta().equals(cartas[1].getNumCarta()))) {

                t1.start();
                repaint();

                s.setAcertoConsecutivo(0);

                vBtn[cartas[0].getLinha()][cartas[0].getColuna()].setIcon(null);
                vBtn[cartas[1].getLinha()][cartas[1].getColuna()].setIcon(null);
                System.out.println("Errou");
                this.repaint();

            } else if (cartas[0].getNumCarta().equals(cartas[1].getNumCarta())) {
                // contabiliza o ponto de acerto
                s.addAcertoConsecutivo();
                qtdeAcertos++;
                System.out.println("Acertou");
                vBtn[cartas[0].getLinha()][cartas[0].getColuna()]
                        .setEnabled(false);
                vBtn[cartas[1].getLinha()][cartas[1].getColuna()]
                        .setEnabled(false);

            }
            cartas = new Carta[2];
            qtdeClique = 0;
        }
        if (qtdeAcertos == ((d.getnLinhas() * d.getnColunas())) / 2) {
            finish = System.currentTimeMillis();
            long tempo = ((finish - start) / 1000);
            s.setTempo((int) tempo);
            float pontuacao = s.calcScore();
            System.out.println("POntuaçao: " + pontuacao);
            s.setPontos(pontuacao);
            p.setScore(s);

            int resposta = JOptionPane.showConfirmDialog(null, "Fim de jogo! \n Sua pontuação é: " + pontuacao, "Score", JOptionPane.YES_NO_OPTION);

            
            
            if (resposta == JOptionPane.YES_OPTION) {
                String nick = JOptionPane.showInputDialog(this, "Digite seu nick: ");
                Persistencia persist = new Persistencia();
                p.setNome(nick);
                jogo.setPlayer(p);
                jogo.setDificuldade(d);
                persist.gravaPlayer(jogo);
                
            } 
            
            Listener l = null;
            l.fimJogo();
//            resposta = JOptionPane.showConfirmDialog(null, "Fim de jogo! \n Sua pontuação é: " + pontuacao, "Score", JOptionPane.YES_NO_OPTION);
                
//                this.validate();
//            setVisible(false);
            
        }


    }

}
