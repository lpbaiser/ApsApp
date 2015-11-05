package Cenario;

/**
 *
 * @author Emanuel Mazzer & Leonardo Baiser
 * @version 1.0
 * @since 19/10/2015
 */
import java.awt.BorderLayout;
import java.awt.Container;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.util.ArrayList;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.WindowConstants;

import Jogo.Dificuldade;
import Jogo.Player;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;

public class GUI extends JFrame {

    Container cp = new Container();
    JPanel painel = new JPanel();
    PainelCartas painelCartas;
    JMenuBar menuBar = new JMenuBar();
    JMenu jogoMenu = new JMenu("Jogo");
    JMenuItem novoJogo = new JMenuItem("Novo Jogo");
    JMenuItem viewRanking = new JMenuItem("Ranking");



    private Player player;
    private Dificuldade dificuldade;
    private GUI gui;
    ArrayList<Integer> numeros;
    JButton[][] vBtn;
    JComboBox cbDificuldade = new JComboBox();

    public GUI() {
        setTitle("JOGO DA MEMORIA");
        setSize(1024, 768);
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
        painelCartas = new PainelCartas(dificuldade);

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
        cp.add(painel, BorderLayout.NORTH);
        cp.add(painelCartas, BorderLayout.CENTER);
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

//    public JPanel geraCenario(JButton[][] vBtn, int nLinha, int nColuna) {
//        JPanel panel = new JPanel();
//        GridLayout layout = new GridLayout(nLinha, nColuna);
//        panel.setLayout(layout);
//        for (int i = 0; i < nLinha; i++) {
//            for (int j = 0; j < nColuna; j++) {
//                // System.out.println("i: " + i + " j: " + j);
//                vBtn[i][j].addActionListener(this);
//                panel.add(vBtn[i][j]);
//            }
//        }
//        return panel;
//    }
//
//    @Override
//    public void actionPerformed(ActionEvent e) {
//
//        String action = e.getActionCommand();
//        String aux[] = action.split("-");//quebra o valor do action, o action passa uma string que contem numero da carta, linha e coluna do matriz
//        int linha = Integer.parseInt(aux[1]);
//        int coluna = Integer.parseInt(aux[2]);
//
//        Carta c = new Carta();
//        c.setColuna(coluna);
//        c.setLinha(linha);
//        c.setNumCarta(aux[0]);
//        cartas[qtdeClique] = c;
//        qtdeClique++;
//
//        ImageIcon icone = new ImageIcon(getClass().getResource("/icones/" + aux[0] + ".png"));
//
//        vBtn[linha][coluna].setIcon(icone);
//
//        if (qtdeClique == 2) {
//
//            if (!(cartas[0].getNumCarta().equals(cartas[1].getNumCarta()))) {
//
//                try {
//                    Thread.sleep(1000);// nao esta funcionando corretamente
//                } catch (InterruptedException e2) {
//                    // TODO Auto-generated catch block
//                    e2.printStackTrace();
//                }
//
//                // retornas as cartas no estado inicial
//                ImageIcon def = new ImageIcon(getClass().getResource(
//                        "/icones/default.png"));
////				vBtn[cartas[0].getLinha()][cartas[0].getColuna()].setIcon(def);
////				vBtn[cartas[1].getLinha()][cartas[1].getColuna()].setIcon(def);
//                System.out.println("Errou");
//
//            } else if (cartas[0].getNumCarta().equals(cartas[1].getNumCarta())) {
//                // contabiliza o ponto de acerto
//                qtdeAcertos++;
//                System.out.println("Acertou");
//                vBtn[cartas[0].getLinha()][cartas[0].getColuna()]
//                        .setEnabled(false);
//                vBtn[cartas[1].getLinha()][cartas[1].getColuna()]
//                        .setEnabled(false);
//
//            }
//            cartas = new Carta[2];
//            qtdeClique = 0;
//            // delay1s();
//        }
////		System.out.println("atdeA: " + qtdeAcertos + " tam btn"+ ((nLinhas * nColunas) / 2));
//        if (qtdeAcertos == ((dificuldade.getnLinhas() * dificuldade.getnColunas()) / 2)) {
//            System.out.println("Fim de jogo");
////			return;
//        }
//
//    }
}
