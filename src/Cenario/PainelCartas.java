package Cenario;

import Jogo.Carta;
import Jogo.Dificuldade;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JPanel;

/**
 *
 * @author Leonardo Baiser <lpbaiser@gmail.com>
 * @since
 */
public class PainelCartas extends JPanel implements ActionListener {

    private int qtdeClique = 0;
    private int qtdeAcertos = 0;
    private Carta cartas[] = new Carta[2];
    private int nLinhas = 0;
    private int nColunas = 0;
    private JButton[][] vBtn;
    private Dificuldade d;
    ArrayList<Integer> numeros;
    
    public PainelCartas(Dificuldade d) {
        this.d = d;
        System.out.println("d"+d.getnColunas() +"  li " + d.getnLinhas());
        
        vBtn = d.geraVetorJButton();
        GridLayout layout = new GridLayout(d.getnLinhas(), d.getnColunas());
        setLayout(layout);
        for (int i = 0; i < d.getnLinhas(); i++) {
            for (int j = 0; j < d.getnColunas(); j++) {
                vBtn[i][j].addActionListener(this);
                add(vBtn[i][j]);
            }
        }
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        String action = e.getActionCommand();
        String aux[] = action.split("-");//quebra o valor do action, o action passa uma string que contem numero da carta, linha e coluna do matriz
        int linha = Integer.parseInt(aux[1]);
        int coluna = Integer.parseInt(aux[2]);

        Carta c = new Carta();
        c.setColuna(coluna);
        c.setLinha(linha);
        c.setNumCarta(aux[0]);
        cartas[qtdeClique] = c;
        qtdeClique++;

        ImageIcon icone = new ImageIcon(getClass().getResource("/icones/" + aux[0] + ".png"));

        vBtn[linha][coluna].setIcon(icone);

        if (qtdeClique == 2) {

            if (!(cartas[0].getNumCarta().equals(cartas[1].getNumCarta()))) {

                try {
                    Thread.sleep(1000);// nao esta funcionando corretamente
                } catch (InterruptedException e2) {
                    // TODO Auto-generated catch block
                    e2.printStackTrace();
                }

                // retornas as cartas no estado inicial
                ImageIcon def = new ImageIcon(getClass().getResource("/icones/fundo.png"));
				vBtn[cartas[0].getLinha()][cartas[0].getColuna()].setIcon(def);
				vBtn[cartas[1].getLinha()][cartas[1].getColuna()].setIcon(def);
                System.out.println("Errou");

            } else if (cartas[0].getNumCarta().equals(cartas[1].getNumCarta())) {
                // contabiliza o ponto de acerto
                qtdeAcertos++;
                System.out.println("Acertou");
                vBtn[cartas[0].getLinha()][cartas[0].getColuna()]
                        .setEnabled(false);
                vBtn[cartas[1].getLinha()][cartas[1].getColuna()]
                        .setEnabled(false);

            }
            cartas = new Carta[2];
            qtdeClique = 0;
            // delay1s();
        }
//		System.out.println("atdeA: " + qtdeAcertos + " tam btn"+ ((nLinhas * nColunas) / 2));
        if (qtdeAcertos == ((d.getnLinhas() * d.getnColunas()) / 2)) {
            System.out.println("Fim de jogo");
//			return;
        }

    }

}
