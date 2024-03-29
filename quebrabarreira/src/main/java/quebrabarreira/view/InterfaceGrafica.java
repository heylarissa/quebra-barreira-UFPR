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
import quebrabarreira.models.Pedido;
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

    public static void Invoke(AlunoController aluno, FormularioController formController) {

        JPanel panel = new JPanel(new GridBagLayout());

        JPanel panel1 = addPanel(0, 0, panel, new GridLayout(1, 3));
        JPanel panelName = addPanel(0, 0, panel1, new GridLayout(2, 1));
        JLabel name = addLabel(0, 0, true, "Nome:", panelName);
        JLabel tname = addLabel(0, 1, false, aluno.getAluno().getNome(), panelName);

        JPanel panelCurso = addPanel(1, 0, panel1, new GridLayout(2, 1));
        JLabel curso = addLabel(0, 0, true, "Curso:", panelCurso);
        JLabel tcurso = addLabel(0, 1, false, "Curso de Ciência da Computação - Bacharelado", panelCurso);

        JPanel panelGRR = addPanel(2, 0, panel1, new GridLayout(2, 1));
        JLabel grr = addLabel(0, 0, true, "GRR:", panelGRR);
        JLabel tgrr = addLabel(0, 1, false, aluno.getAluno().getGRR(), panelGRR);

        JPanel panelInfo = addPanel(0, 2, panel, new GridLayout(1, 4));
        JPanel panelIRAgeral = addPanel(0, 0, panelInfo, new GridLayout(2, 1));
        JLabel IRAgeral = addLabel(0, 0, true, "IRA Geral:", panelIRAgeral);
        JLabel tIRAgeral = addLabel(0, 1, false, String.format("%1.2f", aluno.getAluno().getIra()), panelIRAgeral);

        JPanel panelPercAprov = addPanel(2, 0, panelInfo, new GridLayout(2, 1));
        JLabel percAprov = addLabel(0, 0, true, "Porcentagem de aprovação do último período:", panelPercAprov);
        JLabel tPercAprov = addLabel(0, 1, false,
                String.format("%2.1f%%", aluno.getAluno().getTaxaAprovacaoUltimoPeriodo()), panelPercAprov);

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

        for (int i = 0; i < col; i++) {
            List<Disciplina> materiasBarreira = aluno.getAluno().getMateriasQueFaltaNaBarreira();
            List<Disciplina> materiasPeriodo = aluno.getAluno().getOfertadasNoSemestreNaoConcluidas();
            int j = 0;
            for (Disciplina materia : materiasPeriodo) {
                String codigo = materia.getCodigoDisciplina();
                String label;
                label = "( ) " + codigo;
                if (materia.isInList(materiasBarreira))
                    label = "(Barreira) " + codigo;
                discTable.setValueAt(label, materia.getPeriodoIdeal(), i);
                discTable.getColumnModel().getColumn(i).setPreferredWidth(150);
                j++;
            }
        }

        discTable.setFont(new Font("Arial", Font.PLAIN, 15));
        discTable.setRowHeight(discTable.getRowHeight() + 8);
        discTable.setCellSelectionEnabled(true);
        discTable.setBackground(null);

        Dimension d = discTable.getPreferredSize();
        JScrollPane ScrollPane = new JScrollPane(discTable);
        ScrollPane.setPreferredSize(new Dimension(d.width, discTable.getRowHeight() * 6));
        panel4.add(ScrollPane, constraints);

        JPanel panell5 = addPanel(0, 4, panel, new GridLayout(1, 1));
        String legenda = "(A): Aprovado (R): Reprovado (M): Matriculado no período vigente";
        JLabel tLegenda = addLabel(0, 0, false, legenda, panell5);

        JPanel panel6 = addPanel(0, 5, panel, new GridLayout(1, 1));
        String textoCondicoes = "Tem condições de se matricular nesta disciplina, "
                + "sem colisão de horários com as disciplinas faltantes, "
                + "possuindo condições de finalizar as atividades formativas "
                + "complementares seguindo as regras vigentes do seu curso?";

        JTextArea condicoes = addTextArea(0, 0, textoCondicoes, panel6, false);

        JPanel panel7 = addPanel(0, 6, panel, new GridLayout(1, 1));
        JCheckBox radioButtonCondicoes1 = addRadioButton(0, 0, "Sim", panel7);


        JPanel panel10 = addPanel(0, 9, panel, new GridLayout(1, 1));
        String textoDisciplina2 = "Quais disciplinas você solicita além da barreira?";
        JLabel discSolicitadas = addLabel(0, 11, true, textoDisciplina2, panel10);

        JPanel panel11 = addPanel(0, 10, panel, new GridLayout(1, 1));
        constraints.anchor = GridBagConstraints.CENTER;
        constraints.gridwidth = GridBagConstraints.REMAINDER;
        constraints.fill = GridBagConstraints.HORIZONTAL;
        constraints.insets = new Insets(4, 0, 10, 4);
        constraints.gridx = 0;
        constraints.gridy = 0;

        int n2 = 5;
        JTable discSolicitadasTable = new JTable(n2, n2);
        for (int i = 0; i < n2; i++) {
            for (int j = 0; j < n2; j++) {
                discSolicitadasTable.isCellEditable(i, j);
            }
        }

        discSolicitadasTable.setBorder(BorderFactory.createLineBorder(Color.black));
        discSolicitadasTable.setRowHeight(discTable.getRowHeight() + 8);
        discSolicitadasTable.setCellSelectionEnabled(true);
        discSolicitadasTable.setBackground(null);
        panel11.add(discSolicitadasTable, constraints);

        JPanel panel13 = addPanel(0, 10, panel, new GridLayout(2, 1));
        JLabel pedido = addLabel(0, 0, true, "Justifique seu pedido:", panel13);
        JTextArea tpedido = addTextArea(0, 1, "", panel13, true);

        JPanel panel14 = addPanel(0, 11, panel, new GridLayout(1, 3));

        JButton buttonRecover = addButton(0, 0, "Recuperar", panel14);
        JButton buttonSave = addButton(1, 0, "Salvar", panel14);

        JButton buttonSend = addButton(2, 0, "Enviar", panel14);

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
