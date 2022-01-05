
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.util.Vector;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author Saba Fatima
 */
public class Product extends javax.swing.JFrame {

    /**
     * Creates new form Product
     */
    public Product()  {
        initComponents();
    }
    
    String driver = "oracle.jdbc.OracleDriver";
    String url = "jdbc:oracle:thin:@localhost:1521:ORCL";
    String user = "system";
    String password = "OracleUser";
    
    //Statement st;
    ResultSet rs;
    PreparedStatement pst;
    Connection con;

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        prodnr_field = new javax.swing.JTextField();
        prodname_field = new javax.swing.JTextField();
        prodtype_field = new javax.swing.JTextField();
        quantity_field = new javax.swing.JTextField();
        jScrollPane1 = new javax.swing.JScrollPane();
        prodTable = new javax.swing.JTable();
        insertBtn = new javax.swing.JButton();
        updateBtn = new javax.swing.JButton();
        delBtn = new javax.swing.JButton();
        nextBtn = new javax.swing.JButton();
        jButton1 = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jLabel1.setFont(new java.awt.Font("Tahoma", 1, 24)); // NOI18N
        jLabel1.setText("PRODUCTS");

        jLabel2.setText("Number");

        jLabel3.setText("Name");

        jLabel4.setText("Type");

        jLabel5.setText("Quantity");

