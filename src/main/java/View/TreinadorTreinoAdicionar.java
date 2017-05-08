package View;

import javax.swing.*;
import java.awt.*;

public class TreinadorTreinoAdicionar extends JFrame{
    public TreinadorTreinoAdicionar() {
        initComponents();
    }

    private void initComponents() {

        jPanel = new JPanel();
        jLabelTitulo = new JLabel();
        jButtonAdicionar = new JButton();
        jComboBoxExercicio = new JComboBox<>();
        jLabelExercicio = new JLabel();
        jLabelRepeticao = new JLabel();
        jLabelCarga = new JLabel();
        jTextFieldRepeticao = new JTextField();
        jTextFieldCarga = new JTextField();
        jButtonCancelar = new JButton();

        setDefaultCloseOperation(WindowConstants.DISPOSE_ON_CLOSE);

        jLabelTitulo.setFont(new java.awt.Font("Tahoma", 1, 24)); // NOI18N
        jLabelTitulo.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabelTitulo.setText("Adicionar Treino");

        jButtonAdicionar.setText("Adicionar");
        jButtonAdicionar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonAdicionarActionPerformed(evt);
            }
        });

        jComboBoxExercicio.setModel(new DefaultComboBoxModel<>(new String[] {}));

        jLabelExercicio.setText("Exercício");

        jLabelRepeticao.setText("Repetição");

        jLabelCarga.setText("Carga");

        jButtonCancelar.setText("Cancelar");
        jButtonCancelar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonCancelarActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanelLayout = new javax.swing.GroupLayout(jPanel);
        jPanel.setLayout(jPanelLayout);
        jPanelLayout.setHorizontalGroup(
                jPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(jPanelLayout.createSequentialGroup()
                                .addGap(102, 102, 102)
                                .addComponent(jLabelTitulo)
                                .addGap(0, 0, Short.MAX_VALUE))
                        .addGroup(jPanelLayout.createSequentialGroup()
                                .addGap(83, 83, 83)
                                .addComponent(jButtonCancelar)
                                .addGap(70, 70, 70)
                                .addComponent(jButtonAdicionar)
                                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                        .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanelLayout.createSequentialGroup()
                                .addGap(55, 55, 55)
                                .addGroup(jPanelLayout.createParallelGroup(GroupLayout.Alignment.LEADING)
                                        .addComponent(jLabelRepeticao)
                                        .addComponent(jLabelCarga)
                                        .addComponent(jLabelExercicio))
                                .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED, 81, Short.MAX_VALUE)
                                .addGroup(jPanelLayout.createParallelGroup(GroupLayout.Alignment.LEADING)
                                        .addGroup(GroupLayout.Alignment.TRAILING, jPanelLayout.createSequentialGroup()
                                                .addComponent(jComboBoxExercicio, GroupLayout.PREFERRED_SIZE, 172, GroupLayout.PREFERRED_SIZE)
                                                .addGap(44, 44, 44))
                                        .addGroup(jPanelLayout.createSequentialGroup()
                                                .addGroup(jPanelLayout.createParallelGroup(GroupLayout.Alignment.LEADING)
                                                        .addComponent(jTextFieldRepeticao, GroupLayout.PREFERRED_SIZE, 172, GroupLayout.PREFERRED_SIZE)
                                                        .addComponent(jTextFieldCarga, GroupLayout.PREFERRED_SIZE, 172, GroupLayout.PREFERRED_SIZE))
                                                .addContainerGap())))
        );
        jPanelLayout.setVerticalGroup(
                jPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(jPanelLayout.createSequentialGroup()
                                .addGap(26, 26, 26)
                                .addComponent(jLabelTitulo)
                                .addGap(59, 59, 59)
                                .addGroup(jPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                        .addComponent(jComboBoxExercicio, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addComponent(jLabelExercicio))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addGroup(jPanelLayout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                                        .addComponent(jTextFieldRepeticao, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
                                        .addComponent(jLabelRepeticao))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addGroup(jPanelLayout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                                        .addComponent(jTextFieldCarga, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addComponent(jLabelCarga))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 70, Short.MAX_VALUE)
                                .addGroup(jPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                        .addComponent(jButtonCancelar)
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

    private void jButtonAdicionarActionPerformed(java.awt.event.ActionEvent evt) {

    }

    private void jButtonCancelarActionPerformed(java.awt.event.ActionEvent evt) { this.dispose(); }

    private JButton jButtonAdicionar;
    private JButton jButtonCancelar;
    private JComboBox<String> jComboBoxExercicio;
    private JLabel jLabelExercicio;
    private JLabel jLabelRepeticao;
    private JLabel jLabelCarga;
    private JLabel jLabelTitulo;
    private JPanel jPanel;
    private JTextField jTextFieldRepeticao;
    private JTextField jTextFieldCarga;
}

