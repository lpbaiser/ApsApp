package Jogo;

import java.util.ArrayList;

/**
 *
 * @author Emanuel Mazzer & Leonardo Baiser
 * @version 1.0
 * @since 19/10/2015
 */

public class Player {

	private String nome;
	private Score score;

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public Score getScore() {
		return score;
	}

	public void setScore(Score score) {
		this.score = score;
	}

	public void setPontos(float pontos) {
		this.score.setScore(pontos);
	}

	public ArrayList<Player> ranking() {
		Persistencia p = new Persistencia();
		ArrayList<Player> players = p.lista();
		ArrayList<Player> rank = new ArrayList<>();
		//Player aux = new Player();
		for (int i = players.size(); i >= 1; i--) {  
            for (int j = 1; j < i; j++) {  
                if (players.get(j-1).getScore().getPontos() < players.get(j).getScore().getPontos()) {  
                    Player aux = players.get(j);  
                    players.set(j, players.get(j-1));  
                    players.set(j-1, aux);  
                }  
            }  
        }    

		return players;
	}

	// int j=players.size();
	// float maior=0;
	// for (int i=0;i<players.size();i++){
	// if((players.get(i).getScore().getScore())>(maior)){
	// rank.add(players.get(i));
	// players.remove(i);
	// maior=0;
	// }
	// // System.out.println(rank.get(i).getNome());
	//
	// }
	// return rank;
	// }

}
