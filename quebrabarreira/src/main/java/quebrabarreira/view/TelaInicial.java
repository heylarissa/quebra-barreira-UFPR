package quebrabarreira.view;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.SwingConstants;

import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class TelaInicial extends JFrame implements ActionListener {

  private JButton BSolicitar, Binformacoes,Bimportar;
  private JLabel Titulo;


  public void Tela_Inicial() {

    setTitle("Tela Incial");
    setSize(500, 500);
    this.setLayout(null);
    setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    setResizable(false);
    setLocationRelativeTo(null);

    Titulo = new JLabel();
    Titulo.setText("Pedido de Quebra de Barreira do DINF ");

    //Panel do titulo
    JPanel panelTitulo = new JPanel();
    panelTitulo.setBounds(120, 100, 270, 270);
    panelTitulo.add(Titulo);

    //Botoes da tela
    BSolicitar = new JButton("Solicitar");
    BSolicitar.addActionListener(this);
    Binformacoes = new JButton("Informações");
    Binformacoes.addActionListener(this);
    Bimportar = new JButton("Importar Historico");
    Bimportar.addActionListener(this);

    //Panel de botoes
    JPanel panelBotoes =  new JPanel();
    panelBotoes.setBounds(150, 200, 200, 100);
    panelBotoes.add(BSolicitar);
    panelBotoes.add(Binformacoes);
    panelBotoes.add(Bimportar);

    setVisible(true);
    this.add(panelTitulo);
    this.add(panelBotoes);

  }
  
  /*public void actionPerformed(ActionEvent e) {
    Object source = e.getSource();
    if (source == BSolicitar) {
      telaSolicitar();
    } else if (source == Binformacoes) {
      telaAluno();
    } else {
      return;
    }
  }*/
  
  @Override
  public void actionPerformed(ActionEvent e) {
    if (e.getSource() == BSolicitar) {
      System.out.println("MATERIA");
      telaSolicitacao solicitacao = new telaSolicitacao();
      setVisible(false);
    } else if  (e.getSource() == Binformacoes){
      System.out.println("alunoo");
    } else if  (e.getSource() == Bimportar){
      System.out.println("historico");
    }

    
  }
}