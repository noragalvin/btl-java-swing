/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package forms;

import baitaplon.State;
import controllers.BULCategory;
import controllers.BULProduct;
import entities.DTOCategory;
import entities.DTOProduct;
import java.awt.Color;
import java.awt.Component;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.GridLayout;
import java.awt.List;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.ArrayList;
import java.util.HashMap;
import javax.swing.BorderFactory;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.SwingConstants;
import javax.swing.border.BevelBorder;
import javax.swing.border.EmptyBorder;

/**
 *
 * @author aboyb
 */
public class IndexStaff extends javax.swing.JFrame {
    private ArrayList<DTOProduct> products;
    private ArrayList<DTOCategory> categories;

    private BULProduct bulProduct = new BULProduct();
    private BULCategory bulCategory = new BULCategory();

    private final int limit = 6; //number of products per page
    private int offset = 0;
    
    private String filter = "All";

    /**
     * Creates new form Index
     */
    public IndexStaff() {
        initComponents();
        setLocationRelativeTo(null);
        initCategories();
        initProducts();
        

        lblName.setText("Hi, " + State.currentUser.getName());
        pnContent.setBorder(new EmptyBorder(10, 10, 10, 10));
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        pnContainer = new javax.swing.JPanel();
        pnTab = new javax.swing.JPanel();
        pnCurrentUser = new javax.swing.JPanel();
        lblName = new javax.swing.JLabel();
        pnCategories = new javax.swing.JPanel();
        jButton1 = new javax.swing.JButton();
        pnContent = new javax.swing.JPanel();
        pnSearch = new javax.swing.JPanel();
        txtSearch = new javax.swing.JTextField();
        btnSearch = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();
        lblFilter = new javax.swing.JLabel();
        btnOrder = new javax.swing.JButton();
        btnClear = new javax.swing.JButton();
        pnPagination = new javax.swing.JPanel();
        pnList = new javax.swing.JPanel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        pnTab.setBorder(javax.swing.BorderFactory.createEtchedBorder());

        javax.swing.GroupLayout pnCurrentUserLayout = new javax.swing.GroupLayout(pnCurrentUser);
        pnCurrentUser.setLayout(pnCurrentUserLayout);
        pnCurrentUserLayout.setHorizontalGroup(
            pnCurrentUserLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnCurrentUserLayout.createSequentialGroup()
                .addGap(40, 40, 40)
                .addComponent(lblName, javax.swing.GroupLayout.PREFERRED_SIZE, 161, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(39, Short.MAX_VALUE))
        );
        pnCurrentUserLayout.setVerticalGroup(
            pnCurrentUserLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnCurrentUserLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(lblName, javax.swing.GroupLayout.PREFERRED_SIZE, 22, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(20, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout pnCategoriesLayout = new javax.swing.GroupLayout(pnCategories);
        pnCategories.setLayout(pnCategoriesLayout);
        pnCategoriesLayout.setHorizontalGroup(
            pnCategoriesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 0, Short.MAX_VALUE)
        );
        pnCategoriesLayout.setVerticalGroup(
            pnCategoriesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 332, Short.MAX_VALUE)
        );

        jButton1.setText("Exit");
        jButton1.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jButton1MouseClicked(evt);
            }
        });

        javax.swing.GroupLayout pnTabLayout = new javax.swing.GroupLayout(pnTab);
        pnTab.setLayout(pnTabLayout);
        pnTabLayout.setHorizontalGroup(
            pnTabLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(pnCurrentUser, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(pnCategories, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(pnTabLayout.createSequentialGroup()
                .addGap(89, 89, 89)
                .addComponent(jButton1)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        pnTabLayout.setVerticalGroup(
            pnTabLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, pnTabLayout.createSequentialGroup()
                .addComponent(pnCurrentUser, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(pnCategories, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGap(18, 18, 18)
                .addComponent(jButton1)
                .addContainerGap())
        );

        btnSearch.setText("Search");

        jLabel1.setText("Filter:");

        lblFilter.setText("All");

        btnOrder.setText("Order");
        btnOrder.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btnOrderMouseClicked(evt);
            }
        });

        btnClear.setText("Reset");

        javax.swing.GroupLayout pnSearchLayout = new javax.swing.GroupLayout(pnSearch);
        pnSearch.setLayout(pnSearchLayout);
        pnSearchLayout.setHorizontalGroup(
            pnSearchLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnSearchLayout.createSequentialGroup()
                .addComponent(jLabel1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(lblFilter)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 145, Short.MAX_VALUE)
                .addComponent(txtSearch, javax.swing.GroupLayout.PREFERRED_SIZE, 238, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(btnSearch)
                .addGap(98, 98, 98)
                .addComponent(btnOrder)
                .addGap(27, 27, 27)
                .addComponent(btnClear)
                .addContainerGap())
        );
        pnSearchLayout.setVerticalGroup(
            pnSearchLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnSearchLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(pnSearchLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtSearch, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnSearch)
                    .addComponent(jLabel1)
                    .addComponent(lblFilter)
                    .addComponent(btnOrder)
                    .addComponent(btnClear))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        pnPagination.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));

        javax.swing.GroupLayout pnPaginationLayout = new javax.swing.GroupLayout(pnPagination);
        pnPagination.setLayout(pnPaginationLayout);
        pnPaginationLayout.setHorizontalGroup(
            pnPaginationLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 0, Short.MAX_VALUE)
        );
        pnPaginationLayout.setVerticalGroup(
            pnPaginationLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 43, Short.MAX_VALUE)
        );

        javax.swing.GroupLayout pnListLayout = new javax.swing.GroupLayout(pnList);
        pnList.setLayout(pnListLayout);
        pnListLayout.setHorizontalGroup(
            pnListLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 0, Short.MAX_VALUE)
        );
        pnListLayout.setVerticalGroup(
            pnListLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 0, Short.MAX_VALUE)
        );

        javax.swing.GroupLayout pnContentLayout = new javax.swing.GroupLayout(pnContent);
        pnContent.setLayout(pnContentLayout);
        pnContentLayout.setHorizontalGroup(
            pnContentLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, pnContentLayout.createSequentialGroup()
                .addGroup(pnContentLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(pnList, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(pnPagination, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(pnSearch, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
        );
        pnContentLayout.setVerticalGroup(
            pnContentLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnContentLayout.createSequentialGroup()
                .addComponent(pnSearch, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(pnList, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(pnPagination, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
        );

        javax.swing.GroupLayout pnContainerLayout = new javax.swing.GroupLayout(pnContainer);
        pnContainer.setLayout(pnContainerLayout);
        pnContainerLayout.setHorizontalGroup(
            pnContainerLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnContainerLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(pnTab, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(pnContent, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        pnContainerLayout.setVerticalGroup(
            pnContainerLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(pnTab, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(pnContent, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(pnContainer, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(pnContainer, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jButton1MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jButton1MouseClicked
        // TODO add your handling code here:
        setVisible(false);
    }//GEN-LAST:event_jButton1MouseClicked

    private void btnOrderMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnOrderMouseClicked
        (new EnterCustomer()).setVisible(true);
    }//GEN-LAST:event_btnOrderMouseClicked

    private final void initProducts()
    {
        int rows = 2;
        int columns = 3;
        
        lblFilter.setText(this.filter);
        products = bulProduct.getProducts(this.filter, limit, offset);
        System.out.println(products);
        pnList.removeAll();
        pnList.revalidate();
        pnList.repaint();
        pnList.setLayout(new GridLayout(rows, columns, -1, -1));
        
        for(int i = 0; i < products.size(); i++)
        {
            final DTOProduct product = products.get(i);
            final JPanel p = new JPanel();
            //p.setName("product-"+i);
            //p.setBackground(color[i]);
            p.setBorder(BorderFactory.createLineBorder(Color.black));
            
            JLabel lbl = new JLabel(products.get(i).getName());
            p.add(lbl);
            
            p.addMouseListener(new MouseAdapter() {
                public void mouseClicked(MouseEvent ev){
                    //System.out.println(((JPanel)ev.getSource()).getName());
                    
                    (new ProductDetails(product)).setVisible(true);
                }
            });
            pnList.add(p);
            
            if(products.size() < this.limit && i == products.size()-1){
                System.out.println("out");
                for(int j = 0; j < this.limit - products.size(); j++){
                    //System.out.println("added");
                    JPanel pn = new JPanel();
                    pnList.add(pn);
                }
            }
            
         
            //setVisible(true);
            //setDefaultCloseOperation(3);
            //setSize(400, 400);
        }
        initPagination();
    }
    
    public void initPagination(){
        bulProduct.calculatePage(lblFilter.getText());
        pnPagination.removeAll();
        pnPagination.revalidate();
        pnPagination.repaint();
        if(State.totalPages > 0){
            int x = 5;
            for(int i = 0; i < State.totalPages; i++){
                
                JLabel lbl = new JLabel(Integer.toString(i+1), SwingConstants.CENTER);
                lbl.setName(String.valueOf(i+1));
                lbl.setBorder(BorderFactory.createLineBorder(Color.black));
                lbl.setBounds(x, 10, 20, 20);
                x = x + 25;
                
                lbl.addMouseListener(new MouseAdapter() {
                    public void mouseClicked(MouseEvent ev){
                        int currentPage = Integer.parseInt(((JLabel)ev.getSource()).getName());
                        
                        offset = (currentPage - 1) * limit;
                        initProducts();
                        
                    }
                });
                
                pnPagination.add(lbl);
                pnPagination.repaint();
                
            }
        }
    }
    
    public void initCategories() {
        categories = bulCategory.getCategories();    
        System.out.println(categories);
        
        // Add 1 because we need a tab called "All"
        int rows = categories.size() + 1;
        int columns = 1;
        System.out.println(rows);
        pnCategories.setLayout(new GridLayout(rows, columns, -1, -1));
        
        // Add tab all
        JLabel lblAll = new JLabel("All", JLabel.CENTER);
        lblAll.setBorder(BorderFactory.createLineBorder(Color.black));
        lblAll.setPreferredSize(new Dimension(100, 50));
        lblAll.addMouseListener(new MouseAdapter() {
            public void mouseClicked(MouseEvent ev){
                filter = "All";
                initProducts();
            }
        });
        pnCategories.add(lblAll);
        
        for(int i = 0; i < categories.size(); i++)
        {
            final DTOCategory category = categories.get(i);
            final JLabel l = new JLabel(categories.get(i).getName(), JLabel.CENTER);
            l.setBorder(BorderFactory.createLineBorder(Color.black));
            l.setPreferredSize(new Dimension(100, 50));
            
            l.addMouseListener(new MouseAdapter() {
                public void mouseClicked(MouseEvent ev){
                    filter = category.getName();
                    initProducts();
                }
            });
            
            //pnTab.setLayout(new FlowLayout()); 
            pnCategories.add(l);
        }
    }
    
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
            java.util.logging.Logger.getLogger(IndexStaff.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(IndexStaff.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(IndexStaff.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(IndexStaff.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new IndexStaff().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnClear;
    private javax.swing.JButton btnOrder;
    private javax.swing.JButton btnSearch;
    private javax.swing.JButton jButton1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel lblFilter;
    private javax.swing.JLabel lblName;
    private javax.swing.JPanel pnCategories;
    private javax.swing.JPanel pnContainer;
    private javax.swing.JPanel pnContent;
    private javax.swing.JPanel pnCurrentUser;
    private javax.swing.JPanel pnList;
    private javax.swing.JPanel pnPagination;
    private javax.swing.JPanel pnSearch;
    private javax.swing.JPanel pnTab;
    private javax.swing.JTextField txtSearch;
    // End of variables declaration//GEN-END:variables
}
