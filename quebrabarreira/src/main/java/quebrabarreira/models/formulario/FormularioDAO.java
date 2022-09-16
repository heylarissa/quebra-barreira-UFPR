package quebrabarreira.models.formulario;

import com.google.gson.Gson;

public class FormularioDAO {
    /* Funções que leem e escrevem de um txt que serão utilizadas no front */
    public static String formularioToString(Formulario form) {
        Gson gson = new Gson();
        return gson.toJson(form);
    }

    public static Formulario stringToFormulario(String str) {
        Gson gson = new Gson();
        return gson.fromJson(str, Formulario.class);
    }
}
