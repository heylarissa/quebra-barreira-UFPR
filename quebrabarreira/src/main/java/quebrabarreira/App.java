package quebrabarreira;

import quebrabarreira.controllers.AlunoController;
import quebrabarreira.controllers.PedidoController;
import quebrabarreira.view.TelaInicial;

public class App 
{
    public static void main( String[] args )
    {
        System.out.println( "Hello World!" );

        //AlunoController Aluno = new AlunoController();
        //PedidoController Pedido = new PedidoController();
        TelaInicial tela = new TelaInicial();
        tela.Tela_Inicial();
    }
}