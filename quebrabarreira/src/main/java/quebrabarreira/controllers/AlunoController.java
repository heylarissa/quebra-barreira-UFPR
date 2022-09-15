package quebrabarreira.controllers;

import java.io.IOException;

import quebrabarreira.models.aluno.Aluno;
import quebrabarreira.models.aluno.AlunoDAO;
import quebrabarreira.models.aluno.curso.Curso;
import quebrabarreira.models.aluno.curso.CursoDAO;

public class AlunoController {
    Aluno aluno;

    public AlunoController(int ano, String historicoFileName) throws IOException{
        setAluno(AlunoDAO.lerHistorico(historicoFileName), ano);
        
    }

    public void setAluno(Aluno aluno, int ano) {
        
        CursoDAO DAO = new CursoDAO();
        Curso newCurso = DAO.lerGrade(ano);
        aluno.setCurso(newCurso);

        this.aluno = aluno;
    }

    public Aluno getAluno() {
        return this.aluno;
    }



}
