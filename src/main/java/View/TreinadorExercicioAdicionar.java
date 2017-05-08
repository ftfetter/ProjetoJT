package View;

import Beans.Exercicio;
import Database.ExercicioDAO;

import javax.swing.*;

public class TreinadorExercicioAdicionar extends JFrame{
    public TreinadorExercicioAdicionar() {
        initComponents();
    }

    private void initComponents() {

        jLabelNome = new JLabel();
        jButtonAdicionar = new JButton();
        jLabelDescricao = new JLabel();
        jButtonCancelar = new JButton();
        jTextFieldNome = new JTextField();
        jLabelTitulo = new JLabel();
        jScrollPane = new JScrollPane();
        jTextAreaDescricao = new JTextArea();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);

        jLabelNome.setText("Nome");

        jButtonAdicionar.setText("Adicionar");
        jButtonAdicionar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonAdicionarActionPerformed(evt);
            }
        });

        jLabelDescricao.setText("Descrição");

        jButtonCancelar.setText("Cancelar");
        jButtonCancelar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonCancelarActionPerformed(evt);
            }
        });

        jLabelTitulo.setFont(new java.awt.Font("Tahoma", 1, 24));
        jLabelTitulo.setText("Adicionar Exercício");

        jTextAreaDescricao.setColumns(20);
        jTextAreaDescricao.setRows(5);
        jScrollPane.setViewportView(jTextAreaDescricao);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
                layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(layout.createSequentialGroup()
                                .addGap(117, 117, 117)
                                .addComponent(jButtonAdicionar)
                                .addGap(18, 18, 18)
                                .addComponent(jButtonCancelar)
                                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                        .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                .addContainerGap(29, Short.MAX_VALUE)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                        .addComponent(jLabelNome)
                                        .addComponent(jLabelDescricao))
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                        .addGroup(layout.createSequentialGroup()
                                                .addGap(27, 27, 27)
                                                .addComponent(jLabelTitulo))
                                        .addGroup(layout.createSequentialGroup()
                                                .addGap(50, 50, 50)
                                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                                        .addComponent(jTextFieldNome, javax.swing.GroupLayout.DEFAULT_SIZE, 240, Short.MAX_VALUE)
                                                        .addComponent(jScrollPane))))
                                .addGap(35, 35, 35))
        );
        layout.setVerticalGroup(
                layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                .addContainerGap()
                                .addComponent(jLabelTitulo, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 46, Short.MAX_VALUE)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                        .addComponent(jTextFieldNome, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addComponent(jLabelNome))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                        .addComponent(jLabelDescricao)
                                        .addComponent(jScrollPane, javax.swing.GroupLayout.PREFERRED_SIZE, 118, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGap(18, 18, 18)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                        .addComponent(jButtonAdicionar)
                                        .addComponent(jButtonCancelar))
                                .addGap(23, 23, 23))
        );

        pack();
    }

    private void jButtonAdicionarActionPerformed(java.awt.event.ActionEvent evt) {
        ExercicioDAO exercicioDAO = new ExercicioDAO();
        Exercicio exercicio = new Exercicio(jTextFieldNome.getText(),jTextAreaDescricao.getText());

        if(exercicioDAO.validarExercicio(exercicio.getNome())) {
            System.out.println(exercicioDAO.validarExercicio(exercicio.getNome()));
            if (exercicioDAO.adicionarExercicio(exercicio)) {
                JOptionPane.showMessageDialog(null, "Exercício cadastrado com sucesso!");
            } else {
                JOptionPane.showMessageDialog(null, "Falha no cadastro do exercício.");
            }
        } else {
            JOptionPane.showMessageDialog(null, "Já existe um exercício com esse nome.");
        }

    }

    private void jButtonCancelarActionPerformed(java.awt.event.ActionEvent evt) { this.dispose(); }

    private JButton jButtonAdicionar;
    private JButton jButtonCancelar;
    private JLabel jLabelDescricao;
    private JLabel jLabelNome;
    private JLabel jLabelTitulo;
    private JScrollPane jScrollPane;
    private JTextArea jTextAreaDescricao;
    private JTextField jTextFieldNome;
}
