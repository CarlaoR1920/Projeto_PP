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
import Backend.repositorioCentroVacinacao;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;

/**
 *
 * @author josep
 */
public class listarCentros extends javax.swing.JFrame {

   private Sistema sistema;
   private Serializacao serializacao;
   private AbstractTableModel tableModel;
    
   public listarCentros(Sistema sistema, Serializacao serializacao) {
        initComponents();
        this.sistema = sistema;
        this.serializacao = serializacao;
        this.setResizable(false);
        this.setLocationRelativeTo(null);
        this.tableModel = criarModeloTabela();
        tableCentros.setModel(tableModel);
       
    }
   private AbstractTableModel criarModeloTabela() { 
       String[] nomeColunas = {"Código", "numPostos", "Localidade", "Morada", "nMaxVacinas", "Gestor"};
      
        
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
                        return sistema.getListaCentros().todos().get(rowIndex).getNumPostos();
                    case 2:
                        return sistema.getListaCentros().todos().get(rowIndex).getLocalidade();
                    case 3:
                        return sistema.getListaCentros().todos().get(rowIndex).getMorada();
                    case 4:
                        return sistema.getListaCentros().todos().get(rowIndex).getNumMaxVacDia();
                    case 5:
                       return sistema.getListaCentros().todos().get(rowIndex).getGestor().getNome();
                  
                   


                    default:
                        return "";
                }                              
            }            
        };
    }
   
    private void adicionar() 
    {
         EditarCentro janela = new EditarCentro(sistema, serializacao, this, null);
        janela.setVisible(true);
        this.dispose();
    }
    
    private void editar() {
        int rowIndex = tableCentros.getSelectedRow();
        //Se nenhum registo selecionado, nao é possivel editar
        if (rowIndex == -1) {
            JOptionPane.showMessageDialog(this, "Seleccione um centro.");
            return;
        }

        String cod = (String) tableModel.getValueAt(rowIndex, 0);

        try {
            CentroVacinacao centro = sistema.getListaCentros().getCentro(cod);
            EditarCentro janela = new EditarCentro(sistema, serializacao, this, centro);
            janela.setVisible(true);
             this.dispose();
        } catch (repositorioCentroVacinacao.CentroNaoExistenteException ex) {
            JOptionPane.showMessageDialog(this, "O centro não existe");
        }
       

    }
    
    private void apagar()  {

           int rowIndex = tableCentros.getSelectedRow();
           if (rowIndex == -1) {
            JOptionPane.showMessageDialog(this, "Seleccione um centro.");
            return;
        }
           String codigo = (String) tableModel.getValueAt(rowIndex, 0);
           sistema.getListaCentros().removerCentros(codigo);
           atualizar();

    }

    
    public void atualizar() {    
        //Informa o modelo que foram efetuadas alteracoes, o modelo informa a tabela e os dados são redesenhados
       tableModel.fireTableDataChanged();
    }
    
   
       public void alocarVacinas() throws repositorioCentroVacinacao.CentroNaoExistenteException {
           int rowIndex = tableCentros.getSelectedRow();
           if (rowIndex == -1) {
            JOptionPane.showMessageDialog(this, "Seleccione um centro.");
            return;
        }
           String codigo = (String) tableModel.getValueAt(rowIndex, 0);
           CentroVacinacao centro = sistema.getListaCentros().getCentro(codigo);
           EscolherVacinaAlocar va = new EscolherVacinaAlocar(sistema, serializacao, centro);
           va.setVisible(true);
           this.dispose();
       }
       
       public void adicionarVacina()
       {
           AdicionarVacina av = new AdicionarVacina(sistema, serializacao);
           av.setVisible(true);
           this.dispose();
       }
    


    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        tableCentros = new javax.swing.JTable();
        btnApagar = new javax.swing.JButton();
        btnEditar = new javax.swing.JButton();
        jButton1 = new javax.swing.JButton();
        jLabel2 = new javax.swing.JLabel();
        btnCentroAdd = new javax.swing.JButton();
        jButton2 = new javax.swing.JButton();
        jButton3 = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.DO_NOTHING_ON_CLOSE);
        setBackground(new java.awt.Color(8, 44, 191));
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jPanel1.setBackground(new java.awt.Color(8, 44, 191));

        jScrollPane1.setForeground(new java.awt.Color(0, 51, 204));

        tableCentros.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null}
            },
            new String [] {
                "Codigo", "numPostos", "Localidade", "Morada", "nMaxVacinas", "Gestor"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.String.class, java.lang.Integer.class, java.lang.String.class, java.lang.String.class, java.lang.Integer.class, java.lang.String.class
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }
        });
        jScrollPane1.setViewportView(tableCentros);

        btnApagar.setBackground(new java.awt.Color(255, 255, 255));
        btnApagar.setFont(new java.awt.Font("Verdana", 3, 12)); // NOI18N
        btnApagar.setForeground(new java.awt.Color(0, 204, 255));
        btnApagar.setText("Apagar");
        btnApagar.setBorderPainted(false);
        btnApagar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnApagarActionPerformed(evt);
            }
        });

        btnEditar.setBackground(new java.awt.Color(255, 255, 255));
        btnEditar.setFont(new java.awt.Font("Verdana", 3, 12)); // NOI18N
        btnEditar.setForeground(new java.awt.Color(0, 204, 255));
        btnEditar.setText("Editar");
        btnEditar.setBorderPainted(false);
        btnEditar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnEditarActionPerformed(evt);
            }
        });

        jButton1.setBackground(new java.awt.Color(255, 255, 255));
        jButton1.setFont(new java.awt.Font("Verdana", 3, 12)); // NOI18N
        jButton1.setForeground(new java.awt.Color(0, 204, 255));
        jButton1.setText("Alocar Vacinas");
        jButton1.setBorderPainted(false);
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        jLabel2.setFont(new java.awt.Font("Tahoma", 3, 14)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(0, 204, 255));
        jLabel2.setText("CONSULTAR CENTROS");

        btnCentroAdd.setBackground(new java.awt.Color(255, 255, 255));
        btnCentroAdd.setFont(new java.awt.Font("Verdana", 3, 12)); // NOI18N
        btnCentroAdd.setForeground(new java.awt.Color(0, 204, 255));
        btnCentroAdd.setText("Adicionar");
        btnCentroAdd.setBorderPainted(false);
        btnCentroAdd.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnCentroAddActionPerformed(evt);
            }
        });

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

        jButton3.setBackground(new java.awt.Color(255, 255, 255));
        jButton3.setFont(new java.awt.Font("Verdana", 3, 12)); // NOI18N
        jButton3.setForeground(new java.awt.Color(0, 204, 255));
        jButton3.setText("Adicionar Vacina");
        jButton3.setBorderPainted(false);
        jButton3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton3ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(btnCentroAdd, javax.swing.GroupLayout.PREFERRED_SIZE, 124, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 37, Short.MAX_VALUE)
                .addComponent(btnApagar, javax.swing.GroupLayout.PREFERRED_SIZE, 125, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(53, 53, 53)
                .addComponent(btnEditar, javax.swing.GroupLayout.PREFERRED_SIZE, 107, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(46, 46, 46)
                .addComponent(jButton1)
                .addGap(47, 47, 47))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 195, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(40, 40, 40)
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 406, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(56, 56, 56)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jButton3, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE)
                    .addComponent(jButton2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addGap(36, 36, 36))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 37, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jButton2, javax.swing.GroupLayout.PREFERRED_SIZE, 37, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(73, 73, 73)
                        .addComponent(jButton3, javax.swing.GroupLayout.PREFERRED_SIZE, 43, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(91, 91, 91))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 103, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(79, 79, 79)))
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(btnCentroAdd, javax.swing.GroupLayout.DEFAULT_SIZE, 42, Short.MAX_VALUE)
                    .addComponent(jButton1, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(btnEditar, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(btnApagar, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
        );

        getContentPane().add(jPanel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, -1, -1));

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnCentroAddActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCentroAddActionPerformed
        adicionar();
    }//GEN-LAST:event_btnCentroAddActionPerformed

    private void btnApagarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnApagarActionPerformed
         apagar();
    }//GEN-LAST:event_btnApagarActionPerformed

    private void btnEditarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnEditarActionPerformed
       editar();
    }//GEN-LAST:event_btnEditarActionPerformed

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
      
        try {
           alocarVacinas();
       } catch (repositorioCentroVacinacao.CentroNaoExistenteException ex) {
           Logger.getLogger(listarCentros.class.getName()).log(Level.SEVERE, null, ex);
       }
    }//GEN-LAST:event_jButton1ActionPerformed

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
        this.dispose();
        janelaAdmin ja = new janelaAdmin(sistema, serializacao);
        ja.setVisible(true);
                
    }//GEN-LAST:event_jButton2ActionPerformed

    private void jButton3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton3ActionPerformed
    adicionarVacina();
   
    }//GEN-LAST:event_jButton3ActionPerformed

  


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnApagar;
    private javax.swing.JButton btnCentroAdd;
    private javax.swing.JButton btnEditar;
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JButton jButton3;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable tableCentros;
    // End of variables declaration//GEN-END:variables
}
