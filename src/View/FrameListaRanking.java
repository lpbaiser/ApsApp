package View;

import Control.Jogo;
import Control.Player;
import Control.Score;
import Model.PlayerDao;
import Model.ScoreDao;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.List;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
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
public class FrameListaRanking extends JFrame {

    Player player = new Player();
    Jogo jogo = new Jogo();
    List<Score> ranking;
    JTextArea txtRanking = new JTextArea();
    DefaultTableModel modeloTab1;
    DefaultTableModel modeloTab2;
    DefaultTableModel modeloTab3;
    JTable tabela1;
    JTable tabela2;
    JTable tabela3;

    JButton btnFechar = new JButton("Fechar ranking");

    JPanel dificuldade1;
    JPanel dificuldade2;
    JPanel dificuldade3;
    FlowLayout layout = new FlowLayout(FlowLayout.CENTER);

    JPanel painel1 = new JPanel();
    JPanel painel2 = new JPanel();
    JPanel painel3 = new JPanel();

    ScoreDao scoredao;
    PlayerDao playerDao;

    public FrameListaRanking() {
        scoredao = new ScoreDao();
        playerDao = new PlayerDao();
        setSize(800, 600);

        ranking = new ArrayList<>();
        ranking = scoredao.ranking();

       

        modeloTab1 = new DefaultTableModel();
        modeloTab1.addColumn("Nome");
        modeloTab1.addColumn("Pontuação");
        modeloTab2 = new DefaultTableModel();
        modeloTab2.addColumn("Nome");
        modeloTab2.addColumn("Pontuação");
        modeloTab3 = new DefaultTableModel();
        modeloTab3.addColumn("Nome");
        modeloTab3.addColumn("Pontuação");

        tabela1 = new JTable(modeloTab1);
        tabela2 = new JTable(modeloTab2);
        tabela3 = new JTable(modeloTab3);

        for (Score r : ranking) {
            Player p = playerDao.getPlayerByScore(r.getIdScore());
            if (p != null){
                
            Object[] linha = {p.getNamePlayer(), r.getPontos()};
            if (r.getDificuldade() == 0) {
                modeloTab1.addRow(linha);

            } else if (r.getDificuldade() == 1) {
                modeloTab2.addRow(linha);

            } else if (r.getDificuldade() == 2) {
                modeloTab3.addRow(linha);

            }
            }

        }

        tabela1.setEnabled(false);
        
        tabela1.setModel(modeloTab1);
        tabela1.setPreferredSize(new Dimension(180, 500));
        JScrollPane scrollPane = new JScrollPane(tabela1);
        scrollPane.setPreferredSize(new Dimension(200, 500));
        dificuldade1 = new JPanel();
        dificuldade1.setPreferredSize(new Dimension(250, 550));
        dificuldade1.setLayout(layout);
        dificuldade1.add(new JLabel("Dificuldade 12 peças"));
        dificuldade1.add(scrollPane);
                
        
        tabela2.setModel(modeloTab2);
        tabela2.setPreferredSize(new Dimension(180, 500));
        scrollPane = new JScrollPane(tabela2);
        scrollPane.setPreferredSize(new Dimension(200, 500));
        dificuldade2 = new JPanel();
        dificuldade2.setPreferredSize(new Dimension(250, 550));
        dificuldade2.setLayout(layout);
        dificuldade2.add(new JLabel("Dificuldade 24 peças"));
        dificuldade2.add(scrollPane);
        
        tabela3.setModel(modeloTab3);
        tabela3.setPreferredSize(new Dimension(180, 500));
        scrollPane = new JScrollPane(tabela3);
        scrollPane.setPreferredSize(new Dimension(200, 500));
        dificuldade3 = new JPanel();
        dificuldade3.setPreferredSize(new Dimension(250, 550));
        dificuldade3.setLayout(layout);
        dificuldade3.add(new JLabel("Dificuldade 36 peças"));
        dificuldade3.add(scrollPane);
        
        
        painel3.add(dificuldade1);
        painel3.add(dificuldade2);
        painel3.add(dificuldade3);
        
        this.add(painel3);

//
//        modeloTab = new DefaultTableModel();
//        modeloTab.addColumn("Nome");
//        modeloTab.addColumn("Pontuação");
//
//        tabela = new JTable(modeloTab);
//
//        for (int i = 0; i < ranking.get(1).size(); i++) {
//            jogo = new Jogo();
//            jogo = ranking.get(1).get(i);
//            Object[] linha = {jogo.getPlayer().getNome(), jogo.getPlayer().getScore().getPontos()};
//            modeloTab.addRow(linha);
//
//        }
//
//        tabela.setEnabled(false);
//        tabela.setModel(modeloTab);
//        tabela.setPreferredSize(new Dimension(180, 500));
//        scrollPane = new JScrollPane(tabela);
//        scrollPane.setPreferredSize(new Dimension(200, 500));
//        dificuldade2.add(new JLabel("Dificuldade 24 peças"));
//        dificuldade2.add(scrollPane);
//
//        dificuldade3 = new JPanel();
//        dificuldade3.setPreferredSize(new Dimension(250, 560));
//        dificuldade3.setLayout(layout);
//
//        modeloTab = new DefaultTableModel();
//        modeloTab.addColumn("Nome");
//        modeloTab.addColumn("Pontuação");
//
//        tabela = new JTable(modeloTab);
//
//        for (int i = 0; i < ranking.get(2).size(); i++) {
//            jogo = new Jogo();
//            jogo = ranking.get(2).get(i);
//            Object[] linha = {jogo.getPlayer().getNome(), jogo.getPlayer().getScore().getPontos()};
//            modeloTab.addRow(linha);
//
//        }
//
//        tabela.setEnabled(false);
//        tabela.setModel(modeloTab);
//        tabela.setPreferredSize(new Dimension(180, 500));
//        scrollPane = new JScrollPane(tabela);
//        scrollPane.setPreferredSize(new Dimension(200, 500));
//        dificuldade3.add(new JLabel("Dificuldade 36 peças"));
//        dificuldade3.add(scrollPane);
//        dificuldade3.add(btnFechar);
//
//        painel.add(dificuldade2);
//        painel.add(dificuldade3);


        btnFechar.addActionListener(new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent e) {
                fechaPainel();
            }
        });

    }

    public void fechaPainel() {

        this.setVisible(false);

    }

}
