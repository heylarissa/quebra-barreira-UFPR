package quebrabarreira.models;

import quebrabarreira.models.Historico;
import java.util.List;

public class Historico {
    List<Historico> disciplinas;
    double ira;
    double taxaAprovacao;

    public List<Historico> getDisciplinas() {
        return this.disciplinas;
    }

    public void setDisciplinas(List<Historico> disciplinas) {
        this.disciplinas = disciplinas;
    }

    public double getIra() {
        return this.ira;
    }

    public void setIra(double ira) {
        this.ira = ira;
    }

    public double getTaxaAprovacao() {
        return this.taxaAprovacao;
    }

    public void setTaxaAprovacao(double taxaAprovacao) {
        this.taxaAprovacao = taxaAprovacao;
    }

    public double calcularIRA() {
        double somatorio = 0;
        double cargaHorariaTotal = 0;
        return somatorio / cargaHorariaTotal;
    }

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
