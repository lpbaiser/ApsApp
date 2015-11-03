package Cenario;

/**
 *
 * @author Emanuel Mazzer & Leonardo Baiser 
 * @version 1.0
 * @since 19/10/2015
 */

import java.awt.BorderLayout;
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
import javax.swing.JPanel;
import javax.swing.WindowConstants;
import javax.swing.border.Border;

import Jogo.Carta;
import Jogo.Dificuldade;
import Jogo.Player;

public class GUI extends JFrame implements ActionListener {
    // Cenario d = new Cenario();
    JPanel painelCartas = new JPanel();
    JPanel painel = new JPanel();
    Container cp = new Container();

    private Player player;
    private Dificuldade dificuldade;
    private GUI gui;
    ArrayList<Integer> numeros;
    JButton[][] vBtn;
    JComboBox cbDificuldade = new JComboBox();

    private int qtdeClique = 0;
    private int qtdeAcertos = 0;
    private Carta cartas[] = new Carta[2];
    private int nLinhas = 0;
    private int nColunas = 0;

    public GUI() {
	setTitle("JOGO DA MEMORIA");
	setSize(1024, 768);
	this.vBtn = vBtn;

	cbDificuldade.addItem("12 Peças");
	cbDificuldade.addItem("24 Peças");
	cbDificuldade.addItem("36 Peças");

	painel = new JPanel();
	 cp = getContentPane();

	// painelCartas = geraCenario(vBtn, 3, 4);
	// al = d.actionL;

	 cp.setLayout(new BorderLayout());
	// cp.add(j, BorderLayout.CENTER);
	

	dificuldade = new Dificuldade();
	numeros = dificuldade.random(12);
	dificuldade.setnColunas(4);
	dificuldade.setnLinhas(3);
	vBtn = dificuldade.geraVetorJButton(numeros);
	painelCartas = geraCenario(vBtn, dificuldade.getnLinhas(),
		dificuldade.getnColunas());
	cbDificuldade.addActionListener(new ActionListener() {

	    @Override
	    public void actionPerformed(ActionEvent e) {
		if (cbDificuldade.getSelectedIndex() == 0) {
		    dificuldade = new Dificuldade();
		    numeros = dificuldade.random(12);
		    dificuldade.setnColunas(4);
		    dificuldade.setnLinhas(3);
		    vBtn = dificuldade.geraVetorJButton(numeros);
		    cp.remove(painelCartas);
		    cp.repaint();
		    painelCartas = new JPanel();
		    painelCartas = geraCenario(vBtn, dificuldade.getnLinhas(),dificuldade.getnColunas());
		    cp.add(painelCartas, BorderLayout.CENTER);
//		    repaint();
		} else if (cbDificuldade.getSelectedIndex() == 1) {
		    dificuldade = new Dificuldade();
		    numeros = dificuldade.random(24);
		    dificuldade.setnColunas(6);
		    dificuldade.setnLinhas(4);
		    vBtn = dificuldade.geraVetorJButton(numeros);
		    cp.remove(painelCartas);
//		    cp.repaint();
		    painelCartas = new JPanel();
		    painelCartas = geraCenario(vBtn, dificuldade.getnLinhas(),dificuldade.getnColunas());
		    cp.add(painelCartas, BorderLayout.CENTER);
		    painelCartas.repaint();
		    cp.repaint();
		    
//		    repaint();

		} else if (cbDificuldade.getSelectedIndex() == 2) {
		    dificuldade = new Dificuldade();
		    numeros = dificuldade.random(36);
		    dificuldade.setnColunas(6);
		    dificuldade.setnLinhas(6);
		    vBtn = dificuldade.geraVetorJButton(numeros);
		    remove(painelCartas);
		    repaint();
		    painelCartas = new JPanel();
		    painelCartas = geraCenario(vBtn, dificuldade.getnLinhas(),dificuldade.getnColunas());
		    add(painelCartas, BorderLayout.CENTER);
		    repaint();
		    
		}

	    }
	});

	painel.add(new JLabel("Escolha uma dificuldade: "));
	painel.add(cbDificuldade);
	cp.add(painel, BorderLayout.NORTH);
	cp.add(painelCartas, BorderLayout.CENTER);
	
	
	setVisible(true);
	setLocationRelativeTo(null);
	setDefaultCloseOperation(WindowConstants.DO_NOTHING_ON_CLOSE);
	addWindowListener(new WindowAdapter() {
	    public void windowClosing(WindowEvent e) {
		System.exit(0);
	    }
	});

    }

    public JPanel geraCenario(JButton[][] vBtn, int nLinha, int nColuna) {
	JPanel panel = new JPanel();
	GridLayout layout = new GridLayout(nLinha, nColuna);
	panel.setLayout(layout);
	for (int i = 0; i < nLinha; i++) {
	    for (int j = 0; j < nColuna; j++) {
//		System.out.println("i: " + i + " j: " + j);
		vBtn[i][j].addActionListener(this);
		panel.add(vBtn[i][j]);
	    }
	}
	return panel;
    }

    @Override
    public void actionPerformed(ActionEvent e) {

	String action = e.getActionCommand();
	String aux[] = action.split("-");
	int linha = Integer.parseInt(aux[1]);
	int coluna = Integer.parseInt(aux[2]);

	Carta c = new Carta();
	c.setColuna(coluna);
	c.setLinha(linha);
	c.setNumCarta(aux[0]);
	cartas[qtdeClique] = c;
	qtdeClique++;

	System.out.println("icones/" + aux[0] + ".png");
	ImageIcon icone = new ImageIcon(getClass().getResource(
		"/icones/" + aux[0] + ".png"));

	vBtn[linha][coluna].setIcon(icone);
	System.out.println("pos: " + aux[0] + "linha: " + linha + "coluna: "
		+ coluna);

	if (qtdeClique == 2) {

	    if (!(cartas[0].getNumCarta().equals(cartas[1].getNumCarta()))) {

		try {
		    Thread.sleep(1000);// não esta funcionando corretamente
		} catch (InterruptedException e2) {
		    // TODO Auto-generated catch block
		    e2.printStackTrace();
		}

		// retornas as cartas no estado inicial
		ImageIcon def = new ImageIcon(getClass().getResource(
			"/icones/default.png"));
		vBtn[cartas[0].getLinha()][cartas[0].getColuna()].setIcon(def);
		vBtn[cartas[1].getLinha()][cartas[1].getColuna()].setIcon(def);
		System.out.println("Errou");

	    } else if (cartas[0].getNumCarta().equals(cartas[1].getNumCarta())) {
		// contabiliza o ponto de acerto
		qtdeAcertos++;
		System.out.println("Acertou");
		vBtn[cartas[0].getLinha()][cartas[0].getColuna()]
			.setEnabled(false);
		vBtn[cartas[1].getLinha()][cartas[1].getColuna()]
			.setEnabled(false);

	    }
	    cartas = new Carta[2];
	    qtdeClique = 0;
	    // delay1s();
	}
	System.out.println("atdeA: " + qtdeAcertos + " tam btn"
		+ ((nLinhas * nColunas) / 2));
	if (qtdeAcertos == ((nLinhas * nColunas) / 2)) {
	    System.out.println("Fim de jogo");
	    return;
	}

    }

}
