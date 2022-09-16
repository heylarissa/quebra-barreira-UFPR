package quebrabarreira.controllers;

import java.util.List;

import quebrabarreira.models.Pedido;

public class PedidoController {
    Pedido pedido;

    public PedidoController(String grr, List<String> materias) {
        this.pedido = new Pedido(grr, materias);
    }

    public void setPedido(Pedido pedido) {
        this.pedido = pedido;
    }

    public Pedido getPedido() {
        return this.pedido;
    }

}
