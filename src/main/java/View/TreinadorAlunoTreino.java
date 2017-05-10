package View;

import Beans.*;
import Database.ExercicioDAO;
import Database.TreinoDAO;

import javax.swing.*;
import javax.swing.event.*;
import javax.swing.table.DefaultTableModel;
import java.util.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.List;

public class TreinadorAlunoTreino extends JFrame{

    private Treinador treinador;
    private TreinoDAO treinoDAO = new TreinoDAO();
    private Aluno aluno;

    public TreinadorAlunoTreino(Treinador treinador, Aluno aluno) {
        this.treinador = treinador;
        this.aluno = aluno;
        initComponents();
        atualizarTabela();
    }

    private void initComponents() {

        jPanel = new JPanel();
        jLabelTitulo = new JLabel();
        jScrollPane = new JScrollPane();
        jTableTreinos = new JTable();
        jButtonAlterar = new JButton();
        jButtonExcluir = new JButton();
        jButtonAdicionar = new JButton();

        setDefaultCloseOperation(WindowConstants.DISPOSE_ON_CLOSE);

        jLabelTitulo.setFont(new Font("Tahoma", 1, 24));
        jLabelTitulo.setHorizontalAlignment(SwingConstants.CENTER);
        jLabelTitulo.setText("Treino de "+aluno.getNome());

        jTableTreinos.setModel(new DefaultTableModel(
                new Object[][]{

                },
                new String[]{
                       "Id", "Nome", "Repetição", "Carga (kg)"
                }
        ));
        jTableTreinos.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
        jTableTreinos.getSelectionModel().addListSelectionListener(new ListSelectionListener() {
            @Override
            public void valueChanged(ListSelectionEvent evt) {
                ListSelectionModel listSelectionModel = (ListSelectionModel) evt.getSource();
                jButtonAlterar.setEnabled(!listSelectionModel.isSelectionEmpty());
                jButtonExcluir.setEnabled(!listSelectionModel.isSelectionEmpty());
            }
        });
        jScrollPane.setViewportView(jTableTreinos);

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

        jButtonAdicionar.setText("Adicionar");
        jButtonAdicionar.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent evt) {
                jButtonAdicionarActionPerformed(evt);
            }
        });

        GroupLayout jPanelLayout = new GroupLayout(jPanel);
        jPanel.setLayout(jPanelLayout);
        jPanelLayout.setHorizontalGroup(
                jPanelLayout.createParallelGroup(GroupLayout.Alignment.LEADING)
                        .addGroup(jPanelLayout.createSequentialGroup()
                                .addContainerGap()
                                .addComponent(jScrollPane, GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE)
                                .addContainerGap())
                        .addGroup(jPanelLayout.createSequentialGroup()
                                .addGap(22, 22, 22)
                                .addComponent(jButtonAdicionar)
                                .addGap(71, 71, 71)
                                .addComponent(jButtonAlterar)
                                .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED, 83, Short.MAX_VALUE)
                                .addComponent(jButtonExcluir)
                                .addGap(19, 19, 19))
                        .addGroup(GroupLayout.Alignment.TRAILING, jPanelLayout.createSequentialGroup()
                                .addContainerGap(GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(jLabelTitulo)
                                .addGap(95, 95, 95))
        );
        jPanelLayout.setVerticalGroup(
                jPanelLayout.createParallelGroup(GroupLayout.Alignment.LEADING)
                        .addGroup(jPanelLayout.createSequentialGroup()
                                .addGap(18, 18, 18)
                                .addComponent(jLabelTitulo)
                                .addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(jScrollPane, GroupLayout.DEFAULT_SIZE, 190, Short.MAX_VALUE)
                                .addGap(18, 18, 18)
                                .addGroup(jPanelLayout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                                        .addComponent(jButtonAlterar)
                                        .addComponent(jButtonExcluir)
                                        .addComponent(jButtonAdicionar))
                                .addContainerGap())
        );

        GroupLayout layout = new GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
                layout.createParallelGroup(GroupLayout.Alignment.LEADING)
                        .addComponent(jPanel, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
                layout.createParallelGroup(GroupLayout.Alignment.LEADING)
                        .addComponent(jPanel, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
        );

        pack();
    }

    private void jTableTreinoMouseClicked(java.awt.event.MouseEvent evt) {
        while(evt.getClickCount()==1){
            jButtonAlterar.setEnabled(true);
            jButtonExcluir.setEnabled(true);
        }
    }

    private void jButtonAdicionarActionPerformed(java.awt.event.ActionEvent evt) {
        TreinadorTreinoAdicionar treinadorTreinoAdicionar = new TreinadorTreinoAdicionar(aluno);
        treinadorTreinoAdicionar.setVisible(true);
    }

    private void jButtonAlterarActionPerformed(java.awt.event.ActionEvent evt) {
        //TreinadorTreinoAlterar treinadorTreinoAlterar = new TreinadorTreinoAlterar();
        //treinadorTreinoAlterar.setVisible(true);
    }

    private void jButtonExcluirActionPerformed(java.awt.event.ActionEvent evt) {
        Treino treino = pegarTabela();

        if (excluirTreino(treino)){
            JOptionPane.showMessageDialog(null, "Exercício excluído com sucesso!");
        } else {
            JOptionPane.showMessageDialog(null, "Falha ao excluir o exercício.");
        }
        atualizarTabela();
    }

    private boolean povoarTabela(List<Treino> treinos, DefaultTableModel tableModel){
        Object[] rowData = new Object[4];

        for (int i = 0; i < treinos.size(); i++) {
            rowData[0] = treinos.get(i).getIdTreino();
            rowData[1] = treinos.get(i).getExercicio();
            rowData[2] = treinos.get(i).getRepeticao();
            rowData[3] = treinos.get(i).getCarga();
            tableModel.addRow(rowData);
        }

        return true;
    }

    private void atualizarTabela(){
        List<Treino> treinos = new ArrayList<>();
        DefaultTableModel tableModel = (DefaultTableModel) jTableTreinos.getModel();

        tableModel.setNumRows(0);
        treinos = treinoDAO.listarTreino(aluno.getId());

        if (treinos.size() > 0){
            povoarTabela(treinos,tableModel);
        }
    }

    private Treino pegarTabela(){
        Treino treino = new Treino();
        DefaultTableModel tableModel = (DefaultTableModel) jTableTreinos.getModel();
        int linha = jTableTreinos.getSelectedRow();

        treino.setIdAluno(aluno.getId());
        treino.setIdTreino((Integer) tableModel.getValueAt(linha, 0));
        treino.setExercicio((String) tableModel.getValueAt(linha,1));
        treino.setRepeticao((Integer) tableModel.getValueAt(linha,2));
        treino.setCarga((Integer) tableModel.getValueAt(linha,3));

        return treino;
    }

    private boolean excluirTreino(Treino treino){
        TreinoDAO treinoDAO = new TreinoDAO();

        if(treinoDAO.excluirTreino(treino.getIdTreino()))
            return true;
        else
            return false;
    }

    private JButton jButtonAdicionar;
    private JButton jButtonAlterar;
    private JButton jButtonExcluir;
    private JLabel jLabelTitulo;
    private JPanel jPanel;
    private JScrollPane jScrollPane;
    private JTable jTableTreinos;
}
