package Jogo;

import java.util.ArrayList;

import Cenario.Dificuldade;
import Cenario.GUI;

public class Main {

	public static void main(String[] args) {
		//GUI g = new GUI();
		Player p = new Player();
		Persistencia per= new Persistencia();
		Score s=new Score();
		s.setAcertoConsecutivo(5);
		s.setNumTentativas(40);
		s.setTempo(120);
		p.setNome("Joao gris");
		p.setScore(s);
		per.gravaPlayer(p);
		p.setNome("Joaaaaaaaao gris");
		per.gravaPlayer(p);
		
		per.ranking();
		
		
	}

}
