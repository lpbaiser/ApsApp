package Jogo;

import java.util.ArrayList;
import java.util.Collections;

import javax.swing.ImageIcon;
import javax.swing.JButton;

/**
 * @author Leonardo P. Baiser <lpbaiser@gmail.com>
 * @version 1.0
 * @since
 */

public class Dificuldade {

    int nLinhas;
    int nColunas;
    JButton[][] vBtn;

    public JButton[][] geraVetorJButton(ArrayList<Integer> numeros) {
	vBtn = new JButton[this.nLinhas][this.nColunas];
	int aux = 0;
	for (int i = 0; i < (this.nLinhas); i++) {
	    for (int j = 0; j < this.nColunas; j++) {
		JButton b = new JButton();
		ImageIcon def = new ImageIcon(getClass().getResource(
			"/icones/default.png"));
//		b.addActionListener(this.actionL);
		b.setActionCommand(String.valueOf(numeros.get(aux) + "-" + i
			+ "-" + j));
		b.setIcon(def);
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

    /**
     * @return the nLinhas
     */
    public int getnLinhas() {
	return nLinhas;
    }

    /**
     * @param nLinhas
     *            the nLinhas to set
     */
    public void setnLinhas(int nLinhas) {
	this.nLinhas = nLinhas;
    }

    /**
     * @return the nColunas
     */
    public int getnColunas() {
	return nColunas;
    }

    /**
     * @param nColunas
     *            the nColunas to set
     */
    public void setnColunas(int nColunas) {
	this.nColunas = nColunas;
    }

}
