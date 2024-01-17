/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Frontend;
import Backend.CentroVacinacao;
import Backend.Gestor;
import Backend.Sistema;
import Serializacao.Serializacao;
import java.time.format.DateTimeFormatter;
import javax.swing.table.AbstractTableModel;

/**
 *
 * @author josep
 */
public class ConsultarUtentesEmFalta extends javax.swing.JFrame {
    private Serializacao serializacao;
    private Sistema sistema;
    private AbstractTableModel tableModel;

    /**
     * Creates new form ConsultarUtentesEmFalta
     */
    public ConsultarUtentesEmFalta(Sistema sistema, Serializacao serializacao) {
        initComponents();
         this.setResizable(false);
        this.setLocationRelativeTo(null);
        this.sistema = sistema;
        this.serializacao = serializacao;
        this.tableModel = criarModeloTabela();
        tableFaltas.setModel(tableModel);
        
    }
    private AbstractTableModel criarModeloTabela() { 
       String[] nomeColunas = {"Nome", "Nº SNS", "Horário"};
       CentroVacinacao centro = sistema.getListaCentros().procurarCentro((Gestor) sistema.getUtilizadorLigado());
       System.out.println(centro.getMarcacoes().todosValuesFaltaram().get(0).getNome());
        
        return new AbstractTableModel() {
            @Override
            public String getColumnName(int column) {
                return nomeColunas[column];
            }
            
            @Override
            public int getColumnCount() {
                return nomeColunas.length;
            }
           
            @Override
            public int getRowCount() {
                return centro.getMarcacoes().todosValuesFaltaram().size();
            }
            
            @Override
            public Object getValueAt(int rowIndex, int columnIndex) {
            
                switch (columnIndex) {
                    case 0: 
                        return centro.getMarcacoes().todosValuesFaltaram().get(rowIndex).getNome();
                    case 1:
                        return centro.getMarcacoes().todosValuesFaltaram().get(rowIndex).getNumUtente();
                    case 2:
                        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd 'às' HH:mm");
                        return centro.getMarcacoes().todosKeysFaltaram().get(rowIndex).format(formatter);
                  
                   


                    default:
                        return "";
                }                              
            }            
        };
    }
    
    
    
    

   
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jScrollPane1 = new javax.swing.JScrollPane();
        tableFaltas = new javax.swing.JTable();
        jLabel1 = new javax.swing.JLabel();
        jButton1 = new javax.swing.JButton();
        jPanel1 = new javax.swing.JPanel();

        setDefaultCloseOperation(javax.swing.WindowConstants.DO_NOTHING_ON_CLOSE);
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        tableFaltas.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null}
            },
            new String [] {
                "Nome", "Nº Sns", "Horário"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.String.class, java.lang.Integer.class, java.lang.String.class
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }
        });
        jScrollPane1.setViewportView(tableFaltas);

        getContentPane().add(jScrollPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(33, 38, 375, 229));

        jLabel1.setFont(new java.awt.Font("Verdana", 3, 14)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(0, 204, 255));
        jLabel1.setText("UTENTES QUE FALTARAM ÁS CONSULTAS");
        getContentPane().add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 338, 20));

        jButton1.setBackground(new java.awt.Color(255, 255, 255));
        jButton1.setFont(new java.awt.Font("Verdana", 3, 12)); // NOI18N
        jButton1.setForeground(new java.awt.Color(0, 153, 255));
        jButton1.setText("Voltar");
        jButton1.setBorderPainted(false);
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });
        getContentPane().add(jButton1, new org.netbeans.lib.awtextra.AbsoluteConstraints(365, 296, 80, 32));

        jPanel1.setBackground(new java.awt.Color(8, 44, 191));

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 460, Short.MAX_VALUE)
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 340, Short.MAX_VALUE)
        );

        getContentPane().add(jPanel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, -1, -1));

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
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable tableFaltas;
    // End of variables declaration//GEN-END:variables
}
