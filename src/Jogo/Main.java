package Jogo;

import java.util.ArrayList;

import Cenario.Dificuldade;

public class Main {

	public static void main(String[] args) {
		Dificuldade d1 = new Dificuldade();
		ArrayList<Integer>v = d1.random(16);
//		for (int i = 0; i < v.size(); i++) {
//			System.out.print(v + "  ");
//		}
		System.out.println(v);
		
	}

}
