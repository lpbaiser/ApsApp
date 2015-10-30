package Cenario;

/**
*
* @author Emanuel Mazzer & Leonardo Baiser 
* @version 1.0
* @since 19/10/2015
*/

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.Collections;

import javax.swing.ImageIcon;
import javax.swing.JButton;

import Jogo.Carta;

public class Cenario {

	JButton[][] vBtn;
	int nLinhas;
	int nColunas;
	private int qtdeClique = 0;
	private Carta cartas[] = new Carta[2];
	

	ActionListener actionL = new ActionListener() {

		@Override
		public void actionPerformed(ActionEvent e) {
			if (qtdeClique == 2) {
				if (cartas[0].getNumCarta() != cartas[1].getNumCarta()){
					//retornas as cartas no estado inicial
					ImageIcon def = new ImageIcon(getClass().getResource("/icones/default.png"));
					vBtn[cartas[0].getLinha()][cartas[0].getColuna()].setIcon(def);
					vBtn[cartas[1].getLinha()][cartas[1].getColuna()].setIcon(def);
					System.out.println("Errou");
				}else{
					//contabiliza o ponto de acerto
					System.out.println("Acertou");
				}
				qtdeClique = 0;
			}
			
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
			System.out.println("pos: " + aux[0] + "linha: " + linha
					+ "coluna: " + coluna);

		}
	};

	public JButton[][] geraVetorJButton(ArrayList<Integer> numeros) {
		vBtn = new JButton[this.nLinhas][this.nColunas];
		int aux = 0;
		for (int i = 0; i < (this.nLinhas); i++) {
			for (int j = 0; j < this.nColunas; j++) {
				JButton b = new JButton();
				b.addActionListener(this.actionL);
				b.setActionCommand(String.valueOf(numeros.get(aux) + "-" + i
						+ "-" + j));
				// b.setEnabled(false);
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
