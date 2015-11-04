package Jogo;

import java.awt.Color;
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

    private int numBtns;
    int nLinhas;
    int nColunas;
    JButton[][] vBtn;
    ArrayList<Integer> numeros;
    
    public Dificuldade(int dificuldade){
        if (dificuldade == 12){
            this.nColunas = 4;
            this.nLinhas = 3;
            this.numBtns = 12;
        }else if (dificuldade == 24){
            this.nColunas = 6;
            this.nLinhas = 4;
            this.numBtns = 24;
        }else if (dificuldade == 36){
            this.nColunas = 6;
            this.nLinhas = 6;
            this.numBtns = 36;
        }
    }
    
    public JButton[][] geraVetorJButton() {
        numeros = random(this.numBtns);
	vBtn = new JButton[this.nLinhas][this.nColunas];
	int aux = 0;
	for (int i = 0; i < (this.nLinhas); i++) {
	    for (int j = 0; j < this.nColunas; j++) {
		JButton b = new JButton();
		ImageIcon def = new ImageIcon(getClass().getResource("/icones/fundo.png"));
                b.setSize(10, 10);
//		b.addActionListener(this.actionL);
//                b.setBackground(Color.red);
                b.setBorderPainted(false);
//                b.setBounds(0, 0, 2, 2);
                
		b.setActionCommand(String.valueOf(numeros.get(aux) + "-" + i+ "-" + j));
                
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

    public int getNumBtns() {
        return numBtns;
    }

    public void setNumBtns(int numBtns) {
        this.numBtns = numBtns;
    }
    
    
    

}
