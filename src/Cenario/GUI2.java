package Cenario;

import Jogo.Dificuldade;
import java.awt.BorderLayout;
import java.awt.Container;
import javax.swing.JFrame;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JPanel;

/**
 *
 * @author Leonardo Baiser <lpbaiser@gmail.com>
 * @since 
 */
public class GUI2 extends JFrame{

    Container cp = new Container();
    JPanel painel = new JPanel();
    PainelCartas painelCartas;
    JMenuBar menuBar = new JMenuBar();
    JMenu jogoMenu = new JMenu("Jogo");
    JMenuItem novoJogo = new JMenuItem("Novo Jogo");
    JMenuItem viewRanking = new JMenuItem("Ranking");

    private Dificuldade dificuldade;
    
    public GUI2(){
        setTitle("JOGO DA MEMORIA");
        setJMenuBar(menuBar);
        menuBar.add(jogoMenu);
        jogoMenu.add(novoJogo);
        jogoMenu.add(viewRanking);
        
        
        cp = getContentPane();
        cp.setLayout(new BorderLayout());
        
        dificuldade = new Dificuldade(12);
        
    }
    
}
