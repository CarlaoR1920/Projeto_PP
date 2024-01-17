/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Frontend;

import Backend.CentroVacinacao;
import Backend.Gestor;
import Backend.Sistema;
import Backend.Utente;
import Serializacao.Serializacao;
import java.util.ArrayList;
import javax.swing.JOptionPane;

/**
 *
 * @author josep
 */
public class ConsultarProgresso extends javax.swing.JFrame {

    private Sistema sistema;
    private Serializacao serializacao;

    /**
     * Creates new form ConsultarProgresso
     */
    public ConsultarProgresso(Sistema sistema, Serializacao serializacao) {
        initComponents();

        //Não permite o redimensionamento da janela
        this.setResizable(false);

        //Mostra a centralização da janela
        this.setLocationRelativeTo(null);
        this.sistema = sistema;
        this.serializacao = serializacao;

        double percentagem;
        int soma = 0;
        CentroVacinacao centro = sistema.getListaCentros().procurarCentro((Gestor) sistema.getUtilizadorLigado());

        ArrayList<Utente> utentes = sistema.getListaUtentes().utentePorCentro(centro);
        for (Utente u : utentes) {
            if (u.getNumTomas() == u.getVacina().getTomas()) {
                soma = soma + 1;
            }
        }

        double tamanho = utentes.size();
        percentagem = (soma / tamanho) * 100;

        labelPercentagem.setText(String.valueOf(percentagem) + "%");

    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel2 = new javax.swing.JLabel();
        labelPercentagem = new javax.swing.JLabel();
        jButton1 = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.DO_NOTHING_ON_CLOSE);
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel2.setBackground(new java.awt.Color(255, 255, 255));
        jLabel2.setFont(new java.awt.Font("Verdana", 3, 12)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(0, 204, 255));
        jLabel2.setText("Percentagem de utentes vacinados");
        getContentPane().add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 40, 270, 40));

        labelPercentagem.setFont(new java.awt.Font("Verdana", 1, 30)); // NOI18N
        labelPercentagem.setForeground(new java.awt.Color(255, 255, 255));
        getContentPane().add(labelPercentagem, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 100, 140, 40));

        jButton1.setBackground(new java.awt.Color(255, 255, 255));
        jButton1.setFont(new java.awt.Font("Verdana", 3, 12)); // NOI18N
        jButton1.setForeground(new java.awt.Color(0, 204, 255));
        jButton1.setText("Voltar");
        jButton1.setBorderPainted(false);
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });
        getContentPane().add(jButton1, new org.netbeans.lib.awtextra.AbsoluteConstraints(400, 250, 80, 30));

        jLabel1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Images/login-image.jpg"))); // NOI18N
        jLabel1.setText("jLabel1");
        getContentPane().add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(-27, 0, 520, 293));

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        dispose();
        JanelaGestor jg = new JanelaGestor(sistema, serializacao);
        jg.setVisible(true);
    }//GEN-LAST:event_jButton1ActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButton1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel labelPercentagem;
    // End of variables declaration//GEN-END:variables
}
