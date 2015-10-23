package Jogo;

public class Score {

	private int tempo;
	private int numTentativas;
	private int getTempo() {
		return tempo;
	}
	public void setTempo(int tempo) {
		this.tempo = tempo;
	}
	public int getNumTentativas() {
		return numTentativas;
	}
	public void setNumTentativas(int numTentativas) {
		this.numTentativas = numTentativas;
	}
	
	public float getScore(){
		return (this.tempo/this.numTentativas);
	}
	
	
}
