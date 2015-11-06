package Cenario;

import Jogo.Carta;
import Jogo.Dificuldade;
import Jogo.Jogo;
import Jogo.Persistencia;
import Jogo.Player;
import Jogo.Score;
import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Container;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.util.ArrayList;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.WindowConstants;

/**
 *
 * @author Leonardo Baiser <lpbaiser@gmail.com>
 * @since 
 */
public class GUI2 extends JFrame implements ActionListener{

    Container cp = new Container();
    JPanel painel = new JPanel();
    PainelCartas painelCartas;
    PainelInicial painelInicial;
    JMenuBar menuBar = new JMenuBar();
    JMenu jogoMenu = new JMenu("Jogo");
    JMenuItem novoJogo = new JMenuItem("Novo Jogo");
    JMenuItem viewRanking = new JMenuItem("Ranking");

    private Jogo jogo = new Jogo();
    private Player player = new Player();
    private Score score = new Score();
    private Dificuldade dificuldade;
    ArrayList<Integer> numeros;
    JButton[][] vBtn;
    JComboBox cbDificuldade = new JComboBox();
    
    private Carta cartas[] = new Carta[2];
     private int qtdeAcertos = 0;
     private int qtdeClique = 0;
    
    private long start;
    private long finish;
    
    public GUI2(){
        setTitle("JOGO DA MEMORIA");
        setJMenuBar(menuBar);
        menuBar.add(jogoMenu);
        jogoMenu.add(novoJogo);
        jogoMenu.add(viewRanking);

        cbDificuldade.addItem("12 Peças");
        cbDificuldade.addItem("24 Peças");
        cbDificuldade.addItem("36 Peças");

        painel = new JPanel();
        cp = getContentPane();

        cp.setLayout(new BorderLayout());

        dificuldade = new Dificuldade(12);
        

        cbDificuldade.addActionListener(new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent e) {
                cp.remove(painelCartas);
                if (cbDificuldade.getSelectedIndex() == 0) {
                    dificuldade = new Dificuldade(12);
                    painelCartas = new PainelCartas(dificuldade);
                } else if (cbDificuldade.getSelectedIndex() == 1) {
                    dificuldade = new Dificuldade(24);
                    painelCartas = new PainelCartas(dificuldade);
                } else if (cbDificuldade.getSelectedIndex() == 2) {
                    dificuldade = new Dificuldade(36);
                    painelCartas = new PainelCartas(dificuldade);

                }
                cp.add(painelCartas, BorderLayout.CENTER);
                cp.validate(); //Atualiza o Painel

            }
        });

        viewRanking.addActionListener(new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent e) {
                PainelListaRanking painelRanking = new PainelListaRanking();
                cp.add(painelRanking, BorderLayout.EAST);
                cp.validate();

            }
        });

        novoJogo.addActionListener(new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent e) {
                cp.remove(painelCartas);
                painelCartas = new PainelCartas(dificuldade);
                cp.add(painelCartas, BorderLayout.CENTER);
                cp.validate(); //Atualiza o Painel
            }
        });

        painel.add(new JLabel("Escolha uma dificuldade: "));
        painel.add(cbDificuldade);
        painel.setBackground(Color.lightGray);

        cp.add(painel, BorderLayout.NORTH);
        painelCartas(dificuldade);
        cp.add(painelCartas(dificuldade), BorderLayout.CENTER);
        
        this.setExtendedState(JFrame.MAXIMIZED_BOTH);

        setVisible(true);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(WindowConstants.DO_NOTHING_ON_CLOSE);
        addWindowListener(new WindowAdapter() {
            public void windowClosing(WindowEvent e) {
                System.exit(0);
            }
        });

    
        
    }
    
    public JPanel painelCartas(Dificuldade d){
        JPanel painelCartas = new JPanel();
        vBtn = d.geraVetorJButton();
        JButton btn = new JButton();
        GridLayout layout = new GridLayout(d.getnLinhas(), d.getnColunas());
        painelCartas.setLayout(layout);
        for (int i = 0; i < d.getnLinhas(); i++) {
            for (int j = 0; j < d.getnColunas(); j++) {
                btn = vBtn[i][j];
                btn.addActionListener(this);
                painelCartas.add(btn);
            }
        }
        setBackground(Color.BLUE);

//        repaint();

        start = System.currentTimeMillis();
        return painelCartas;
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
            score.addNumTentativas();

            if (!(cartas[0].getNumCarta().equals(cartas[1].getNumCarta()))) {

//                t1.start();
//                repaint();

                score.setAcertoConsecutivo(0);

                vBtn[cartas[0].getLinha()][cartas[0].getColuna()].setIcon(null);
                vBtn[cartas[1].getLinha()][cartas[1].getColuna()].setIcon(null);
                System.out.println("Errou");
                this.repaint();

            } else if (cartas[0].getNumCarta().equals(cartas[1].getNumCarta())) {
                // contabiliza o ponto de acerto
                score.addAcertoConsecutivo();
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
        if (qtdeAcertos == ((dificuldade.getnLinhas() * dificuldade.getnColunas())) / 2) {
            finish = System.currentTimeMillis();
            long tempo = ((finish - start) / 1000);
            score.setTempo((int) tempo);
            float pontuacao = score.calcScore();
            System.out.println("POntuaçao: " + pontuacao);
            score.setPontos(pontuacao);
            player.setScore(score);

            int resposta = JOptionPane.showConfirmDialog(null, "Fim de jogo! \n Sua pontuação é: " + pontuacao, "Score", JOptionPane.YES_NO_OPTION);

            
            
            if (resposta == JOptionPane.YES_OPTION) {
                String nick = JOptionPane.showInputDialog(this, "Digite seu nick: ");
                Persistencia persist = new Persistencia();
                player.setNome(nick);
                jogo.setPlayer(player);
                jogo.setDificuldade(dificuldade);
                persist.gravaPlayer(jogo);
                
            } 
            
    }
    
    }
        
    
}
