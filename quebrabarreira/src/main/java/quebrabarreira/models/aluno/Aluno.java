package quebrabarreira.models.aluno;

import java.util.ArrayList;
import java.util.List;

import quebrabarreira.models.aluno.curso.Curso;
import quebrabarreira.models.aluno.historico.HistoricoDisciplina;

public class Aluno {
    private String nome;
    private String grr;
    private Curso curso;
    private List<HistoricoDisciplina> disciplinas;
    private int ultimoAnoCursado;
    private int ultimoPeriodoCursado;
    private double taxaAprovacaoUltimoPeriodo;
    private double ira;
    private double iraUltimoPeriodo;

    public Aluno() {
    }

    public Aluno(String nome, String grr, Curso curso) {
        this.nome = nome;
        this.grr = grr;
        this.curso = curso;
    }

    public Aluno(String nome, String grr, Curso curso, List<HistoricoDisciplina> disciplinas) {
        this.nome = nome;
        this.grr = grr;
        this.curso = curso;
        this.disciplinas = disciplinas;
    }

    public double getIra() {
        return this.ira;
    }

    public void setIra(double ira) {
        this.ira = ira;
    }

    public double getIraUltimoPeriodo() {
        return this.ira;
    }

    public void setIraUltimoPeriodo(double ira) {
        this.ira = ira;
    }

    public String getNome() {
        return nome;
    }

    public double getTaxaAprovacaoUltimoPeriodo() {
        return this.taxaAprovacaoUltimoPeriodo;
    }

    public void setTaxaAprovacaoUltimoPeriodo(double taxaAprovacao) {
        this.taxaAprovacaoUltimoPeriodo = taxaAprovacao;
    }

    public void setNome(String novoNome) {
        this.nome = novoNome;
    }

    public String getGRR() {
        return grr;
    }

    public void setGRR(String newGRR) {
        this.grr = newGRR;
    }

    public Curso getCurso() {
        return curso;
    }

    public void setCurso(Curso newCurso) {
        this.curso = newCurso;
    }

    public List<HistoricoDisciplina> getHistoricos() {
        return disciplinas;
    }

    public void setHistoricos(List<HistoricoDisciplina> disciplinas) {
        this.disciplinas = disciplinas;
    }

    public void setUltimoAnoCursado(int ultimoAnoCursado) {
        this.ultimoAnoCursado = ultimoAnoCursado;
    }

    public int getUltimoAnoCursado() {
        return ultimoAnoCursado;
    }

    public void setUltimoPeriodoCursado(int ultimoPeriodoCursado) {
        this.ultimoPeriodoCursado = ultimoPeriodoCursado;
    }

    public int getUltimoPeriodoCursado() {
        return this.ultimoPeriodoCursado;
    }

    public double calculateIra() {
        double iraTotal;
        double somatorioMedia = 0;
        double cargaHorariaTotal = 0;
        for (HistoricoDisciplina historicoDisciplina : this.disciplinas) {
            if (historicoDisciplina.getFrequencia() != -1) { // desconsidera materias com situação MATRICULADO
                somatorioMedia = somatorioMedia
                        + historicoDisciplina.getMedia() * historicoDisciplina.getDisciplina().getCargaHoraria();
                cargaHorariaTotal = cargaHorariaTotal + historicoDisciplina.getDisciplina().getCargaHoraria();
            }
        }

        cargaHorariaTotal = cargaHorariaTotal * 100;
        iraTotal = somatorioMedia / cargaHorariaTotal;
        return iraTotal;
    }

    public double calcularTaxaAprovacaoUltimoPeriodo() {
        double taxa;
        int aprovadas = 0;
        int matriculadas = 0;

        for (HistoricoDisciplina historicoDisciplina : historicosUltimoPeriodo()) {
            if (historicoDisciplina.getFrequencia() != -1 & historicoDisciplina.getSituacao() == "Aprovado") { 
                aprovadas++;
            }
            matriculadas++;
        }

        taxa = aprovadas / matriculadas;

        return taxa;
    }

    public List<HistoricoDisciplina> historicosUltimoPeriodo() {
        List<HistoricoDisciplina> historicoUltimoPeriodo = new ArrayList<>();

        for (HistoricoDisciplina historicoDisciplina : this.getHistoricos()) {
            if (historicoDisciplina.getPeriodo() == this.getUltimoPeriodoCursado()
                    && historicoDisciplina.getFrequencia() != -1) {
                historicoUltimoPeriodo.add(historicoDisciplina);
            }
        }

        return historicoUltimoPeriodo;
    }

    public double calcularIRAUltimoPeriodo() {
        double ultimoIra;
        double somatorioMedia = 0;
        double cargaHorariaTotal = 0;

        for (HistoricoDisciplina historicoDisciplina : this.historicosUltimoPeriodo()) {
            if (historicoDisciplina.getFrequencia() != -1) { // desconsidera materias com situação MATRICULADO
                somatorioMedia = somatorioMedia
                        + historicoDisciplina.getMedia() * historicoDisciplina.getDisciplina().getCargaHoraria();
                cargaHorariaTotal = cargaHorariaTotal + historicoDisciplina.getDisciplina().getCargaHoraria();
            }
        }
        cargaHorariaTotal = cargaHorariaTotal * 100;
        ultimoIra = somatorioMedia / cargaHorariaTotal;

        return ultimoIra;
    }

    public int calculaUltimoPeriodo() {
        int ultimoPeriodo = 0;

        for (HistoricoDisciplina historicoDisciplina : disciplinas) {
            if (historicoDisciplina.getPeriodo() > ultimoPeriodo & historicoDisciplina.getFrequencia() != -1) {
                ultimoPeriodo = historicoDisciplina.getPeriodo();
            }
        }

        return ultimoPeriodo;
    }

}