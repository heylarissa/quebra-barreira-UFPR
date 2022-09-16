package quebrabarreira.view;

import java.awt.Color;

import javax.swing.JFrame;
import javax.swing.JPanel;

public class telaResultado extends JFrame /*implements ActionListerner*/{


    public telaResultado(){
        
        setTitle("Resultado");
        setSize(500, 500);
        this.setLayout(null);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setResizable(false);
        setLocationRelativeTo(null);

        JPanel panel1JPanel =  new JPanel();
        panel1JPanel.setBounds(0,0,250,500);
        panel1JPanel.setBackground(Color.BLUE);

        JPanel panel2JPanel =  new JPanel();
        panel2JPanel.setBounds(250,0,250,500);
        panel2JPanel.setBackground(Color.RED);

        setVisible(true);
        this.add(panel1JPanel);
        this.add(panel2JPanel);

    }
    
}
