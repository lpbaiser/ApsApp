//package Cenario;
//
///**
//*
//* @author Emanuel Mazzer & Leonardo Baiser 
//* @version 1.0
//* @since 19/10/2015
//*/
//
//import java.awt.event.ActionEvent;
//import java.awt.event.ActionListener;
//import java.util.ArrayList;
//import java.util.Collections;
//
//import javax.swing.ImageIcon;
//import javax.swing.JButton;
//
//import Jogo.Carta;
//
//public class Cenario {
//
//    
//	JButton[][] vBtn;
//	
//	private int qtdeClique = 0;
//	private int qtdeAcertos = 0;
//	private Carta cartas[] = new Carta[2];
//	
//
//	ActionListener actionL = new ActionListener() {
//
//		@Override
//		public void actionPerformed(ActionEvent e) {
//			
//			
//			String action = e.getActionCommand();
//			String aux[] = action.split("-");
//			int linha = Integer.parseInt(aux[1]);
//			int coluna = Integer.parseInt(aux[2]);
//
//			
//			
//			Carta c = new Carta();
//			c.setColuna(coluna);
//			c.setLinha(linha);
//			c.setNumCarta(aux[0]);
//			cartas[qtdeClique] = c;
//			qtdeClique++;
//			
//			
//			System.out.println("icones/" + aux[0] + ".png");
//			ImageIcon icone = new ImageIcon(getClass().getResource("/icones/" + aux[0] + ".png"));
//
//			
//			vBtn[linha][coluna].setIcon(icone);
//			System.out.println("pos: " + aux[0] + "linha: " + linha+ "coluna: " + coluna);
//			
//			
//			if (qtdeClique == 2) {
//			    
//				if (!(cartas[0].getNumCarta().equals(cartas[1].getNumCarta()))){
//
//				    delay1s();//não esta funcionando corretamente
//				    //retornas as cartas no estado inicial
//					ImageIcon def = new ImageIcon(getClass().getResource("/icones/default.png"));
//					vBtn[cartas[0].getLinha()][cartas[0].getColuna()].setIcon(def);
//					vBtn[cartas[1].getLinha()][cartas[1].getColuna()].setIcon(def);
//				    System.out.println("Errou");
//
//				 
//					
//				}else if (cartas[0].getNumCarta().equals(cartas[1].getNumCarta())){
//				    //contabiliza o ponto de acerto
//				    qtdeAcertos++;
//					System.out.println("Acertou");
//					vBtn[cartas[0].getLinha()][cartas[0].getColuna()].setEnabled(false);
//					vBtn[cartas[1].getLinha()][cartas[1].getColuna()].setEnabled(false);
//					
//				}
//				cartas = new Carta[2];
//				qtdeClique = 0;
////				delay1s();
//			}
//			System.out.println("atdeA: "+qtdeAcertos + " tam btn"+((nLinhas*nColunas)/2));
//			if (qtdeAcertos == ((nLinhas*nColunas)/2)){
//			    System.out.println("Fim de jogo");
//			    return;
//			}
//
//		}
//	};
//
//	
//	
//	public void delay1s(){
//	    try {
//		Thread.sleep(1000);
//	    } catch (InterruptedException e2) {
//		// TODO Auto-generated catch block
//		e2.printStackTrace();
//	    }
//	}
//
//	public JButton[][] getvBtn() {
//		return vBtn;
//	}
//
//	public void setvBtn(JButton[][] vBtn) {
//		this.vBtn = vBtn;
//	}
//
//	public int getnLinhas() {
//		return nLinhas;
//	}
//
//	public void setnLinhas(int nLinhas) {
//		this.nLinhas = nLinhas;
//	}
//
//	public int getnColunas() {
//		return nColunas;
//	}
//
//	public void setnColunas(int nColunas) {
//		this.nColunas = nColunas;
//	}
//
//	public ActionListener getActionL() {
//		return actionL;
//	}
//
//	public void setActionL(ActionListener actionL) {
//		this.actionL = actionL;
//	}
//
//}
