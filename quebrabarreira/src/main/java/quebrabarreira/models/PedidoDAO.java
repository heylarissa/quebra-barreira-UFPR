package quebrabarreira.models;

import java.util.ArrayList;
import java.util.List;

import quebrabarreira.Utils.FileHandle;

public class PedidoDAO {

    public FileHandle ioHandler = new FileHandle();
    String basePath = "./src/main/resources/";
    String pathExtension = ".csv";
    String path;
    Pedido pedido;

    public PedidoDAO(Pedido pedido) {
        this.pedido = pedido;
        this.path = this.basePath + "Pedido" + pedido.getGrr() + this.pathExtension;
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

        for (String materia : pedido.getMaterias()) {
            List<String> l = new ArrayList<>();
            l.add(materia);
            lines.add(l);
        }

        this.ioHandler.writeCsvFile(this.path, lines);
        return this.path;
    }

    public List<List<String>> getGrades() {
        List<List<String>> materias2011 = new ArrayList<>();
        List<List<String>> materias2019 = new ArrayList<>();

        materias2011 = this.ioHandler.readCsvFile("./src/main/resources/grade2011.csv");
        materias2019 = this.ioHandler.readCsvFile("./src/main/resources/grade2019.csv");

        materias2011 = materias2011.subList(2, materias2011.size());
        materias2019 = materias2019.subList(2, materias2019.size());

        materias2011.addAll(materias2019);
        return materias2011;
    }

}