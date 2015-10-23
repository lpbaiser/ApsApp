package Cenario;

import java.util.ArrayList;

import javax.swing.JPanel;

public interface Cenario {

	public JPanel geraCenario(ArrayList<Integer> numeros);
	public ArrayList<Integer> random(int tamanho);
	
}
