package quebrabarreira.view;

import java.awt.*;
import java.awt.event.*;
import java.util.LinkedList;
import java.util.List;

import javax.swing.*;
import javax.swing.border.Border;
import javax.swing.border.EmptyBorder;

import quebrabarreira.controllers.AlunoController;
import quebrabarreira.controllers.FormularioController;
import quebrabarreira.models.*;
import quebrabarreira.models.aluno.Aluno;
import quebrabarreira.models.aluno.curso.Disciplina;

import javax.swing.table.JTableHeader;

public class InterfaceGrafica {

    public static JLabel addLabel(int x, int y, boolean isTitle, String text, JPanel myPanel) {
        JLabel newLabel = new JLabel(text);

        GridBagConstraints constraints = new GridBagConstraints();
        constraints.anchor = GridBagConstraints.WEST;
        constraints.gridx = x;
        constraints.gridy = y;

        if (isTitle) {
            newLabel.setFont(new Font("Arial", Font.BOLD, 15));
            constraints.insets = new Insets(5, 0, 0, 5);
        } else {
            newLabel.setFont(new Font("Arial", Font.PLAIN, 15));
            constraints.insets = new Insets(5, 0, 10, 5);
        }

        myPanel.add(newLabel, constraints);

        return newLabel;
    }

    public static JCheckBox addRadioButton(int x, int y, String text, JPanel myPanel) {
        GridBagConstraints constraints = new GridBagConstraints();
        constraints.anchor = GridBagConstraints.WEST;
        constraints.insets = new Insets(5, 0, 10, 5);
        constraints.gridx = x;
        constraints.gridy = y;

        JCheckBox radioButton = new JCheckBox(text);

        myPanel.add(radioButton, constraints);

        return radioButton;
    }

    public static JTextField addTextField(int x, int y, JPanel myPanel) {
        GridBagConstraints constraints = new GridBagConstraints();
        constraints.anchor = GridBagConstraints.WEST;
        constraints.fill = GridBagConstraints.HORIZONTAL;
        constraints.insets = new Insets(5, 0, 10, 5);
        constraints.gridx = x;
        constraints.gridy = y;

        JTextField textField = new JTextField();
        textField.setFont(new Font("Arial", Font.PLAIN, 15));
        Border blackline = BorderFactory.createLineBorder(Color.black);
        textField.setBorder(blackline);

        myPanel.add(textField, constraints);

        return textField;
    }

    public static JTextArea addTextArea(int x, int y, String text, JPanel myPanel, boolean edit) {
        GridBagConstraints constraints = new GridBagConstraints();
        constraints.anchor = GridBagConstraints.WEST;
        constraints.gridwidth = GridBagConstraints.REMAINDER;
        constraints.fill = GridBagConstraints.HORIZONTAL;
        constraints.gridx = x;
        constraints.gridy = y;

        JTextArea newTextArea = new JTextArea(text);

        if (edit) {
            newTextArea.setBackground(Color.WHITE);
            Border blackline = BorderFactory.createLineBorder(Color.black);
            newTextArea.setBorder(blackline);
            newTextArea.setFont(new Font("Arial", Font.PLAIN, 15));
            constraints.insets = new Insets(5, 0, 10, 5);
        } else {
            newTextArea.setBackground(null);
            newTextArea.setFont(new Font("Arial", Font.BOLD, 15));
            constraints.insets = new Insets(5, 0, 0, 5);
        }

        newTextArea.setEditable(edit);
        newTextArea.setLineWrap(true);

        myPanel.add(newTextArea, constraints);

        return newTextArea;
    }

    public static JPanel addPanel(int x, int y, JPanel myPanel, GridLayout layout) {
        GridBagConstraints constraints = new GridBagConstraints();
        constraints.anchor = GridBagConstraints.WEST;
        constraints.fill = GridBagConstraints.HORIZONTAL;
        constraints.insets = new Insets(5, 5, 10, 5);
        constraints.gridx = x;
        constraints.gridy = y;

        JPanel newPanel = new JPanel(layout);

        myPanel.add(newPanel, constraints);
        return newPanel;
    }

    public static JButton addButton(int x, int y, String text, JPanel myPanel) {
        GridBagConstraints constraints = new GridBagConstraints();
        constraints.anchor = GridBagConstraints.WEST;
        constraints.insets = new Insets(5, 5, 10, 5);
        constraints.gridx = x;
        constraints.gridy = y;

        JButton newButton = new JButton(text);
        newButton.setPreferredSize(new Dimension(40, 20));

        myPanel.add(newButton, constraints);
        return newButton;
    }

