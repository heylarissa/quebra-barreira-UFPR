package quebrabarreira.models.aluno;

import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import quebrabarreira.Utils.FileHandle;
import quebrabarreira.models.aluno.curso.Disciplina;
import quebrabarreira.models.aluno.historico.HistoricoDisciplina;

public class AlunoDAO {

    /* 
        Traz informação do histórico para o objeto Aluno
    */ 

    public static Aluno lerHistorico(String historicoPath) throws IOException {
        Aluno aluno = new Aluno();
        List<HistoricoDisciplina> historicoAlunoList = new ArrayList<HistoricoDisciplina>();

        List<HashMap<String, String>> csvResult;
        FileHandle file = new FileHandle();
        
        csvResult = file.getCsv(historicoPath);

        for (HashMap<String, String> hash : csvResult) {
            String codigoDisciplina = hash.get("COD_ATIV_CURRIC");
            String nomeDisciplina = hash.get("NOME_ATIV_CURRIC");

            String classificacao = hash.get("DESCR_ESTRUTURA");
            int cargaHoraria = Integer.parseInt(hash.get("CH_TOTAL"));
            Disciplina disciplina = new Disciplina( codigoDisciplina, nomeDisciplina,
                                                    -1, // periodo ideal - inexistente no arquivo de histórico, SOMENTE NA GRADE
                                                    classificacao, cargaHoraria);

            String anoString = hash.get("ANO");
            int ano = Integer.parseInt(anoString);

            double media = Double.parseDouble(hash.get("MEDIA_FINAL"));
            String situacao = hash.get("SITUACAO");
            int periodo = Integer.parseInt(hash.get("SITUACAO_ITEM"));
            int frequencia = 0 ;//Integer.parseInt(hash.get("FREQUENCIA"));

            HistoricoDisciplina historico = new HistoricoDisciplina( disciplina, 
                                                                     ano,
                                                                     media,
                                                                     situacao,
                                                                     periodo,
                                                                     frequencia);

            aluno.setNome(hash.get("NOME_PESSOA"));
            aluno.setGRR(hash.get("MATR_ALUNO"));

            historicoAlunoList.add(historico);
        }

        aluno.setHistoricos(historicoAlunoList);

        return aluno;
    }
}
