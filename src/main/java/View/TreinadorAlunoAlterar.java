package View;

import Beans.Aluno;
import Database.AlunoDAO;

import javax.swing.*;

public class TreinadorAlunoAlterar extends JFrame{

    private AlunoDAO alunoDAO = new AlunoDAO();
    private Aluno alteracao;

    public TreinadorAlunoAlterar(Aluno aluno) {
        this.alteracao = aluno;
        initComponents();
        preencherCampos(aluno);
    }

    private void initComponents() {

        jPanel = new javax.swing.JPanel();
        jLabelTitulo = new javax.swing.JLabel();
        jTextFieldNome = new javax.swing.JTextField();
        jTextFieldEmail = new javax.swing.JTextField();
        jButtonAdicionar = new javax.swing.JButton();
        jButtonCancelar = new javax.swing.JButton();
        jLabelNome = new javax.swing.JLabel();
        jLabelEmail = new javax.swing.JLabel();
        jLabelTelefone = new javax.swing.JLabel();
        jTextFieldPeso = new javax.swing.JTextField();
        jTextFieldAltura = new javax.swing.JTextField();
        jTextFieldGordura = new javax.swing.JTextField();
        jFormattedTextFieldTelefone = new javax.swing.JFormattedTextField();
        jLabelPeso = new javax.swing.JLabel();
        jLabelAltura = new javax.swing.JLabel();
        jLabelGordura = new javax.swing.JLabel();

        setDefaultCloseOperation(WindowConstants.DISPOSE_ON_CLOSE);

        jLabelTitulo.setFont(new java.awt.Font("Tahoma", 1, 24));
        jLabelTitulo.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabelTitulo.setText("Alterar Aluno");

        jButtonAdicionar.setText("Adicionar");
        jButtonAdicionar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonAdicionarActionPerformed(evt);
            }
        });

        jButtonCancelar.setText("Cancelar");
        jButtonCancelar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonCancelarActionPerformed(evt);
            }
        });

        jLabelNome.setText("Nome");

        jLabelEmail.setText("Email");

        jLabelTelefone.setText("Telefone");

        try {
            jFormattedTextFieldTelefone.setFormatterFactory(new javax.swing.text.DefaultFormatterFactory(new javax.swing.text.MaskFormatter("(##)#########")));
        } catch (java.text.ParseException ex) {
            ex.printStackTrace();
        }

        jLabelPeso.setText("Peso (kg)");

        jLabelAltura.setText("Altura (m)");

        jLabelGordura.setText("Gordura (%)");

        javax.swing.GroupLayout jPanelLayout = new javax.swing.GroupLayout(jPanel);
        jPanel.setLayout(jPanelLayout);
        jPanelLayout.setHorizontalGroup(
                jPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(jPanelLayout.createSequentialGroup()
                                .addGroup(jPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                        .addGroup(jPanelLayout.createSequentialGroup()
                                                .addGap(92, 92, 92)
                                                .addComponent(jButtonAdicionar)
                                                .addGap(74, 74, 74)
                                                .addComponent(jButtonCancelar))
                                        .addGroup(jPanelLayout.createSequentialGroup()
                                                .addGap(36, 36, 36)
                                                .addGroup(jPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                                        .addComponent(jLabelTelefone)
                                                        .addGroup(jPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                                                .addGroup(jPanelLayout.createSequentialGroup()
                                                                        .addComponent(jLabelNome)
                                                                        .addGap(65, 65, 65)
                                                                        .addGroup(jPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                                                                .addComponent(jLabelTitulo)
                                                                                .addComponent(jTextFieldNome, javax.swing.GroupLayout.PREFERRED_SIZE, 229, javax.swing.GroupLayout.PREFERRED_SIZE)))
                                                                .addGroup(javax.swing.GroupLayout.Alignment.LEADING, jPanelLayout.createSequentialGroup()
                                                                        .addComponent(jLabelEmail)
                                                                        .addGap(68, 68, 68)
                                                                        .addGroup(jPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                                                                .addComponent(jTextFieldEmail, javax.swing.GroupLayout.PREFERRED_SIZE, 229, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                                                .addComponent(jFormattedTextFieldTelefone, javax.swing.GroupLayout.PREFERRED_SIZE, 101, javax.swing.GroupLayout.PREFERRED_SIZE)))
                                                                .addGroup(jPanelLayout.createSequentialGroup()
                                                                        .addGroup(jPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                                                                .addGroup(javax.swing.GroupLayout.Alignment.LEADING, jPanelLayout.createSequentialGroup()
                                                                                        .addComponent(jLabelGordura)
                                                                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                                                                        .addComponent(jTextFieldGordura, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE))
                                                                                .addGroup(jPanelLayout.createSequentialGroup()
                                                                                        .addGroup(jPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                                                                                .addComponent(jLabelPeso)
                                                                                                .addComponent(jLabelAltura))
                                                                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                                                                        .addGroup(jPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                                                                                .addComponent(jTextFieldAltura, javax.swing.GroupLayout.DEFAULT_SIZE, 100, Short.MAX_VALUE)
                                                                                                .addComponent(jTextFieldPeso))))
                                                                        .addGap(129, 129, 129))))))
                                .addContainerGap(43, Short.MAX_VALUE))
        );
        jPanelLayout.setVerticalGroup(
                jPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(jPanelLayout.createSequentialGroup()
                                .addGap(31, 31, 31)
                                .addComponent(jLabelTitulo)
                                .addGap(18, 18, 18)
                                .addGroup(jPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                        .addComponent(jTextFieldNome, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addComponent(jLabelNome))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(jPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                        .addComponent(jFormattedTextFieldTelefone, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addComponent(jLabelTelefone))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(jPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                        .addComponent(jTextFieldEmail, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addComponent(jLabelEmail))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(jPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                        .addComponent(jTextFieldPeso, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addComponent(jLabelPeso))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(jPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                        .addComponent(jTextFieldAltura, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addComponent(jLabelAltura))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(jPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                        .addComponent(jTextFieldGordura, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addComponent(jLabelGordura))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 31, Short.MAX_VALUE)
                                .addGroup(jPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                        .addComponent(jButtonAdicionar)
                                        .addComponent(jButtonCancelar))
                                .addGap(25, 25, 25))
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

    private void jButtonAdicionarActionPerformed(java.awt.event.ActionEvent evt) {
        alteracao = pegarAlteracoes();
        if(alunoDAO.alterarAluno(alteracao))
            JOptionPane.showMessageDialog(null,"Aluno atualizado com sucesso!");
        else
            JOptionPane.showMessageDialog(null,"Falha ao atualizar aluno.");
    }

    private void jButtonCancelarActionPerformed(java.awt.event.ActionEvent evt) {
        this.dispose();
    }

    private Aluno pegarAlteracoes(){
        alteracao.setNome(jTextFieldNome.getText());
        alteracao.setTelefone(jFormattedTextFieldTelefone.getText());
        alteracao.setEmail(jTextFieldEmail.getText());
        alteracao.setPeso(Float.parseFloat(jTextFieldPeso.getText()));
        alteracao.setAltura(Float.parseFloat(jTextFieldAltura.getText()));
        alteracao.setGordura(Float.parseFloat(jTextFieldGordura.getText()));

        return alteracao;
    }

    private void preencherCampos(Aluno aluno){
        jTextFieldNome.setText(aluno.getNome());
        jFormattedTextFieldTelefone.setText(aluno.getTelefone());
        jTextFieldEmail.setText(aluno.getEmail());
        jTextFieldPeso.setText(String.valueOf(aluno.getPeso()));
        jTextFieldAltura.setText(String.valueOf(aluno.getAltura()));
        jTextFieldGordura.setText(String.valueOf(aluno.getGordura()));
    }

    private javax.swing.JButton jButtonAdicionar;
    private javax.swing.JButton jButtonCancelar;
    private javax.swing.JFormattedTextField jFormattedTextFieldTelefone;
    private javax.swing.JLabel jLabelAltura;
    private javax.swing.JLabel jLabelEmail;
    private javax.swing.JLabel jLabelGordura;
    private javax.swing.JLabel jLabelNome;
    private javax.swing.JLabel jLabelPeso;
    private javax.swing.JLabel jLabelTelefone;
    private javax.swing.JLabel jLabelTitulo;
    private javax.swing.JPanel jPanel;
    private javax.swing.JTextField jTextFieldAltura;
    private javax.swing.JTextField jTextFieldEmail;
    private javax.swing.JTextField jTextFieldGordura;
    private javax.swing.JTextField jTextFieldNome;
    private javax.swing.JTextField jTextFieldPeso;
}
