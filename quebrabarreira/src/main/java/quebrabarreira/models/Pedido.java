package quebrabarreira.models;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.List;

import quebrabarreira.models.aluno.historico.HistoricoDisciplina;

public class Pedido {
    String grr;
    String numeroPedido;
    List<String> materias;
    List<String> resultado;
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


    public List<String> trataPedido(HistoricoDisciplina historico) {

        List<List<String>> grade = this.dao.getGrades();
        
        // Ordena as materias por periodo
        HashMap<String, Integer> gradePeriodo = new HashMap<>(); // Materia: Perido - Para toda a grade
        final HashMap<String, Integer> materias = new HashMap<>(); // Materia: Periodo - Para as materias do pedido
        
        for(List<String> mat: grade) {            
            if (mat.size() > 6) {
                int periodo;
                if (mat.get(6).equals("")) periodo = 10;
                else periodo = Integer.parseInt(mat.get(6));   
                
                gradePeriodo.put(mat.get(3), periodo);
            }
        }
        
        for(String mat: this.materias) {
            materias.put(mat, gradePeriodo.get(mat));
        }
        
        // List optativas
        List<String> optativas = new ArrayList<>();
        for (List<String> mat: grade) {
            if (mat.size() > 8) {
                if (mat.get(8).compareTo("Optativa") == 0) {
                    optativas.add(mat.get(3));
                }
            }
        }

        Collections.sort(this.materias, new Comparator<String>(){
            public int compare(String item1, String item2){
                int compare = materias.get(item1) - materias.get(item2);
                if(compare == 0)
                {  
                    return (item1.compareTo(item2)); 
                }
                return compare;
            }
        });

        if (historico.getIra() >= 0.8) {
            this.resultado = new ArrayList<>(this.materias);
            return this.resultado;
        
        } else if (historico.getTaxaAprovacao() > (2/3)) {
            this.resultado = new ArrayList<>(this.materias.subList(0, 5+1));
            return this.resultado;
        
        } else if (historico.getTaxaAprovacao() > (1/2)) {
            this.resultado = new ArrayList<>(this.materias.subList(0, 4+1));
            return this.resultado;
        
        } else {
            this.resultado = new ArrayList<>(this.materias.subList(0, 3+1));
            return this.resultado;
        }

    }
    

}
