package Cenario;

import Jogo.Carta;
import Jogo.Dificuldade;
import Jogo.Persistencia;
import Jogo.Player;
import Jogo.Score;
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
    private int acertosConsecutivos = 0;
    private long start;
    private long finish;
    
    Listener listener = null;

    public PainelCartas(Dificuldade d) {
        this.d = d;
        System.out.println("d" + d.getnColunas() + "  li " + d.getnLinhas());

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
        s.addNumTentativas();

        ImageIcon icone = new ImageIcon(getClass().getResource("/icones/" + aux[0] + ".png"));

        vBtn[linha][coluna].setIcon(icone);

        if (qtdeClique == 2) {

            if (!(cartas[0].getNumCarta().equals(cartas[1].getNumCarta()))) {

                try {
                    Thread.sleep(1000);// nao esta funcionando corretamente
                } catch (InterruptedException e2) {
                    // TODO Auto-generated catch block
                    e2.printStackTrace();
                }

                s.setAcertoConsecutivo(0);
                
                vBtn[cartas[0].getLinha()][cartas[0].getColuna()].setIcon(null);
                vBtn[cartas[1].getLinha()][cartas[1].getColuna()].setIcon(null);
                System.out.println("Errou");

            } else if (cartas[0].getNumCarta().equals(cartas[1].getNumCarta())) {
                // contabiliza o ponto de acerto
                s.addAcertoConsecutivo();
                System.out.println("Acertou");
                vBtn[cartas[0].getLinha()][cartas[0].getColuna()]
                        .setEnabled(false);
                vBtn[cartas[1].getLinha()][cartas[1].getColuna()]
                        .setEnabled(false);

            }
            cartas = new Carta[2];
            qtdeClique = 0;
        }
        if (s.getNumTentativas() == ((d.getnLinhas() * d.getnColunas()) / 2)) {
            Player p = new Player();
            finish = System.currentTimeMillis();
            long tempo = ((finish - start) / 1000);
            s.setTempo((int) tempo);
            float pontuacao = p.getScore().calcScore();
            s.setPontos(pontuacao);
            p.setScore(s);
            System.out.println("Score: Tenta " + s.getNumTentativas() + " N Acerto" + s.getAcertoConsecutivo() + " Pontos: " + s.getPontos() + " Tempo: " + s.getTempo());
            Persistencia persist = new Persistencia();
            persist.gravaPlayer(p);
            JOptionPane.showMessageDialog(this, "Fim de jogo! \n sua pontuação é: " + pontuacao);
            listener.dadoTransmitido(p, "player");//passar o Player
            
        }

    }

   

}
