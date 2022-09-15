package quebrabarreira.controllers;

import quebrabarreira.models.aluno.Aluno;

public class AlunoController {
    Aluno aluno;
    private String historicoPath;
    private String gradePath;

    public void setAluno(Aluno aluno) {
        // adicionar historico ao aluno
        this.aluno = aluno;
    }

    public Aluno getAluno() {
        return this.aluno;
    }

    public void setHistoricoPath(String historicoPath) {
        this.historicoPath = historicoPath;
    }

    public String getHistoricoPath() {
        return this.historicoPath;
    }

    public String getGradePath() {
        return gradePath;
    }

    public void setGradePath(String gradePath) {
        this.gradePath = gradePath;
    }

}
