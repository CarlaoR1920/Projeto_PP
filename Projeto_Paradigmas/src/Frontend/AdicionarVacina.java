/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Frontend;
import Serializacao.Serializacao;
import Backend.Sistema;
import Backend.Vacina;
import javax.swing.JOptionPane;

/**
 *
 * @author josep
 */
public class AdicionarVacina extends javax.swing.JFrame {
    private Serializacao serializacao;
    private Sistema sistema;

    /**
     * Creates new form AdicionarVacina
     */
    public AdicionarVacina(Sistema sistema, Serializacao serializacao) {
        initComponents();
        this.setResizable(false);
        this.setLocationRelativeTo(null);
        this.sistema = sistema;
        this.serializacao = serializacao;
        
        
    }
    
    public void ProximoPasso()
    {
        if (txtCodigo.getText().isEmpty()) {
            JOptionPane.showMessageDialog(this, "Introduza p.f. o código da vacina!");
            txtCodigo.requestFocus();
            return;
        }

      
        if (txtNome.getText().isEmpty()) {
            JOptionPane.showMessageDialog(this, "Introduza p.f o nome da vacina");
            txtNome.requestFocus();
            return;
        }

        if (txtFabricante.getText().isEmpty()) {
            JOptionPane.showMessageDialog(this, "Introduza p.f. o fabricante da vacina!");
            txtFabricante.requestFocus();
            return;
        }

        if (txtDose.getText().isEmpty()) {
            JOptionPane.showMessageDialog(this, "Introduza p.f. a dose da vacina!");
            txtDose.requestFocus();
            return;
        }

        if (txtTomas.getText().isEmpty()) {
            JOptionPane.showMessageDialog(this, "Introduza p.f. o número de tomas da vacina!");
           txtTomas.requestFocus();
            return;
        }

        if (txtIdadeMin.getText().isEmpty()) {
            JOptionPane.showMessageDialog(this, "Introduza p.f. a idade mínima para tomar a vacina!");
            txtIdadeMin.requestFocus();
            return;
        }

        if (txtIdadeMax.getText().isEmpty()) {
            JOptionPane.showMessageDialog(this, "Introduza p.f. a idade máxima para tomar a vacina!");
            txtIdadeMax.requestFocus();
            return;
        }

        
        Vacina vacina = new Vacina();
        vacina.setCodigo(txtCodigo.getText());
        vacina.setNome(txtNome.getText());
        vacina.setFabricante(txtFabricante.getText());
        double dose = Double.parseDouble(txtDose.getText());;
        vacina.setDoseIndividual(dose);
        int tomas = Integer.parseInt(txtTomas.getText());
        vacina.setTomas(tomas);
        int idadeMin = Integer.parseInt(txtIdadeMin.getText());
        vacina.setIdadeMinima(idadeMin);
        int idadeMax = Integer.parseInt(txtIdadeMax.getText());
        vacina.setIdadeMaxima(idadeMax);
        
        
        AdicionarDoencasVac adv = new  AdicionarDoencasVac(sistema, serializacao, vacina);
        adv.setVisible(true);
        this.dispose();
    }
    
    

    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        jLabel9 = new javax.swing.JLabel();
        txtNome = new javax.swing.JTextField();
        txtCodigo = new javax.swing.JTextField();
        txtFabricante = new javax.swing.JTextField();
        txtDose = new javax.swing.JTextField();
        txtTomas = new javax.swing.JTextField();
        txtIdadeMin = new javax.swing.JTextField();
        txtIdadeMax = new javax.swing.JTextField();
        jButton1 = new javax.swing.JButton();
        jButton2 = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.DO_NOTHING_ON_CLOSE);
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel2.setFont(new java.awt.Font("Verdana", 3, 14)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(0, 204, 255));
        jLabel2.setText("ADICIONAR VACINA");
        getContentPane().add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 10, 190, 30));

        jLabel3.setFont(new java.awt.Font("Tahoma", 3, 12)); // NOI18N
        jLabel3.setForeground(new java.awt.Color(0, 204, 255));
        jLabel3.setText("Nome ");
        getContentPane().add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 60, 90, 30));

        jLabel4.setFont(new java.awt.Font("Tahoma", 3, 12)); // NOI18N
        jLabel4.setForeground(new java.awt.Color(0, 204, 255));
        jLabel4.setText("Código");
        getContentPane().add(jLabel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 100, 50, 20));

        jLabel5.setFont(new java.awt.Font("Verdana", 3, 12)); // NOI18N
        jLabel5.setForeground(new java.awt.Color(0, 204, 255));
        jLabel5.setText("Fabricante");
        getContentPane().add(jLabel5, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 140, 90, 30));

        jLabel6.setFont(new java.awt.Font("Verdana", 3, 12)); // NOI18N
        jLabel6.setForeground(new java.awt.Color(0, 204, 255));
        jLabel6.setText("Dose");
        getContentPane().add(jLabel6, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 180, 70, 20));

        jLabel7.setFont(new java.awt.Font("Verdana", 3, 12)); // NOI18N
        jLabel7.setForeground(new java.awt.Color(0, 204, 255));
        jLabel7.setText("Nº tomas");
        getContentPane().add(jLabel7, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 210, 130, 30));

        jLabel8.setFont(new java.awt.Font("Verdana", 3, 12)); // NOI18N
        jLabel8.setForeground(new java.awt.Color(0, 204, 255));
        jLabel8.setText("Idade Minima");
        getContentPane().add(jLabel8, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 260, 110, 30));

        jLabel9.setFont(new java.awt.Font("Tahoma", 3, 12)); // NOI18N
        jLabel9.setForeground(new java.awt.Color(0, 204, 255));
        jLabel9.setText("Idade Máxima");
        getContentPane().add(jLabel9, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 300, 100, 30));
        getContentPane().add(txtNome, new org.netbeans.lib.awtextra.AbsoluteConstraints(110, 60, 140, 30));
        getContentPane().add(txtCodigo, new org.netbeans.lib.awtextra.AbsoluteConstraints(110, 100, 140, 30));
        getContentPane().add(txtFabricante, new org.netbeans.lib.awtextra.AbsoluteConstraints(110, 140, 140, 30));
        getContentPane().add(txtDose, new org.netbeans.lib.awtextra.AbsoluteConstraints(110, 180, 140, 30));
        getContentPane().add(txtTomas, new org.netbeans.lib.awtextra.AbsoluteConstraints(110, 220, 140, 30));
        getContentPane().add(txtIdadeMin, new org.netbeans.lib.awtextra.AbsoluteConstraints(110, 260, 140, 30));
        getContentPane().add(txtIdadeMax, new org.netbeans.lib.awtextra.AbsoluteConstraints(110, 300, 140, 30));

        jButton1.setBackground(new java.awt.Color(255, 255, 255));
        jButton1.setFont(new java.awt.Font("Verdana", 3, 12)); // NOI18N
        jButton1.setForeground(new java.awt.Color(0, 204, 255));
        jButton1.setText("Próximo");
        jButton1.setBorderPainted(false);
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });
        getContentPane().add(jButton1, new org.netbeans.lib.awtextra.AbsoluteConstraints(400, 320, 100, 30));

        jButton2.setBackground(new java.awt.Color(255, 255, 255));
        jButton2.setFont(new java.awt.Font("Verdana", 3, 12)); // NOI18N
        jButton2.setForeground(new java.awt.Color(0, 204, 255));
        jButton2.setText("Voltar");
        jButton2.setBorderPainted(false);
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });
        getContentPane().add(jButton2, new org.netbeans.lib.awtextra.AbsoluteConstraints(421, 10, 90, 30));

        jLabel1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Images/login-image.jpg"))); // NOI18N
        jLabel1.setText("jLabel1");
        getContentPane().add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 520, 360));

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
      ProximoPasso();
    }//GEN-LAST:event_jButton1ActionPerformed

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
    dispose();
    listarCentros lc = new listarCentros(sistema, serializacao);
    lc.setVisible(true);

    }//GEN-LAST:event_jButton2ActionPerformed

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
    private javax.swing.JTextField txtCodigo;
    private javax.swing.JTextField txtDose;
    private javax.swing.JTextField txtFabricante;
    private javax.swing.JTextField txtIdadeMax;
    private javax.swing.JTextField txtIdadeMin;
    private javax.swing.JTextField txtNome;
    private javax.swing.JTextField txtTomas;
    // End of variables declaration//GEN-END:variables
}
