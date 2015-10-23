package Cenario;

import java.awt.BorderLayout;
import java.awt.Container;
import java.awt.Panel;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

import javax.swing.JFrame;
import javax.swing.JPanel;

public class GUI extends JFrame implements ActionListener {
	Dificuldade d = new Dificuldade();
	JPanel j = new JPanel();
	ArrayList<Integer> numeros;
	Container cp = new Container();

	public GUI() {
		setTitle("JOGO DA MEMORIA");
		setSize(600, 600);
		cp = getContentPane();

		numeros = d.random(12);
		d.geraCenario(numeros);

		cp.setLayout(new BorderLayout());
		cp.add(j, BorderLayout.CENTER);
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		String nome = e.getActionCommand();
		for (Integer integer : numeros) {
			if (nome.equals(integer.toString())) {
				System.out.println(nome);
			}

		}
	}

}
