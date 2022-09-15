package quebrabarreira.models.aluno.historico;

import quebrabarreira.models.aluno.curso.Disciplina;
import quebrabarreira.models.aluno.historico.HistoricoDisciplina;

public class HistoricoDisciplina {
    private Disciplina disciplina;
    private int ano;
    private String situacao; // SITUACAO {aprovado, reprovado, matriculado}
    private int frequencia;
    private double media;
    private int periodo;
    
    public HistoricoDisciplina (){}
    public HistoricoDisciplina ( Disciplina disciplina, 
                                 int ano, 
                                 double media, 
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

    public double getMedia (){
        return this.media;
    }

    public void setMedia (double media){
        this.media = media;
    }

    public Disciplina getDisciplina() {
        return this.disciplina;
    }

    public void setDisciplina(Disciplina disciplina) {
        this.disciplina = disciplina;
    }

    public double taxaAprovacao() {
        double taxa=0;
        return taxa;

    }
}
