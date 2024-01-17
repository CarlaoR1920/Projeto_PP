/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Frontend;

import Backend.CentroVacinacao;
import Serializacao.Serializacao;
import Backend.Sistema;
import javax.swing.JOptionPane;
import Backend.repositorioCentroVacinacao;
import Backend.Gestor;

/**
 *
 * @author josep
 */
public class JanelaGestor extends javax.swing.JFrame {

    private Sistema sistema;
    private Serializacao serializacao;

    public JanelaGestor(Sistema sistema, Serializacao serializacao) {
        initComponents();
        this.setResizable(false);
        this.setLocationRelativeTo(null);
        this.sistema = sistema;
        this.serializacao = serializacao;

    }

    public void centro() {
        if (sistema.getListaCentros() == null) {
            JOptionPane.showMessageDialog(this, "Não existem centro no sistema!");
            return;
        }
        Gestor gestor = (Gestor) sistema.getUtilizadorLigado();
        CentroVacinacao centro = sistema.getListaCentros().procurarCentro(gestor);

        if (centro == null) {
            JOptionPane.showMessageDialog(this, "Não existe um centro associado.");

        } else {
            CentroGestor cg = new CentroGestor(sistema, serializacao, centro);
            cg.setVisible(true);
            this.dispose();
        }
    }

    public void consultarMarcacoesGestor() {
        CentroVacinacao centro = sistema.getListaCentros().procurarCentro((Gestor) sistema.getUtilizadorLigado());
        if (centro.getMarcacoes() == null) {
            JOptionPane.showMessageDialog(this, "Ainda não existe marcações neste centro!");
            return;
        }
        if (centro.getMarcacoes().todosKeys().isEmpty()) {
            JOptionPane.showMessageDialog(this, "Ainda não existe marcações neste centro!");
            return;
        }
        ConsultarMarcacoesGestor cmg = new ConsultarMarcacoesGestor(sistema, serializacao);
        cmg.setVisible(true);
        this.dispose();
    }

    public void monitorizarStockVacinas() {
        CentroVacinacao centro = sistema.getListaCentros().procurarCentro((Gestor) sistema.getUtilizadorLigado());
        if (centro.getStock() == null) {
            JOptionPane.showMessageDialog(this, "O centro não tem stock!");
            return;
        }

        MonitorizarStockVacinas msv = new MonitorizarStockVacinas(sistema, serializacao);
        msv.setVisible(true);
        this.dispose();
    }

    public void consultarUtentes() {
        CentroVacinacao centro = sistema.getListaCentros().procurarCentro((Gestor) sistema.getUtilizadorLigado());
        if (sistema.getListaUtentes().utentePorCentro(centro) == null) {
            JOptionPane.showMessageDialog(this, "O centro ainda não tem utentes agendados!");
            return;
        }
        if (sistema.getListaUtentes().utentePorCentro(centro).isEmpty()) {
            JOptionPane.showMessageDialog(this, "O centro ainda não tem utentes agendados!");
            return;
        }
        ListaUtentesPorCentro lpc = new ListaUtentesPorCentro(sistema, serializacao);
        lpc.setVisible(true);
        this.dispose();

    }

    public void consultarMarcacoesParaAmanha() {
        CentroVacinacao centro = sistema.getListaCentros().procurarCentro((Gestor) sistema.getUtilizadorLigado());
        if (centro.getMarcacoes() == null) {
            JOptionPane.showMessageDialog(this, "O centro não contêm marcações!");
            return;
        }
        if (centro.getMarcacoes().todosKeysTomorrow().isEmpty()) {

            JOptionPane.showMessageDialog(this, "O centro não contêm marcações para amanhã!");
            return;
        }
        ConsultarMarcacoesParaAmanha cma = new ConsultarMarcacoesParaAmanha(sistema, serializacao);
        cma.setVisible(true);
        this.dispose();

    }

