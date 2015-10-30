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
	public float getScore(){
		return (this.tempo/this.numTentativas)*(this.acertoConsecutivo/100);
	}
	
	public int getAcertoConsecutivo() {
		return acertoConsecutivo;
	}
	public void setAcertoConsecutivo(int acertoConsecutivo) {
		this.acertoConsecutivo = acertoConsecutivo;
	}
	
	public ArrayList<String> listaScore(){
		ArrayList<String> ranking = new ArrayList<>();
		//implementar metodo no percistencia
		return ranking;
	}
	
	
	
}
