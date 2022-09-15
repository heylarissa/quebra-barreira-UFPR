package quebrabarreira.models.aluno;

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

    public Aluno() {
    }

    public Aluno (String nome, String grr, Curso curso){
        this.nome = nome;
        this.grr = grr;
        this.curso = curso;
    }

    public Aluno (String nome, String grr, Curso curso, List<HistoricoDisciplina> disciplinas){
        this.nome = nome;
        this.grr = grr;
        this.curso = curso;
        this.disciplinas = disciplinas;
    }

    public String getNome() {
        return nome;
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

    public void setUltimoPeriodoCursado(int ultimoPeriodoCursado){
        this.ultimoPeriodoCursado = ultimoPeriodoCursado;
    }

    public int getUltimoPeriodoCursado(){
        return ultimoPeriodoCursado;
    }

}
