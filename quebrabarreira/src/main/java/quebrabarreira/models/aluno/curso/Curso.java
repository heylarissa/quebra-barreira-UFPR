package quebrabarreira.models.aluno.curso;

import java.util.List;

public class Curso {
    
    private String codigoCurso; // COD_CURSO
    private String nomeCurso; // NOME_CURSO
    private int grade; // NUM_VERSAO
    private List<Disciplina> disciplinas;

    public Curso(){}

    public void setCodigoCurso (String codigoCurso){
        this.codigoCurso = codigoCurso;
    }

    public String getCodigoCurso (){
        return this.codigoCurso;
    }

    public void setnomeCurso (String nomeCurso){
        this.nomeCurso = nomeCurso;
    }

    public String getNomeCurso(){
        return this.nomeCurso;
    }

    public void setGradeAno (int grade){
        this.grade = grade;
    }
    public int getGradeAno (){
        return this.grade;
    }

    public void setDisciplinas(List<Disciplina> disciplinas){
        this.disciplinas = disciplinas;
    }

    public List<Disciplina> getDisciplinas(){
        return this.disciplinas;
    }

}
