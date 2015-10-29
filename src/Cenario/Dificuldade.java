package Cenario;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.Collections;

import javax.swing.JButton;

public class Dificuldade {

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

	public JButton[][] geraVetorJButton(ArrayList<Integer> numeros) {
		vBtn = new JButton[this.nLinhas][this.nColunas];
		int aux = 0;
		for (int i = 0; i < (this.nLinhas); i++) {
			for (int j = 0; j < this.nColunas; j++) {
				JButton b = new JButton();
				b.addActionListener(this.actionL);
				b.setActionCommand(String.valueOf(numeros.get(aux)));
				b.setEnabled(false);
				vBtn[i][j] = b;
				aux++;
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

	public JButton[][] getvBtn() {
		return vBtn;
	}

	public void setvBtn(JButton[][] vBtn) {
		this.vBtn = vBtn;
	}

	public int getnLinhas() {
		return nLinhas;
	}

	public void setnLinhas(int nLinhas) {
		this.nLinhas = nLinhas;
	}

	public int getnColunas() {
		return nColunas;
	}

	public void setnColunas(int nColunas) {
		this.nColunas = nColunas;
	}

	public ActionListener getActionL() {
		return actionL;
	}

	public void setActionL(ActionListener actionL) {
		this.actionL = actionL;
	}

}
