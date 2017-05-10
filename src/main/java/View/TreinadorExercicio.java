package View;

import Beans.Exercicio;
import Beans.Treinador;
import Database.ExercicioDAO;

import javax.swing.*;
import javax.swing.event.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.List;

public class TreinadorExercicio extends JFrame{

    private ExercicioDAO exercicioDAO = new ExercicioDAO();

    public TreinadorExercicio() {
        initComponents();
        atualizarTabela();
    }

    private void initComponents() {

        jPanel = new JPanel();
        jLabelTitulo = new JLabel();
        jScrollPane = new JScrollPane();
        jTableExercicios = new JTable();
        jButtonAdicionar = new JButton();
        jButtonAlterar = new JButton();
        jButtonExcluir = new JButton();
        jButtonAtualizar = new JButton();

        setDefaultCloseOperation(WindowConstants.DISPOSE_ON_CLOSE);

        jLabelTitulo.setFont(new Font("Tahoma", 1, 24));
        jLabelTitulo.setText("Exercícios");

        jTableExercicios.setModel(new DefaultTableModel(
                new Object [][] {

                },
                new String [] {
                        "ID", "Nome", "Descrição"
                }
        ));
        jTableExercicios.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
        jTableExercicios.getSelectionModel().addListSelectionListener(new ListSelectionListener() {
            public void valueChanged(ListSelectionEvent evt) {
                ListSelectionModel listSelectionModel = (ListSelectionModel) evt.getSource();
                jButtonAlterar.setEnabled(!listSelectionModel.isSelectionEmpty());
                jButtonExcluir.setEnabled(!listSelectionModel.isSelectionEmpty());
            }
        });
        jScrollPane.setViewportView(jTableExercicios);

        jButtonAdicionar.setText("Adicionar");
        jButtonAdicionar.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent evt) {
                jButtonAdicionarActionPerformed(evt);
            }
        });

        jButtonAlterar.setText("Alterar");
        jButtonAlterar.setEnabled(false);
        jButtonAlterar.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent evt) {
                jButtonAlterarActionPerformed(evt);
            }
        });

        jButtonExcluir.setText("Excluir");
        jButtonExcluir.setEnabled(false);
        jButtonExcluir.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent evt) {
                jButtonExcluirActionPerformed(evt);
            }
        });

        jButtonAtualizar.setText("Atualizar");
        jButtonAtualizar.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent evt) {
                jButtonAtualizarActionPerformed(evt);
            }
        });

        GroupLayout jPanelLayout = new GroupLayout(jPanel);
        jPanel.setLayout(jPanelLayout);
        jPanelLayout.setHorizontalGroup(
                jPanelLayout.createParallelGroup(GroupLayout.Alignment.LEADING)
                        .addGroup(jPanelLayout.createSequentialGroup()
                                .addContainerGap()
                                .addGroup(jPanelLayout.createParallelGroup(GroupLayout.Alignment.LEADING)
                                        .addComponent(jScrollPane, GroupLayout.PREFERRED_SIZE, 288, GroupLayout.PREFERRED_SIZE)
                                        .addGroup(jPanelLayout.createSequentialGroup()
                                                .addGap(130, 130, 130)
                                                .addComponent(jLabelTitulo)))
                                .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED, 15, Short.MAX_VALUE)
                                .addGroup(jPanelLayout.createParallelGroup(GroupLayout.Alignment.LEADING)
                                        .addGroup(GroupLayout.Alignment.TRAILING, jPanelLayout.createParallelGroup(GroupLayout.Alignment.LEADING, false)
                                                .addComponent(jButtonAdicionar, GroupLayout.Alignment.TRAILING, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                                .addComponent(jButtonAlterar, GroupLayout.Alignment.TRAILING, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                                .addComponent(jButtonExcluir, GroupLayout.Alignment.TRAILING, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                                        .addComponent(jButtonAtualizar, GroupLayout.Alignment.TRAILING))
                                .addContainerGap())
        );
        jPanelLayout.setVerticalGroup(
                jPanelLayout.createParallelGroup(GroupLayout.Alignment.LEADING)
                        .addGroup(jPanelLayout.createSequentialGroup()
                                .addGap(83, 83, 83)
                                .addComponent(jButtonAdicionar)
                                .addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(jButtonAlterar)
                                .addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(jButtonExcluir)
                                .addGap(68, 68, 68)
                                .addComponent(jButtonAtualizar)
                                .addContainerGap(GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                        .addGroup(GroupLayout.Alignment.TRAILING, jPanelLayout.createSequentialGroup()
                                .addContainerGap()
                                .addComponent(jLabelTitulo)
                                .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED, 22, Short.MAX_VALUE)
                                .addComponent(jScrollPane, GroupLayout.PREFERRED_SIZE, 246, GroupLayout.PREFERRED_SIZE)
                                .addGap(24, 24, 24))
        );

        GroupLayout layout = new GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
                layout.createParallelGroup(GroupLayout.Alignment.LEADING)
                        .addComponent(jPanel, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
                layout.createParallelGroup(GroupLayout.Alignment.LEADING)
                        .addComponent(jPanel, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        pack();
    }

    private void jButtonAdicionarActionPerformed(java.awt.event.ActionEvent evt) {
        TreinadorExercicioAdicionar treinadorExercicioAdicionar = new TreinadorExercicioAdicionar();
        treinadorExercicioAdicionar.setVisible(true);
    }

    private void jButtonAlterarActionPerformed(java.awt.event.ActionEvent evt) {
        //Exercicio exercicio = pegarTabela();
        //TreinadorExercicioAlterar treinadorExercicioAlterar = new TreinadorExercicioAlterar();
        //treinadorExercicioAlterar.setVisible(true);
    }

    private void jButtonExcluirActionPerformed(java.awt.event.ActionEvent evt) {
        // TODO add your handling code here:
    }

    private void jButtonAtualizarActionPerformed(java.awt.event.ActionEvent evt) {
        if(!atualizarTabela())
            JOptionPane.showMessageDialog(null,"Nenhum exercício registrado.");
    }

    private boolean atualizarTabela(){
        boolean retorno = false;
        List<Exercicio> exercicios = new ArrayList<>();
        DefaultTableModel tableModel = (DefaultTableModel) jTableExercicios.getModel();

        tableModel.setNumRows(0);
        exercicios = exercicioDAO.listarExercicio();

        if (exercicios.size() > 0){
            povoarTabela(exercicios,tableModel);
            retorno = true;
        }
        return retorno;
    }

    private Exercicio pegarTabela(){
        Exercicio exercicio = new Exercicio();
        DefaultTableModel tableModel = (DefaultTableModel) jTableExercicios.getModel();
        int linha = jTableExercicios.getSelectedRow();

        exercicio.setId((Integer) tableModel.getValueAt(linha,0));
        exercicio.setNome((String) tableModel.getValueAt(linha,1));
        exercicio.setDescricao((String) tableModel.getValueAt(linha,2));
        return exercicio;
    }

    private boolean povoarTabela(List<Exercicio> exercicios, DefaultTableModel tableModel){
        Object[] rowData = new Object[3];

        for (int i = 0; i < exercicios.size(); i++) {
            rowData[0] = exercicios.get(i).getId();
            rowData[1] = exercicios.get(i).getNome();
            rowData[2] = exercicios.get(i).getDescricao();
            tableModel.addRow(rowData);
        }
        return true;
    }

    private javax.swing.JButton jButtonAdicionar;
    private javax.swing.JButton jButtonAlterar;
    private javax.swing.JButton jButtonAtualizar;
    private javax.swing.JButton jButtonExcluir;
    private javax.swing.JLabel jLabelTitulo;
    private javax.swing.JPanel jPanel;
    private javax.swing.JScrollPane jScrollPane;
    private javax.swing.JTable jTableExercicios;
}
