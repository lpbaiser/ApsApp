package View;

import Control.Jogo;
import Control.Player;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
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
    ArrayList<ArrayList<Jogo>> ranking;
    JTextArea txtRanking = new JTextArea();
    DefaultTableModel modeloTab;
    JTable tabela;
    
    JButton btnFechar = new JButton("Fechar ranking");
    
    JPanel dificuldade1;
    JPanel dificuldade2;
    JPanel dificuldade3;
    FlowLayout layout = new FlowLayout(FlowLayout.CENTER);
    
    JPanel painel = new JPanel();

    public FrameListaRanking() {
        
        setSize(800, 600);

        ranking = jogo.ranking();
        
        
        
        dificuldade1 = new JPanel();
        dificuldade1.setPreferredSize(new Dimension(250, 550));
        dificuldade1.setLayout(layout);
        

        modeloTab = new DefaultTableModel();
        modeloTab.addColumn("Nome");
        modeloTab.addColumn("Pontuação");

        tabela = new JTable(modeloTab);

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
        dificuldade1.add(new JLabel("Dificuldade 12 peças"));
        dificuldade1.add(scrollPane);
        
        dificuldade2 = new JPanel();
        dificuldade2.setPreferredSize(new Dimension(250, 550));
        dificuldade2.setLayout(layout);

        modeloTab = new DefaultTableModel();
        modeloTab.addColumn("Nome");
        modeloTab.addColumn("Pontuação");

        tabela = new JTable(modeloTab);

        for (int i = 0; i < ranking.get(1).size(); i++) {
            jogo = new Jogo();
            jogo = ranking.get(1).get(i);
            Object[] linha = {jogo.getPlayer().getNome(), jogo.getPlayer().getScore().getPontos()};
            modeloTab.addRow(linha);

        }

        tabela.setEnabled(false);
        tabela.setModel(modeloTab);
        tabela.setPreferredSize(new Dimension(180, 500));
        scrollPane = new JScrollPane(tabela);
        scrollPane.setPreferredSize(new Dimension(200, 500));
        dificuldade2.add(new JLabel("Dificuldade 24 peças"));
        dificuldade2.add(scrollPane);
        
        dificuldade3 = new JPanel();
        dificuldade3.setPreferredSize(new Dimension(250, 560));
        dificuldade3.setLayout(layout);
        
        modeloTab = new DefaultTableModel();
        modeloTab.addColumn("Nome");
        modeloTab.addColumn("Pontuação");

        tabela = new JTable(modeloTab);

        for (int i = 0; i < ranking.get(2).size(); i++) {
            jogo = new Jogo();
            jogo = ranking.get(2).get(i);
            Object[] linha = {jogo.getPlayer().getNome(), jogo.getPlayer().getScore().getPontos()};
            modeloTab.addRow(linha);

        }

        tabela.setEnabled(false);
        tabela.setModel(modeloTab);
        tabela.setPreferredSize(new Dimension(180, 500));
        scrollPane = new JScrollPane(tabela);
        scrollPane.setPreferredSize(new Dimension(200, 500));
        dificuldade3.add(new JLabel("Dificuldade 36 peças"));
        dificuldade3.add(scrollPane);
        dificuldade3.add(btnFechar);
        
        painel.add(dificuldade1);
        painel.add(dificuldade2);
        painel.add(dificuldade3);
        
        this.add(painel);

        btnFechar.addActionListener(new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent e) {
                fechaPainel();
            }
        });
        
    }
    
    public void fechaPainel(){
        
        this.setVisible(false);
        
    }

}
