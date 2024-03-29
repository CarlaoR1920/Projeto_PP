/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Frontend;
import Serializacao.Serializacao;
import Backend.Sistema;
import javax.swing.table.AbstractTableModel;
import Backend.CentroVacinacao;
import Backend.Utente;
import Backend.repositorioCentroVacinacao;
import javax.swing.JOptionPane;

/**
 *
 * @author josep
 */
public class EscolherCentro extends javax.swing.JFrame {

    private Sistema sistema;
    private  AbstractTableModel tableModel;
    private Serializacao serializacao;
    
    public EscolherCentro(Sistema sistema, Serializacao serializacao) {
        initComponents();
         this.setResizable(false);
        this.setLocationRelativeTo(null);
        this.sistema = sistema;
        this.serializacao = serializacao;
        this.tableModel = criarModeloTabela();
        tableCentros.setModel(tableModel);
    
    }
    
    private AbstractTableModel criarModeloTabela() { 
       String[] nomeColunas = {"Código", "Localidade", "Morada"};


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
                return sistema.getListaCentros().size();
            }



            @Override
            public Object getValueAt(int rowIndex, int columnIndex) {

                switch (columnIndex) {
                    case 0: 
                        return sistema.getListaCentros().todos().get(rowIndex).getCodigo();
                    case 1:
                        return sistema.getListaCentros().todos().get(rowIndex).getLocalidade();
                    case 2:
                        return sistema.getListaCentros().todos().get(rowIndex).getMorada();

                    default:
                        return "";
                }
            }
        };
    }
    
    public void escolherCentro() throws repositorioCentroVacinacao.CentroNaoExistenteException
    {
          int rowIndex = tableCentros.getSelectedRow();
           if (rowIndex == -1) return;
           String codigo = (String) tableModel.getValueAt(rowIndex, 0);
           CentroVacinacao centro = sistema.getListaCentros().getCentro(codigo);
           Utente utente =  (Utente) sistema.getUtilizadorLigado();
           utente.setCentroVac(centro);
           JOptionPane.showMessageDialog(this, "Centro escolhido com sucesso!");

        JanelaUtente ju = new JanelaUtente(sistema, serializacao);
        ju.setVisible(true);
        
       
         

    }
    
   

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jScrollPane1 = new javax.swing.JScrollPane();
        jTable1 = new javax.swing.JTable();
        jPanel1 = new javax.swing.JPanel();
        jScrollPane2 = new javax.swing.JScrollPane();
        jTable2 = new javax.swing.JTable();
        jPanel2 = new javax.swing.JPanel();
        jScrollPane3 = new javax.swing.JScrollPane();
        tableCentros = new javax.swing.JTable();
        jLabel1 = new javax.swing.JLabel();
        btAdicionar = new javax.swing.JButton();
        btFechar = new javax.swing.JButton();

        jTable1.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "Title 1", "Title 2", "Title 3", "Title 4"
            }
        ));
        jScrollPane1.setViewportView(jTable1);

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 100, Short.MAX_VALUE)
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 100, Short.MAX_VALUE)
        );

        jTable2.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "Title 1", "Title 2", "Title 3", "Title 4"
            }
        ));
        jScrollPane2.setViewportView(jTable2);

        setDefaultCloseOperation(javax.swing.WindowConstants.DO_NOTHING_ON_CLOSE);

        jPanel2.setBackground(new java.awt.Color(8, 44, 191));
        jPanel2.setForeground(new java.awt.Color(8, 44, 191));

        tableCentros.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null}
            },
            new String [] {
                "codigo", "localidade", "morada"
            }
        ));
        jScrollPane3.setViewportView(tableCentros);

        jLabel1.setFont(new java.awt.Font("Verdana", 3, 14)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(0, 204, 255));
        jLabel1.setText("ESCOLHER CENTRO DE VACINAÇÃO");

        btAdicionar.setBackground(new java.awt.Color(255, 255, 255));
        btAdicionar.setFont(new java.awt.Font("Tahoma", 3, 12)); // NOI18N
        btAdicionar.setForeground(new java.awt.Color(0, 204, 255));
        btAdicionar.setText("Adicionar");
        btAdicionar.setBorderPainted(false);
        btAdicionar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btAdicionarActionPerformed(evt);
            }
        });

        btFechar.setBackground(new java.awt.Color(255, 255, 255));
        btFechar.setFont(new java.awt.Font("Tahoma", 3, 12)); // NOI18N
        btFechar.setForeground(new java.awt.Color(0, 204, 255));
        btFechar.setText("Voltar");
        btFechar.setBorderPainted(false);
        btFechar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btFecharActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGap(18, 18, 18)
                        .addComponent(jScrollPane3, javax.swing.GroupLayout.PREFERRED_SIZE, 417, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(jLabel1))
                .addContainerGap(35, Short.MAX_VALUE))
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(btFechar, javax.swing.GroupLayout.PREFERRED_SIZE, 89, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(btAdicionar)
                .addGap(18, 18, 18))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jScrollPane3, javax.swing.GroupLayout.PREFERRED_SIZE, 222, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 40, Short.MAX_VALUE)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btFechar, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btAdicionar, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap())
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel2, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btAdicionarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btAdicionarActionPerformed
        try {
            escolherCentro();
        } catch (repositorioCentroVacinacao.CentroNaoExistenteException ex) {
            JOptionPane.showMessageDialog(this, "O Centro escolhido não existe!");
        }
        dispose();
    }//GEN-LAST:event_btAdicionarActionPerformed

    private void btFecharActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btFecharActionPerformed
       dispose();
        JanelaUtente ju = new JanelaUtente(sistema, serializacao);
        ju.setVisible(true);
    }//GEN-LAST:event_btFecharActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btAdicionar;
    private javax.swing.JButton btFechar;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JTable jTable1;
    private javax.swing.JTable jTable2;
    private javax.swing.JTable tableCentros;
    // End of variables declaration//GEN-END:variables
}
