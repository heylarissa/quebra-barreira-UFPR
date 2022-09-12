package quebrabarreira.models;

import quebrabarreira.models.Historico;
import java.util.List;

public class Historico {
    public double calcularIRA() {
        double somatorio = 0;
        double cargaHorariaTotal = 0;
        return somatorio / cargaHorariaTotal;
    }

    List<Historico> disciplinas;
    // to do
    public List<Historico> historicosUltimoPeriodo() {
        return this.disciplinas;
    }

    public double calcularIRAUltimoPeriodo() {

        double IRA=0;
        return IRA;
    }

    public double taxaAprovacao() {
        double taxa=0;
        return taxa;

    }
}
