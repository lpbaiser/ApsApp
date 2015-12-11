package Control;

/**
*
* @author Emanuel Mazzer & Leonardo Baiser 
* @version 1.0
* @since 19/10/2015
*/

import java.util.ArrayList;

public class Score2 {

	private int tempo = 0;
	private int numTentativas = 0;
	private int acertoConsecutivo = 0;
	private float pontos = 0;

	public float getPontos() {
		return pontos;
	}

	public void setPontos(float pontos) {
		this.pontos = pontos;
	}

	public int getTempo() {
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

	/*
	 * Calcula o score de um jogo
	 */
	public float calcScore() {
		pontos = ((this.tempo / this.numTentativas)* (this.acertoConsecutivo)*1000);
		return pontos;
	}
	
	public void setScore(float pontos){
		this.pontos=pontos;
	}

	public int getAcertoConsecutivo() {
		return acertoConsecutivo;
	}

	public void setAcertoConsecutivo(int acertoConsecutivo) {
		this.acertoConsecutivo = acertoConsecutivo;
	}
        
        public void addNumTentativas(){
            this.numTentativas ++;
        }
        
        public void addAcertoConsecutivo(){
            this.acertoConsecutivo++;
        }

	public ArrayList<String> listaScore() {
		ArrayList<String> ranking = new ArrayList<>();
		// implementar metodo no percistencia
		return ranking;
	}
        
       
}
