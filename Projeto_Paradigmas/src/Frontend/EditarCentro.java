/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Frontend;

import Backend.Sistema;
import Backend.CentroVacinacao;
import javax.swing.JOptionPane;
import Backend.CentroVacinacao;
import Serializacao.Serializacao;

/**
 *
 * @author josep
 */
public class EditarCentro extends javax.swing.JFrame {

    private Sistema sistema;
    private CentroVacinacao centro;
    private listarCentros listagem;
    private Serializacao serializacao;

    public EditarCentro(Sistema sistema, Serializacao serializacao, listarCentros listagem, CentroVacinacao centro) {
        initComponents();
        this.setResizable(false);
        this.setLocationRelativeTo(null);

        this.sistema = sistema;
        this.serializacao = serializacao;
        this.centro = centro;
        this.listagem = listagem;

        if (registoNovo()) {
            setTitle("Criação de um novo Centro de Vacinação");
            txtCodigo.requestFocus();
        } else {
            setTitle("Altereção de dados de centro");
            txtCodigo.setEditable(false);
            txtCodigo.setText(centro.getCodigo());
            String postos = String.valueOf(centro.getNumPostos());
            txtPostos.setText(postos);
            txtLocalidade.setText(centro.getLocalidade());
            txtMorada.setText(centro.getMorada());
            String vacinas = String.valueOf(centro.getNumMaxVacDia());
            txtMaxVacinas.setText(vacinas);
            txtGestor.setText(centro.getGestor().getNome());
            txtPostos.requestFocus();
        }
    }

    /*
    * Verificar se é para adicionar Centro.  
     */
    private boolean registoNovo() {
        return centro == null;
    }

    private void guardar() {

        if (txtCodigo.getText().isEmpty()) {
            JOptionPane.showMessageDialog(this, "Introduza p.f. o codigo pretendido!");
            txtCodigo.requestFocus();
            return;
        }
        if (txtMorada.getText().isEmpty()) {
            JOptionPane.showMessageDialog(this, "Introduza p.f. a morada pretendido!");
            txtMorada.requestFocus();
            return;
        }
        if (txtLocalidade.getText().isEmpty()) {
            JOptionPane.showMessageDialog(this, "Introduza p.f. a localidade pretendido!");
            txtLocalidade.requestFocus();
            return;
        }
        if (txtMaxVacinas.getText().isEmpty()) {
            JOptionPane.showMessageDialog(this, "Introduza p.f. o numero maximo de vacinas por dia pretendido!");
            txtMaxVacinas.requestFocus();
            return;
        }
        if (txtPostos.getText().isEmpty()) {
            JOptionPane.showMessageDialog(this, "Introduza p.f. o numero de postos do Centro de Vacinacao!");
            txtPostos.requestFocus();
            return;
        }
        if (!sistema.getListaGestores().existeGestorNome(txtGestor.getText())) {
            JOptionPane.showMessageDialog(this, "Introduza p.f um gestor valido!");
            txtGestor.requestFocus();
            return;
        }
        CentroVacinacao center = sistema.getListaCentros().procurarCentro(sistema.getListaGestores().getGestorNome(txtGestor.getText()));

        if (center != null && center != centro) {
            JOptionPane.showMessageDialog(this, "Este gestor ja tem um centro associado!");
            txtGestor.requestFocus();
            return;
        }
        if (registoNovo()) {
            CentroVacinacao centro = new CentroVacinacao();
            centro.setCodigo(txtCodigo.getText());
            centro.setMorada(txtMorada.getText());
            centro.setLocalidade(txtLocalidade.getText());
            int numMaxVac = Integer.parseInt(txtMaxVacinas.getText());
            centro.setNumMaxVacDia(numMaxVac);
            int numPostos = Integer.parseInt(txtPostos.getText());
            centro.setNumPostos(numPostos);
            centro.setGestor(sistema.getListaGestores().getGestorNome(txtGestor.getText()));
            sistema.getListaCentros().adicionarCentro(centro); //@TODO ADICIONAR TRY/CATCH 
            JOptionPane.showMessageDialog(this, "Registo guardado com sucesso.");
            fechar();
            
        } else {
            centro.setCodigo(txtCodigo.getText());
            centro.setMorada(txtMorada.getText());
            centro.setLocalidade(txtLocalidade.getText());
            int numMaxVac = Integer.parseInt(txtMaxVacinas.getText());
            centro.setNumMaxVacDia(numMaxVac);
            int postos = Integer.parseInt(txtPostos.getText());
            centro.setNumPostos(postos);
            centro.setGestor(sistema.getListaGestores().getGestorNome(txtGestor.getText()));
            JOptionPane.showMessageDialog(this, "Atualizado com sucesso.");
            fechar();
            

        }

        if (listagem != null) {
            listagem.atualizar();
        }

    }

