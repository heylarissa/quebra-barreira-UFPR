package quebrabarreira.view;

import javax.swing.JFrame;
import javax.swing.JPanel;

import java.awt.Color;

public class telaInfoAluno extends JFrame {

    public telaInfoAluno() {

        setTitle("Aluno");
        setSize(500, 500);
        this.setLayout(null);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setResizable(false);
        setLocationRelativeTo(null);

        //Binicio = new JButton("voltar inicio");
        //Binicio.addActionListener(this);

        JPanel panel1JPanel =  new JPanel();
        panel1JPanel.setBounds(0,0,250,500);
        panel1JPanel.setBackground(Color.BLUE);

        JPanel panel2JPanel =  new JPanel();
        panel2JPanel.setBounds(250,0,250,500);
        panel2JPanel.setBackground(Color.RED);



        //JPanel panelBotoes =  new JPanel();
        //panelBotoes.setBounds(150, 200, 200, 100);
        //panelBotoes.add(Binicio);

        setVisible(true);
        this.add(panel1JPanel);
        this.add(panel2JPanel);



    }
    
}
