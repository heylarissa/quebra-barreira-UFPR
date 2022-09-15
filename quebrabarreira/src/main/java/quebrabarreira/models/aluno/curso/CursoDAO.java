package quebrabarreira.models.aluno.curso;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import quebrabarreira.models.FileHandle;

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
    public static Curso lerGrade(String path, int ano){
        Curso curso = new Curso();
        FileHandle file = new FileHandle();
        String nameFile;

        Disciplina disciplina = new Disciplina();
        List<Disciplina> disciplinasList = new ArrayList<Disciplina>();

        List<HashMap<String, String>> csvResult;

        // setGradeYear
        if (ano == 2019){
            nameFile = "grade2019";
        } 
        else {
            nameFile = "grade2011";
        }

        csvResult = file.getCsv(nameFile);

        for (HashMap<String,String> hashMap : csvResult) {
            String codigoCurso = hashMap.get("COD_CURSO");
            curso.setCodigoCurso(codigoCurso);

            String nomeCurso = hashMap.get("NOME_CURSO");
            curso.setnomeCurso(nomeCurso);

            // lerDisciplina
            String nomeDisciplina = hashMap.get("NOME_DISCIPLINA");
            disciplina.setNomeDisciplina(nomeDisciplina);

            String horas = hashMap.get("NUM_HORAS");
            int cargaHoraria = Integer.parseInt(horas);
            disciplina.setCargaHoraria(cargaHoraria);

            String classificacao = hashMap.get("DESCR_ESTRUTURA");
            disciplina.setClassificacao(classificacao);

            String periodo = hashMap.get("PERIODO_IDEAL");
            int periodoIdeal = Integer.parseInt(periodo);
            disciplina.setPeriodoIdeal(periodoIdeal);

            String codigoDisciplina = hashMap.get("NOME_DISCIPLINA");
            disciplina.setCodigoDisciplina(codigoDisciplina);

            disciplinasList.add(disciplina);
        }

        curso.setGradeAno(ano);
        curso.setDisciplinas(disciplinasList);
                
        return curso;
    }
}