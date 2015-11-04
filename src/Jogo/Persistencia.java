package Jogo;


import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.util.ArrayList;

public class Persistencia {

	public void gravaPlayer(Player jogador) {
		File file = new File("ranking.txt");

		try {
			FileWriter writer = new FileWriter(file,true);
			writer.write(jogador.getNome() + ";"+jogador.getScore().getPontos()+";"+jogador.getScore().getTempo()+";"+jogador.getScore().getNumTentativas()+";" + jogador.getScore().getAcertoConsecutivo());
			writer.write("\n");
			writer.close();
		} catch (Exception e) {
			e.printStackTrace();
		}

	}

	public ArrayList<Player> lista() {
		String arquivo[];
		ArrayList<Player> players= new ArrayList<Player>();
		
		try {
			FileReader file = new FileReader("ranking.txt");
			BufferedReader fi = new BufferedReader(file);
			String linha = fi.readLine();
			while (linha != null) {
				Player novo = new Player();
				Score s = new Score();
				arquivo = linha.split(";");
				novo.setNome(arquivo[0]);
				s.setPontos(Float.parseFloat(arquivo[1]));
				s.setTempo(Integer.parseInt(arquivo[2]));
				s.setNumTentativas(Integer.parseInt(arquivo[3]));
				s.setAcertoConsecutivo(Integer.parseInt(arquivo[4]));
				novo.setScore(s);
				players.add(novo);
				
				linha= fi.readLine();

			}
			fi.close();
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		return players;

	}
}
