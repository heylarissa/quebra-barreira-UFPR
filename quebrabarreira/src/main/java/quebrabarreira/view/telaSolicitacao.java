package quebrabarreira.view;

import javax.swing.JFrame;
import javax.swing.JPanel;

import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;


public class telaSolicitacao extends JFrame implements ActionListener {

    //private JButton Binicio;

    private static telaSolicitacao instancia = null;

    public static synchronized telaSolicitacao getInstance(){
      if (instancia == null)
        instancia = new telaSolicitacao();
      return instancia;
    }

    public telaSolicitacao() {

        setTitle("Solicitar");
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

    @Override
    public void actionPerformed(ActionEvent e) {
        //if (e.getSource() == Binicio) {
        //    System.out.println("INICIO");
        //    //TelaInicial inicio = new TelaInicial();
        //    //setVisible(false);
        // } 
    }
    
}