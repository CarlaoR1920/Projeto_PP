/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Frontend;

import Backend.ListaEfeitos;
import Backend.RepositorioDoencas;
import Serializacao.Serializacao;
import Backend.Sistema;
import Backend.Utente;
import Backend.Vacina;
import javax.swing.JOptionPane;

/**
 *
 * @author josep
 */
public class AdicionarDoencasVac extends javax.swing.JFrame {

    private Serializacao serializacao;
    private Sistema sistema;
    private Vacina vacina;

    /**
     * Creates new form AdicionarDoencasVac
     */
    public AdicionarDoencasVac(Sistema sistema, Serializacao serializacao, Vacina vacina) {
        initComponents();
        this.setResizable(false);
        this.setLocationRelativeTo(null);
        this.sistema = sistema;
        this.serializacao = serializacao;
        this.vacina = vacina;

    }

    public void addDoenca() {
        if (txtDoencas.getText().isEmpty()) {
            JOptionPane.showMessageDialog(this, "Introduza uma Doenca!");
            txtDoencas.requestFocus();
            return;
        }

        RepositorioDoencas doencas = vacina.getDoençasRestritas();
        System.out.print(doencas);
        if (doencas == null) {
            RepositorioDoencas doencasTemp = new RepositorioDoencas();

            doencasTemp.adicionarDoencas(txtDoencas.getText());
            vacina.setDoencasRestritas(doencasTemp);

        } else {
            if (doencas.existeDoenca(txtDoencas.getText())) {
                JOptionPane.showMessageDialog(this, "Já existe esta doença associada a esta vacina");
                return;
            }
            doencas.adicionarDoencas(txtDoencas.getText());
            vacina.setDoencasRestritas(doencas);

        }
        JOptionPane.showMessageDialog(this, "Doenca adicionada com sucesso");
        txtDoencas.setText("");

    }

    public void addEfeitos() {
        if (txtEfeitos.getText().isEmpty()) {
            JOptionPane.showMessageDialog(this, "Introduza um efeito!");
            txtEfeitos.requestFocus();
            return;
        }

        ListaEfeitos efeitos = vacina.getEfeitosSecundarios();
        if (efeitos == null) {
            ListaEfeitos listaEfeitosTemp = new ListaEfeitos();

            listaEfeitosTemp.adicionarEfeito(txtEfeitos.getText());
            vacina.setEfeitosSecundarios(listaEfeitosTemp);

        } else {
            if (efeitos.existeEfeito(txtEfeitos.getText())) {
                JOptionPane.showMessageDialog(this, "Já existe este efeito associada a esta vacina");
                return;
            }
            efeitos.adicionarEfeito(txtEfeitos.getText());
            vacina.setEfeitosSecundarios(efeitos);

        }
        JOptionPane.showMessageDialog(this, "Efeito adicionado com sucesso");
        txtEfeitos.setText("");

    }

    public void guardar() {
        sistema.getListaVacinas().adicionarVacinas(vacina);
        JOptionPane.showMessageDialog(this, "Vacina adicionada com sucesso.");
        this.dispose();
        listarCentros lc = new listarCentros(sistema, serializacao);
        lc.setVisible(true);
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        txtDoencas = new javax.swing.JTextField();
        jButton1 = new javax.swing.JButton();
        jLabel4 = new javax.swing.JLabel();
        txtEfeitos = new javax.swing.JTextField();
        jButton2 = new javax.swing.JButton();
        jButton3 = new javax.swing.JButton();
        jButton4 = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.DO_NOTHING_ON_CLOSE);
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel2.setFont(new java.awt.Font("Verdana", 3, 14)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(0, 204, 255));
        jLabel2.setText("Adicionar doenças restritas e efeitos secundários da Vacina");
        getContentPane().add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 10, 500, 30));

        jLabel3.setFont(new java.awt.Font("Verdana", 3, 12)); // NOI18N
        jLabel3.setForeground(new java.awt.Color(0, 204, 255));
        jLabel3.setText("Insira doenças restritas da vacina");
        getContentPane().add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 50, 230, 30));
        getContentPane().add(txtDoencas, new org.netbeans.lib.awtextra.AbsoluteConstraints(240, 50, 170, 30));

        jButton1.setBackground(new java.awt.Color(255, 255, 255));
        jButton1.setFont(new java.awt.Font("Verdana", 3, 12)); // NOI18N
        jButton1.setForeground(new java.awt.Color(0, 204, 255));
        jButton1.setText("add");
        jButton1.setBorderPainted(false);
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });
        getContentPane().add(jButton1, new org.netbeans.lib.awtextra.AbsoluteConstraints(430, 60, 70, 21));

        jLabel4.setFont(new java.awt.Font("Verdana", 3, 12)); // NOI18N
        jLabel4.setForeground(new java.awt.Color(0, 204, 255));
        jLabel4.setText("Insira efeitos secundários");
        getContentPane().add(jLabel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 110, 190, 30));
        getContentPane().add(txtEfeitos, new org.netbeans.lib.awtextra.AbsoluteConstraints(240, 110, 170, 30));

        jButton2.setBackground(new java.awt.Color(255, 255, 255));
        jButton2.setFont(new java.awt.Font("Verdana", 3, 12)); // NOI18N
        jButton2.setForeground(new java.awt.Color(0, 204, 255));
        jButton2.setText("add");
        jButton2.setBorderPainted(false);
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });
        getContentPane().add(jButton2, new org.netbeans.lib.awtextra.AbsoluteConstraints(430, 120, 70, 21));

        jButton3.setBackground(new java.awt.Color(255, 255, 255));
        jButton3.setFont(new java.awt.Font("Verdana", 3, 12)); // NOI18N
        jButton3.setForeground(new java.awt.Color(0, 204, 255));
        jButton3.setText("Guardar");
        jButton3.setBorderPainted(false);
        jButton3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton3ActionPerformed(evt);
            }
        });
        getContentPane().add(jButton3, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 310, 100, 30));

        jButton4.setBackground(new java.awt.Color(255, 255, 255));
        jButton4.setFont(new java.awt.Font("Verdana", 3, 12)); // NOI18N
        jButton4.setForeground(new java.awt.Color(0, 204, 255));
        jButton4.setText("Voltar");
        jButton4.setBorderPainted(false);
        jButton4.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton4ActionPerformed(evt);
            }
        });
        getContentPane().add(jButton4, new org.netbeans.lib.awtextra.AbsoluteConstraints(410, 310, 90, 30));

        jLabel1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Images/login-image.jpg"))); // NOI18N
        jLabel1.setText("jLabel1");
        getContentPane().add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 511, 352));

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        addDoenca();
    }//GEN-LAST:event_jButton1ActionPerformed

    private void jButton3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton3ActionPerformed
        guardar();
    }//GEN-LAST:event_jButton3ActionPerformed

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
        addEfeitos();
    }//GEN-LAST:event_jButton2ActionPerformed

    private void jButton4ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton4ActionPerformed
    dispose();
    listarCentros lc = new listarCentros(sistema, serializacao);
    lc.setVisible(true);
    }//GEN-LAST:event_jButton4ActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JButton jButton3;
    private javax.swing.JButton jButton4;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JTextField txtDoencas;
    private javax.swing.JTextField txtEfeitos;
    // End of variables declaration//GEN-END:variables
}
