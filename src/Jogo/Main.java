package Jogo;

import Cenario.Dificuldade1;

public class Main {

	public static void main(String[] args) {
		Dificuldade1 d1 = new Dificuldade1();
		int v[] = d1.random(16);
		for (int i = 0; i < v.length; i++) {
			System.out.print(v[i] + "  ");
		}
		
		
	}

}
