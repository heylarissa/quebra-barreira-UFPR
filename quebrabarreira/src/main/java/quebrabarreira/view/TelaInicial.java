package quebrabarreira.view;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class TelaInicial extends JFrame /*implements ActionListener */{

  private JButton BSolicitar, Binformacoes;
  private JLabel L1;

  // Ver minhas informações
  // Redireciona para telaInfoAluno
  // public static void printAlunoInfo(AlunoController Aluno){
  // System.out.print(Aluno);
  // }
  public void Tela_Inicial() {

    setTitle("Tela Incial");
    setVisible(true);
    setSize(700, 500);
    setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    setResizable(false);
    setLocationRelativeTo(null);

    JPanel;
    //JLabel label = new JLabel();
    ///label.setText("Pedido de Quebra de Barreira do DINF ");
    //L1.setHorizontalTextPosition(JLabel.CENTER);

    //label.setHorizontalTextPosition(JLabel.CENTER);
    //label.setHorizontalTextPosition(JLabel.TOP);
    //add(label);
    

    
    //L1 = new JLabel("Pedido de Quebra de Barreira do DINF ");
    //L1.setBounds(100, 100, 200, 200);

    //L1.setHorizontalTextPosition(JLabel.CENTER);
    //L1.setHorizontalTextPosition(JLabel.TOP);
    //add(L1);
    /* 
    //System.out.println("add L1");

    BSolicitar = new JButton("Solicitar");
    BSolicitar.setBounds(200, 250, 100, 70);
    // BSolicitar.addActionListener(this);
    add(BSolicitar);

    Binformacoes = new JButton("Informações");
    Binformacoes.setBounds(200, 300, 100, 70);
    // Binformacoes.addActionListener(this);
    add(Binformacoes);

    L2 = new JLabel("Solicitar a Quebra de barreira");
    L2.setBounds(100, 250, 100, 70);
    add(L1);

    L3 = new JLabel("Informações do Aluno");
    L3.setBounds(100, 300, 100, 70);
    add(L3);
    // Solicitar quebra de barreira*/
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
  }

  @Override
  public void actionPerformed(ActionEvent arg0) {
    // TODO Auto-generated method stub
    
  }*/
}
