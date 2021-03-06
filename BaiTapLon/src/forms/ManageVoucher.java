/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package forms;

import baitaplon.Helpers;
import controllers.BULVoucher;
import entities.DTOCustomer;
import entities.DTOVoucher;
import java.awt.Color;
import java.awt.Image;
import java.util.ArrayList;
import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author aboyb
 */
public class ManageVoucher extends javax.swing.JFrame {
    BULVoucher bulVoucher = new BULVoucher();
    ArrayList<DTOVoucher> vouchers;
    int limit = 5;
    int offset = 0;
    int currentPage = 1;
    /**
     * Creates new form ManageVoucher
     */
    public ManageVoucher() {
        initComponents();
        setLocationRelativeTo(null);
        
        loadData();
        initIconLabel();
        
        getContentPane().setBackground(new Color(241, 196, 15));
        lblHeader.setForeground(new Color(52, 73, 94));
        lblID.setForeground(new Color(52, 73, 94));
        lblCode.setForeground(new Color(52, 73, 94));
        lblPercent.setForeground(new Color(52, 73, 94));
        lblCurrentPage.setForeground(new Color(52, 73, 94));
    }
    
    public void initIconLabel(){ 
        ImageIcon imageIcon = new ImageIcon(new ImageIcon("./src/images/back.png").getImage().getScaledInstance(40, 40, Image.SCALE_DEFAULT));
        //System.out.println(Paths.get("").toAbsolutePath().toString());
        lblBack.setIcon(imageIcon);
        //lblBack.setText("Back");
        lblBack.setVerticalTextPosition(JLabel.CENTER);
        lblBack.setHorizontalTextPosition(JLabel.RIGHT);
    }
    
