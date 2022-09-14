package quebrabarreira.models;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class Pedido {
    String grr;
    String numeroPedido;
    List<String> materias;
    public PedidoDAO dao;
    
    public Pedido(String grr, String numeroPedido, List<String> materias) {
        this.grr = grr;
        this.numeroPedido = numeroPedido;
        this.materias = materias;
        this.dao = new PedidoDAO(this);
    }

    public String getNumeroPedido() {return this.numeroPedido;}
    public void setNumeroPedido(String numeroPedido) {this.numeroPedido = numeroPedido;}
    public String getGrr() {return this.grr;}
    public void setGrr(String grr) {this.grr = grr;}
    public List<String> getMaterias() {return this.materias;}
    public void setMaterias(List<String> materias) {this.materias = materias;}

    public void savePedido() {
        this.dao.writePedido();
    }

    public void readPedido() {
        this.dao.readPedido();
    }

    public List<String> trataPedido(Historico historico) {

        List<List<String>> grade = this.dao.getGrades();
        
        // Ordena as materias por periodo
        HashMap<String, Integer> gradePeriodo = new HashMap<>();
        HashMap<String, Integer> materias = new HashMap<>();

        for(List<String> mat: grade) {
            gradePeriodo.put(mat.get(3), Integer.parseInt(mat.get(6)));
        }

        for(String mat: this.materias) {
            materias.put(mat, gradePeriodo.get(mat));
        }
        
        System.out.println(materias);

        if (historico.getIra() > 0.8) {
            return this.materias;
        } else if (true) {

        }

        return this.materias;
    }

}
