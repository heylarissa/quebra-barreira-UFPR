package quebrabarreira;

import java.util.ArrayList;
import java.util.List;

import quebrabarreira.controllers.AlunoController;
import quebrabarreira.controllers.PedidoController;
import quebrabarreira.models.Aluno;
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
        
        List<String> materias = new ArrayList<>();
        materias.add("calc 1");
        materias.add("alg 1");
        materias.add("SO");
        materias.add("paradinhas");
        Pedido pedido = new Pedido("GRR",
                                     "NUMERO", 
                                     materias);
        pedido.savePedido();
        pedido.readPedido();
        System.out.println(pedido.getMaterias());
    }
}
