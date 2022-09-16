package quebrabarreira.models.formulario;

import java.util.List;

import quebrabarreira.models.Pedido;
import quebrabarreira.models.aluno.Aluno;

public class Formulario {
    private Aluno aluno;
    private Pedido pedido;
    private boolean temCondicoes;
    private List<String> disciplinasSolicitadas;
    private String justificativa;

    public Formulario() {
    }

    public Formulario(
            Aluno aluno,
            boolean temCondicoes,
            List<String> disciplinasSolicitadas,
            String justificativa) {
        this.aluno = aluno;
        this.temCondicoes = temCondicoes;
        this.disciplinasSolicitadas = disciplinasSolicitadas;
        this.justificativa = justificativa;
    }

    public Aluno getAluno() {
        return this.aluno;
    }

    public void setAluno(Aluno aluno) {
        this.aluno = aluno;
    }

    public Pedido getPedido(){
        return this.pedido;
    }

    public boolean isTemCondicoes() {
        return this.temCondicoes;
    }

    public void setTemCondicoes(boolean temCondicoes) {
        this.temCondicoes = temCondicoes;
    }

    public List<String> getDisciplinasSolicitadas() {
        return this.disciplinasSolicitadas;
    }

    public void setDisciplinasSolicitadas(List<String> disciplinasSolicitadas) {
        this.disciplinasSolicitadas = disciplinasSolicitadas;
    }

    public String getJustificativa() {
        return justificativa;
    }

    public void setJustificativa(String justificativa) {
        this.justificativa = justificativa;
    }

}
