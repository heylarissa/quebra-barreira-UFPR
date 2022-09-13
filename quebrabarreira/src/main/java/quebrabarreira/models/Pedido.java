package quebrabarreira.models;

import java.util.List;

public class Pedido {
    String grr;
    String numeroPedido;
    List<String> materias;

    public Pedido(String grr, String numeroPedido, List<String> materias) {
        this.grr = grr;
        this.numeroPedido = numeroPedido;
        this.materias = materias;
    }

    public String getNumeroPedido() {
        return this.numeroPedido;
    }

    public void setNumeroPedido(String numeroPedido) {
        this.numeroPedido = numeroPedido;
    }

    public String getGrr() {
        return this.grr;
    }

    public void setGrr(String grr) {
        this.grr = grr;
    }

    public List<String> getMaterias() {
        return this.materias;
    }

    public void setMaterias(List<String> materias) {
        this.materias = materias;
    }

    public void savePedido() {
        PedidoDAO dao = new PedidoDAO(this);
        dao.writePedido();
    }

    public void readPedido() {
        PedidoDAO dao = new PedidoDAO(this);
        dao.readPedido();
    }
}
