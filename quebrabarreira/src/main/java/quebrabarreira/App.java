package quebrabarreira;

import java.io.IOException;

import quebrabarreira.controllers.AlunoController;
// import quebrabarreira.controllers.PedidoController;
// import quebrabarreira.view.TelaInicial;


public class App 
{
    public static void main( String[] args ) throws IOException
    {

        // System.out.println( "Hello World!" );

        // TelaInicial tela = new TelaInicial();
        // tela.Tela_Inicial();

        int ano = 2019; 
        String historicoPath = "./src/main/resources/historicoAluno.csv";    
        String gradePath = "./src/main/resources/grade2019.csv";
        
        AlunoController aluno = new AlunoController(ano, historicoPath, gradePath);

        // tela info aluno
        System.out.println("GRR " + aluno.getAluno().getGRR());
        System.out.println("NOME " + aluno.getAluno().getNome());
        System.out.println("IRA " + aluno.getAluno().getIra());
        System.out.println("ULTIMO PERIODO TAXA APROV " + aluno.getAluno().getTaxaAprovacaoUltimoPeriodo());
        System.out.println("ULTIMO ANO CURSADO " + aluno.getAluno().getUltimoAnoCursado());
        System.out.println("ULTIMO PERIODO " + aluno.getAluno().getUltimoPeriodoCursado());
        System.out.println("ULTIMO PERIODO IRA " + aluno.getAluno().getIraUltimoPeriodo());
        
        // PedidoController Pedido = new PedidoController();

        // FileHandle file = new FileHandle();
        // List<HashMap<String, String>> result;
        // result = file.getCsv(gradePath);

        // for (HashMap<String,String> hashMap : result) {
        //     System.out.println(hashMap.get("PERIODO_IDEAL"));
        //     System.out.println(hashMap.get("CH_TOTAL"));
        //     System.out.println(hashMap.get("COD_DISCIPLINA"));
        //     // System.out.println(hashMap.get("PERIODO"));
        //     // System.out.println(hashMap.get("PERIODO"));
        //     // System.out.println(hashMap.get("PERIODO"));
        //     // System.out.println(hashMap.get("PERIODO"));
        //     // System.out.println(hashMap.get("PERIODO"));
        //     // System.out.println(hashMap.get("PERIODO"));

        // }
    }
}