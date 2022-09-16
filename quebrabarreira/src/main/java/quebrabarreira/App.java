package quebrabarreira;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import quebrabarreira.controllers.AlunoController;
import quebrabarreira.models.Pedido;
// import quebrabarreira.controllers.PedidoController;
// import quebrabarreira.view.TelaInicial;
import quebrabarreira.models.aluno.historico.HistoricoDisciplina;

public class App {
    public static void main(String[] args) throws IOException {

        // System.out.println( "Hello World!" );

        // TelaInicial tela = new TelaInicial();
        // tela.Tela_Inicial();

        int ano = 2019;
        String historicoPath = "./src/main/resources/historicoAluno.csv";
        String gradePath = "./src/main/resources/grade2019.csv";

        AlunoController aluno = new AlunoController(ano, historicoPath, gradePath);

        // // tela info aluno
        // System.out.println("GRR " + aluno.getAluno().getGRR());
        // System.out.println("NOME " + aluno.getAluno().getNome());
        // System.out.println("IRA " + aluno.getAluno().getIra());
        // System.out.println("ULTIMO PERIODO TAXA APROV " + aluno.getAluno().getTaxaAprovacaoUltimoPeriodo());
        // System.out.println("ULTIMO ANO CURSADO " + aluno.getAluno().getUltimoAnoCursado());
        // System.out.println("ULTIMO PERIODO " + aluno.getAluno().getUltimoPeriodoCursado());

        // List<String> materiasPedidas = new ArrayList<>();
        // materiasPedidas.add("CI1061");
        // materiasPedidas.add("CI1163");
        // materiasPedidas.add("CI1350");
        // materiasPedidas.add("CI1215");
        // materiasPedidas.add("CI1165");
        // materiasPedidas.add("CI1028");
        // Pedido pedido = new Pedido(aluno.getAluno().getGRR(), "1", materiasPedidas);
        // pedido.savePedido();
        // pedido.readPedido();
        
        // List<String> res = new ArrayList<>();
        // res = pedido.trataPedido(aluno);
        // System.out.println(res);
    }
}