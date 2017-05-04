package View;

import Beans.Aluno;
import Beans.Treinador;
import Database.AlunoDAO;

import javax.swing.*;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;
import javax.swing.table.DefaultTableModel;
import java.awt.event.ActionEvent;
import java.util.ArrayList;
import java.util.List;

public class TreinadorAlunoPesquisar extends JFrame{

    private Treinador treinador;
    private AlunoDAO alunoDAO = new AlunoDAO();

    public TreinadorAlunoPesquisar(Treinador treinador){
        this.treinador = treinador;
        initComponents();
    }

    private void initComponents() {

        jPanel = new javax.swing.JPanel();
        jLabelTitulo = new javax.swing.JLabel();
        jTextFieldNome = new javax.swing.JTextField();
        jButtonPesquisar = new javax.swing.JButton();
        jScrollPane = new javax.swing.JScrollPane();
        jTableAlunos = new javax.swing.JTable();
        jButtonAlterar = new javax.swing.JButton();
        jButtonExcluir = new javax.swing.JButton();
        jButtonVerTreino = new javax.swing.JButton();
        jLabelNome = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);

        jLabelTitulo.setFont(new java.awt.Font("Tahoma", 1, 24)); // NOI18N
        jLabelTitulo.setText("Pesquisar Aluno");

        jButtonPesquisar.setText("Pesquisar");
        jButtonPesquisar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonPesquisarActionPerformed(evt);
            }
        });

        jTableAlunos.setModel(new javax.swing.table.DefaultTableModel(
                new Object [][] {

                },
                new String [] {
                        "Nome", "Peso (kg)", "Altura (m)", "Gordura (%)"
                }
        ));
        jTableAlunos.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
        jTableAlunos.getSelectionModel().addListSelectionListener(new ListSelectionListener() {
            @Override
            public void valueChanged(ListSelectionEvent evt) {
                ListSelectionModel listSelectionModel = (ListSelectionModel) evt.getSource();
                jButtonAlterar.setEnabled(!listSelectionModel.isSelectionEmpty());
                jButtonExcluir.setEnabled(!listSelectionModel.isSelectionEmpty());
                jButtonVerTreino.setEnabled(!listSelectionModel.isSelectionEmpty());
            }
        });
        jScrollPane.setViewportView(jTableAlunos);

        jButtonAlterar.setText("Alterar");
        jButtonAlterar.setEnabled(false);
        jButtonAlterar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonAlterarActionPerformed(evt);
            }
        });

        jButtonExcluir.setText("Excluir");
        jButtonExcluir.setEnabled(false);
        jButtonExcluir.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonExcluirActionPerformed(evt);
            }
        });

        jButtonVerTreino.setText("Ver Treino");
        jButtonVerTreino.setEnabled(false);
        jButtonVerTreino.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonVerTreinoActionPerformed(evt);
            }
        });

        jLabelNome.setText("Nome:");

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel);
        jPanel.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
                jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                        .addGroup(jPanel1Layout.createSequentialGroup()
                                                .addGap(20, 20, 20)
                                                .addComponent(jButtonAlterar)
                                                .addGap(82, 82, 82)
                                                .addComponent(jButtonExcluir)
                                                .addGap(67, 67, 67)
                                                .addComponent(jButtonVerTreino)
                                                .addGap(0, 0, Short.MAX_VALUE))
                                        .addGroup(jPanel1Layout.createSequentialGroup()
                                                .addContainerGap()
                                                .addComponent(jScrollPane, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE))
                                        .addGroup(jPanel1Layout.createSequentialGroup()
                                                .addContainerGap()
                                                .addComponent(jLabelNome)
                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 11, Short.MAX_VALUE)
                                                .addComponent(jTextFieldNome, javax.swing.GroupLayout.PREFERRED_SIZE, 231, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                .addGap(18, 18, 18)
                                                .addComponent(jButtonPesquisar)
                                                .addGap(10, 10, 10)))
                                .addContainerGap())
                        .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGap(103, 103, 103)
                                .addComponent(jLabelTitulo)
                                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
                jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGap(18, 18, 18)
                                .addComponent(jLabelTitulo)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                        .addComponent(jTextFieldNome, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addComponent(jButtonPesquisar)
                                        .addComponent(jLabelNome))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(jScrollPane, javax.swing.GroupLayout.PREFERRED_SIZE, 150, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                        .addComponent(jButtonAlterar)
                                        .addComponent(jButtonExcluir)
                                        .addComponent(jButtonVerTreino))
                                .addContainerGap(18, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
                layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addComponent(jPanel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
                layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addComponent(jPanel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
        );

        pack();
    }

    private void jTableAlunosMouseClicked(java.awt.event.MouseEvent evt) {
        while(evt.getClickCount()==1){
            jButtonAlterar.setEnabled(true);
            jButtonExcluir.setEnabled(true);
            jButtonVerTreino.setEnabled(true);
        }
    }

    private void jButtonPesquisarActionPerformed(ActionEvent evt) {
        List<Aluno> alunos = new ArrayList<>();
        String nomeAluno = jTextFieldNome.getText();
        DefaultTableModel tableModel = (DefaultTableModel) jTableAlunos.getModel();

        tableModel.setNumRows(0);
        alunos = alunoDAO.listarAluno(nomeAluno, treinador.getId());

        if (alunos.size() > 0){
            povoarTabela(alunos,tableModel);
        } else {
            JOptionPane.showMessageDialog(null,"Não foram encontrados usuários com esse nome.");
        }

    }

    private void jButtonAlterarActionPerformed(java.awt.event.ActionEvent evt) {
        // TODO add your handling code here:
    }

    private void jButtonExcluirActionPerformed(java.awt.event.ActionEvent evt) {
        Aluno aluno = new Aluno();
        int indice = jTableAlunos.getSelectedRow();
    }

    private void jButtonVerTreinoActionPerformed(java.awt.event.ActionEvent evt) {
        // TODO add your handling code here:
    }

    private boolean povoarTabela(List<Aluno> alunos, DefaultTableModel tableModel){
        Object[] rowData = new Object[4];

        for (int i = 0; i < alunos.size(); i++) {
            rowData[0] = alunos.get(i).getNome();
            rowData[1] = alunos.get(i).getPeso();
            rowData[2] = alunos.get(i).getAltura();
            rowData[3] = alunos.get(i).getGordura();
            tableModel.addRow(rowData);
        }

        return true;
    }

    private javax.swing.JButton jButtonPesquisar;
    private javax.swing.JButton jButtonAlterar;
    private javax.swing.JButton jButtonExcluir;
    private javax.swing.JButton jButtonVerTreino;
    private javax.swing.JLabel jLabelTitulo;
    private javax.swing.JLabel jLabelNome;
    private javax.swing.JPanel jPanel;
    private javax.swing.JScrollPane jScrollPane;
    private javax.swing.JTable jTableAlunos;
    private javax.swing.JTextField jTextFieldNome;
}
