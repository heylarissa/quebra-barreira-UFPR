package quebrabarreira.models.aluno;

import java.util.ArrayList;
import java.util.List;

import quebrabarreira.models.aluno.curso.Curso;
import quebrabarreira.models.aluno.curso.Disciplina;
import quebrabarreira.models.aluno.historico.HistoricoDisciplina;

public class Aluno {
    private String nome;
    private String grr;
    private Curso curso;
    private List<HistoricoDisciplina> historico;
    private List<HistoricoDisciplina> ultimoPeriodoDisciplinas;
    private List<Disciplina> materiasQueFaltaNaBarreira;
    private List<Disciplina> materiasBarreira;
    private List<Disciplina> ofertadasNoSemestreNaoConcluidas;
    private int ultimoAnoCursado;
    private int ultimoPeriodoCursado;
    private double taxaAprovacaoUltimoPeriodo;
    private double ira;

    // private double iraUltimoPeriodo;

    public Aluno() {
    }

    public Aluno(String nome, String grr, Curso curso) {
        this.nome = nome;
        this.grr = grr;
        this.curso = curso;
    }

    public Aluno(String nome, String grr, Curso curso, List<HistoricoDisciplina> historico) {
        this.nome = nome;
        this.grr = grr;
        this.curso = curso;
        this.historico = historico;
    }


    public String getGrr() {
        return this.grr;
    }

    public void setGrr(String grr) {
        this.grr = grr;
    }

    public List<HistoricoDisciplina> getHistorico() {
        return this.historico;
    }

    public void setHistorico(List<HistoricoDisciplina> historico) {
        this.historico = historico;
    }

    public List<Disciplina> getMateriasQueFaltaNaBarreira() {
        return this.materiasQueFaltaNaBarreira;
    }

    public void setMateriasQueFaltaNaBarreira(List<Disciplina> materiasQueFaltaNaBarreira) {
        this.materiasQueFaltaNaBarreira = materiasQueFaltaNaBarreira;
    }

    public List<Disciplina> getOfertadasNoSemestreNaoConcluidas() {
        return this.ofertadasNoSemestreNaoConcluidas;
    }

    public void setOfertadasNoSemestreNaoConcluidas(List<Disciplina> ofertadasNoSemestreNaoConcluidas) {
        this.ofertadasNoSemestreNaoConcluidas = ofertadasNoSemestreNaoConcluidas;
    }

    public double getIra() {
        return this.ira;
    }

    public void setIra(double ira) {
        this.ira = ira;
    }

    public double getIraUltimoPeriodo() {
        return this.ira;
    }

    public void setIraUltimoPeriodo(double ira) {
        this.ira = ira;
    }

    public String getNome() {
        return nome;
    }

    public double getTaxaAprovacaoUltimoPeriodo() {
        return this.taxaAprovacaoUltimoPeriodo;
    }

    public void setTaxaAprovacaoUltimoPeriodo(double taxaAprovacao) {
        this.taxaAprovacaoUltimoPeriodo = taxaAprovacao;
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
        return historico;
    }

    public void setHistoricos(List<HistoricoDisciplina> historico) {
        this.historico = historico;
    }

    public void setUltimoAnoCursado(int ultimoAnoCursado) {
        this.ultimoAnoCursado = ultimoAnoCursado;
    }

    public int getUltimoAnoCursado() {
        return ultimoAnoCursado;
    }

    public void setUltimoPeriodoCursado(int ultimoPeriodoCursado) {
        this.ultimoPeriodoCursado = ultimoPeriodoCursado;
    }

    public int getUltimoPeriodoCursado() {
        return this.ultimoPeriodoCursado;
    }

    public void setUltimoPeriodoDisciplinas(List<HistoricoDisciplina> disciplinasUltimoPeriodo) {
        this.ultimoPeriodoDisciplinas = disciplinasUltimoPeriodo;
    }

    public List<HistoricoDisciplina> getUltimoPeriodoDisciplinas() {
        return this.ultimoPeriodoDisciplinas;
    }

