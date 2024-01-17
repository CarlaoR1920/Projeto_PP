/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Frontend;

import Backend.Sistema;
import javax.swing.JOptionPane;
import Serializacao.Serializacao;
import Backend.Administrador;
import Backend.Gestor;
import Backend.Utente;

/**
 *
 * @author ZEZAO
 */
public class janelaLogin extends javax.swing.JFrame {

    private Sistema sistema;
    private Serializacao serializacao;

    /**
     * Creates new form JanelaLogin
     */
    public janelaLogin(Sistema sistema, Serializacao serializacao) {
        initComponents();
        // this.setModal(true);           

        //Não permite o redimensionamento da janela
        this.setResizable(false);

        //Mostra a centralização da janela
        this.setLocationRelativeTo(null);

        //O processo de fecho da janela será controlado pelo programa
        this.setDefaultCloseOperation(DO_NOTHING_ON_CLOSE);

        this.sistema = sistema;
        this.serializacao = serializacao;

        txtuser.requestFocus();
    }

    private void autenticar() {
        checkUsernamePassword("Utilizador");
        if (!sistema.autenticarUtilizador(txtuser.getText(), new String(txtpass.getPassword()))) {
            JOptionPane.showMessageDialog(this, "As credenciais introduzidas não correspondem a um utilizador válido.",
                    "Autenticação", JOptionPane.WARNING_MESSAGE);
            txtuser.requestFocus();
        } else {

            if (sistema.getUtilizadorLigado() instanceof Administrador) {
                dispose();
                JOptionPane.showMessageDialog(this, "Bem-vindo " + sistema.getUtilizadorLigado().getUsername() + "!");
                janelaAdmin hp = new janelaAdmin(sistema, serializacao);
                hp.setVisible(true);
            } else if (sistema.getUtilizadorLigado() instanceof Utente) {
                dispose();
                JOptionPane.showMessageDialog(this, "Bem-vindo " + sistema.getUtilizadorLigado().getUsername() + "!");
                JanelaUtente ju = new JanelaUtente(sistema, serializacao);
                ju.setVisible(true);
            } else if (sistema.getUtilizadorLigado() instanceof Gestor) {
                dispose();
                JOptionPane.showMessageDialog(this, "Bem-vindo " + sistema.getUtilizadorLigado().getUsername() + "!");
                JanelaGestor jg = new JanelaGestor(sistema, serializacao);
                jg.setVisible(true);
            }
        }
    }

    private void checkUsernamePassword(String mensagem) {
        if (txtuser.getText().isEmpty()) {
            JOptionPane.showMessageDialog(this, "Introduza um username!", mensagem + " EM FALTA", JOptionPane.WARNING_MESSAGE);
            txtuser.requestFocus();
        }
        if (txtpass.getPassword().length == 0) {
            JOptionPane.showMessageDialog(this, "Introduza a sua password!");
            txtpass.requestFocus();
        }
    }

    private void registar() {
        janelaRegistar rg = new janelaRegistar(serializacao, sistema);
        rg.setVisible(true);

    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jMenu1 = new javax.swing.JMenu();
        jLabel1 = new javax.swing.JLabel();
        txtuser = new javax.swing.JTextField();
        jLabel2 = new javax.swing.JLabel();
        txtpass = new javax.swing.JPasswordField();
        txtlogin = new javax.swing.JButton();
        txtclose = new javax.swing.JButton();
        btnRegistar = new javax.swing.JButton();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();

        jMenu1.setText("jMenu1");

        setDefaultCloseOperation(javax.swing.WindowConstants.DO_NOTHING_ON_CLOSE);
        setBackground(new java.awt.Color(51, 51, 255));
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel1.setFont(new java.awt.Font("Verdana", 1, 12)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(0, 204, 255));
        jLabel1.setText("USERNAME :");
        jLabel1.setToolTipText("");
        getContentPane().add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 180, 127, 39));
        getContentPane().add(txtuser, new org.netbeans.lib.awtextra.AbsoluteConstraints(100, 180, 160, 39));

        jLabel2.setFont(new java.awt.Font("Verdana", 1, 12)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(0, 204, 255));
        jLabel2.setText("PASSWORD :");
        getContentPane().add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 230, 110, 45));
        getContentPane().add(txtpass, new org.netbeans.lib.awtextra.AbsoluteConstraints(100, 230, 160, 37));

        txtlogin.setBackground(new java.awt.Color(255, 255, 255));
        txtlogin.setFont(new java.awt.Font("Verdana", 1, 10)); // NOI18N
        txtlogin.setForeground(new java.awt.Color(0, 204, 255));
        txtlogin.setText("LOGIN");
        txtlogin.setBorderPainted(false);
        txtlogin.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtloginActionPerformed(evt);
            }
        });
        getContentPane().add(txtlogin, new org.netbeans.lib.awtextra.AbsoluteConstraints(210, 320, 96, 30));

        txtclose.setBackground(new java.awt.Color(255, 255, 255));
        txtclose.setFont(new java.awt.Font("Verdana", 1, 10)); // NOI18N
        txtclose.setForeground(new java.awt.Color(0, 204, 255));
        txtclose.setText("CLOSE");
        txtclose.setBorderPainted(false);
        txtclose.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtcloseActionPerformed(evt);
            }
        });
        getContentPane().add(txtclose, new org.netbeans.lib.awtextra.AbsoluteConstraints(410, 320, 93, 30));

        btnRegistar.setBackground(new java.awt.Color(255, 255, 255));
        btnRegistar.setFont(new java.awt.Font("Verdana", 1, 10)); // NOI18N
        btnRegistar.setForeground(new java.awt.Color(0, 204, 255));
        btnRegistar.setText("REGISTAR");
        btnRegistar.setBorderPainted(false);
        btnRegistar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnRegistarActionPerformed(evt);
            }
        });
        getContentPane().add(btnRegistar, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 320, 95, 30));

        jLabel3.setFont(new java.awt.Font("Verdana", 3, 14)); // NOI18N
        jLabel3.setForeground(new java.awt.Color(0, 204, 255));
        jLabel3.setText("LOGIN");
        getContentPane().add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 10, 140, 20));

        jLabel4.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Images/login-image.jpg"))); // NOI18N
        jLabel4.setText("jLabel4");
        getContentPane().add(jLabel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(1, 3, 520, 360));

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void txtloginActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtloginActionPerformed
        autenticar();
    }//GEN-LAST:event_txtloginActionPerformed

    private void txtcloseActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtcloseActionPerformed

        if (JOptionPane.showConfirmDialog(null,
                "Deseja realmente terminar o programa?",
                "Terminar",
                JOptionPane.YES_NO_OPTION) == JOptionPane.YES_OPTION) {
            serializacao.guardar(sistema);
            System.exit(0);
        }
    }//GEN-LAST:event_txtcloseActionPerformed

    private void btnRegistarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnRegistarActionPerformed
        registar();
        this.dispose();
    }//GEN-LAST:event_btnRegistarActionPerformed

    /**
     * @param args the command line arguments
     */

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnRegistar;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JMenu jMenu1;
    private javax.swing.JButton txtclose;
    private javax.swing.JButton txtlogin;
    private javax.swing.JPasswordField txtpass;
    private javax.swing.JTextField txtuser;
    // End of variables declaration//GEN-END:variables

}
