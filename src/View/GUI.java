package View;

import Control.Carta;
import Model.Dificuldade;
import Control.Jogo;
import Model.Persistencia;
import Control.Player;
import Control.Score;
import Model.Som;
import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Container;
import java.awt.FlowLayout;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.util.ArrayList;
import java.util.Random;
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
import javax.swing.JTextField;
import javax.swing.Timer;
import javax.swing.WindowConstants;

/**
 *
 * @author Leonardo Baiser <lpbaiser@gmail.com>
 * @since
 */
public class GUI extends JFrame implements ActionListener {

    Container cp = new Container();
    JPanel painel;
    JMenuBar menuBar = new JMenuBar();
    JMenu jogoMenu = new JMenu("Jogo");
    JMenuItem novoJogo = new JMenuItem("Novo Jogo");
    JMenuItem viewRanking = new JMenuItem("Ranking");
    JMenuItem sair = new JMenuItem("Sair");

    int seg;

    JLabel jlTempo = new JLabel();
    JLabel jlT = new JLabel("Tempo");

    //Painel Inicial
    JPanel painelInicial;
    JButton btnOk = new JButton("Iniciar Jogo");
    JTextField txtNick = new JTextField(10);
    //--

    //JPanel Cartas
    JPanel painelCartas;
    //

    private Jogo jogo = new Jogo();
    private Player player = new Player();
    private Score score = new Score();
    private Som som = new Som();
    Random gerador = new Random();
    int n;
    private Dificuldade d;
    private int dificuldade;
    ArrayList<Integer> numeros;
    JButton[][] vBtn;
    JComboBox cbDificuldade = new JComboBox();

    private Carta cartas[] = new Carta[2];
    private int qtdeAcertos = 0;
    private int qtdeClique = 0;

    Timer t;
    tempo tmp;