    public List<Disciplina> getMateriasBarreira() {
        return this.materiasBarreira;
    }

    public void setMateriasBarreira(List<Disciplina> materiasBarreira) {
        this.materiasBarreira = materiasBarreira;
    }

    public double calculateIra() {
        double iraTotal;
        double somatorioMedia = 0;
        double cargaHorariaTotal = 0;
        for (HistoricoDisciplina historicoDisciplina : this.getHistoricos()) {
            if (historicoDisciplina.getFrequencia() != -1) { // desconsidera materias com situação MATRICULADO
                somatorioMedia = somatorioMedia
                        + historicoDisciplina.getMedia() * historicoDisciplina.getDisciplina().getCargaHoraria();
                cargaHorariaTotal = cargaHorariaTotal + historicoDisciplina.getDisciplina().getCargaHoraria();
            }
        }

        cargaHorariaTotal = cargaHorariaTotal * 100;
        iraTotal = somatorioMedia / cargaHorariaTotal;
        return iraTotal;
    }

    public int calculaUltimoPeriodo() {
        int ultimoPeriodo = 0;

        for (HistoricoDisciplina historicoDisciplina : this.getHistoricos()) {
            if (historicoDisciplina.getPeriodo() > ultimoPeriodo & historicoDisciplina.getFrequencia() != -1) {
                ultimoPeriodo = historicoDisciplina.getPeriodo();
            }
        }

        return ultimoPeriodo;
    }

    public List<HistoricoDisciplina> historicosUltimoPeriodo() {
        List<HistoricoDisciplina> historicoUltimoPeriodo = new ArrayList<>();

        for (HistoricoDisciplina historicoDisciplina : this.getHistoricos()) {

            if (historicoDisciplina.getPeriodo() == this.getUltimoPeriodoCursado()
                    && historicoDisciplina.getFrequencia() != -1) {

                historicoUltimoPeriodo.add(historicoDisciplina);
            }
        }

        return historicoUltimoPeriodo;
    }

    public double calcularTaxaAprovacaoUltimoPeriodo(List<HistoricoDisciplina> hist) {
        double taxa;
        double aprovadas = 0;
        double matriculadas = 0;

        for (HistoricoDisciplina historicoDisciplina : hist) {
            if (historicoDisciplina.getMedia() > 70) {
                aprovadas++;
            }
            matriculadas++;
        }

        taxa = aprovadas / matriculadas;

        return taxa*100;
    }

    public void OfertadasNoSemestreNaoConcluidas() {;

        List<Disciplina> grade = curso.getDisciplinas();
        List<Disciplina> cursadas = new ArrayList<>();

        /* HistoricoDisciplina para list<Disciplina> - para fins de comparacao*/ 
        for (HistoricoDisciplina historicoDisciplina : historico) {
            if (historicoDisciplina.getSituacao().equals("Aprovado")){
                cursadas.add(historicoDisciplina.getDisciplina());
            }
        }

        this.materiasBarreira = cursadas;
        
        List<Disciplina> lista = new ArrayList<>();

        for (Disciplina hist : grade) {
            boolean naoCursado = true;

            for (Disciplina disciplina : cursadas) {
                if (hist.getCodigoDisciplina().equals(disciplina.getCodigoDisciplina())) {
                    naoCursado = false;
                    break;
                }
            }

            if (naoCursado){
                lista.add(hist);
            }
        }

        this.ofertadasNoSemestreNaoConcluidas = lista;
    }

    public void calcMateriasBarreira() {

        this.materiasQueFaltaNaBarreira = new ArrayList<>();
        for(Disciplina disc: this.curso.getDisciplinas()) {
            if (disc.getPeriodoIdeal() <= 3) {
                for (HistoricoDisciplina hist: this.historico) {
                    if (disc.getCodigoDisciplina().equals(hist.getDisciplina().getCodigoDisciplina())) {
                        this.materiasQueFaltaNaBarreira.add(hist.getDisciplina());
                    }
                }
            }
        }

    }

}
