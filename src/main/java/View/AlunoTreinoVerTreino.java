package View;

import Beans.Aluno;
import Beans.Treino;
import Database.TreinoDAO;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.util.ArrayList;
import java.util.List;

public class AlunoTreinoVerTreino extends JFrame{

    private TreinoDAO treinoDAO = new TreinoDAO();
    private Aluno aluno;

    public AlunoTreinoVerTreino(Aluno aluno) {
        this.aluno = aluno;
        initComponents();
        atualizarTabela();
    }

    private void initComponents() {

        jPanel = new javax.swing.JPanel();
        jLabelTitulo = new javax.swing.JLabel();
        jScrollPane = new javax.swing.JScrollPane();
        jTableTreino = new javax.swing.JTable();

        setDefaultCloseOperation(WindowConstants.DISPOSE_ON_CLOSE);

        jLabelTitulo.setFont(new java.awt.Font("Tahoma", 1, 24));
        jLabelTitulo.setText("Treino");

        jTableTreino.setModel(new javax.swing.table.DefaultTableModel(
                new Object [][] {

                },
                new String [] {
                        "Exercício", "Repetição", "Carga (kg)"
                }
        ));
        jScrollPane.setViewportView(jTableTreino);

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel);
        jPanel.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
                jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                        .addGroup(jPanel1Layout.createSequentialGroup()
                                                .addGap(161, 161, 161)
                                                .addComponent(jLabelTitulo))
                                        .addGroup(jPanel1Layout.createSequentialGroup()
                                                .addContainerGap()
                                                .addComponent(jScrollPane, javax.swing.GroupLayout.PREFERRED_SIZE, 375, javax.swing.GroupLayout.PREFERRED_SIZE)))
                                .addContainerGap(15, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
                jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(jPanel1Layout.createSequentialGroup()
                                .addContainerGap()
                                .addComponent(jLabelTitulo)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jScrollPane, javax.swing.GroupLayout.PREFERRED_SIZE, 275, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
                layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addComponent(jPanel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
                layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addComponent(jPanel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        pack();
    }

    private boolean atualizarTabela(){
        boolean retorno = false;
        List<Treino> treinos = new ArrayList<>();
        DefaultTableModel tableModel = (DefaultTableModel) jTableTreino.getModel();

        tableModel.setNumRows(0);
        treinos = treinoDAO.listarTreino(aluno.getId());

        if (treinos.size() > 0){
            povoarTabela(treinos,tableModel);
            retorno = true;
        }
        return retorno;
    }

    private boolean povoarTabela(List<Treino> treinos, DefaultTableModel tableModel){
        Object[] rowData = new Object[3];

        for (int i = 0; i < treinos.size(); i++) {
            rowData[0] = treinos.get(i).getExercicio();
            rowData[1] = treinos.get(i).getRepeticao();
            rowData[2] = treinos.get(i).getCarga();
            tableModel.addRow(rowData);
        }
        return true;
    }

    private javax.swing.JLabel jLabelTitulo;
    private javax.swing.JPanel jPanel;
    private javax.swing.JScrollPane jScrollPane;
    private javax.swing.JTable jTableTreino;
}