    public GUI() {
        setTitle("JOGO DA MEMÓRIA");
        setJMenuBar(menuBar);
        menuBar.add(jogoMenu);
        jogoMenu.add(novoJogo);
        jogoMenu.add(viewRanking);
        jogoMenu.add(sair);

        cbDificuldade.addItem("12 Peças");
        cbDificuldade.addItem("24 Peças");
        cbDificuldade.addItem("36 Peças");

//        painel = new JPanel();
        cp = getContentPane();

        cp.setLayout(new BorderLayout());

        dificuldade = 0;

        novoJogo.setEnabled(false);

        t = new Timer(600, taskPerformer);

        cbDificuldade.addActionListener(new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent e) {

                novoJogo(cbDificuldade.getSelectedIndex());

            }
        });

        viewRanking.addActionListener(new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent e) {
                FrameListaRanking painelRanking = new FrameListaRanking();
                painelRanking.setVisible(true);
//                cp.add(painelRanking, BorderLayout.CENTER);
//                cp.validate();

            }
        });

        novoJogo.addActionListener(new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent e) {
                novoJogo(0);
            }
        });

        btnOk.addActionListener(new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent e) {
                if (txtNick.getText().isEmpty()) {
                    JOptionPane.showMessageDialog(rootPane, "Digite um nick!");
                } else {
                    novoJogo.setEnabled(true);
                    novoJogo(0);
                    player.setNamePlayer(txtNick.getText());
                    painelInicial.setVisible(false);
                    cp.add(painelCartas);

                }
            }
        });

        sair.addActionListener(new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent e) {
                System.exit(0);
            }
        });

        painelInicial = painelInicial();
        cp.add(painelInicial);

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

    public JPanel criaPainelCartas(Dificuldade d) {

        JPanel painelCartas = new JPanel();

        vBtn = d.geraVetorJButton();
        JButton btn = new JButton();
        GridLayout layout = new GridLayout(d.getnLinhas(), d.getnColunas());
        painelCartas.setLayout(layout);
        for (int i = 0; i < d.getnLinhas(); i++) {
            for (int j = 0; j < d.getnColunas(); j++) {
                btn = vBtn[i][j];
                btn.requestFocus(false);
                btn.addActionListener(this);

                painelCartas.add(btn);
            }
        }
        painelCartas.setBackground(Color.BLUE);

        return painelCartas;
    }

    public JPanel painelInicial() {
        JPanel painelIncial = new JPanel();

        JPanel centro = new JPanel();
        FlowLayout layout = new FlowLayout(FlowLayout.CENTER);

        centro.setLayout(layout);

        centro.add(new JLabel("Digite um nick:"));
        centro.add(txtNick);
        centro.add(btnOk);

        centro.setBackground(Color.lightGray);

        painelIncial.add(centro, BorderLayout.CENTER);

        return painelIncial;
    }

    public void novoJogo(int dificuldade) {

        qtdeAcertos = 0;
        qtdeClique = 0;
        try {
            cp.remove(painelCartas);
            cp.remove(painel);
        } catch (Exception ex) {
            System.out.println("erro:" + ex.getMessage());
        }
        painel = new JPanel();
        painel.add(new JLabel("Escolha uma dificuldade: "));
        painel.add(cbDificuldade);
        painel.add(jlT);
        painel.add(jlTempo);
        painel.setBackground(Color.lightGray);
        cp.add(painel, BorderLayout.NORTH);

        if (dificuldade == 0) {
            d = new Dificuldade(12);
            score.setDificuldade(0);
            painelCartas = criaPainelCartas(d);
        } else if (dificuldade == 1) {
            d = new Dificuldade(24);
            score.setDificuldade(1);
            painelCartas = criaPainelCartas(d);
        } else if (dificuldade == 2) {
            d = new Dificuldade(36);
            score.setDificuldade(2);
            painelCartas = criaPainelCartas(d);

        }

        jogo.setDificuldade(d);
        jogo.setPlayer(player);

//        start = System.currentTimeMillis();
        tmp = new tempo();
        tmp.start();

        cp.add(painelCartas, BorderLayout.CENTER);
        cp.validate(); //Atualiza o Painel
    }

    public void acaoBotao(String acao) {
        String aux[] = acao.split("-");//quebra o valor do action, o action passa uma string que contem numero da carta, linha e coluna do matriz
        int linha = Integer.parseInt(aux[1]);
        int coluna = Integer.parseInt(aux[2]);

        Carta c = new Carta();
        c.setColuna(coluna);
        c.setLinha(linha);
        c.setNumCarta(aux[0]);
        cartas[qtdeClique] = c;
        qtdeClique++;

        ImageIcon icone = new ImageIcon(getClass().getResource("/icones/" + aux[0] + ".png"));

        vBtn[linha][coluna].setIcon(icone);
        vBtn[linha][coluna].setEnabled(false);
        vBtn[linha][coluna].repaint();
        vBtn[linha][coluna].validate();

        painelCartas.repaint();
        painelCartas.validate();
        cp.repaint();
        cp.validate();

        if (qtdeClique == 2) {
            score.addNumTentativas();

            n = gerador.nextInt(3);//random som

            if (!(cartas[0].getNumCarta().equals(cartas[1].getNumCarta()))) {

                if (n == 1) {
                    som.music("Errou");
                }

                score.setAcertoConsecutivo(0);
                System.out.println("Errou");

                t.setRepeats(false);
                t.start();
            } else if (cartas[0].getNumCarta().equals(cartas[1].getNumCarta())) {
                // contabiliza o ponto de acerto
                score.addAcertoConsecutivo();
                qtdeAcertos++;
                //Gera um valor random para ativar um som 
                //O valor random é para nao ativar o som a todo momento

                if (n == 1) {
                    som.music("Acerto");
                } else if (score.getAcertoConsecutivo() == 3) {
                    som.music("PegandoFogo");
                }

                System.out.println("Acertou");
                vBtn[cartas[0].getLinha()][cartas[0].getColuna()]
                        .setEnabled(false);
                vBtn[cartas[1].getLinha()][cartas[1].getColuna()]
                        .setEnabled(false);

                cartas = new Carta[2];
            }
            qtdeClique = 0;
        }
        if (jogo.verificaFimJogo(qtdeAcertos)) {

            tmp.stop();
            int te = Integer.parseInt(jlTempo.getText());

            score.setTempo(te);

            int pontuacao = score.calcScore();
            score.setPontos(pontuacao);
            int resposta = JOptionPane.showConfirmDialog(null, "Fim de jogo! \n Sua pontuação é: " + pontuacao + "\nDeseja iniciar um novo jogo?", "Score", JOptionPane.YES_NO_OPTION);

            if (resposta == JOptionPane.YES_OPTION) {
                novoJogo(0);
            }

            jogo.gravaJogo(score);
            seg=0;

        }

    }

    public class tempo extends Thread {

        public void run() {
            while (true) {
                try {
                    Thread.sleep(1000);
                } catch (Exception e) {

                }
                seg++;
                jlTempo.setText(seg + "");
            }
        }
    }

    @Override
    public void actionPerformed(ActionEvent e) {

        String action = e.getActionCommand();
        acaoBotao(action);

    }

    ActionListener taskPerformer = new ActionListener() {
        public void actionPerformed(ActionEvent evt) {

            vBtn[cartas[0].getLinha()][cartas[0].getColuna()].setIcon(null);
            vBtn[cartas[1].getLinha()][cartas[1].getColuna()].setIcon(null);
            vBtn[cartas[0].getLinha()][cartas[0].getColuna()].setEnabled(true);
            vBtn[cartas[1].getLinha()][cartas[1].getColuna()].setEnabled(true);
        }
    };

    public static void main(String[] args) {
        new GUI();
    }

}
