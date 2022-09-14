package quebrabarreira.view;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;


public class telaSolicitacao extends JFrame implements ActionListener {

    private JButton Binicio;

    public telaSolicitacao() {

        setTitle("Solicitar");
        setSize(500, 500);
        this.setLayout(null);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setResizable(false);
        setLocationRelativeTo(null);

        Binicio = new JButton("voltar inicio");
        Binicio.addActionListener(this);

        JPanel panelBotoes =  new JPanel();
        panelBotoes.setBounds(150, 200, 200, 100);
        panelBotoes.add(Binicio);

        setVisible(true);
        this.add(panelBotoes);


    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == Binicio) {
            System.out.println("INICIO");
            //TelaInicial inicio = new TelaInicial();
            //setVisible(false);
          } 
    }
    
}