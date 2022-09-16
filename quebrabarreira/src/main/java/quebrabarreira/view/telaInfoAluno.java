package quebrabarreira.view;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

import quebrabarreira.controllers.AlunoController;

import java.awt.Color;
import java.awt.BorderLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class telaInfoAluno extends JFrame implements ActionListener{

    private JLabel Titulo1,Titulo2,Titulo3,Titulo4;
    private JButton Binicio;

    // private static telaInfoAluno instancia = null;

    // public static synchronized telaInfoAluno getInstance(){
    //   if (instancia == null)
    //     instancia = new telaInfoAluno(aluno);
    //   return instancia;
    // }

    public telaInfoAluno(){}

    public telaInfoAluno(AlunoController aluno) {

        setTitle("Aluno");
        setSize(750, 500);
        this.setLayout(null);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setResizable(false);
        setLocationRelativeTo(null);


        Titulo1 = new JLabel();
        Titulo1.setText("Materia já feitas");
        Titulo1.setBounds(65, 10, 120, 20);

        Titulo2 = new JLabel();
        Titulo2.setText("Materia que falta da barreira");
        Titulo2.setBounds(20, 10, 210, 20);

        Titulo3 = new JLabel();
        Titulo3.setText("Dados do ultimo semestre");
        Titulo3.setBounds(30, 10, 190, 20);

        /*Botoes */
        Binicio = new JButton("inicio");
        Binicio.addActionListener(this);
        Binicio.setBounds(500, 400, 200, 20);

        JPanel panelMateriasCursadas =  new JPanel(null);
        panelMateriasCursadas.setBounds(0,0,250,400);
        panelMateriasCursadas.add(Titulo1);
        panelMateriasCursadas.setBackground(Color.BLUE);

        JPanel panelMateriasFalta =  new JPanel(null);
        panelMateriasFalta.setBounds(250,0,250,400);
        panelMateriasFalta.add(Titulo2);
        panelMateriasFalta.setBackground(Color.RED);

        JPanel panelMateriasOfertadas =  new JPanel(null);
        panelMateriasOfertadas.setBounds(500,0,250,400);
        panelMateriasOfertadas.add(Titulo3);
        panelMateriasOfertadas.setBackground(Color.GREEN);

        JPanel panelBotoes = new JPanel();
        panelBotoes.setBounds(250, 420, 200, 100);
        //panelBotoes.setBackground(Color.YELLOW);
        panelBotoes.add(Binicio);

        setVisible(true);
        this.add(panelMateriasCursadas);
        this.add(panelMateriasFalta);
        this.add(panelMateriasOfertadas);
        this.add(panelBotoes);
        
    }

    @Override
  public void actionPerformed(ActionEvent e) {

    //JFrame proxTela;
    
    if (e.getSource() == Binicio) {
      //proxTela = TelaInicial.getInstance();
      System.out.println("inicio");
      //TelaInicial inicio = new TelaInicial();
      setVisible(false);
    }
    }
  }
