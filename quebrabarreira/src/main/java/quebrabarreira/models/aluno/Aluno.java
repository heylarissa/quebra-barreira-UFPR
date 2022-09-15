package quebrabarreira.models.aluno;

import java.util.List;

import quebrabarreira.models.aluno.historico.HistoricoDisciplina;

public class Aluno {
    private String nome;
    private String grr;
    private String curso;
    private List<HistoricoDisciplina> disciplinas;
    private int ultimoAnoCursado;
    private int ultimoPeriodoCursado;

    public Aluno() {
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

    public String getCurso() {
        return curso;
    }

    public void setCurso(String newCurso) {
        this.curso = newCurso;
    }

    public List<HistoricoDisciplina> getHistoricos() {
        return disciplinas;
    }

    public void setHistoricos(List<HistoricoDisciplina> disciplinas) {
        this.disciplinas = disciplinas;
    }

    public void setUltimoAnoCursado(int ultimoAnoCursado) {
    }

    public int getUltimoAnoCursado() {
        return ultimoAnoCursado;
    }

    public void setUltimoPeriodoCursado(int ultimoPeriodoCursado){
    }

    public int getUltimoPeriodoCursado(){
        return ultimoPeriodoCursado;
    }


}
