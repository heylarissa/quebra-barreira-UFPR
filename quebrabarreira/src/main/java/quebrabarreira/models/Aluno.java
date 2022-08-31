package quebrabarreira.models;

public class Aluno {
    String nome;
    String grr;
    String curso;
    String historico;

    public Aluno (){}

    public String getNome(){
        return nome;
    }

    public void setNome(String novoNome){
        this.nome = novoNome;
    }

    public String getGRR(){
        return grr;
    }

    public void setGRR(String newGRR){
        this.grr = newGRR;
    }

    public String getCurso(){
        return curso;
    }

    public void setCurso(String newCurso){
        this.curso = newCurso;
    }


}
