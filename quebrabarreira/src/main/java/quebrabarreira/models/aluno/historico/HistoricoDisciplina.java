package quebrabarreira.models.aluno.historico;

import quebrabarreira.models.aluno.curso.Disciplina;
import quebrabarreira.models.aluno.historico.HistoricoDisciplina;

public class HistoricoDisciplina {
    private Disciplina disciplina;
    private double ira;
    private double taxaAprovacao;
    private int ano;
    private String situacao; // SITUACAO {aprovado, reprovado, matriculado}
    private int frequencia;
    private int media;
    private int periodo;
    
    public HistoricoDisciplina (){}
    public HistoricoDisciplina ( Disciplina disciplina, 
                                 int ano, 
                                 int media, 
                                 String situacao, 
                                 int periodo, 
                                 int frequencia){
        this.disciplina = disciplina;
        this.ano = ano;
        this.media = media;
        this.periodo = periodo;
        this.frequencia = frequencia;
        this.situacao = situacao;
    }

    public void setPeriodo (int periodo){
        this.periodo = periodo;
    }

    public int getPeriodo(){
        return this.periodo;
    }

    public int getFrequencia (){
        return this.frequencia;
    }

    public void setFrequencia(int frequencia){
        this.frequencia = frequencia;
    }
    public void setSituacao (String situacao){
        this.situacao = situacao;
    }

    public String getSituacao (){
        return this.situacao;
    }

    public int getAno(){
        return this.ano;
    }

    public void setAno(int ano){
        this.ano = ano;
    }

    public int getMedia (){
        return this.media;
    }

    public void setMedia (int media){
        this.media = media;
    }

    public Disciplina getDisciplina() {
        return this.disciplina;
    }

    public void setDisciplina(Disciplina disciplina) {
        this.disciplina = disciplina;
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

    public double calcularIRAUltimoPeriodo() {

        double IRA=0;
        return IRA;
    }

    public double taxaAprovacao() {
        double taxa=0;
        return taxa;

    }
}