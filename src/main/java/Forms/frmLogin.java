package Forms;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

import Database.*;
import Users.*;

public class frmLogin extends JFrame{

    public frmLogin() {

        initComponents();

    }

    // Função para inicialização de todos os componentes visuais
    private void initComponents() {

        jTextFieldUsuario = new JTextField();
        jButtonLogin = new JButton();
        jLabelLogin = new JLabel();
        jLabelSenha = new JLabel();
        jLabelTitulo = new JLabel();
        jPasswordFieldSenha = new JPasswordField();

        setTitle("TrainingCheck");
        setSize(350,500);
        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);

        jButtonLogin.setText("Entrar");
        jButtonLogin.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent evt) {
                try {
                    jButtonLoginActionPerformed(evt);
                } catch (ClassNotFoundException e) {
                    e.printStackTrace();
                }
            }
        });

        jLabelLogin.setText("Login");

        jLabelSenha.setText("Senha");

        jLabelTitulo.setFont(new Font("Trebuchet MS", 1, 36)); // NOI18N
        jLabelTitulo.setText("TrainingCheck");

        GroupLayout layout = new GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
                layout.createParallelGroup(GroupLayout.Alignment.LEADING)
                        .addGroup(layout.createSequentialGroup()
                                .addGap(75, 75, 75)
                                .addGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING)
                                        .addGroup(layout.createSequentialGroup()
                                                .addGroup(layout.createParallelGroup(GroupLayout.Alignment.TRAILING)
                                                        .addComponent(jLabelLogin)
                                                        .addComponent(jLabelSenha))
                                                .addGap(18, 18, 18)
                                                .addGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING, false)
                                                        .addComponent(jTextFieldUsuario, GroupLayout.DEFAULT_SIZE, 164, Short.MAX_VALUE)
                                                        .addGroup(layout.createSequentialGroup()
                                                                .addGap(40, 40, 40)
                                                                .addComponent(jButtonLogin))
                                                        .addComponent(jPasswordFieldSenha)))
                                        .addGroup(layout.createSequentialGroup()
                                                .addGap(5, 5, 5)
                                                .addComponent(jLabelTitulo)))
                                .addContainerGap(80, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
                layout.createParallelGroup(GroupLayout.Alignment.LEADING)
                        .addGroup(GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                .addContainerGap(73, Short.MAX_VALUE)
                                .addComponent(jLabelTitulo, GroupLayout.PREFERRED_SIZE, 42, GroupLayout.PREFERRED_SIZE)
                                .addGap(31, 31, 31)
                                .addGroup(layout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                                        .addComponent(jTextFieldUsuario, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
                                        .addComponent(jLabelLogin))
                                .addGap(18, 18, 18)
                                .addGroup(layout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                                        .addComponent(jLabelSenha)
                                        .addComponent(jPasswordFieldSenha, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
                                .addGap(18, 18, 18)
                                .addComponent(jButtonLogin)
                                .addGap(55, 55, 55))
        );

        pack();
    }

    private void jButtonLoginActionPerformed(java.awt.event.ActionEvent evt) throws ClassNotFoundException {
        Usuario usuario = new Usuario(jTextFieldUsuario.getText(),String.valueOf(jPasswordFieldSenha.getPassword()));

        if (validaLogin(usuario)){
            usuario = UsuarioDAO.autenticando(usuario);
            login(usuario);
        } else {
            JOptionPane.showMessageDialog(null,"Login inválido.");
        }
    }
    public boolean validaLogin(Usuario usuario){
        if (usuario.getLogin().isEmpty() || usuario.getSenha().isEmpty()){
            return false;
        }else {
            return true;
        }
    }

    public boolean login(Usuario usuario){
        switch(usuario.getTipoLogin()){
            case 1:
                TreinadorDAO treinadorDAO = new TreinadorDAO();
                Usuario treinador = treinadorDAO.setTreinador(usuario);
                //JOptionPane.showMessageDialog(null,"Bem vindo "+treinador.getNome());
                return true;
            case 2:
                AlunoDAO alunoDAO = new AlunoDAO();
                Usuario aluno = alunoDAO.setAluno(usuario);
                //JOptionPane.showMessageDialog(null,"Bem vindo "+aluno.getNome());
                return true;
            default:
                JOptionPane.showMessageDialog(null,"Usuário e/ou senha inválidos.");
        }
        return false;
    }

    private JLabel jLabelTitulo;
    private JLabel jLabelLogin;
    private JLabel jLabelSenha;
    private JTextField jTextFieldUsuario;
    private JButton jButtonLogin;
    private JPasswordField jPasswordFieldSenha;
}
