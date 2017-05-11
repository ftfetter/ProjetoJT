package View;

import Beans.Aluno;
import Beans.Treinador;
import Database.TreinadorDAO;
import Database.TreinoDAO;

import javax.swing.*;

public class AlunoPerfil extends JFrame{

    private Aluno aluno;

    public AlunoPerfil(Aluno aluno) {
        this.aluno = aluno;
        initComponents();
        adicionarTreinador();
    }

    private void initComponents() {

        jPanel = new javax.swing.JPanel();
        jLabelNome = new javax.swing.JLabel();
        jLabelPeso = new javax.swing.JLabel();
        jLabelAltura = new javax.swing.JLabel();
        jLabelGordura = new javax.swing.JLabel();
        jButtonFechar = new javax.swing.JButton();
        jLabelPesoValor = new javax.swing.JLabel();
        jLabelAlturaValor = new javax.swing.JLabel();
        jLabelGorduraValor = new javax.swing.JLabel();
        jLabelTreinador = new javax.swing.JLabel();
        jLabelTreinadorValor = new javax.swing.JLabel();

        setDefaultCloseOperation(WindowConstants.DISPOSE_ON_CLOSE);

        jLabelNome.setFont(new java.awt.Font("Tahoma", 1, 24)); // NOI18N
        jLabelNome.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabelNome.setText(aluno.getNome());
        jLabelNome.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);

        jLabelPeso.setText("Peso (kg)");

        jLabelAltura.setText("Altura (m)");

        jLabelGordura.setText("Gordura (%)");

        jButtonFechar.setText("Fechar");
        jButtonFechar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonFecharActionPerformed(evt);
            }
        });

        jLabelPesoValor.setText(String.valueOf(aluno.getPeso()));

        jLabelAlturaValor.setText(String.valueOf(aluno.getAltura()));

        jLabelGorduraValor.setText(String.valueOf(aluno.getGordura()));

        jLabelTreinador.setText("Treinador");

        jLabelTreinadorValor.setText("");

        javax.swing.GroupLayout jPanelLayout = new javax.swing.GroupLayout(jPanel);
        jPanel.setLayout(jPanelLayout);
        jPanelLayout.setHorizontalGroup(
                jPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(jPanelLayout.createSequentialGroup()
                                .addGap(39, 39, 39)
                                .addComponent(jLabelNome, javax.swing.GroupLayout.PREFERRED_SIZE, 315, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addContainerGap(46, Short.MAX_VALUE))
                        .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanelLayout.createSequentialGroup()
                                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addGroup(jPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                        .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanelLayout.createSequentialGroup()
                                                .addComponent(jButtonFechar)
                                                .addGap(166, 166, 166))
                                        .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanelLayout.createSequentialGroup()
                                                .addGroup(jPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                                        .addComponent(jLabelGordura)
                                                        .addComponent(jLabelAltura)
                                                        .addComponent(jLabelPeso)
                                                        .addComponent(jLabelTreinador))
                                                .addGap(43, 43, 43)
                                                .addGroup(jPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                                        .addGroup(jPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                                                .addComponent(jLabelPesoValor, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                                                .addComponent(jLabelAlturaValor, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                                                .addComponent(jLabelGorduraValor, javax.swing.GroupLayout.DEFAULT_SIZE, 73, Short.MAX_VALUE))
                                                        .addComponent(jLabelTreinadorValor, javax.swing.GroupLayout.PREFERRED_SIZE, 174, javax.swing.GroupLayout.PREFERRED_SIZE))
                                                .addGap(19, 19, 19))))
        );
        jPanelLayout.setVerticalGroup(
                jPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(jPanelLayout.createSequentialGroup()
                                .addGap(22, 22, 22)
                                .addComponent(jLabelNome, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(28, 28, 28)
                                .addGroup(jPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                        .addComponent(jLabelTreinador)
                                        .addComponent(jLabelTreinadorValor))
                                .addGap(18, 18, 18)
                                .addGroup(jPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                        .addComponent(jLabelPeso)
                                        .addComponent(jLabelPesoValor))
                                .addGap(18, 18, 18)
                                .addGroup(jPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                        .addComponent(jLabelAltura)
                                        .addComponent(jLabelAlturaValor))
                                .addGap(18, 18, 18)
                                .addGroup(jPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                        .addComponent(jLabelGordura)
                                        .addComponent(jLabelGorduraValor))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 55, Short.MAX_VALUE)
                                .addComponent(jButtonFechar)
                                .addGap(27, 27, 27))
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

    private void jButtonFecharActionPerformed(java.awt.event.ActionEvent evt) { this.dispose(); }

    private void adicionarTreinador () {
        TreinadorDAO treinadorDAO = new TreinadorDAO();
        Treinador treinador = treinadorDAO.buscaTreinador(aluno.getTreinadorId());

        jLabelTreinadorValor.setText(treinador.getNome());
    }

    private javax.swing.JButton jButtonFechar;
    private javax.swing.JLabel jLabelAltura;
    private javax.swing.JLabel jLabelAlturaValor;
    private javax.swing.JLabel jLabelGordura;
    private javax.swing.JLabel jLabelGorduraValor;
    private javax.swing.JLabel jLabelNome;
    private javax.swing.JLabel jLabelPeso;
    private javax.swing.JLabel jLabelPesoValor;
    private javax.swing.JLabel jLabelTreinador;
    private javax.swing.JLabel jLabelTreinadorValor;
    private javax.swing.JPanel jPanel;
}
