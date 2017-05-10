package View;

import Beans.Aluno;

import javax.swing.*;
import java.util.jar.JarFile;

public class AlunoFrame extends JFrame{

    private Aluno aluno;

    public AlunoFrame(Aluno aluno) {
        this.aluno = aluno;
        initComponents();
    }

    private void initComponents() {

        jPanel = new javax.swing.JPanel();
        jLabelBemVindo = new javax.swing.JLabel();
        jLabelNome = new javax.swing.JLabel();
        jMenuBar = new javax.swing.JMenuBar();
        jMenuTreino = new javax.swing.JMenu();
        jMenuItemVerTreino = new javax.swing.JMenuItem();
        jMenuPerfil = new javax.swing.JMenu();
        jMenuItemVerPerfil = new javax.swing.JMenuItem();
        jMenuItemSair = new javax.swing.JMenuItem();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("TrainingCheck");

        jLabelBemVindo.setFont(new java.awt.Font("Tahoma", 1, 36));
        jLabelBemVindo.setText("Bem Vindo");

        jLabelNome.setFont(new java.awt.Font("Tahoma", 0, 14));
        jLabelNome.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabelNome.setText(aluno.getNome());
        jLabelNome.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);

        javax.swing.GroupLayout jPanelLayout = new javax.swing.GroupLayout(jPanel);
        jPanel.setLayout(jPanelLayout);
        jPanelLayout.setHorizontalGroup(
                jPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(jPanelLayout.createSequentialGroup()
                                .addGroup(jPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                        .addGroup(jPanelLayout.createSequentialGroup()
                                                .addGap(28, 28, 28)
                                                .addComponent(jLabelNome, javax.swing.GroupLayout.PREFERRED_SIZE, 337, javax.swing.GroupLayout.PREFERRED_SIZE))
                                        .addGroup(jPanelLayout.createSequentialGroup()
                                                .addGap(96, 96, 96)
                                                .addComponent(jLabelBemVindo)))
                                .addContainerGap(35, Short.MAX_VALUE))
        );
        jPanelLayout.setVerticalGroup(
                jPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(jPanelLayout.createSequentialGroup()
                                .addGap(67, 67, 67)
                                .addComponent(jLabelBemVindo)
                                .addGap(18, 18, 18)
                                .addComponent(jLabelNome, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addContainerGap(110, Short.MAX_VALUE))
        );

        jMenuTreino.setText("Treino");

        jMenuItemVerTreino.setText("Ver Treino");
        jMenuItemVerTreino.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItemVerTreinoActionPerformed(evt);
            }
        });
        jMenuTreino.add(jMenuItemVerTreino);

        jMenuBar.add(jMenuTreino);

        jMenuPerfil.setText("Perfil");

        jMenuItemVerPerfil.setText("Ver Perfil");
        jMenuItemVerPerfil.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItemVerPerfilActionPerformed(evt);
            }
        });
        jMenuPerfil.add(jMenuItemVerPerfil);

        jMenuItemSair.setText("Sair");
        jMenuItemSair.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItemSairActionPerformed(evt);
            }
        });
        jMenuPerfil.add(jMenuItemSair);

        jMenuBar.add(jMenuPerfil);

        setJMenuBar(jMenuBar);

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

    private void jMenuItemVerTreinoActionPerformed(java.awt.event.ActionEvent evt) {
        AlunoTreinoVerTreino alunoTreinoVerTreino = new AlunoTreinoVerTreino(aluno);
        alunoTreinoVerTreino.setVisible(true);
    }

    private void jMenuItemVerPerfilActionPerformed(java.awt.event.ActionEvent evt) {
        AlunoPerfil alunoPerfil = new AlunoPerfil(aluno);
        alunoPerfil.setVisible(true);
    }

    private void jMenuItemSairActionPerformed(java.awt.event.ActionEvent evt) {
        LoginFrame loginFrame = new LoginFrame();
        this.dispose();
        loginFrame.setVisible(true);
    }

    private javax.swing.JLabel jLabelBemVindo;
    private javax.swing.JLabel jLabelNome;
    private javax.swing.JMenuBar jMenuBar;
    private javax.swing.JMenuItem jMenuItemSair;
    private javax.swing.JMenuItem jMenuItemVerPerfil;
    private javax.swing.JMenuItem jMenuItemVerTreino;
    private javax.swing.JMenu jMenuPerfil;
    private javax.swing.JMenu jMenuTreino;
    private javax.swing.JPanel jPanel;
}
