package quebrabarreira.view;

import javax.swing.JFrame;
import javax.swing.JLabel;

public class telaResultado extends JFrame /*implements ActionListerner*/{

    private JLabel nomeAluno,quantidadeMateria;

    public telaResultado(){
        setTitle("Resultado");
        setVisible(true);
        setSize(800,500);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setResizable(false);
        setLocationRelativeTo(null);

        setLayout(null);

        nomeAluno = new JLabel();
        nomeAluno.setText("O aluno:");

        quantidadeMateria = new JLabel();
        quantidadeMateria.setText("Conseseguiu a quantidade de materias");

        



    }
    
}
