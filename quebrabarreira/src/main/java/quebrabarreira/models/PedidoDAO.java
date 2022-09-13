package quebrabarreira.models;

import java.util.ArrayList;
import java.util.List;

public class PedidoDAO {

    FileHandle ioHandler = new FileHandle();
    String basePath = "quebrabarreira/src/main/resources/";
    String pathExtension = ".csv";
    String path;
    Pedido pedido;

    public PedidoDAO(Pedido pedido) {
        this.pedido = pedido;
        this.path = this.basePath + "Pedido" + pedido.getGrr() + pedido.getNumeroPedido() + this.pathExtension;
    }

    /**
     * Reads materias from file in path into pedido
    */
    public List<String> readPedido() {
        List<List<String>> res = new ArrayList<>();
        List<String> lines = new ArrayList<>();

        res = ioHandler.readCsvFile(this.path);

        for(List<String> line: res) {
            lines.add(line.get(0));
        }

        this.pedido.setMaterias(lines);
        return this.pedido.getMaterias();
    }

    /** 
     * @return path pedido was saved
     */
    public String writePedido() {

        List<List<String>> lines = new ArrayList<>();

        // Que construção feia, queria uma list comprehension nessas horas
        for (String materia : pedido.getMaterias()) {
            List<String> l = new ArrayList<>();
            l.add(materia);
            lines.add(l);
        }

        this.ioHandler.writeCsvFile(this.path, lines);
        return this.path;
    }

}