package Cenario;

import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javafx.scene.text.Text;
import javax.swing.GroupLayout;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTabbedPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;

/**
 *
 * @author Leonardo Baiser <lpbaiser@gmail.com>
 * @since 05/11/2015
 */
public class PainelInicial extends JPanel {

    JTextField txtNick = new JTextField(10);
    JButton btnOK = new JButton("OK");
    GroupLayout layout = new GroupLayout(this);

    Listener listener = null;
    String nick = null;

    public PainelInicial() {
        setSize(200, 100);
        setBackground(Color.lightGray);

        layout.setHorizontalGroup(layout.createSequentialGroup()
                .addComponent(new JLabel("Nick: "))
                .addComponent(txtNick)
                .addComponent(btnOK)
        );

        btnOK.addActionListener(new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent e) {
                nick = txtNick.getText();
                txtNick.setText(null);
                setVisible(false);
            }
        });

        
        

    }

}
