package Cenario;

import java.awt.Container;
import java.awt.GridLayout;
import java.util.ArrayList;
import java.util.Collections;

import javax.swing.JButton;
import javax.swing.JComponent;
import javax.swing.JPanel;

public class Dificuldade implements Cenario {

	@Override
	public JPanel geraCenario(ArrayList<Integer>numeros) {
		JPanel panel = new JPanel();
		int colunas = 4;
		GridLayout layout = new GridLayout(0, colunas);
		panel.setLayout(layout);
		for (Integer i : numeros) {
			JButton b = new JButton();
			b.addActionListener(panel);
			b.setActionCommand(i.toString());
			panel.add(b);
		}
		return panel;
	}

	@Override
	public ArrayList<Integer> random(int tamanho) {
		ArrayList<Integer> numeros = new ArrayList<>();
		for (int i = 0, j = 0; i < (tamanho - 1); i += 2) {

			numeros.add(j);
			numeros.add(j);
			j++;
		}
		Collections.shuffle(numeros);

		return numeros;
	}

}
