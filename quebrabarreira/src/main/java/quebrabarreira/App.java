package quebrabarreira;

import java.io.IOException;

import quebrabarreira.controllers.AlunoController;
import quebrabarreira.controllers.FormularioController;
import quebrabarreira.view.InterfaceGrafica;

public class App 
{
    public static void main( String[] args ) throws IOException
    {
        int ano = 2019; 
        String historicoPath = "./src/main/resources/historicoAluno.csv";    
        String gradePath = "./src/main/resources/grade2019.csv";
        
        AlunoController aluno = new AlunoController(ano, historicoPath, gradePath);
        FormularioController formController = new FormularioController();

        // TelaInicial tela = new TelaInicial(aluno);
        // tela.Tela_Inicial(aluno);

        // tela info aluno
        // System.out.println(aluno.getAluno().getGRR());
        // System.out.println(aluno.getAluno().getNome());
        // System.out.println(aluno.getAluno().getIra());
        // System.out.println(aluno.getAluno().getTaxaAprovacaoUltimoPeriodo());
        // System.out.println(aluno.getAluno().getUltimoAnoCursado());
        // System.out.println(aluno.getAluno().getUltimoPeriodoCursado());
        
        // PedidoController Pedido = new PedidoController();

        // FileHandle file = new FileHandle();
        // List<HashMap<String, String>> result;
        // result = file.getCsv(gradePath);


        InterfaceGrafica.Invoke(aluno, formController);

    }
}