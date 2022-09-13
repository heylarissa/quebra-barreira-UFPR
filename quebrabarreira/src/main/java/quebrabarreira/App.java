package quebrabarreira;

import quebrabarreira.controllers.AlunoController;
import quebrabarreira.controllers.PedidoController;
import quebrabarreira.models.Aluno;
import quebrabarreira.view.TelaInicial;

public class App {
    public static void main( String[] args ){
        TelaInicial tela = new TelaInicial();
        // System.out.println( "Hello World!" );
        // String gradePath = "./src/main/resources/grade2019.csv";
        // String historicoPath = "./src/main/resources/historicoaluno.csv";
// 
        // AlunoController Aluno = new AlunoController();
        // PedidoController Pedido = new PedidoController();

        tela.Tela_Inicial();
    }
}
