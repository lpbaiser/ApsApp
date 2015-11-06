package Cenario;

import Jogo.Jogo;
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
public class PainelListaRanking extends JPanel {

    Player player = new Player();
    Jogo jogo = new Jogo();
    ArrayList<ArrayList<Jogo>> ranking;
    JTextArea txtRanking = new JTextArea();
    DefaultTableModel modeloTab = new DefaultTableModel();
    JTable tabela = new JTable(modeloTab);

    public PainelListaRanking() {

        ranking = jogo.ranking();

        modeloTab.addColumn("Nome");
        modeloTab.addColumn("Pontuação");

        for (int i = 0; i < ranking.get(0).size(); i++) {
            jogo = new Jogo();
            jogo = ranking.get(0).get(i);
            Object[] linha = {jogo.getPlayer().getNome(), jogo.getPlayer().getScore().getPontos()};
            modeloTab.addRow(linha);

        }

        modeloTab.addColumn("Nome");
        modeloTab.addColumn("Pontuação");
        for (int i = 0; i < ranking.get(0).size(); i++) {
            jogo = new Jogo();
            jogo = ranking.get(0).get(i);
            Object[] linha = {jogo.getPlayer().getNome(), jogo.getPlayer().getScore().getPontos()};
            modeloTab.addRow(linha);

        }

        modeloTab.addColumn("Nome");
        modeloTab.addColumn("Pontuação");

        for (int i = 0; i < ranking.get(0).size(); i++) {
            jogo = new Jogo();
            jogo = ranking.get(0).get(i);
            Object[] linha = {jogo.getPlayer().getNome(), jogo.getPlayer().getScore().getPontos()};
            modeloTab.addRow(linha);

        }

        tabela.setEnabled(false);
        tabela.setModel(modeloTab);
        tabela.setPreferredSize(new Dimension(180, 500));
        JScrollPane scrollPane = new JScrollPane(tabela);
        scrollPane.setPreferredSize(new Dimension(200, 500));
        this.add(scrollPane);

    }

}
