/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Frontend;

import Backend.CentroVacinacao;
import Serializacao.Serializacao;
import Backend.Sistema;
import Backend.CentroVacinacao;
import Backend.repositorioCentroVacinacao;
import javax.swing.JOptionPane;

/**
 *
 * @author josep
 */
public class CentroGestor extends javax.swing.JFrame {

    private Sistema sistema;
    private CentroVacinacao centro;
    private Serializacao serializacao;

    public CentroGestor(Sistema sistema, Serializacao serializacao, CentroVacinacao centro) {
        initComponents();
        this.setResizable(false);
        this.setLocationRelativeTo(null);
        this.sistema = sistema;
        this.serializacao = serializacao;
        this.centro = centro;

        txtCod.setText(centro.getCodigo());
        txtLocalidade.setText(centro.getLocalidade());
        txtMorada.setText(centro.getMorada());
        txtCod.setEditable(false);
        txtLocalidade.setEditable(false);
        txtMorada.setEditable(false);
        String postos = String.valueOf(centro.getNumPostos());
        txtPostos.setText(postos);
        String vacinas = String.valueOf(centro.getNumMaxVacDia());
        txtVacinas.setText(vacinas);
        txtVacinas.setEditable(false);
    }

    public void atualizarPostos() {
        int postos = Integer.parseInt(txtPostos.getText());
        centro.setNumPostos(postos);
        JOptionPane.showMessageDialog(this, "Número de postos atualizado com sucesso!!");
    }


    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel4 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        jPanel1 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        txtCod = new javax.swing.JTextField();
        jLabel3 = new javax.swing.JLabel();
        txtLocalidade = new javax.swing.JTextField();
        jLabel5 = new javax.swing.JLabel();
        txtMorada = new javax.swing.JTextField();
        jButton1 = new javax.swing.JButton();
        jLabel6 = new javax.swing.JLabel();
        txtPostos = new javax.swing.JTextField();
        jLabel8 = new javax.swing.JLabel();
        txtVacinas = new javax.swing.JTextField();
        jButton2 = new javax.swing.JButton();
        jLabel9 = new javax.swing.JLabel();

        jLabel7.setText("jLabel7");

        setDefaultCloseOperation(javax.swing.WindowConstants.DO_NOTHING_ON_CLOSE);
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jPanel1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel1.setFont(new java.awt.Font("Verdana", 3, 14)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(0, 204, 255));
        jLabel1.setText("CENTRO DE VACINAÇÃO");
        jPanel1.add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 191, 32));

        jLabel2.setFont(new java.awt.Font("Verdana", 0, 12)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(0, 204, 255));
        jLabel2.setText("Código:");
        jPanel1.add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 40, 87, 26));
        jPanel1.add(txtCod, new org.netbeans.lib.awtextra.AbsoluteConstraints(115, 38, 113, 33));

        jLabel3.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        jLabel3.setForeground(new java.awt.Color(0, 204, 255));
        jLabel3.setText("Localidade:");
        jPanel1.add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 82, 87, 31));
        jPanel1.add(txtLocalidade, new org.netbeans.lib.awtextra.AbsoluteConstraints(115, 83, 113, 31));

        jLabel5.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        jLabel5.setForeground(new java.awt.Color(0, 204, 255));
        jLabel5.setText("Morada:");
        jPanel1.add(jLabel5, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 125, 87, 30));

        txtMorada.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtMoradaActionPerformed(evt);
            }
        });
        jPanel1.add(txtMorada, new org.netbeans.lib.awtextra.AbsoluteConstraints(115, 125, 113, 36));

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
        jPanel1.add(jButton1, new org.netbeans.lib.awtextra.AbsoluteConstraints(320, 270, 90, 37));

        jLabel6.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        jLabel6.setForeground(new java.awt.Color(0, 204, 255));
        jLabel6.setText("Nº de Postos:");
        jPanel1.add(jLabel6, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 172, -1, 40));
        jPanel1.add(txtPostos, new org.netbeans.lib.awtextra.AbsoluteConstraints(115, 174, 113, 36));

        jLabel8.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        jLabel8.setForeground(new java.awt.Color(0, 204, 255));
        jLabel8.setText("Nº de Vacinas:");
        jPanel1.add(jLabel8, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 224, 87, 29));
        jPanel1.add(txtVacinas, new org.netbeans.lib.awtextra.AbsoluteConstraints(115, 223, 113, 33));

        jButton2.setBackground(new java.awt.Color(255, 255, 255));
        jButton2.setFont(new java.awt.Font("Tahoma", 3, 12)); // NOI18N
        jButton2.setForeground(new java.awt.Color(0, 204, 255));
        jButton2.setText("Atualizar nº de postos");
        jButton2.setBorderPainted(false);
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });
        jPanel1.add(jButton2, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 270, -1, 37));

        jLabel9.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Images/login-image.jpg"))); // NOI18N
        jLabel9.setText("jLabel9");
        jPanel1.add(jLabel9, new org.netbeans.lib.awtextra.AbsoluteConstraints(-7, 0, 440, 320));

        getContentPane().add(jPanel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 420, 322));

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        dispose();
        JanelaGestor jg = new JanelaGestor(sistema, serializacao);
        jg.setVisible(true);
    }//GEN-LAST:event_jButton1ActionPerformed

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
        atualizarPostos();
    }//GEN-LAST:event_jButton2ActionPerformed

    private void txtMoradaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtMoradaActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtMoradaActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JTextField txtCod;
    private javax.swing.JTextField txtLocalidade;
    private javax.swing.JTextField txtMorada;
    private javax.swing.JTextField txtPostos;
    private javax.swing.JTextField txtVacinas;
    // End of variables declaration//GEN-END:variables
}
