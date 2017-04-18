import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.*;

/**
 * Created by ilegra0320 on 17/04/2017.
 */
public class frmLogin extends JFrame {
    private JPanel jPanelLogin;

    Connection con = null;
    PreparedStatement pst = null;
    ResultSet rs = null;

    private void createUIComponents() {
        // TODO: place custom component creation code here
    }

    public frmLogin() throws ClassNotFoundException {

        initComponents();

        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

    }
    public void login() throws ClassNotFoundException {

        String select = "SELECT * FROM login WHERE usuario = ? AND senha = ?;";

        try{
            con = dbConnect.getConnection();

            //preparando os SELECTS
            pst = con.prepareStatement(select);
            //setando as variáveis do SELECT
            pst.setString(1, jTextFieldUsuario.getText());
            pst.setString(2, String.valueOf(jPasswordFieldSenha.getPassword()));

            rs = pst.executeQuery();

            if(rs.next()){
                int tipo = rs.getInt(4);
                if(tipo == 1){
                    JOptionPane.showMessageDialog(null,"BEM VINDO ADMIN");
                    int id_treinador = rs.getInt(5);
                }else{
                    JOptionPane.showMessageDialog(null,"BEM VINDO CLIENTE");
                    int id_aluno = rs.getInt(6);
                }
            }else {
                JOptionPane.showMessageDialog(null,"Usuário e/ou senha inválidos.");
            }
        }
        catch(SQLException error){
            error.printStackTrace();
        }

    }

    private void initComponents() {

        jPanelLogin = new JPanel();
        jTextFieldUsuario = new JTextField();
        jButtonLogin = new JButton();
        jLabelLogin = new JLabel();
        jLabelSenha = new JLabel();
        jLabelTitulo = new JLabel();
        jPasswordFieldSenha = new JPasswordField();

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
        jLabelLogin.setToolTipText("");

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
        // TODO add your handling code here:
        login();

    }

    private JLabel jLabelTitulo;
    private JLabel jLabelLogin;
    private JLabel jLabelSenha;
    private JTextField jTextFieldUsuario;
    private JButton jButtonLogin;
    private JPasswordField jPasswordFieldSenha;
}
