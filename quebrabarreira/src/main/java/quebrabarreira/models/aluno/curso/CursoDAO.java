package quebrabarreira.models.aluno.curso;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import quebrabarreira.Utils.FileHandle;

// 0 COD_CURSO
// 1 NUM_VERSAO
// 2 DESCR_ESTRUTURA
// 3 COD_DISCIPLINA
// 4 NOME_UNIDADE
// 5 NOME_DISCIPLINA
// 6 PERIODO_IDEAL
// 7 TIPO_DISCIPLINA
// 8 CH_TOTAL
// 9 DESCR_SITUACAO

public class CursoDAO {

    public Curso lerGrade(int ano, String gradePath) {
        Curso curso = new Curso();
        FileHandle file = new FileHandle();

        List<Disciplina> disciplinasList = new ArrayList<Disciplina>();

        List<HashMap<String, String>> csvResult;

        csvResult = file.getCsv(gradePath);

        for (HashMap<String, String> hashMap : csvResult) {
            String codigoCurso = hashMap.get("COD_CURSO");
            curso.setCodigoCurso(codigoCurso);

            String nomeCurso = hashMap.get("NOME_CURSO");
            curso.setnomeCurso(nomeCurso);

            String nomeDisciplina = hashMap.get("NOME_DISCIPLINA");
            String horas = hashMap.get("NUM_HORAS");
            String classificacao = hashMap.get("DESCR_ESTRUTURA");
            String periodo = hashMap.get("PERIODO_IDEAL");
            String codigoDisciplina = hashMap.get("NOME_DISCIPLINA");

            int cargaHoraria;
            if (horas != null) {
                cargaHoraria = Integer.parseInt(horas);
            } else {
                cargaHoraria = 0;
            }

            int periodoIdeal = 0;
            if (periodo == "null") {
                periodoIdeal = Integer.parseInt(periodo);
            }

            Disciplina disciplina = new Disciplina(codigoDisciplina, nomeDisciplina, periodoIdeal, classificacao,
                    cargaHoraria);

            disciplinasList.add(disciplina);
        }

        curso.setGradeAno(ano);
        curso.setDisciplinas(disciplinasList);

        return curso;
    }
}