    public void loadData() {
        lblCurrentPage.setText(Integer.toString(this.currentPage));
        vouchers = bulVoucher.getVouchers(offset, limit);
        DefaultTableModel dtm = (DefaultTableModel)tblData.getModel();
        dtm.setRowCount(0);
        for(DTOVoucher voucher: vouchers) {
            dtm.addRow(new Object[] {voucher.getId(), voucher.getCode(), voucher.getDiscount_percent()});
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

        txtPercent = new javax.swing.JTextField();
        lblPercent = new javax.swing.JLabel();
        btnAdd = new javax.swing.JButton();
        btnEdit = new javax.swing.JButton();
        btnDelete = new javax.swing.JButton();
        btnSearch = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        tblData = new javax.swing.JTable();
        lblHeader = new javax.swing.JLabel();
        txtCode = new javax.swing.JTextField();
        lblCode = new javax.swing.JLabel();
        lblPrevious = new javax.swing.JLabel();
        lblNext = new javax.swing.JLabel();
        lblCurrentPage = new javax.swing.JLabel();
        lblBack = new javax.swing.JLabel();
        jLabel1 = new javax.swing.JLabel();
        lblID = new javax.swing.JLabel();
        txtID = new javax.swing.JTextField();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        lblPercent.setText("Percent");

        btnAdd.setText("Add");
        btnAdd.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btnAddMouseClicked(evt);
            }
        });

        btnEdit.setText("Edit");
        btnEdit.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btnEditMouseClicked(evt);
            }
        });

        btnDelete.setText("Delete");
        btnDelete.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btnDeleteMouseClicked(evt);
            }
        });

        btnSearch.setText("Search");
        btnSearch.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btnSearchMouseClicked(evt);
            }
        });

        tblData.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null}
            },
            new String [] {
                "ID", "Code", "Percent"
            }
        ));
        tblData.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tblDataMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(tblData);

        lblHeader.setFont(new java.awt.Font("Tahoma", 0, 24)); // NOI18N
        lblHeader.setText("Voucher Manager");

        txtCode.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtCodeActionPerformed(evt);
            }
        });

        lblCode.setText("Code");

        lblPrevious.setText(" < ");
        lblPrevious.setBorder(javax.swing.BorderFactory.createEtchedBorder());
        lblPrevious.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                lblPreviousMouseClicked(evt);
            }
        });

        lblNext.setText(" > ");
        lblNext.setBorder(javax.swing.BorderFactory.createEtchedBorder());
        lblNext.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                lblNextMouseClicked(evt);
            }
        });

        lblCurrentPage.setText("1");

        lblBack.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lblBack.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                lblBackMouseClicked(evt);
            }
        });

        jLabel1.setText("%");

        lblID.setText("ID");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(lblBack, javax.swing.GroupLayout.PREFERRED_SIZE, 45, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(154, 154, 154)
                .addComponent(lblHeader, javax.swing.GroupLayout.PREFERRED_SIZE, 230, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addGap(0, 34, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(lblPrevious)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(lblCurrentPage)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(lblNext))
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                            .addComponent(lblID)
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                            .addComponent(txtID, javax.swing.GroupLayout.PREFERRED_SIZE, 53, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGap(43, 43, 43)
                            .addComponent(lblCode)
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                            .addComponent(txtCode, javax.swing.GroupLayout.PREFERRED_SIZE, 75, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGap(36, 36, 36)
                            .addComponent(lblPercent)
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                            .addComponent(txtPercent, javax.swing.GroupLayout.PREFERRED_SIZE, 26, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                            .addComponent(jLabel1)
                            .addGap(131, 131, 131))
                        .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                            .addComponent(btnAdd)
                            .addGap(55, 55, 55)
                            .addComponent(btnEdit)
                            .addGap(51, 51, 51)
                            .addComponent(btnDelete)
                            .addGap(62, 62, 62)
                            .addComponent(btnSearch)
                            .addGap(108, 108, 108))
                        .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                            .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 577, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGap(28, 28, 28)))))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(lblHeader)
                        .addGap(30, 30, 30)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(txtCode, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(lblCode)
                            .addComponent(lblPercent)
                            .addComponent(txtPercent, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel1)
                            .addComponent(lblID)
                            .addComponent(txtID, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(37, 37, 37)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(btnAdd)
                            .addComponent(btnEdit)
                            .addComponent(btnDelete)
                            .addComponent(btnSearch)))
                    .addComponent(lblBack, javax.swing.GroupLayout.PREFERRED_SIZE, 38, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(19, 19, 19)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblPrevious)
                    .addComponent(lblCurrentPage)
                    .addComponent(lblNext))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 322, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnAddMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnAddMouseClicked
        String code = txtCode.getText();
        int percent = Integer.parseInt(txtPercent.getText());
        DTOVoucher v = new DTOVoucher(code, percent);
        int result = bulVoucher.Add(v);
        if(result > 0) {
            Helpers.MessageBox("Success", "Add successfully", "success");
            loadData();
        } else {
            Helpers.MessageBox("False", "Opps! Something went wrong", "error");
        }
    }//GEN-LAST:event_btnAddMouseClicked

    private void btnEditMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnEditMouseClicked
        int id = Integer.parseInt(txtID.getText());
        String code = txtCode.getText();
        int percent = Integer.parseInt(txtPercent.getText());

        DTOVoucher v = new DTOVoucher(id, code, percent);
        int result = bulVoucher.Update(v);
        if(result > 0) {
            Helpers.MessageBox("Success", "Edit successfully", "success");
            loadData();
        } else {
            Helpers.MessageBox("False", "Opps! Something went wrong", "error");
        }
    }//GEN-LAST:event_btnEditMouseClicked

    private void btnDeleteMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnDeleteMouseClicked
        int id = Integer.parseInt(txtID.getText());
        DTOVoucher v = new DTOVoucher(id);
        int result = bulVoucher.ToggleStatus(v);
        if(result > 0) {
            Helpers.MessageBox("Success", "Delete successfully", "success");
            loadData();
        } else {
            Helpers.MessageBox("False", "Opps! Something went wrong", "error");
        }
    }//GEN-LAST:event_btnDeleteMouseClicked

    private void btnSearchMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnSearchMouseClicked
        int id = Integer.parseInt(txtID.getText());
        DTOVoucher v = bulVoucher.Get(id);
        DefaultTableModel dtm = (DefaultTableModel)tblData.getModel();
        dtm.setRowCount(0);
        dtm.addRow(new Object[] {v.getId(), v.getCode(), v.getDiscount_percent()});
    }//GEN-LAST:event_btnSearchMouseClicked

    private void tblDataMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tblDataMouseClicked
        // get the model from the jtable
        DefaultTableModel model = (DefaultTableModel)tblData.getModel();

        // get the selected row index
        int selectedRowIndex = tblData.getSelectedRow();

        // set the selected row data into jtextfields
        txtID.setText(model.getValueAt(selectedRowIndex, 0).toString());
        txtCode.setText(model.getValueAt(selectedRowIndex, 1).toString());
        txtPercent.setText(model.getValueAt(selectedRowIndex, 2).toString());
    }//GEN-LAST:event_tblDataMouseClicked

    private void txtCodeActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtCodeActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtCodeActionPerformed

    private void lblPreviousMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lblPreviousMouseClicked
        this.currentPage--;
        if(this.currentPage <= 0) {
            this.currentPage++;
            Helpers.MessageBox("Warning", "Out of range pagination pages", "error");
        } else {
            offset = (currentPage - 1) * limit;
            loadData();
        }
        
    }//GEN-LAST:event_lblPreviousMouseClicked

    private void lblNextMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lblNextMouseClicked
        this.currentPage++;
        System.out.println(this.currentPage);
        offset = (currentPage - 1) * limit;
        loadData();
    }//GEN-LAST:event_lblNextMouseClicked

    private void lblBackMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lblBackMouseClicked
        this.dispose();
        (new IndexAdmin()).setVisible(true);
    }//GEN-LAST:event_lblBackMouseClicked

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
            java.util.logging.Logger.getLogger(ManageVoucher.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(ManageVoucher.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(ManageVoucher.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(ManageVoucher.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new ManageVoucher().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnAdd;
    private javax.swing.JButton btnDelete;
    private javax.swing.JButton btnEdit;
    private javax.swing.JButton btnSearch;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JLabel lblBack;
    private javax.swing.JLabel lblCode;
    private javax.swing.JLabel lblCurrentPage;
    private javax.swing.JLabel lblHeader;
    private javax.swing.JLabel lblID;
    private javax.swing.JLabel lblNext;
    private javax.swing.JLabel lblPercent;
    private javax.swing.JLabel lblPrevious;
    private javax.swing.JTable tblData;
    private javax.swing.JTextField txtCode;
    private javax.swing.JTextField txtID;
    private javax.swing.JTextField txtPercent;
    // End of variables declaration//GEN-END:variables
}
