package Jogo;

/**
*
* @author Emanuel Mazzer & Leonardo Baiser 
* @version 1.0
* @since 19/10/2015
*/

import java.util.ArrayList;

public class Score {

	private int tempo;
	private int numTentativas;
	private int acertoConsecutivo;
	private float pontos;

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
		pontos = (this.tempo / this.numTentativas)* (this.acertoConsecutivo);
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

	public ArrayList<String> listaScore() {
		ArrayList<String> ranking = new ArrayList<>();
		// implementar metodo no percistencia
		return ranking;
	}

}
