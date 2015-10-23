package Cenario;

import java.awt.BorderLayout;
import java.awt.Container;
import java.awt.Panel;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.util.ArrayList;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.WindowConstants;

public class GUI extends JFrame implements ActionListener {
	Dificuldade d = new Dificuldade();
	JPanel j = new JPanel();
	ArrayList<Integer> numeros;
	Container cp = new Container();
	
	public GUI() {
		setTitle("JOGO DA MEMORIA");
		setSize(600, 600);
//		cp = getContentPane();

		numeros = d.random(12);
		j = d.geraCenario(numeros);

//		cp.setLayout(new BorderLayout());
//		cp.add(j, BorderLayout.CENTER);
		add(j);
		setVisible(true);
		setLocationRelativeTo(null);
		setDefaultCloseOperation(WindowConstants.DO_NOTHING_ON_CLOSE);
		addWindowListener(new WindowAdapter() {
			public void windowClosing(WindowEvent e) {
				System.exit(0);
			}
		});

	}

	public void actionPerformed(ActionEvent e) {
		System.out.println("ACERTO MISERAVI");
		String nome = e.getActionCommand();
		for (Integer integer : numeros) {
			if (nome.equals(integer.toString())) {
				System.out.println(nome);
			}

		}
	}

}
