package quebrabarreira.view;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

import java.awt.Color;
import java.awt.BorderLayout;

public class telaInfoAluno extends JFrame {

    private JLabel Titulo1,Titulo2,Titulo3,Titulo4;

    public telaInfoAluno() {

        setTitle("Aluno");
        setSize(750, 500);
        this.setLayout(null);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setResizable(false);
        setLocationRelativeTo(null);

        //Binicio = new JButton("voltar inicio");
        //Binicio.addActionListener(this);

        Titulo1 = new JLabel();
        Titulo1.setText("Materia já feitas");
        Titulo1.setBounds(65, 10, 120, 20);

        Titulo2 = new JLabel();
        Titulo2.setText("Materia que falta da barreira");
        Titulo2.setBounds(20, 10, 210, 20);

        Titulo3 = new JLabel();
        Titulo3.setText("Materia ofertadas esse semestre");
        Titulo3.setBounds(5, 10, 240, 20);

        Titulo4 = new JLabel();
        Titulo4.setText("Dados do ultimo semestre");
        Titulo4.setBounds(290, 100, 240, 50);



        JPanel panelMateriasCursadas =  new JPanel(null);
        panelMateriasCursadas.setBounds(0,0,250,300);
        panelMateriasCursadas.add(Titulo1);
        panelMateriasCursadas.setBackground(Color.BLUE);

        JPanel panelMateriasFalta =  new JPanel(null);
        panelMateriasFalta.setBounds(250,0,250,300);
        panelMateriasFalta.add(Titulo2);
        panelMateriasFalta.setBackground(Color.RED);

        JPanel panelMateriasOfertadas =  new JPanel(null);
        panelMateriasOfertadas.setBounds(500,0,250,300);
        panelMateriasOfertadas.add(Titulo3);
        panelMateriasOfertadas.setBackground(Color.GREEN);

        JPanel paneldados =  new JPanel(null);
        paneldados.setBounds(0,200,750,300);
        paneldados.add(Titulo4);
        paneldados.setBackground(Color.YELLOW);

        setVisible(true);
        this.add(panelMateriasCursadas);
        this.add(panelMateriasFalta);
        this.add(panelMateriasOfertadas);
        this.add(paneldados);
    }
    
}
