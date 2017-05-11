package View;

import Database.AlunoDAO;
import Beans.Aluno;
import Beans.Treinador;
import Database.UsuarioDAO;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class TreinadorAlunoAdicionar extends JFrame{

    private Treinador treinador;
    private AlunoDAO alunoDAO = new AlunoDAO();
    private UsuarioDAO usuarioDAO = new UsuarioDAO();

    public TreinadorAlunoAdicionar(Treinador treinador){
        this.treinador = treinador;
        initComponents();
    }

    private void initComponents() {

        jPanelAdicionarAluno = new JPanel();
        jTextFieldEmail = new JTextField();
        jTextFieldLogin = new JTextField();
        jLabelNome = new JLabel();
        jButtonAdicionar = new JButton();
        jLabelCPF = new JLabel();
        jButtonCancelar = new JButton();
        jLabelTelefone = new JLabel();
        jTextFieldNome = new JTextField();
        jLabelEmail = new JLabel();
        jFormattedTextFieldCpf = new JFormattedTextField();
        jLabelLogin = new JLabel();
        jFormattedTextFieldTelefone = new JFormattedTextField();
        jLabelTitulo = new JLabel();
        jTextFieldSenha = new JTextField();
        jLabelSenha = new JLabel();

        setDefaultCloseOperation(DISPOSE_ON_CLOSE);
        setTitle("TrainingCheck");

        jLabelNome.setText("Nome");

        jButtonAdicionar.setText("Adicionar");
        jButtonAdicionar.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent evt) {
                jButtonAdicionarActionPerformed(evt);
            }
        });

        jLabelCPF.setText("CPF");

        jButtonCancelar.setText("Cancelar");
        jButtonCancelar.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent evt) {
                jButtonCancelarActionPerformed(evt);
            }
        });

        jLabelTelefone.setText("Telefone");

        jLabelEmail.setText("Email");

        jLabelLogin.setText("Login");

        jLabelTitulo.setFont(new Font("Tahoma", 1, 24)); // NOI18N
        jLabelTitulo.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabelTitulo.setText("Cadastro de Alunos");
        jLabelTitulo.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);

        jLabelSenha.setText("Senha");

        try {
            jFormattedTextFieldCpf.setFormatterFactory(new javax.swing.text.DefaultFormatterFactory(new javax.swing.text.MaskFormatter("###.###.###-##")));
        } catch (java.text.ParseException ex) {
            ex.printStackTrace();
        }

        try {
            jFormattedTextFieldTelefone.setFormatterFactory(new javax.swing.text.DefaultFormatterFactory(new javax.swing.text.MaskFormatter("(##)#########")));
        } catch (java.text.ParseException ex) {
            ex.printStackTrace();
        }

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(jPanelAdicionarAluno);
        jPanelAdicionarAluno.setLayout(layout);
        layout.setHorizontalGroup(
                layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                        .addGroup(layout.createSequentialGroup()
                                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                                        .addGroup(layout.createSequentialGroup()
                                                                .addGap(0, 0, Short.MAX_VALUE)
                                                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                                                        .addComponent(jLabelCPF)
                                                                        .addComponent(jLabelEmail)
                                                                        .addComponent(jLabelLogin)
                                                                        .addComponent(jLabelSenha)))
                                                        .addGroup(javax.swing.GroupLayout.Alignment.LEADING, layout.createSequentialGroup()
                                                                .addComponent(jLabelNome)
                                                                .addGap(0, 0, Short.MAX_VALUE)))
                                                .addGap(47, 47, 47))
                                        .addGroup(layout.createSequentialGroup()
                                                .addComponent(jLabelTelefone)
                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                        .addComponent(jFormattedTextFieldTelefone, javax.swing.GroupLayout.PREFERRED_SIZE, 170, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                                .addComponent(jTextFieldNome, javax.swing.GroupLayout.DEFAULT_SIZE, 274, Short.MAX_VALUE)
                                                .addComponent(jTextFieldEmail, javax.swing.GroupLayout.Alignment.TRAILING)
                                                .addComponent(jFormattedTextFieldCpf, javax.swing.GroupLayout.PREFERRED_SIZE, 170, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                .addComponent(jTextFieldLogin, javax.swing.GroupLayout.PREFERRED_SIZE, 170, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                .addComponent(jTextFieldSenha, javax.swing.GroupLayout.PREFERRED_SIZE, 170, javax.swing.GroupLayout.PREFERRED_SIZE)))
                                .addGap(35, 35, 35))
                        .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                .addContainerGap(76, Short.MAX_VALUE)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                        .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                                .addComponent(jButtonAdicionar)
                                                .addGap(18, 18, 18)
                                                .addComponent(jButtonCancelar)
                                                .addGap(114, 114, 114))
                                        .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                                .addComponent(jLabelTitulo, javax.swing.GroupLayout.PREFERRED_SIZE, 250, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                .addGap(74, 74, 74))))
        );
        layout.setVerticalGroup(
                layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                .addGap(29, 29, 29)
                                .addComponent(jLabelTitulo, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(28, 28, 28)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                        .addComponent(jTextFieldNome, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addComponent(jLabelNome))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                        .addComponent(jFormattedTextFieldCpf, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addComponent(jLabelCPF))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                        .addComponent(jFormattedTextFieldTelefone, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addComponent(jLabelTelefone))
                                .addGap(4, 4, 4)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                        .addComponent(jTextFieldEmail, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addComponent(jLabelEmail))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                        .addComponent(jTextFieldLogin, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addComponent(jLabelLogin))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                        .addComponent(jTextFieldSenha, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addComponent(jLabelSenha))
                                .addGap(18, 18, 18)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                        .addComponent(jButtonAdicionar)
                                        .addComponent(jButtonCancelar))
                                .addContainerGap(28, Short.MAX_VALUE))
        );

        GroupLayout contentLayout = new GroupLayout(getContentPane());
        getContentPane().setLayout(contentLayout);
        contentLayout.setHorizontalGroup(
                contentLayout.createParallelGroup(GroupLayout.Alignment.LEADING)
                        .addComponent(jPanelAdicionarAluno, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        contentLayout.setVerticalGroup(
                contentLayout.createParallelGroup(GroupLayout.Alignment.LEADING)
                        .addComponent(jPanelAdicionarAluno, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        pack();
    }

    private void jButtonAdicionarActionPerformed(java.awt.event.ActionEvent evt) {
        Aluno aluno = new Aluno();

        aluno.setNome(jTextFieldNome.getText());
        aluno.setCPF(jFormattedTextFieldCpf.getText());
        aluno.setTelefone(jFormattedTextFieldTelefone.getText());
        aluno.setEmail(jTextFieldEmail.getText());
        aluno.setLogin(jTextFieldLogin.getText());
        aluno.setSenha(jTextFieldSenha.getText());
        aluno.setTipoLogin(2);
        aluno.setTreinadorId(treinador.getId());

        if(alunoDAO.validarAluno(aluno.getCPF())){
            if (adicionarAluno(aluno)) {
                JOptionPane.showMessageDialog(null, "Cliente cadastrado com Sucesso!");
                this.dispose();
            } else {
                JOptionPane.showMessageDialog(null,"Falha no Cadastro!");
            }
        }else{
            JOptionPane.showMessageDialog(null,"CPF já cadastrado!");
        }
    }

    private void jButtonCancelarActionPerformed(java.awt.event.ActionEvent evt) {
        this.dispose();
    }

    public boolean adicionarAluno(Aluno aluno){

        try{
            if (alunoDAO.adicionarAluno(aluno)){
                aluno.setId(alunoDAO.buscarIdAluno(aluno));
                if (usuarioDAO.adicionarUsuario(aluno)){
                    return true;
                }else {
                    alunoDAO.excluirAluno(aluno);
                }
            }
        }catch (Exception e){
            System.out.println(e);
        }
        return false;
    }

    private JButton jButtonAdicionar;
    private JButton jButtonCancelar;
    private JFormattedTextField jFormattedTextFieldCpf;
    private JFormattedTextField jFormattedTextFieldTelefone;
    private JLabel jLabelTitulo;
    private JLabel jLabelNome;
    private JLabel jLabelCPF;
    private JLabel jLabelTelefone;
    private JLabel jLabelEmail;
    private JLabel jLabelLogin;
    private JLabel jLabelSenha;
    private JPanel jPanelAdicionarAluno;
    private JTextField jTextFieldNome;
    private JTextField jTextFieldEmail;
    private JTextField jTextFieldLogin;
    private JTextField jTextFieldSenha;
}
