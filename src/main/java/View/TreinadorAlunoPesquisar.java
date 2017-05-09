package View;

import Beans.Aluno;
import Beans.Treinador;
import Database.AlunoDAO;
import Database.UsuarioDAO;

import javax.swing.*;
import javax.swing.event.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.awt.event.*;
import java.util.*;
import java.util.List;

public class TreinadorAlunoPesquisar extends JFrame{

    private Treinador treinador;
    private AlunoDAO alunoDAO = new AlunoDAO();

    public TreinadorAlunoPesquisar(Treinador treinador){
        this.treinador = treinador;
        initComponents();
    }

    private void initComponents() {

        jPanel = new JPanel();
        jLabelTitulo = new JLabel();
        jTextFieldNome = new JTextField();
        jButtonPesquisar = new JButton();
        jScrollPane = new JScrollPane();
        jTableAlunos = new JTable();
        jButtonAlterar = new JButton();
        jButtonExcluir = new JButton();
        jButtonVerTreino = new JButton();
        jLabelNome = new JLabel();

        setDefaultCloseOperation(WindowConstants.DISPOSE_ON_CLOSE);

        jLabelTitulo.setFont(new Font("Tahoma", 1, 24)); // NOI18N
        jLabelTitulo.setText("Pesquisar Aluno");

        jButtonPesquisar.setText("Pesquisar");
        jButtonPesquisar.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent evt) {
                jButtonPesquisarActionPerformed(evt);
            }
        });

        jTableAlunos.setModel(new DefaultTableModel(
                new Object [][] {

                },
                new String [] {
                        "ID", "Nome", "Peso (kg)", "Altura (m)", "Gordura (%)"
                }
        ));
        jTableAlunos.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
        jTableAlunos.getSelectionModel().addListSelectionListener(new ListSelectionListener() {
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

        jButtonVerTreino.setText("Ver Treino");
        jButtonVerTreino.setEnabled(false);
        jButtonVerTreino.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent evt) {
                jButtonVerTreinoActionPerformed(evt);
            }
        });

        jLabelNome.setText("Nome:");

        GroupLayout jPanelLayout = new GroupLayout(jPanel);
        jPanel.setLayout(jPanelLayout);
        jPanelLayout.setHorizontalGroup(
                jPanelLayout.createParallelGroup(GroupLayout.Alignment.LEADING)
                        .addGroup(jPanelLayout.createSequentialGroup()
                                .addGroup(jPanelLayout.createParallelGroup(GroupLayout.Alignment.LEADING)
                                        .addGroup(jPanelLayout.createSequentialGroup()
                                                .addGap(20, 20, 20)
                                                .addComponent(jButtonAlterar)
                                                .addGap(82, 82, 82)
                                                .addComponent(jButtonExcluir)
                                                .addGap(67, 67, 67)
                                                .addComponent(jButtonVerTreino)
                                                .addGap(0, 0, Short.MAX_VALUE))
                                        .addGroup(jPanelLayout.createSequentialGroup()
                                                .addContainerGap()
                                                .addComponent(jScrollPane, GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE))
                                        .addGroup(jPanelLayout.createSequentialGroup()
                                                .addContainerGap()
                                                .addComponent(jLabelNome)
                                                .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED, 11, Short.MAX_VALUE)
                                                .addComponent(jTextFieldNome, GroupLayout.PREFERRED_SIZE, 231, GroupLayout.PREFERRED_SIZE)
                                                .addGap(18, 18, 18)
                                                .addComponent(jButtonPesquisar)
                                                .addGap(10, 10, 10)))
                                .addContainerGap())
                        .addGroup(jPanelLayout.createSequentialGroup()
                                .addGap(103, 103, 103)
                                .addComponent(jLabelTitulo)
                                .addContainerGap(GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanelLayout.setVerticalGroup(
                jPanelLayout.createParallelGroup(GroupLayout.Alignment.LEADING)
                        .addGroup(jPanelLayout.createSequentialGroup()
                                .addGap(18, 18, 18)
                                .addComponent(jLabelTitulo)
                                .addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED)
                                .addGroup(jPanelLayout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                                        .addComponent(jTextFieldNome, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
                                        .addComponent(jButtonPesquisar)
                                        .addComponent(jLabelNome))
                                .addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(jScrollPane, GroupLayout.PREFERRED_SIZE, 150, GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED)
                                .addGroup(jPanelLayout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                                        .addComponent(jButtonAlterar)
                                        .addComponent(jButtonExcluir)
                                        .addComponent(jButtonVerTreino))
                                .addContainerGap(18, Short.MAX_VALUE))
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

    private void jButtonPesquisarActionPerformed(ActionEvent evt) {
        String nomeAluno = jTextFieldNome.getText();

        if(!atualizarTabela(nomeAluno))
            JOptionPane.showMessageDialog(null,"Nenhum aluno encontrado.");
    }

    private boolean atualizarTabela(String nomeAluno){
        boolean retorno = false;
        List<Aluno> alunos = new ArrayList<>();
        DefaultTableModel tableModel = (DefaultTableModel) jTableAlunos.getModel();

        tableModel.setNumRows(0);
        alunos = alunoDAO.listarAluno(nomeAluno, treinador.getId());

        if (alunos.size() > 0){
            povoarTabela(alunos,tableModel);
            retorno = true;
        }
        return retorno;
    }

    private void jButtonAlterarActionPerformed(java.awt.event.ActionEvent evt) {
        Aluno aluno = pegarTabela();
        TreinadorAlunoAlterar treinadorAlunoAlterar = new TreinadorAlunoAlterar(aluno);
        treinadorAlunoAlterar.setVisible(true);
    }

    private void jButtonExcluirActionPerformed(java.awt.event.ActionEvent evt) {
        Aluno aluno = pegarTabela();
        if (excluirAluno(aluno)){
            JOptionPane.showMessageDialog(null, "Aluno excluído com sucesso!");
        } else {
            JOptionPane.showMessageDialog(null, "Falha ao excluir o aluno.");
        }
        atualizarTabela(aluno.getNome());
    }

    private void jButtonVerTreinoActionPerformed(java.awt.event.ActionEvent evt) {
        Aluno aluno = pegarTabela();
        TreinadorAlunoTreino treinadorAlunoTreino = new TreinadorAlunoTreino(treinador,aluno);
        treinadorAlunoTreino.setVisible(true);
    }

    private boolean povoarTabela(List<Aluno> alunos, DefaultTableModel tableModel){
        Object[] rowData = new Object[5];

        for (int i = 0; i < alunos.size(); i++) {
            rowData[0] = alunos.get(i).getId();
            rowData[1] = alunos.get(i).getNome();
            rowData[2] = alunos.get(i).getPeso();
            rowData[3] = alunos.get(i).getAltura();
            rowData[4] = alunos.get(i).getGordura();
            tableModel.addRow(rowData);
        }

        return true;
    }

    private Aluno pegarTabela(){
        Aluno aluno = new Aluno();
        DefaultTableModel tableModel = (DefaultTableModel) jTableAlunos.getModel();
        int linha = jTableAlunos.getSelectedRow();

        aluno.setId((Integer) tableModel.getValueAt(linha,0));
        aluno.setNome((String) tableModel.getValueAt(linha,1));
        aluno.setPeso((Float) tableModel.getValueAt(linha,2));
        aluno.setAltura((Float) tableModel.getValueAt(linha,3));
        aluno.setGordura((Float) tableModel.getValueAt(linha,4));

        return aluno;
    }

    private boolean excluirAluno(Aluno aluno){
        UsuarioDAO usuarioDAO = new UsuarioDAO();
        AlunoDAO alunoDAO = new AlunoDAO();
        boolean retorno = false;

        if(usuarioDAO.excluirUsuario(aluno)){
            if(alunoDAO.excluirAluno(aluno.getId())){
                retorno = true;
            }
        }
        return retorno;
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
