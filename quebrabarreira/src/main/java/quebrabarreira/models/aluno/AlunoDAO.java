package quebrabarreira.models.aluno;

import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import quebrabarreira.Utils.FileHandle;
import quebrabarreira.models.aluno.curso.Disciplina;
import quebrabarreira.models.aluno.historico.HistoricoDisciplina;
import quebrabarreira.models.aluno.Aluno;

public class AlunoDAO {

    /*
     * Traz informação do histórico para o objeto Aluno
     */

    public static Aluno lerHistorico(String historicoPath) throws IOException {
        Aluno aluno = new Aluno();
        List<HistoricoDisciplina> historicoAlunoList = new ArrayList<HistoricoDisciplina>();

        List<HashMap<String, String>> csvResult;
        FileHandle file = new FileHandle();

        csvResult = file.getCsv(historicoPath);

        double ira = 0;
        int cargaHorariaTotal = 0;

        int ultimoPeriodo = -1;

        for (HashMap<String, String> hash : csvResult) {
            String codigoDisciplina = hash.get("COD_ATIV_CURRIC");
            String nomeDisciplina = hash.get("NOME_ATIV_CURRIC");

            String classificacao = hash.get("DESCR_ESTRUTURA");
            int cargaHoraria = Integer.parseInt(hash.get("CH_TOTAL"));
            Disciplina disciplina = new Disciplina(codigoDisciplina, nomeDisciplina,
                    -1, // periodo ideal - inexistente no arquivo de histórico, SOMENTE NA GRADE
                    classificacao, cargaHoraria);

            String anoString = hash.get("ANO");
            int ano = Integer.parseInt(anoString);

            double media = Double.parseDouble(hash.get("MEDIA_FINAL"));
            String situacao = hash.get("SITUACAO");

            int periodo;

            try {
                periodo = Integer.parseInt(hash.get("SITUACAO_ITEM"));
            } catch (Exception e) {
                periodo = -1;
            }

            int frequencia;

            try {
                frequencia = Integer.parseInt(hash.get("FREQUENCIA"));
            } catch (Exception e) {
                frequencia = -1;
            }

            HistoricoDisciplina historico = new HistoricoDisciplina(disciplina,
                    ano,
                    media,
                    situacao,
                    periodo,
                    frequencia);

            aluno.setNome(hash.get("NOME_PESSOA"));
            aluno.setGRR(hash.get("MATR_ALUNO"));

            historicoAlunoList.add(historico);
            // Determina qual foi o ultimo periodo em que o aluno cursou ao menos uma
            // matéria
            if (periodo > ultimoPeriodo) {
                ultimoPeriodo = historico.getPeriodo();
            }
        }

        System.out.println(cargaHorariaTotal);

        aluno.setHistoricos(historicoAlunoList);
        ira = aluno.calculateIra();
        aluno.setIra(ira);
        aluno.setUltimoPeriodoCursado(ultimoPeriodo);
        aluno.setIraUltimoPeriodo(aluno.calcularIRAUltimoPeriodo());

        return aluno;
    }

}
