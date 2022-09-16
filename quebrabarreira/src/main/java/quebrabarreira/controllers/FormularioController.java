package quebrabarreira.controllers;

import java.util.List;

import quebrabarreira.Utils.FileHandle;
import quebrabarreira.models.Pedido;
import quebrabarreira.models.aluno.Aluno;
import quebrabarreira.models.formulario.Formulario;
import quebrabarreira.models.formulario.FormularioDAO;

public class FormularioController {
    private Formulario form;
    Pedido pedido;

    public FormularioController() {
    }

    public void criaFormulario(
            Aluno aluno,

            boolean temCondicoes,
            List<String> disciplinasSolicitadas,
            String justificativa) {

        this.form = new Formulario(
                aluno,
                temCondicoes,
                disciplinasSolicitadas,
                justificativa);
    }

    public void setFormulario(Formulario form) {
        this.form = form;
    }

    public void saveFormulario(String path) {
        String data = FormularioDAO.formularioToString(form);
        FileHandle.saveToFile("OUTPUTS/" + path, data);
      }
    
      public Boolean recuperaFormulario(String path) {
        String data = FileHandle.readJSON("OUTPUTS/" + path);
    
        if (data.isBlank())
          return false;
    
        this.form = FormularioDAO.stringToFormulario(data);
        return true;
      }

    // public Formulario getForm() {
    // return this.form;
    // }
}
