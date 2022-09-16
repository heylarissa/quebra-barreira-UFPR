package quebrabarreira;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import quebrabarreira.controllers.AlunoController;
import quebrabarreira.controllers.PedidoController;

public class App 
{
    public static void main( String[] args ) throws IOException
    {
        int ano = 2019; 
        String historicoPath = "./src/main/resources/historicoAluno.csv";    
        String gradePath = "./src/main/resources/grades2011_2019.csv";
        
        AlunoController aluno = new AlunoController(ano, historicoPath, gradePath);
        
        aluno.getAluno().setIra(0.6);
        aluno.getAluno().setTaxaAprovacaoUltimoPeriodo(0.7);

        List<String> materias = new ArrayList<>();
        Scanner scanner = new Scanner(System.in);
        while(true) {
            String nextLine = scanner.nextLine();
            if ( nextLine.equals("") ) {
               break;
            }
            materias.add(nextLine);
        }
        scanner.close();
        
        PedidoController pedido = new PedidoController("GRR20190471", materias);
        pedido.getPedido().savePedido();
        System.out.println(pedido.getPedido().trataPedido(aluno));
        
    }
}