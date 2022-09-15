package quebrabarreira.models.aluno.curso;

public class Disciplina {
    private String nomeDisciplina; // COD_ATIV_CURRIC
    private int periodoIdeal;
    private String codigoDisciplina; // COD_ATIV_CURRIC
    private String classificacao; // DESCR_ESTRUTURA {obrigatoria, optativa, tcc, estagio obrigatorio}
    private int cargaHoraria; // CH_TOTAL (horas)

    public Disciplina(){}

    // public Disciplina(String codigoDisciplina, String nomeDisciplina, int periodoIdeal, String classificacao,
    //         int cargaHoraria) {
    //     this.codigoDisciplina = codigoDisciplina;
    //     this.nomeDisciplina = nomeDisciplina;
    //     this.periodoIdeal = periodoIdeal;
    //     this.classificacao = classificacao;
    //     this.cargaHoraria = cargaHoraria;
    // }

    public void setPeriodoIdeal(int periodoIdeal) {
        this.periodoIdeal = periodoIdeal;
    }

    public int getPeriodoIdeal (){
        return this.periodoIdeal;
    }

    public void setCodigoDisciplina(String codigoDisciplina) {
        this.codigoDisciplina = codigoDisciplina;
    }

    public String getCodigoDisciplina (){
        return this.codigoDisciplina;
    }

    public void setNomeDisciplina(String nomeDisciplina) {
        this.nomeDisciplina = nomeDisciplina;
    }

    public String getNomeDisciplina (){
        return this.nomeDisciplina;
    }

    public void setCargaHoraria(int cargaHoraria) {
        this.cargaHoraria = cargaHoraria;
    }

    public int getCargaHoraria() {
        return cargaHoraria;
    }

    public void setClassificacao(String classificacao) {
        this.classificacao = classificacao;
    }

    public String getClassificacao() {
        return classificacao;
    }

}
