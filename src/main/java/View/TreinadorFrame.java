package View;

import Beans.Treinador;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class TreinadorFrame extends JFrame{

    private Treinador treinador;

    public TreinadorFrame(Treinador treinador) {
        this.treinador = treinador;
        initComponents();
    }

    private void initComponents() {

        jPanelTreinador = new JPanel();
        jLabelBemVindo = new JLabel();
        jLabelNome = new JLabel();
        jMenuBar = new JMenuBar();
        jMenuAluno = new JMenu();
        jMenuItemAdicionarAluno = new JMenuItem();
        jMenuItemPesquisar = new JMenuItem();
        jMenuExercicios = new JMenu();
        jMenuItemAdicionarExerc = new JMenuItem();
        jMenuItemVerExercicios = new JMenuItem();
        jMenuPerfil = new JMenu();
        jMenuItemVerPerfil = new javax.swing.JMenuItem();
        jMenuItemSair = new javax.swing.JMenuItem();

        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setTitle("TrainingCheck");

        jLabelBemVindo.setFont(new Font("Trebuchet MS", 1, 36));
        jLabelBemVindo.setText("Bem Vindo");
        jLabelBemVindo.setHorizontalTextPosition(SwingConstants.CENTER);

        jLabelNome.setFont(new Font("Trebuchet MS", 0, 18));
        jLabelNome.setText(treinador.getNome());
        jLabelNome.setName("jLabelNomeTreinador");

        jMenuAluno.setText("Aluno");

        jMenuItemAdicionarAluno.setText("Adicionar");
        jMenuItemAdicionarAluno.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent evt) {
                jMenuItemAdicionarActionPerformed(evt);
            }
        });
        jMenuAluno.add(jMenuItemAdicionarAluno);

        jMenuItemPesquisar.setText("Pesquisar");
        jMenuItemPesquisar.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent evt) {
                jMenuItemPesquisarActionPerformed(evt);
            }
        });
        jMenuAluno.add(jMenuItemPesquisar);

        jMenuBar.add(jMenuAluno);

        jMenuExercicios.setText("Exercícios");

        jMenuItemVerExercicios.setText("Ver Exercícios");
        jMenuItemVerExercicios.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent evt) { jMenuItemVerExerciciosActionPerformed(evt); }
        });
        jMenuExercicios.add(jMenuItemVerExercicios);

        jMenuBar.add(jMenuExercicios);

        jMenuPerfil.setText("Perfil");

        jMenuItemSair.setText("Sair");
        jMenuItemSair.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItemSairActionPerformed(evt);
            }
        });
        jMenuPerfil.add(jMenuItemSair);

        jMenuBar.add(jMenuPerfil);

        setJMenuBar(jMenuBar);

        GroupLayout treinadorLayout = new GroupLayout(jPanelTreinador);
        jPanelTreinador.setLayout(treinadorLayout);
        treinadorLayout.setHorizontalGroup(
                treinadorLayout.createParallelGroup(GroupLayout.Alignment.LEADING)
                        .addGroup(treinadorLayout.createSequentialGroup()
                                .addGroup(treinadorLayout.createParallelGroup(GroupLayout.Alignment.LEADING)
                                        .addGroup(treinadorLayout.createSequentialGroup()
                                                .addGap(107, 107, 107)
                                                .addComponent(jLabelBemVindo))
                                        .addGroup(treinadorLayout.createSequentialGroup()
                                                .addGap(174, 174, 174)
                                                .addComponent(jLabelNome)))
                                .addContainerGap(114, Short.MAX_VALUE))
        );
        treinadorLayout.setVerticalGroup(
                treinadorLayout.createParallelGroup(GroupLayout.Alignment.LEADING)
                        .addGroup(treinadorLayout.createSequentialGroup()
                                .addGap(85, 85, 85)
                                .addComponent(jLabelBemVindo, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addGap(34, 34, 34)
                                .addComponent(jLabelNome)
                                .addGap(116, 116, 116))
        );

        GroupLayout layout = new GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
                layout.createParallelGroup(GroupLayout.Alignment.LEADING)
                        .addComponent(jPanelTreinador, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
                layout.createParallelGroup(GroupLayout.Alignment.LEADING)
                        .addComponent(jPanelTreinador, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        pack();
    }

    private void jMenuItemAdicionarActionPerformed(ActionEvent evt) {
        TreinadorAlunoAdicionar treinadorAlunoAdicionar = new TreinadorAlunoAdicionar(treinador);
        treinadorAlunoAdicionar.setVisible(true);
    }

    private void jMenuItemPesquisarActionPerformed(ActionEvent evt) {
        TreinadorAlunoPesquisar treinadorAlunoPesquisar = new TreinadorAlunoPesquisar(treinador);
        treinadorAlunoPesquisar.setVisible(true);
    }

    private void jMenuItemVerExerciciosActionPerformed(ActionEvent evt) {
        TreinadorExercicio treinadorExercicio = new TreinadorExercicio();
        treinadorExercicio.setVisible(true);
    }

    private void jMenuItemSairActionPerformed(java.awt.event.ActionEvent evt) {
        LoginFrame loginFrame = new LoginFrame();
        this.dispose();
        loginFrame.setVisible(true);
    }

    private JPanel jPanelTreinador;
    private JLabel jLabelNome;
    private JLabel jLabelBemVindo;
    private JMenu jMenuAluno;
    private JMenu jMenuPerfil;
    private JMenu jMenuExercicios;
    private JMenuBar jMenuBar;
    private JMenuItem jMenuItemAdicionarAluno;
    private JMenuItem jMenuItemPesquisar;
    private JMenuItem jMenuItemAdicionarExerc;
    private JMenuItem jMenuItemVerExercicios;
    private javax.swing.JMenuItem jMenuItemSair;
    private javax.swing.JMenuItem jMenuItemVerPerfil;
}
