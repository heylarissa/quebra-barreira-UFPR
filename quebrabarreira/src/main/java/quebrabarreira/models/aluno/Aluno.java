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
    private int taxaAprovacao;
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

    public int getTaxaAprovacaoUltimoPeriodo() {
        return this.taxaAprovacao;
    }

    public void setTaxaAprovacaoUltimoPeriodo(int taxaAprovacao) {
        this.taxaAprovacao = taxaAprovacao;
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

    public List<HistoricoDisciplina> HistoricoUltimoPeriodoCursado(List<HistoricoDisciplina> disciplinas,
            int ultimoPeriodoCursado) {
        List<HistoricoDisciplina> ultimoPeriodoHistorico = new ArrayList<HistoricoDisciplina>();

        for (HistoricoDisciplina disciplina : disciplinas) {
            if (disciplina.getPeriodo() == this.getUltimoPeriodoCursado()) {
                ultimoPeriodoHistorico.add(disciplina);
            }
        }

        return ultimoPeriodoHistorico;
    }

    public double calcularIRAUltimoPeriodo() {
        double ira;
        double somatorioMedia = 0;
        double cargaHorariaTotal = 0;
        List<HistoricoDisciplina> historico = HistoricoUltimoPeriodoCursado(disciplinas, ultimoPeriodoCursado);

        for (HistoricoDisciplina disciplina : historico) {
            somatorioMedia = somatorioMedia + disciplina.getMedia() * disciplina.getDisciplina().getCargaHoraria();
            cargaHorariaTotal = cargaHorariaTotal + disciplina.getDisciplina().getCargaHoraria();
        }

        cargaHorariaTotal = cargaHorariaTotal * 100;
        ira = somatorioMedia / cargaHorariaTotal;
        return ira;
    }

    public double calculateIra() {
        double ira;
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
        ira = somatorioMedia / cargaHorariaTotal;
        return ira;
    }

}
