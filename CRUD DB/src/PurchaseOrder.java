
import java.sql.Connection;
import java.sql.Date;
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
public class PurchaseOrder extends javax.swing.JFrame {

    /**
     * Creates new form PurchaseOrder
     */
    public PurchaseOrder() {
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
    
    public void tableupdate() throws SQLException {
        
        int c;
        try {
            Class.forName(driver);
             con = DriverManager.getConnection(url, user, password);
             
             pst = con.prepareStatement("select * from PURCHASE_ORDER");
            ResultSet rs = pst.executeQuery();
            
            ResultSetMetaData rsd = rs.getMetaData();
            c = rsd.getColumnCount();
            DefaultTableModel dft = (DefaultTableModel)poTable.getModel();
            dft.setRowCount(0);
            
            while(rs.next()){
                
                Vector v2 = new Vector();
                for(int i=1;i<c;i++){
                    
                    v2.add(rs.getString("PONR"));
                    v2.add(rs.getString("PODATE"));
                    v2.add(rs.getString("SUPNR"));
                    
                }
                dft.addRow(v2);
            }
             
        } catch (ClassNotFoundException | SQLException ex) {
            Logger.getLogger(PurchaseOrder.class.getName()).log(Level.SEVERE, null, ex);
        }
        
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
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        ponr_field = new javax.swing.JTextField();
        pod_field = new javax.swing.JTextField();
        supnr_field = new javax.swing.JTextField();
        jScrollPane1 = new javax.swing.JScrollPane();
        poTable = new javax.swing.JTable();
        insertBtn = new javax.swing.JButton();
        updateBtn = new javax.swing.JButton();
        delBtn = new javax.swing.JButton();
        nextBtn = new javax.swing.JButton();
        readBtn = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jLabel1.setFont(new java.awt.Font("Tahoma", 1, 24)); // NOI18N
        jLabel1.setText("PURCHASE ORDER");

        jLabel2.setText("Number");

        jLabel3.setText("Date");

        jLabel4.setText("Supplier Num");

        poTable.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Number", "Date", "Supplier Number"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.String.class, java.lang.String.class, java.lang.Integer.class
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }
        });
        poTable.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                poTableMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(poTable);

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

        readBtn.setText("Read");
        readBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                readBtnActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(23, 23, 23)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel4)
                            .addComponent(jLabel3)
                            .addComponent(jLabel2))
                        .addGap(18, 18, 18)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                            .addComponent(supnr_field, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, 164, Short.MAX_VALUE)
                            .addComponent(pod_field, javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(ponr_field, javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addComponent(updateBtn, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(insertBtn, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addComponent(readBtn, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(delBtn, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))
                        .addGap(41, 41, 41)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 328, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(nextBtn, javax.swing.GroupLayout.PREFERRED_SIZE, 67, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(216, 216, 216)
                        .addComponent(jLabel1)))
                .addContainerGap(43, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(33, 33, 33)
                .addComponent(jLabel1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 33, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel2)
                            .addComponent(ponr_field, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel3)
                            .addComponent(pod_field, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel4)
                            .addComponent(supnr_field, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(34, 34, 34))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)))
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(insertBtn)
                    .addComponent(readBtn))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(delBtn, javax.swing.GroupLayout.PREFERRED_SIZE, 23, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(nextBtn)
                    .addComponent(updateBtn))
                .addGap(59, 59, 59))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void updateBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_updateBtnActionPerformed
        // TODO add your handling code here:
        DefaultTableModel model = (DefaultTableModel)poTable.getModel();
        int selectedIndex = poTable.getSelectedRow();
        
        String date;
        int supnr, ponr;
        
        ponr = Integer.valueOf(ponr_field.getText());
        date = pod_field.getText();
        supnr = Integer.valueOf(supnr_field.getText());
        
        try {
            
            Class.forName(driver);
            con = DriverManager.getConnection(url, user, password);
            
            pst = con.prepareStatement("update PURCHASE_ORDER set PODATE =? ,  SUPNR=? where PONR = ?");
            
            //pst.setInt(1, supnr);
            //pst.setInt(2, prodnr);
            pst.setString(1, date);
            pst.setInt(2, supnr);
            pst.setInt(3, ponr);
            
            pst.executeUpdate();
            JOptionPane.showMessageDialog(this,"RECORD UPDATED!");
            
            ponr_field.setText("");
            pod_field.setText("");
            supnr_field.setText("");
            ponr_field.requestFocus();
            tableupdate();
            
        } catch (ClassNotFoundException | SQLException ex) {
            
            Logger.getLogger(PurchaseOrder.class.getName()).log(Level.SEVERE, null, ex);
            JOptionPane.showMessageDialog(this, ex);
            
        }
    }//GEN-LAST:event_updateBtnActionPerformed

    private void insertBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_insertBtnActionPerformed
        // TODO add your handling code here:
        String date;
        int supnr, ponr;
        
        ponr = Integer.valueOf(ponr_field.getText());
        date = pod_field.getText();
        supnr =  Integer.valueOf(supnr_field.getText());
        
        try {
            // TODO add your handling code here:
            Class.forName(driver);
            con = DriverManager.getConnection(url, user, password);
            pst = con.prepareStatement("insert into PURCHASE_ORDER (PONR,PODATE,SUPNR)values(?,?,?)");
            pst.setInt(1, ponr);
            pst.setString(2, date);
            pst.setInt(3, supnr);
            pst.executeUpdate();
            JOptionPane.showMessageDialog(this,"RECORD ADDED!");
            
            
            ponr_field.setText("");
            pod_field.setText("");
            supnr_field.setText("");
            ponr_field.requestFocus();
            tableupdate();
        } catch (Exception ex) {
            Logger.getLogger(PurchaseOrder.class.getName()).log(Level.SEVERE, null, ex);
        }
        
    }//GEN-LAST:event_insertBtnActionPerformed

    private void poTableMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_poTableMouseClicked
        // TODO add your handling code here:
        DefaultTableModel model = (DefaultTableModel) poTable.getModel();
        int selectedIndex = poTable.getSelectedRow();
        
        ponr_field.setText(model.getValueAt(selectedIndex,0).toString());
        pod_field.setText(model.getValueAt(selectedIndex,1).toString());
        supnr_field.setText(model.getValueAt(selectedIndex,2).toString());
    }//GEN-LAST:event_poTableMouseClicked

    private void delBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_delBtnActionPerformed
        // TODO add your handling code here:
        DefaultTableModel model = (DefaultTableModel)poTable.getModel();
        int selectedIndex = poTable.getSelectedRow();
        
        int ponr = Integer.parseInt(model.getValueAt(selectedIndex, 0).toString());
        
        int dialogresult = JOptionPane.showConfirmDialog(null,"Do you want to delete the record","WARNING!",JOptionPane.YES_NO_OPTION);
        
        if (dialogresult ==JOptionPane.YES_OPTION){
            
            try {
                
                Class.forName(driver);
                 con= DriverManager.getConnection(url, user, password);
            
            pst = con.prepareStatement("delete from PURCHASE_ORDER where PONR=?");
            
            pst.setInt(1, ponr);
            pst.executeUpdate();
            JOptionPane.showMessageDialog(this,"RECORD DELETED!");
            tableupdate();
             ponr_field.setText("");
            pod_field.setText("");
            supnr_field.setText("");
            ponr_field.requestFocus();
            } 
            
            catch (ClassNotFoundException | SQLException ex) {
                
                Logger.getLogger(PurchaseOrder.class.getName()).log(Level.SEVERE, null, ex);
            }
    }//GEN-LAST:event_delBtnActionPerformed

    private void nextBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_nextBtnActionPerformed
        // TODO add your handling code here:
        PurchaseOrderDetails pod = new PurchaseOrderDetails();
        pod.setVisible(true);
        dispose();
    }//GEN-LAST:event_nextBtnActionPerformed

    private void readBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_readBtnActionPerformed
        try {
            // TODO add your handling code here:
            tableupdate();
        } catch (SQLException ex) {
            Logger.getLogger(PurchaseOrder.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_readBtnActionPerformed

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
            java.util.logging.Logger.getLogger(PurchaseOrder.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(PurchaseOrder.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(PurchaseOrder.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(PurchaseOrder.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new PurchaseOrder().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton delBtn;
    private javax.swing.JButton insertBtn;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JButton nextBtn;
    private javax.swing.JTable poTable;
    private javax.swing.JTextField pod_field;
    private javax.swing.JTextField ponr_field;
    private javax.swing.JButton readBtn;
    private javax.swing.JTextField supnr_field;
    private javax.swing.JButton updateBtn;
    // End of variables declaration//GEN-END:variables
}