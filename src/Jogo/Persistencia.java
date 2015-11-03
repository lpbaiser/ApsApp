package Jogo;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.InputStream;
import java.util.ArrayList;

public class Persistencia {

	public void gravaPlayer(Player jogador) {
		File file = new File("ranking.txt");

		try {
			FileWriter writer = new FileWriter(file, true);
			writer.write(jogador.getNome() + ";"+jogador.getScore()+";"+jogador.getScore().getTempo()+";"+jogador.getScore().getNumTentativas()+";" + jogador.getScore().getAcertoConsecutivo());
			writer.write("\n");
			writer.close();
		} catch (Exception e) {
			e.printStackTrace();
		}

	}

	public ArrayList<Player> ranking() {
		String arquivo = new String();
		String[] jogadores;
		String[] jogadores2;
		ArrayList<Player> players= new ArrayList<Player>();
		
		try {
			FileReader file = new FileReader("ranking.txt");
			BufferedReader fi = new BufferedReader(file);
			String linha = fi.readLine();
			while (linha != null) {
				arquivo += linha = fi.readLine();

			}
			jogadores = arquivo.split(";");
			System.out.println("lengh" +jogadores[0]);
			for (int i = 0; i < jogadores.length-1; i++) {
				jogadores2=jogadores[i].split(";");
				Player novo = new Player();
				novo.setNome(jogadores2[0].trim());
				//novo.setPontos(Float.parseFloat(jogadores2[1]));
				players.add(novo);
			}

		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		System.out.println(players.get(0).getNome());
		return players;

	}
}
