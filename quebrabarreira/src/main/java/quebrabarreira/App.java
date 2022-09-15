package quebrabarreira;

import java.io.IOException;
import java.util.HashMap;
import java.util.List;

import quebrabarreira.Utils.FileHandle;
import quebrabarreira.controllers.AlunoController;
//import quebrabarreira.controllers.PedidoController;
import quebrabarreira.models.aluno.Aluno;
//import quebrabarreira.view.telaInicial;

public class App 
{
    public static void main( String[] args ) throws IOException
    {
        System.out.println( "Hello World!" );
        int ano = 2019; 
        String historicoPath = "./src/main/resources/historicoAluno.csv";    
        String gradePath = "./src/main/resources/grade2019.csv";
        
        AlunoController aluno = new AlunoController(ano, historicoPath, gradePath);
        Aluno teste;
        teste = aluno.getAluno();
        System.out.println(teste.getGRR());
        // String gradePath = "./src/main/resources/grade2019.csv";
        // String historicoPath = "./src/main/resources/historicoaluno.csv";

        // AlunoController Aluno = new AlunoController();
        // PedidoController Pedido = new PedidoController();

        FileHandle file = new FileHandle();
        List<HashMap<String, String>> result;
        result = file.getCsv(historicoPath);

        for (HashMap<String,String> hashMap : result) {
            System.out.println(hashMap.get("PERIODO"));
        }

    }
}
