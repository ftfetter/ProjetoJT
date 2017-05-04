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
        jMenuItemAdicionar = new JMenuItem();
        jMenuItemPesquisar = new JMenuItem();
        jMenuOpcoes = new JMenu();
        jMenuSair = new JMenu();

        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setTitle("TrainingCheck");

        jLabelBemVindo.setFont(new Font("Trebuchet MS", 1, 36)); // NOI18N
        jLabelBemVindo.setText("Bem Vindo");
        jLabelBemVindo.setHorizontalTextPosition(SwingConstants.CENTER);

        jLabelNome.setFont(new Font("Trebuchet MS", 0, 18)); // NOI18N
        jLabelNome.setText(treinador.getNome());
        jLabelNome.setName("jLabelNomeTreinador"); // NOI18N

        jMenuAluno.setText("Aluno");

        jMenuItemAdicionar.setText("Adicionar");
        jMenuItemAdicionar.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent evt) {
                jMenuItemAdicionarActionPerformed(evt);
            }
        });
        jMenuAluno.add(jMenuItemAdicionar);

        jMenuItemPesquisar.setText("Pesquisar");
        jMenuItemPesquisar.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent evt) {
                jMenuItemPesquisarActionPerformed(evt);
            }
        });
        jMenuAluno.add(jMenuItemPesquisar);

        jMenuBar.add(jMenuAluno);

        jMenuOpcoes.setText("Opções");
        jMenuBar.add(jMenuOpcoes);

        jMenuSair.setText("Sair");
        jMenuSair.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent evt) { jMenuSairActionPerformed(evt); }
        });
        jMenuBar.add(jMenuSair);

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

    private void jMenuSairActionPerformed(ActionEvent evt) {
        LoginFrame loginFrame = new LoginFrame();
        loginFrame.setVisible(true);
    }

    private JPanel jPanelTreinador;
    private JLabel jLabelNome;
    private JLabel jLabelBemVindo;
    private JMenu jMenuAluno;
    private JMenu jMenuSair;
    private JMenu jMenuOpcoes;
    private JMenuBar jMenuBar;
    private JMenuItem jMenuItemAdicionar;
    private JMenuItem jMenuItemPesquisar;
}