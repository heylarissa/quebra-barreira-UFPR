package quebrabarreira.controllers;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import quebrabarreira.models.aluno.Aluno;
import quebrabarreira.models.aluno.AlunoDAO;
import quebrabarreira.models.aluno.curso.Curso;
import quebrabarreira.models.aluno.curso.CursoDAO;
import quebrabarreira.models.aluno.historico.HistoricoDisciplina;

public class AlunoController {
    Aluno aluno;

    public AlunoController(int ano, String historicoPath, String gradePath) throws IOException {
        setAluno(aluno, ano, historicoPath, gradePath);
    }


    public void setAluno(Aluno aluno, int ano, String historicoPath, String gradePath) throws IOException {
        CursoDAO DAO = new CursoDAO();
        Curso newCurso = DAO.lerGrade(ano, gradePath);
        

        aluno = AlunoDAO.lerHistorico(historicoPath);
        aluno.setCurso(newCurso);

        /* Calcula o IRA */
        double ira = aluno.calculateIra();
        aluno.setIra(ira);

        /* Define o último periodo */
        int ultimoPeriodo = aluno.calculaUltimoPeriodo();
        aluno.setUltimoPeriodoCursado(ultimoPeriodo);

        // double iraUltimo = aluno.calcularIRAUltimoPeriodo();
        // aluno.setIraUltimoPeriodo(iraUltimo);
        
        aluno.setUltimoPeriodoDisciplinas(aluno.historicosUltimoPeriodo());
        double taxa = aluno.calcularTaxaAprovacaoUltimoPeriodo(aluno.getUltimoPeriodoDisciplinas());
        aluno.setTaxaAprovacaoUltimoPeriodo(taxa);
        this.aluno = aluno;
    }

    public Aluno getAluno() {
        return this.aluno;
    }

}