    private static List<String> getValuesTable(JTable table, int row, int column) {
        List<String> capturados = new LinkedList<String>();

        for (int i = 0; i < row; i++) {
            for (int j = 0; j < column; j++) {
                if (table.getModel().getValueAt(i, j) != null) {
                    String value = table.getModel().getValueAt(i, j).toString();
                    if (!value.isBlank())
                        capturados.add(table.getModel().getValueAt(i, j).toString());
                }
            }
        }

        return capturados;
    }

    private static void wipeJTable(JTable table, int row, int column) {
        for (int i = 0; i < row; i++) {
            for (int j = 0; j < column; j++) {
                table.setValueAt("", i, j);
            }
        }
    }

    private static void setJTable(JTable table, int row, int column, List<String> data) {
        wipeJTable(table, row, column);

        int k = 0;

        for (int i = 0; k < data.size() && i < row; i++) {
            for (int j = 0; k < data.size() && j < column; j++) {
                String value = data.get(k++);
                table.setValueAt(value, i, j);
            }
        }
    }

    public static void Invoke(AlunoController alunoController) {
        Aluno aluno = alunoController.getAluno();

        JPanel panel = new JPanel(new GridBagLayout());

        JPanel panel1 = addPanel(0, 0, panel, new GridLayout(1, 3));
        JPanel panelName = addPanel(0, 0, panel1, new GridLayout(2, 1));
        JLabel name = addLabel(0, 0, true, "Nome:", panelName);
        JLabel tname = addLabel(0, 1, false, aluno.getNome(), panelName);

        JPanel panelCurso = addPanel(1, 0, panel1, new GridLayout(2, 1));
        JLabel curso = addLabel(0, 0, true, "Curso:", panelCurso);
        JLabel tcurso = addLabel(0, 1, false, "Curso de Ciência da Computação - Bacharelado", panelCurso);

        JPanel panelGRR = addPanel(2, 0, panel1, new GridLayout(2, 1));
        JLabel grr = addLabel(0, 0, true, "GRR:", panelGRR);
        JLabel tgrr = addLabel(0, 1, false, aluno.getGRR(), panelGRR);

        JPanel panel2 = addPanel(0, 1, panel, new GridLayout(1, 2));
        JPanel panelTel = addPanel(0, 0, panel2, new GridLayout(2, 1));
        JLabel telefone = addLabel(0, 0, true, "Telefone:", panelTel);
        JTextField tTelefone = addTextField(0, 1, panelTel);

        JPanel panelEmail = addPanel(1, 0, panel2, new GridLayout(2, 1));
        JLabel email = addLabel(0, 0, true, "Email:", panelEmail);
        JTextField temail = addTextField(0, 1, panelEmail);

        JPanel panelInfo = addPanel(0, 2, panel, new GridLayout(1, 4));
        JPanel panelIRAgeral = addPanel(0, 0, panelInfo, new GridLayout(2, 1));
        JLabel IRAgeral = addLabel(0, 0, true, "IRA Geral:", panelIRAgeral);
        JLabel tIRAgeral = addLabel(0, 1, false, String.format("%1.2f", aluno.getIra()), panelIRAgeral);


        JPanel panelPercAprov = addPanel(2, 0, panelInfo, new GridLayout(2, 1));
        JLabel percAprov = addLabel(0, 0, true, "Porcentagem de aprovação do último período:", panelPercAprov);
        JLabel tPercAprov = addLabel(0, 1, false, String.format("%2.1f%%", aluno.getTaxaAprovacaoUltimoPeriodo()), panelPercAprov);

        JPanel panel3 = addPanel(0, 2, panel, new GridLayout(1, 1));
        JLabel disciplinasFaltantes = addLabel(0, 5, true, "Disciplinas que faltam aprovar requisito:", panel3);

        JPanel panel4 = addPanel(0, 3, panel, new GridLayout(1, 1));
        GridBagConstraints constraints = new GridBagConstraints();
        constraints.anchor = GridBagConstraints.CENTER;
        constraints.gridwidth = GridBagConstraints.REMAINDER;
        constraints.fill = GridBagConstraints.HORIZONTAL;
        constraints.insets = new Insets(4, 0, 10, 4);
        constraints.gridx = 0;
        constraints.gridy = 0;

        int lin = 5, col = 3;
        JTable discTable = new JTable(lin, col) {
            public boolean isCellEditable(int row, int column) {
                return false;
            };

            public boolean isCellSelected(int row, int column) {
                return false;
            }
        };
        JTableHeader tableHeader = discTable.getTableHeader();
        tableHeader.setReorderingAllowed(false);
        tableHeader.getColumnModel().getColumn(0).setHeaderValue("Primeiro Período");
        tableHeader.getColumnModel().getColumn(1).setHeaderValue("Segundo Período");
        tableHeader.getColumnModel().getColumn(2).setHeaderValue("Terceiro Período");
        tableHeader.setBackground(Color.decode("#AED8E6"));

        // for (int i = 0; i < col; i++) {
        //     List<Disciplina> materiasCursadas = aluno.materiasCursadasBarreira();
        //     List<Disciplina> materiasPeriodo = aluno.materiasPeriodo(i + 1);
        //     int j = 0;
        //     for (Disciplina materia : materiasPeriodo) {
        //         String codigo = materia.getCodigoMateria();
        //         String label;
        //         if (materia.isInList(materiasCursadas))
        //             label = "(A) " + codigo;
        //         else if (materia.isInList(materiasMatriculado))
        //             label = "(M) " + codigo;
        //         else if (materia.isInList(materiasReprovado))
        //             label = "(R) " + codigo;
        //         else
        //             label = "( ) " + codigo;

        //         discTable.setValueAt(label, j, i);
        //         discTable.getColumnModel().getColumn(i).setPreferredWidth(150);
        //         j++;
        //     }
        // }

        // discTable.setFont(new Font("Arial", Font.PLAIN, 15));
        // discTable.setRowHeight(discTable.getRowHeight() + 8);
        // discTable.setCellSelectionEnabled(true);
        // discTable.setBackground(null);

        // Dimension d = discTable.getPreferredSize();
        // JScrollPane ScrollPane = new JScrollPane(discTable);
        // ScrollPane.setPreferredSize(new Dimension(d.width, discTable.getRowHeight() * 6));
        // panel4.add(ScrollPane, constraints);

        // JPanel panell5 = addPanel(0, 4, panel, new GridLayout(1, 1));
        // String legenda = "(A): Aprovado (R): Reprovado (M): Matriculado no período vigente";
        // JLabel tLegenda = addLabel(0, 0, false, legenda, panell5);

        // JPanel panel6 = addPanel(0, 5, panel, new GridLayout(1, 1));
        // String textoCondicoes = "Tem condições de se matricular nesta disciplina, "
        //         + "sem colisão de horários com as disciplinas faltantes, "
        //         + "possuindo condições de finalizar as atividades formativas "
        //         + "complementares seguindo as regras vigentes do seu curso?";

        // JTextArea condicoes = addTextArea(0, 0, textoCondicoes, panel6, false);

        // JPanel panel7 = addPanel(0, 6, panel, new GridLayout(1, 1));
        // JCheckBox radioButtonCondicoes1 = addRadioButton(0, 0, "Sim", panel7);

        // JPanel panel8 = addPanel(0, 7, panel, new GridLayout(1, 1));
        // String textoDisciplina = "Quantas disciplinas você ainda precisa cursar, incluindo as da próxima matrícula?";
        // JLabel nDisciplinas = addLabel(0, 9, true, textoDisciplina, panel8);

        // JPanel panel9 = addPanel(0, 8, panel, new GridLayout(1, 2));
        // JPanel panelDisciplinas = addPanel(0, 0, panel9, new GridLayout(2, 1));
        // JLabel nObrigatorias = addLabel(0, 0, false, "Obrigatórias:", panelDisciplinas);
        // JTextField tObrigatorias = addTextField(0, 1, panelDisciplinas);

        // JPanel panelDisciplinasOpt = addPanel(1, 0, panel9, new GridLayout(2, 1));
        // JLabel nOpt = addLabel(0, 0, false, "Optativas:", panelDisciplinasOpt);
        // JTextField tOpt = addTextField(0, 1, panelDisciplinasOpt);

        // JPanel panel10 = addPanel(0, 9, panel, new GridLayout(1, 1));
        // String textoDisciplina2 = "Quais disciplinas você solicita além da barreira?";
        // JLabel discSolicitadas = addLabel(0, 11, true, textoDisciplina2, panel10);

        // JPanel panel11 = addPanel(0, 10, panel, new GridLayout(1, 1));
        // constraints.anchor = GridBagConstraints.CENTER;
        // constraints.gridwidth = GridBagConstraints.REMAINDER;
        // constraints.fill = GridBagConstraints.HORIZONTAL;
        // constraints.insets = new Insets(4, 0, 10, 4);
        // constraints.gridx = 0;
        // constraints.gridy = 0;

        // int n2 = 5;
        // JTable discSolicitadasTable = new JTable(n2, n2);
        // for (int i = 0; i < n2; i++) {
        //     for (int j = 0; j < n2; j++) {
        //         discSolicitadasTable.isCellEditable(i, j);
        //     }
        // }

        // discSolicitadasTable.setBorder(BorderFactory.createLineBorder(Color.black));
        // discSolicitadasTable.setRowHeight(discTable.getRowHeight() + 8);
        // discSolicitadasTable.setCellSelectionEnabled(true);
        // discSolicitadasTable.setBackground(null);
        // panel11.add(discSolicitadasTable, constraints);

        // JPanel panel13 = addPanel(0, 10, panel, new GridLayout(2, 1));
        // JLabel pedido = addLabel(0, 0, true, "Justifique seu pedido:", panel13);
        // JTextArea tpedido = addTextArea(0, 1, "", panel13, true);

        // JPanel panel14 = addPanel(0, 11, panel, new GridLayout(1, 3));

        // JButton buttonRecover = addButton(0, 0, "Recuperar", panel14);
        // buttonRecover.addActionListener(new ActionListener() {
        //     public void actionPerformed(ActionEvent e) {
        //         Boolean didRecover = formController
        //                 .recuperaFormulario(tname.getText().replace(" ", "_") + ".txt");

        //         if (!didRecover)
        //             return;

        //         Formulario form = formController.getForm();
        //         radioButtonCondicoes1.setSelected(form.isTemCondicoes());
        //         setJTable(discSolicitadasTable, n2, n2, form.getDisciplinasSolicitadas());
        //         tTelefone.setText(form.getTelefone());
        //         temail.setText(form.getEmail());
        //         if (form.getQuantidadeDisciplinasRestantes() >= 0)
        //             tObrigatorias.setText(Integer.toString(form.getQuantidadeDisciplinasRestantes()));
        //         if (form.getQuantidadeDisciplinasRestantes() >= 0)
        //             tOpt.setText(Integer.toString(form.getQuantidadeOptativasRestantes()));
        //         tpedido.setText(form.getJustificativa());
        //     }
        // });

        // JButton buttonSave = addButton(1, 0, "Salvar", panel14);
        // buttonSave.addActionListener(new ActionListener() {
        //     public void actionPerformed(ActionEvent e) {
        //         formController.criaFormulario(
        //                 aluno,
        //                 false,
        //                 tTelefone.getText(),
        //                 temail.getText(),
        //                 radioButtonCondicoes1.isSelected(),
        //                 Utils.toInt(tObrigatorias.getText()),
        //                 Utils.toInt(tOpt.getText()),
        //                 getValuesTable(discSolicitadasTable, n2, n2),
        //                 tpedido.getText());
        //         formController.saveFormulario(tname.getText().replace(" ", "_") + ".txt");
        //     }
        // });

        // JButton buttonSend = addButton(2, 0, "Enviar", panel14);
        // buttonSend.addActionListener(new ActionListener() {
        //     public void actionPerformed(ActionEvent e) {
        //         formController.criaFormulario(
        //                 aluno,
        //                 false,
        //                 tTelefone.getText(),
        //                 temail.getText(),
        //                 radioButtonCondicoes1.isSelected(),
        //                 Utils.toInt(tObrigatorias.getText()),
        //                 Utils.toInt(tOpt.getText()),
        //                 getValuesTable(discSolicitadasTable, n2, n2),
        //                 tpedido.getText());
        //         Pedido.gerarPedido(formController.getForm());
        //         System.exit(0);
        //     }
        // });

        panel.setBorder(new EmptyBorder(10, 50, 10, 50));
        JScrollPane scrollPane = new JScrollPane(panel);

        JFrame f = new JFrame("Pedido de quebra de barreira");
        f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        f.setSize(1100, 1000);
        f.setLocation(200, 200);
        f.getContentPane().add(scrollPane);
        f.setVisible(true);
    }
}
