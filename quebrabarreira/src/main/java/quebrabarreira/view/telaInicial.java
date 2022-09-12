package quebrabarreira.view;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

import quebrabarreira.controllers.AlunoController;

public class telaInicial extends JFrame implements ActionListerner{

    private JButton BSolicitar, Binformacoes;
    private JLabel L1,L2;
    // Ver minhas informações
        // Redireciona para telaInfoAluno
    // public static void printAlunoInfo(AlunoController Aluno){
    //     System.out.print(Aluno);
    // }
    public telaInicial(){
        setTitle("Tela Incial");
        setVisible(true);
        setSize(800,500);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setResizable(false);
        setLocationRelativeTo(null);

        setLayout(null);

        BSolicitar = new JButton("Solicitar");
        BSolicitar.setBounds(200, 250, 100, 70 );
        add(BSolicitar);
       
        Binformacoes = new JButton("Informações");
        Binformacoes.setBounds(200, 300, 100, 70 );
        add(Binformacoes);
        
        L1 = new JLabel("Solicitar a Quebra de barreira");
        L1.setBounds(100, 250, 100, 70 );
        add(L1);

        L2 = new JLabel("Informações do Aluno");
        L1.setBounds(100, 300, 100, 70 );
        add(L1);
    // Solicitar quebra de barreira
    }

    public void actionPerformed(ActionEvent e){
        Object source = e.getSource();
        if(source == BSolicitar){
            telaSolicitar();
          } else if(source == Binformacoes){
            telaAluno();
          } else {
            return;
          }
    }
}
