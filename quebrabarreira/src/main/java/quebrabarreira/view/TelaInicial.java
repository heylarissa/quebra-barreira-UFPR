package quebrabarreira.view;

import javax.swing.JButton;
import javax.swing.JFileChooser;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.SwingConstants;

import quebrabarreira.controllers.AlunoController;

import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;

public class TelaInicial extends JFrame implements ActionListener {

  private JButton BSolicitar, Binformacoes,Bimportar;
  private JLabel Titulo;

  private static TelaInicial instancia = null;

  public TelaInicial(AlunoController aluno) {
  }

  AlunoController alunoInfo;


  //public static synchronized TelaInicial getInstance(){
  //  if (instancia == null)
  //    instancia = new TelaInicial();
  //  return instancia;
  //}


  public void Tela_Inicial(AlunoController alunoInfo) {

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
    BSolicitar = new JButton("Solicitar Materia");
    BSolicitar.addActionListener(this);
    Binformacoes = new JButton("Informações do Aluno");
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
  
  @Override
  public void actionPerformed(ActionEvent e) {

    JFrame proxTela;
    
    //JFrame proxTela;
    
    if (e.getSource() == BSolicitar) {

      proxTela = telaSolicitacao.getInstance();
      System.out.println("MATERIA");
      //telaSolicitacao solicitacao = new telaSolicitacao();
      setVisible(false);

    } else if  (e.getSource() == Binformacoes){

      //proxTela = telaInfoAluno.getInstance();

      System.out.println("aluno");
      
      telaInfoAluno infoAluno = new telaInfoAluno(alunoInfo);
      setVisible(false);

    } else if  (e.getSource() == Bimportar){

      System.out.println("historico");

      JFileChooser importarChooser = new JFileChooser();
      importarChooser.setCurrentDirectory(new File("."));
      int arq = importarChooser.showOpenDialog(null);

      if (arq == JFileChooser.APPROVE_OPTION){
        File fila = new File(importarChooser.getSelectedFile().getAbsolutePath());
        System.out.println(fila);
      }

      
    }

    
  }
}
/*voltar aqui */
// proxTela.setLocationRelativeTo(this);
// proxTela.setBounds(this.getBounds());
// this.setVisible(false);
// proxTela.setVisible(true);
