package Cenario;

import java.awt.Container;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.util.ArrayList;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.WindowConstants;

public class GUI extends JFrame implements ActionListener {
	Dificuldade d = new Dificuldade();
	JPanel j = new JPanel();
	ArrayList<Integer> numeros;
	Container cp = new Container();
	JButton[][] vBtn;
	ActionListener al;
	JComboBox cbDificuldade = new JComboBox();

	public GUI() {
		setTitle("JOGO DA MEMORIA");
		setSize(600, 600);
		
		// cp = getContentPane();

		numeros = d.random(12);
		vBtn = d.geraVetorJButton(numeros);
		j = geraCenario(vBtn, 3, 4);
		al = d.actionL;

		// cp.setLayout(new BorderLayout());
		// cp.add(j, BorderLayout.CENTER);
		add(j);
		
//		vBtn[0][0].addActionListener(new ActionListener() {
//			
//			@Override
//			public void actionPerformed(ActionEvent e) {
//				System.out.println("Clicou");
//				
//			}
//		});
		
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
		int colunas = 4;
		GridLayout layout = new GridLayout(0, colunas);
		panel.setLayout(layout);
		for (int i = 0; i < nLinha; i++) {
			for (int j = 0; j < nColuna; j++) {
				panel.add(vBtn[i][j]);
			}
		}
		return panel;
	}

	

	@Override
	public void actionPerformed(ActionEvent e) {
		
//		al.actionPerformed(e);
		
		System.out.println("ACERTO MISERAVI");
		String nome = e.getActionCommand();
		System.out.println(nome);
		
		
	}

}
