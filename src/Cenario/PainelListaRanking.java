package Cenario;

import Jogo.Player;
import java.awt.Dimension;
import java.util.ArrayList;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextArea;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author Leonardo Baiser <lpbaiser@gmail.com>
 * @since 04/11/2015
 */
public class PainelListaRanking extends JPanel{

    Player player = new Player();
    ArrayList<Player> players = new ArrayList<Player>();
    JTextArea txtRanking = new JTextArea();
    DefaultTableModel modeloTab = new DefaultTableModel();
    JTable tabela = new JTable(modeloTab);
    
    public PainelListaRanking(){
        
        players = player.ranking();
        
        modeloTab.addColumn("Nome");
        modeloTab.addColumn("Pontuação");
        
        for (Player p : players) {
            Object[] linha = {p.getNome(), p.getScore().getPontos()};
            modeloTab.addRow(linha);
//            txtRanking.append(p.getNome() + p.getScore().getPontos());
        }
        tabela.setEnabled(false);
        tabela.setModel(modeloTab);
        tabela.setPreferredSize(new Dimension(180, 500));
        JScrollPane scrollPane = new JScrollPane(tabela);
        scrollPane.setPreferredSize(new Dimension(200, 500));
        this.add(scrollPane);
        
    }
    
}
