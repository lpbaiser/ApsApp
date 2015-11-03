package Jogo;

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
	public void setPontos(float pontos){
		this.score.setScore(pontos);
	}
	
}