    private void fechar() {
        dispose();
        listarCentros lc = new listarCentros(sistema, serializacao);
        lc.setVisible(true);
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        lbCodigo = new javax.swing.JLabel();
        txtCodigo = new javax.swing.JTextField();
        jLabel2 = new javax.swing.JLabel();
        txtMorada = new javax.swing.JTextField();
        lblocalidade = new javax.swing.JLabel();
        txtLocalidade = new javax.swing.JTextField();
        jbMaxVacinas = new javax.swing.JLabel();
        txtMaxVacinas = new javax.swing.JTextField();
        btnGuardar = new javax.swing.JButton();
        jButton1 = new javax.swing.JButton();
        jLabel3 = new javax.swing.JLabel();
        txtGestor = new javax.swing.JTextField();
        lbPostos = new javax.swing.JLabel();
        txtPostos = new javax.swing.JTextField();
        jLabel4 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.DO_NOTHING_ON_CLOSE);
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jPanel1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel1.setFont(new java.awt.Font("Tahoma", 3, 18)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(0, 204, 255));
        jLabel1.setText("CENTRO DE VAÇINACAO");
        jPanel1.add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 235, 43));

        lbCodigo.setFont(new java.awt.Font("Verdana", 0, 14)); // NOI18N
        lbCodigo.setForeground(new java.awt.Color(0, 204, 255));
        lbCodigo.setText("Código:");
        jPanel1.add(lbCodigo, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 40, 85, 38));
        jPanel1.add(txtCodigo, new org.netbeans.lib.awtextra.AbsoluteConstraints(110, 50, 120, 30));

        jLabel2.setFont(new java.awt.Font("Verdana", 0, 14)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(0, 204, 255));
        jLabel2.setText("Morada:");
        jPanel1.add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 80, 85, 42));
        jPanel1.add(txtMorada, new org.netbeans.lib.awtextra.AbsoluteConstraints(110, 90, 120, 30));

        lblocalidade.setFont(new java.awt.Font("Verdana", 0, 14)); // NOI18N
        lblocalidade.setForeground(new java.awt.Color(0, 204, 255));
        lblocalidade.setText("Localidade:");
        jPanel1.add(lblocalidade, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 130, 90, 33));

        txtLocalidade.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtLocalidadeActionPerformed(evt);
            }
        });
        jPanel1.add(txtLocalidade, new org.netbeans.lib.awtextra.AbsoluteConstraints(110, 130, 120, 30));

        jbMaxVacinas.setFont(new java.awt.Font("Verdana", 0, 14)); // NOI18N
        jbMaxVacinas.setForeground(new java.awt.Color(0, 204, 255));
        jbMaxVacinas.setText("MaxVacinas:");
        jPanel1.add(jbMaxVacinas, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 170, 100, 35));
        jPanel1.add(txtMaxVacinas, new org.netbeans.lib.awtextra.AbsoluteConstraints(110, 170, 120, 30));

        btnGuardar.setBackground(new java.awt.Color(255, 255, 255));
        btnGuardar.setFont(new java.awt.Font("Verdana", 1, 12)); // NOI18N
        btnGuardar.setForeground(new java.awt.Color(0, 204, 255));
        btnGuardar.setText("Guardar");
        btnGuardar.setBorderPainted(false);
        btnGuardar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnGuardarActionPerformed(evt);
            }
        });
        jPanel1.add(btnGuardar, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 300, 100, 30));

        jButton1.setBackground(new java.awt.Color(255, 255, 255));
        jButton1.setFont(new java.awt.Font("Verdana", 1, 12)); // NOI18N
        jButton1.setForeground(new java.awt.Color(0, 204, 255));
        jButton1.setText("Voltar");
        jButton1.setBorderPainted(false);
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });
        jPanel1.add(jButton1, new org.netbeans.lib.awtextra.AbsoluteConstraints(360, 300, 100, 30));

        jLabel3.setFont(new java.awt.Font("Verdana", 0, 14)); // NOI18N
        jLabel3.setForeground(new java.awt.Color(0, 204, 255));
        jLabel3.setText("Gestor:");
        jPanel1.add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 210, 86, 30));
        jPanel1.add(txtGestor, new org.netbeans.lib.awtextra.AbsoluteConstraints(110, 210, 120, 30));

        lbPostos.setFont(new java.awt.Font("Verdana", 0, 14)); // NOI18N
        lbPostos.setForeground(new java.awt.Color(0, 204, 255));
        lbPostos.setText("Nº Postos:");
        jPanel1.add(lbPostos, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 240, 90, 43));
        jPanel1.add(txtPostos, new org.netbeans.lib.awtextra.AbsoluteConstraints(110, 250, 120, 30));

        jLabel4.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Images/login-image.jpg"))); // NOI18N
        jLabel4.setText("jLabel4");
        jPanel1.add(jLabel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, -20, 480, 380));

        getContentPane().add(jPanel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 480, 350));

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnGuardarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnGuardarActionPerformed
        guardar();
       
    }//GEN-LAST:event_btnGuardarActionPerformed

    private void txtLocalidadeActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtLocalidadeActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtLocalidadeActionPerformed

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
      fechar();

    }//GEN-LAST:event_jButton1ActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnGuardar;
    private javax.swing.JButton jButton1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JLabel jbMaxVacinas;
    private javax.swing.JLabel lbCodigo;
    private javax.swing.JLabel lbPostos;
    private javax.swing.JLabel lblocalidade;
    private javax.swing.JTextField txtCodigo;
    private javax.swing.JTextField txtGestor;
    private javax.swing.JTextField txtLocalidade;
    private javax.swing.JTextField txtMaxVacinas;
    private javax.swing.JTextField txtMorada;
    private javax.swing.JTextField txtPostos;
    // End of variables declaration//GEN-END:variables
}
