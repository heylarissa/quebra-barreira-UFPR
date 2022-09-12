package quebrabarreira.controllers;

import quebrabarreira.models.Aluno;

public class AlunoController {
    Aluno aluno;

    public void setAluno(Aluno aluno) {
        // adicionar historico ao aluno
        this.aluno = aluno;
    }

    public Aluno getAluno (){
        return this.aluno;
    }
}
