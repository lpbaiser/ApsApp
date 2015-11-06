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
import Jogo.Jogo;
import Jogo.Persistencia;
import Jogo.Player;
import java.awt.Color;
import java.lang.reflect.Array;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;

public class GUI extends JFrame {

    Container cp = new Container();
    JPanel painel = new JPanel();
    PainelCartas painelCartas;
    PainelInicial painelInicial;
    JMenuBar menuBar = new JMenuBar();
    JMenu jogoMenu = new JMenu("Jogo");
    JMenuItem novoJogo = new JMenuItem("Novo Jogo");
    JMenuItem viewRanking = new JMenuItem("Ranking");

    Jogo jogo = new Jogo();

    private Player player;
    private Dificuldade dificuldade;
    private GUI gui;
    ArrayList<Integer> numeros;
    JButton[][] vBtn;
    JComboBox cbDificuldade = new JComboBox();

    public GUI() {
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
        painel.setBackground(Color.lightGray);

        cp.add(painel, BorderLayout.NORTH);
        cp.add(painelCartas, BorderLayout.CENTER);

        this.setExtendedState(JFrame.MAXIMIZED_BOTH);

//        setVisible(true);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(WindowConstants.DO_NOTHING_ON_CLOSE);
        addWindowListener(new WindowAdapter() {
            public void windowClosing(WindowEvent e) {
                System.exit(0);
            }
        });

    }

  

}