        prodnr_field.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                prodnr_fieldActionPerformed(evt);
            }
        });

        prodtype_field.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                prodtype_fieldActionPerformed(evt);
            }
        });

        prodTable.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Number", "Name", "Type", "Quantity"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.Integer.class, java.lang.String.class, java.lang.String.class, java.lang.Integer.class
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }
        });
        prodTable.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                prodTableMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(prodTable);

        insertBtn.setText("Insert");
        insertBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                insertBtnActionPerformed(evt);
            }
        });

        updateBtn.setText("Update");
        updateBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                updateBtnActionPerformed(evt);
            }
        });

        delBtn.setText("Delete");
        delBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                delBtnActionPerformed(evt);
            }
        });

        nextBtn.setText("Next");
        nextBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                nextBtnActionPerformed(evt);
            }
        });

        jButton1.setText("Read");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(26, 26, 26)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jLabel4)
                        .addContainerGap())
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(nextBtn, javax.swing.GroupLayout.PREFERRED_SIZE, 67, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel5)
                                    .addComponent(jLabel3)
                                    .addComponent(jLabel2))
                                .addGap(18, 18, 18)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                    .addGroup(layout.createSequentialGroup()
                                        .addGap(0, 0, Short.MAX_VALUE)
                                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                            .addComponent(prodtype_field, javax.swing.GroupLayout.Alignment.TRAILING)
                                            .addComponent(prodname_field, javax.swing.GroupLayout.Alignment.TRAILING)
                                            .addComponent(prodnr_field)
                                            .addComponent(quantity_field, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 152, Short.MAX_VALUE)))
                                    .addGroup(javax.swing.GroupLayout.Alignment.LEADING, layout.createSequentialGroup()
                                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                            .addComponent(updateBtn, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                            .addComponent(insertBtn, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 24, Short.MAX_VALUE)
                                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                            .addComponent(delBtn, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                            .addComponent(jButton1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))
                                .addGap(44, 44, 44)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 410, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jLabel1))))
                        .addGap(0, 25, Short.MAX_VALUE))))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(28, 28, 28)
                .addComponent(jLabel1)
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel2)
                            .addComponent(prodnr_field, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel3)
                            .addComponent(prodname_field, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel4)
                            .addComponent(prodtype_field, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(21, 21, 21)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel5)
                            .addComponent(quantity_field, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(32, 32, 32)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(insertBtn)
                            .addComponent(jButton1)))
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 192, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(26, 26, 26)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(delBtn)
                    .addComponent(nextBtn)
                    .addComponent(updateBtn))
                .addContainerGap(29, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void prodtype_fieldActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_prodtype_fieldActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_prodtype_fieldActionPerformed

    public void tableupdate() throws SQLException {
        
        int c;
        try {
            Class.forName(driver);
             con = DriverManager.getConnection(url, user, password);
             
             pst = con.prepareStatement("select * from PRODUCT");
            ResultSet rs = pst.executeQuery();
            
            ResultSetMetaData rsd = rs.getMetaData();
            c = rsd.getColumnCount();
            DefaultTableModel dft = (DefaultTableModel)prodTable.getModel();
            dft.setRowCount(0);
            
            while(rs.next()){
                
                Vector v2 = new Vector();
                for(int i=1;i<c;i++){
                    
                    v2.add(rs.getString("PRODNR"));
                    v2.add(rs.getString("PRODNAME"));
                    v2.add(rs.getString("PRODTYPE"));
                    v2.add(rs.getString("AVAILABLE_QUANTITY"));
                    
                }
                dft.addRow(v2);
            }
             
        } catch (ClassNotFoundException | SQLException ex) {
            Logger.getLogger(Product.class.getName()).log(Level.SEVERE, null, ex);
        }
        
    }
    private void updateBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_updateBtnActionPerformed
        // TODO add your handling code here:
        
         DefaultTableModel model = (DefaultTableModel)prodTable.getModel();
        int selectedIndex = prodTable.getSelectedRow();
        
        String name, type;
        int id, quantity;
        
        id = Integer.valueOf(prodnr_field.getText());
        name = prodname_field.getText();
        type = prodtype_field.getText();
        quantity = Integer.valueOf(quantity_field.getText());
        
        try {
            
            Class.forName(driver);
            con = DriverManager.getConnection(url, user, password);
            
            pst = con.prepareStatement("update PRODUCT set PRODNAME=?, PRODTYPE=?, AVAILABLE_QUANTITY=? where PRODNR = ? ");
            pst.setString(1, name);
            pst.setString(2, type);
            pst.setInt(3, quantity);
            pst.setInt(4, id);
            pst.executeUpdate();
            JOptionPane.showMessageDialog(this,"RECORD UPDATED!");
            
            prodnr_field.setText("");
            prodname_field.setText("");
            prodtype_field.setText("");
            quantity_field.setText("");
            prodnr_field.requestFocus();
            tableupdate();
            
        } catch (ClassNotFoundException | SQLException ex) {
            
            Logger.getLogger(Product.class.getName()).log(Level.SEVERE, null, ex);
            JOptionPane.showMessageDialog(this, ex);
            
        }
    }//GEN-LAST:event_updateBtnActionPerformed

    private void insertBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_insertBtnActionPerformed
        // TODO add your handling code here:
        String name, type;
        int id, quantity;
        
        id = Integer.valueOf(prodnr_field.getText());
        name = prodname_field.getText();
        type = prodtype_field.getText();
        quantity = Integer.valueOf(quantity_field.getText());
        
        try {
            // TODO add your handling code here:
            Class.forName(driver);
            con = DriverManager.getConnection(url, user, password);
            pst = con.prepareStatement("insert into PRODUCT (PRODNR,PRODNAME,PRODTYPE,AVAILABLE_QUANTITY)values(?,?,?,?)");
            pst.setInt(1, id);
            pst.setString(2, name);
            pst.setString(3, type);
            pst.setInt(4, quantity);
            pst.executeUpdate();
            JOptionPane.showMessageDialog(this,"RECORD ADDED!");
            
            prodnr_field.setText("");
            prodname_field.setText("");
            prodtype_field.setText("");
            quantity_field.setText("");
            prodnr_field.requestFocus();
            tableupdate();
        } catch (Exception ex) {
            Logger.getLogger(Product.class.getName()).log(Level.SEVERE, null, ex);
        }
        
    }//GEN-LAST:event_insertBtnActionPerformed

    private void delBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_delBtnActionPerformed
        // TODO add your handling code here:
        DefaultTableModel model = (DefaultTableModel)prodTable.getModel();
        int selectedIndex = prodTable.getSelectedRow();
        
        int id = Integer.parseInt(model.getValueAt(selectedIndex, 0).toString());
        
        int dialogresult = JOptionPane.showConfirmDialog(null,"Do you want to delete the record","WARNING!",JOptionPane.YES_NO_OPTION);
        
        if (dialogresult ==JOptionPane.YES_OPTION){
            
            try {
                
                Class.forName(driver);
                 con= DriverManager.getConnection(url, user, password);
            
            pst = con.prepareStatement("delete from PRODUCT where PRODNR = ? ");
            
            pst.setInt(1, id);
            pst.executeUpdate();
            JOptionPane.showMessageDialog(this,"RECORD DELETED!");
            tableupdate();
            prodnr_field.setText("");
            prodname_field.setText("");
            prodtype_field.setText("");
            quantity_field.setText("");
            prodnr_field.requestFocus();
            } 
            
            catch (ClassNotFoundException | SQLException ex) {
                
                Logger.getLogger(Product.class.getName()).log(Level.SEVERE, null, ex);
            }
    }//GEN-LAST:event_delBtnActionPerformed

    private void prodTableMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_prodTableMouseClicked
        // TODO add your handling code here:
        
        DefaultTableModel model = (DefaultTableModel) prodTable.getModel();
        int selectedIndex = prodTable.getSelectedRow();
        
        prodnr_field.setText(model.getValueAt(selectedIndex,0).toString());
        prodname_field.setText(model.getValueAt(selectedIndex,1).toString());
         prodtype_field.setText(model.getValueAt(selectedIndex,2).toString());
        quantity_field.setText(model.getValueAt(selectedIndex,3).toString());
    }//GEN-LAST:event_prodTableMouseClicked

    private void nextBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_nextBtnActionPerformed
        // TODO add your handling code here:
        Supplies supplies = new Supplies();
        supplies.setVisible(true);
        dispose();
    }//GEN-LAST:event_nextBtnActionPerformed

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        try {
            // TODO add your handling code here:
            tableupdate();
        } catch (SQLException ex) {
            Logger.getLogger(Product.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_jButton1ActionPerformed

    private void prodnr_fieldActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_prodnr_fieldActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_prodnr_fieldActionPerformed

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(Product.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Product.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Product.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Product.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Product().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton delBtn;
    private javax.swing.JButton insertBtn;
    private javax.swing.JButton jButton1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JButton nextBtn;
    private javax.swing.JTable prodTable;
    private javax.swing.JTextField prodname_field;
    private javax.swing.JTextField prodnr_field;
    private javax.swing.JTextField prodtype_field;
    private javax.swing.JTextField quantity_field;
    private javax.swing.JButton updateBtn;
    // End of variables declaration//GEN-END:variables
}