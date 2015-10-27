package Cenario;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.Collections;

import javax.swing.JButton;

public class Dificuldade{
	
	JButton[][] vBtn;
	int nLinhas;
	int nColunas;

	ActionListener actionL = new ActionListener() {
		
		@Override
		public void actionPerformed(ActionEvent e) {
			
			String nome = e.getActionCommand();
			System.out.println(nome);
			
		}
	};
	
	public JButton[][] geraVetorJButton(ArrayList<Integer>numeros) {
		vBtn = new JButton[nLinhas][nColunas];
		
		
		
		for (int i = 0; i < (nLinhas); i++) {
			for (int j = 0; j < nColunas; j++) {
				JButton b = new JButton();
				b.addActionListener(actionL);
				b.setActionCommand(String.valueOf(i));
				vBtn[i][j] = b;
			}
			
		}	
		
		return vBtn;
	}

	
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