    public void consultarUtentesEmFalta() {
        CentroVacinacao centro = sistema.getListaCentros().procurarCentro((Gestor) sistema.getUtilizadorLigado());

        if (centro.getMarcacoes() == null) {
            JOptionPane.showMessageDialog(this, "Ainda não existem consultas!");
            return;
        }

        if (centro.getMarcacoes().todosValuesFaltaram().isEmpty()) {
            JOptionPane.showMessageDialog(this, "Ninguém faltou a nenhuma consulta!");
            return;
        }

        ConsultarUtentesEmFalta cuf = new ConsultarUtentesEmFalta(sistema, serializacao);
        cuf.setVisible(true);
        this.dispose();
    }

    public void consultarProgresso() {
        ConsultarProgresso cp = new ConsultarProgresso(sistema, serializacao);
        cp.setVisible(true);
        this.dispose();
    }

    public void consultarEfeitosNoCentro() {
        CentroVacinacao centro = sistema.getListaCentros().procurarCentro((Gestor) sistema.getUtilizadorLigado());
        if (centro.getListaEfeitos() == null) {
            JOptionPane.showMessageDialog(this, "Ainda não existem efeitos secundários!");
            return;

        }
        if (centro.getListaEfeitos().getEfeitos().isEmpty()) {
            JOptionPane.showMessageDialog(this, "Ainda não existem efeitos secundários!");
            return;
        }
        ConsultarEfeitosCentro cec = new ConsultarEfeitosCentro(sistema, serializacao);
        cec.setVisible(true);
        this.dispose();
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jButton1 = new javax.swing.JButton();
        jButton2 = new javax.swing.JButton();
        jButton3 = new javax.swing.JButton();
        jButton4 = new javax.swing.JButton();
        jButton5 = new javax.swing.JButton();
        jButton6 = new javax.swing.JButton();
        jButton7 = new javax.swing.JButton();
        jButton8 = new javax.swing.JButton();
        jButton9 = new javax.swing.JButton();
        jLabel2 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.DO_NOTHING_ON_CLOSE);
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jPanel1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel1.setFont(new java.awt.Font("Tahoma", 3, 14)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(0, 204, 255));
        jLabel1.setText("Gestor");
        jPanel1.add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 64, 29));

        jButton1.setBackground(new java.awt.Color(255, 255, 255));
        jButton1.setFont(new java.awt.Font("Verdana", 3, 12)); // NOI18N
        jButton1.setForeground(new java.awt.Color(0, 204, 255));
        jButton1.setText("CENTRO DE VACINACAO");
        jButton1.setBorderPainted(false);
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });
        jPanel1.add(jButton1, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 30, 210, 39));

        jButton2.setBackground(new java.awt.Color(255, 255, 255));
        jButton2.setFont(new java.awt.Font("Verdana", 3, 12)); // NOI18N
        jButton2.setForeground(new java.awt.Color(0, 204, 255));
        jButton2.setText("CONSULTAR MARCACÕES");
        jButton2.setBorderPainted(false);
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });
        jPanel1.add(jButton2, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 80, 210, 37));

        jButton3.setBackground(new java.awt.Color(255, 255, 255));
        jButton3.setFont(new java.awt.Font("Verdana", 3, 12)); // NOI18N
        jButton3.setForeground(new java.awt.Color(0, 204, 255));
        jButton3.setText("MONITORIZAR STOCK ");
        jButton3.setBorderPainted(false);
        jButton3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton3ActionPerformed(evt);
            }
        });
        jPanel1.add(jButton3, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 130, 210, 41));

        jButton4.setBackground(new java.awt.Color(255, 255, 255));
        jButton4.setFont(new java.awt.Font("Verdana", 3, 12)); // NOI18N
        jButton4.setForeground(new java.awt.Color(0, 204, 255));
        jButton4.setText("CONSULTAR UTENTES");
        jButton4.setBorderPainted(false);
        jButton4.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton4ActionPerformed(evt);
            }
        });
        jPanel1.add(jButton4, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 180, 210, 38));

        jButton5.setBackground(new java.awt.Color(255, 255, 255));
        jButton5.setFont(new java.awt.Font("Tahoma", 3, 12)); // NOI18N
        jButton5.setForeground(new java.awt.Color(0, 204, 255));
        jButton5.setText("CONSULTAS PARA AMANHÃ");
        jButton5.setBorderPainted(false);
        jButton5.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton5ActionPerformed(evt);
            }
        });
        jPanel1.add(jButton5, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 230, 210, 39));

        jButton6.setBackground(new java.awt.Color(255, 255, 255));
        jButton6.setFont(new java.awt.Font("Tahoma", 3, 12)); // NOI18N
        jButton6.setForeground(new java.awt.Color(0, 204, 255));
        jButton6.setText("CONSULTAR AUSÊNCIAS");
        jButton6.setBorderPainted(false);
        jButton6.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton6ActionPerformed(evt);
            }
        });
        jPanel1.add(jButton6, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 280, 210, 39));

        jButton7.setBackground(new java.awt.Color(255, 255, 255));
        jButton7.setFont(new java.awt.Font("Verdana", 3, 12)); // NOI18N
        jButton7.setForeground(new java.awt.Color(0, 204, 255));
        jButton7.setText("CONSULTAR PROGRESSO ");
        jButton7.setBorderPainted(false);
        jButton7.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton7ActionPerformed(evt);
            }
        });
        jPanel1.add(jButton7, new org.netbeans.lib.awtextra.AbsoluteConstraints(260, 30, 210, 40));

        jButton8.setBackground(new java.awt.Color(255, 255, 255));
        jButton8.setFont(new java.awt.Font("Verdana", 3, 12)); // NOI18N
        jButton8.setForeground(new java.awt.Color(0, 204, 255));
        jButton8.setText("Sair");
        jButton8.setBorderPainted(false);
        jButton8.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton8ActionPerformed(evt);
            }
        });
        jPanel1.add(jButton8, new org.netbeans.lib.awtextra.AbsoluteConstraints(390, 320, 80, 30));

        jButton9.setBackground(new java.awt.Color(255, 255, 255));
        jButton9.setFont(new java.awt.Font("Verdana", 3, 12)); // NOI18N
        jButton9.setForeground(new java.awt.Color(0, 204, 255));
        jButton9.setText("CONSULTAR EFEITOS ");
        jButton9.setBorderPainted(false);
        jButton9.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton9ActionPerformed(evt);
            }
        });
        jPanel1.add(jButton9, new org.netbeans.lib.awtextra.AbsoluteConstraints(260, 80, 210, 40));

        jLabel2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Images/login-image.jpg"))); // NOI18N
        jLabel2.setText("jLabel2");
        jPanel1.add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, -10, 480, 380));

        getContentPane().add(jPanel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 480, 360));

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        centro();

    }//GEN-LAST:event_jButton1ActionPerformed

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
        consultarMarcacoesGestor();
    }//GEN-LAST:event_jButton2ActionPerformed

    private void jButton3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton3ActionPerformed
        monitorizarStockVacinas();
    }//GEN-LAST:event_jButton3ActionPerformed

    private void jButton4ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton4ActionPerformed
        consultarUtentes();
    }//GEN-LAST:event_jButton4ActionPerformed

    private void jButton5ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton5ActionPerformed
        consultarMarcacoesParaAmanha();
    }//GEN-LAST:event_jButton5ActionPerformed

    private void jButton6ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton6ActionPerformed
        consultarUtentesEmFalta();
    }//GEN-LAST:event_jButton6ActionPerformed

    private void jButton7ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton7ActionPerformed
        consultarProgresso();
    }//GEN-LAST:event_jButton7ActionPerformed

    private void jButton8ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton8ActionPerformed
        dispose();
        janelaLogin jl = new janelaLogin(sistema, serializacao);
        jl.setVisible(true);

    }//GEN-LAST:event_jButton8ActionPerformed

    private void jButton9ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton9ActionPerformed
        consultarEfeitosNoCentro();
    }//GEN-LAST:event_jButton9ActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JButton jButton3;
    private javax.swing.JButton jButton4;
    private javax.swing.JButton jButton5;
    private javax.swing.JButton jButton6;
    private javax.swing.JButton jButton7;
    private javax.swing.JButton jButton8;
    private javax.swing.JButton jButton9;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JPanel jPanel1;
    // End of variables declaration//GEN-END:variables

}
