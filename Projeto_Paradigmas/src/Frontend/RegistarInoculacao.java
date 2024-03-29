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
import java.time.LocalDateTime;
import Backend.Vacina;
import java.time.LocalDate;
import java.util.ArrayList;
import javax.swing.JOptionPane;

/**
 *
 * @author josep
 */
public class RegistarInoculacao extends javax.swing.JFrame {

    private Sistema sistema;
    private Serializacao serializacao;
    private Utente utente;
    private LocalDateTime hora;
    private ConsultarMarcacoesGestor listagem2;

    /**
     * Creates new form RegistarInoculacao
     */
    public RegistarInoculacao(Sistema sistema, Serializacao serializacao, Utente utente, LocalDateTime hora, ConsultarMarcacoesGestor listagem2) {
        this.setResizable(false);
        this.setLocationRelativeTo(null);
        initComponents();
        this.sistema = sistema;
        this.serializacao = serializacao;

        for (Vacina vac : sistema.getListaVacinas().todos()) {

            cbVacina.addItem(vac.getNome());
        }
        this.utente = utente;
        this.hora = hora;
        this.listagem2 = listagem2;

    }

    public void registar() {
        ArrayList<Utente> utentes = new ArrayList<>();
        utentes.add(utente);
        CentroVacinacao centro = sistema.getListaCentros().procurarCentro((Gestor) sistema.getUtilizadorLigado());
        if (centro.getMarcacoes().getHoraUtente(utentes) != null) {

            String nome = (String) cbVacina.getSelectedItem();
            Vacina vacina = sistema.getListaVacinas().getVacina(nome);
            utente.setVacina(vacina);
            centro.getStock().Atualizar(vacina, -1);
            LocalDate horario = hora.toLocalDate();
            utente.setData_adminVac(horario);
            utente.setNumTomas(utente.getNumTomas() + 1);
            centro.getMarcacoes().cancelarMarcacao(hora);
            listagem2.atualizar();
            JOptionPane.showMessageDialog(this, "Inoculação registada com sucesso!");
        } else {
            JOptionPane.showMessageDialog(this, "Já foi registada inoculação!");
        }

    }

    public void agendarProximaMarcacao() {

        AgendarProximaMarcacao apm = new AgendarProximaMarcacao(sistema, serializacao, hora, utente, listagem2);
        apm.setVisible(true);
        this.dispose();
    }

    public void efeitosSecundarios() {
        EfeitosSecundarios es = new EfeitosSecundarios(sistema, serializacao, utente, hora, listagem2);
        es.setVisible(true);
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel1 = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        jList1 = new javax.swing.JList<>();
        jPanel1 = new javax.swing.JPanel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        cbVacina = new javax.swing.JComboBox<>();
        jButton1 = new javax.swing.JButton();
        jButton2 = new javax.swing.JButton();
        jButton3 = new javax.swing.JButton();
        jButton4 = new javax.swing.JButton();
        jLabel4 = new javax.swing.JLabel();

        jLabel1.setFont(new java.awt.Font("Tahoma", 3, 12)); // NOI18N
        jLabel1.setText("Vacina administrada:");

        jList1.setModel(new javax.swing.AbstractListModel<String>() {
            String[] strings = { "Item 1", "Item 2", "Item 3", "Item 4", "Item 5" };
            public int getSize() { return strings.length; }
            public String getElementAt(int i) { return strings[i]; }
        });
        jScrollPane1.setViewportView(jList1);

        setDefaultCloseOperation(javax.swing.WindowConstants.DO_NOTHING_ON_CLOSE);
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jPanel1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel2.setFont(new java.awt.Font("Verdana", 3, 14)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(0, 204, 255));
        jLabel2.setText("REGISTO DE INOCULAÇÃO");
        jPanel1.add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 230, 35));

        jLabel3.setFont(new java.awt.Font("Verdana", 0, 12)); // NOI18N
        jLabel3.setForeground(new java.awt.Color(0, 204, 255));
        jLabel3.setText("Vacina administrada:");
        jPanel1.add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 46, 152, 34));

        jPanel1.add(cbVacina, new org.netbeans.lib.awtextra.AbsoluteConstraints(140, 50, 118, 31));

        jButton1.setBackground(new java.awt.Color(255, 255, 255));
        jButton1.setFont(new java.awt.Font("Verdana", 3, 12)); // NOI18N
        jButton1.setForeground(new java.awt.Color(0, 204, 255));
        jButton1.setText("Registar");
        jButton1.setBorderPainted(false);
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });
        jPanel1.add(jButton1, new org.netbeans.lib.awtextra.AbsoluteConstraints(280, 50, 110, 33));

        jButton2.setBackground(new java.awt.Color(255, 255, 255));
        jButton2.setFont(new java.awt.Font("Tahoma", 3, 12)); // NOI18N
        jButton2.setForeground(new java.awt.Color(0, 204, 255));
        jButton2.setText("Agendar próxima marcação");
        jButton2.setBorderPainted(false);
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });
        jPanel1.add(jButton2, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 240, 199, 33));

        jButton3.setBackground(new java.awt.Color(255, 255, 255));
        jButton3.setFont(new java.awt.Font("Verdana", 3, 12)); // NOI18N
        jButton3.setForeground(new java.awt.Color(0, 204, 255));
        jButton3.setText("Voltar");
        jButton3.setBorderPainted(false);
        jButton3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton3ActionPerformed(evt);
            }
        });
        jPanel1.add(jButton3, new org.netbeans.lib.awtextra.AbsoluteConstraints(350, 240, 110, 33));

        jButton4.setBackground(new java.awt.Color(255, 255, 255));
        jButton4.setFont(new java.awt.Font("Verdana", 3, 12)); // NOI18N
        jButton4.setForeground(new java.awt.Color(0, 204, 255));
        jButton4.setText("Efeitos Secundários");
        jButton4.setBorderPainted(false);
        jButton4.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton4ActionPerformed(evt);
            }
        });
        jPanel1.add(jButton4, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 200, 200, 30));

        jLabel4.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Images/login-image.jpg"))); // NOI18N
        jLabel4.setText("jLabel4");
        jPanel1.add(jLabel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 3, 470, 280));

        getContentPane().add(jPanel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 471, 280));

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        registar();
    }//GEN-LAST:event_jButton1ActionPerformed

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
        agendarProximaMarcacao();
    }//GEN-LAST:event_jButton2ActionPerformed

    private void jButton3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton3ActionPerformed
        dispose();
        ConsultarMarcacoesGestor cmg = new ConsultarMarcacoesGestor(sistema, serializacao);
        cmg.setVisible(true);

    }//GEN-LAST:event_jButton3ActionPerformed

    private void jButton4ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton4ActionPerformed
        efeitosSecundarios();
        this.dispose();
    }//GEN-LAST:event_jButton4ActionPerformed

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JComboBox<String> cbVacina;
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JButton jButton3;
    private javax.swing.JButton jButton4;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JList<String> jList1;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    // End of variables declaration//GEN-END:variables

}
