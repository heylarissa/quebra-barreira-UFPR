package quebrabarreira;

import java.util.ArrayList;
import java.util.List;

import quebrabarreira.controllers.AlunoController;
import quebrabarreira.controllers.PedidoController;
import quebrabarreira.models.Aluno;
import quebrabarreira.models.FileHandle;
import quebrabarreira.models.Historico;
import quebrabarreira.models.Pedido;
import quebrabarreira.models.PedidoDAO;
import quebrabarreira.view.telaInicial;

public class App 
{
    public static void main( String[] args )
    {
        // System.out.println( "Hello World!" );
        // String gradePath = "./src/main/resources/grade2019.csv";
        // String historicoPath = "./src/main/resources/historicoaluno.csv";

        // AlunoController Aluno = new AlunoController();
        // PedidoController Pedido = new PedidoController();

        // telaInicial.printAlunoInfo(Aluno);

        
        Historico historico = new Historico();
        historico.setIra(0.9);
        historico.setTaxaAprovacao(0.5);

        List<String> materias = new ArrayList<>();
        materias.add("CI1058");
        materias.add("CI1057");
        materias.add("CI1005");
        materias.add("CI1062");
        Pedido pedido = new Pedido("GRR",
                                     "NUMERO", 
                                     materias);
        pedido.savePedido();
        pedido.readPedido();

        List<String> res = pedido.trataPedido(historico);  
        System.out.println(res);
    }
}
