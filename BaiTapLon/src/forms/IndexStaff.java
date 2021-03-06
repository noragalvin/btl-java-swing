/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package forms;

import baitaplon.Helpers;
import baitaplon.State;
import controllers.BULCategory;
import controllers.BULProduct;
import entities.DTOCategory;
import entities.DTOProduct;
import java.awt.Color;
import java.awt.Component;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.GridLayout;
import java.awt.List;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.imageio.ImageIO;
import javax.swing.BorderFactory;
import javax.swing.BoxLayout;
import javax.swing.ImageIcon;
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
        products = bulProduct.getProducts(this.filter, limit, offset);
        initProducts(products);
        

        lblName.setText("Hi, " + State.currentUser.getName());
        pnContent.setBorder(new EmptyBorder(10, 10, 10, 10));
        
        //pnContainer.setBackground(new Color(52, 152, 219));
        pnContainer.setBackground(Helpers.mainBgColor);
        /* Background tab */
        pnTab.setBackground(Helpers.mainBgColor);
        pnCurrentUser.setBackground(Helpers.mainBgColor);
        pnCategories.setBackground(Helpers.mainBgColor);
        /* End background tab */
        
        /* Background content */
        pnContent.setBackground(Helpers.mainBgColor);
        pnSearch.setBackground(Helpers.mainBgColor);
        pnList.setBackground(Helpers.mainBgColor);
        pnPagination.setBackground(Helpers.mainBgColor);
        /* End background content */
        
        lblName.setForeground(Helpers.mainFgColor);
        lblFilter.setForeground(Helpers.mainFgColor);
        lblFilterKey.setForeground(Helpers.mainFgColor);
        
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
        btnLogout = new javax.swing.JButton();
        pnContent = new javax.swing.JPanel();
        pnSearch = new javax.swing.JPanel();
        txtSearch = new javax.swing.JTextField();
        btnSearch = new javax.swing.JButton();
        lblFilterKey = new javax.swing.JLabel();
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
            .addGap(0, 468, Short.MAX_VALUE)
        );

        btnLogout.setBackground(new java.awt.Color(230, 126, 34));
        btnLogout.setForeground(new java.awt.Color(236, 240, 241));
        btnLogout.setText("Logout");
        btnLogout.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btnLogoutMouseClicked(evt);
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
                .addComponent(btnLogout)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        pnTabLayout.setVerticalGroup(
            pnTabLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, pnTabLayout.createSequentialGroup()
                .addComponent(pnCurrentUser, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(pnCategories, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGap(18, 18, 18)
                .addComponent(btnLogout)
                .addContainerGap())
        );

        btnSearch.setBackground(new java.awt.Color(230, 126, 34));
        btnSearch.setForeground(new java.awt.Color(236, 240, 241));
        btnSearch.setText("Search");
        btnSearch.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btnSearchMouseClicked(evt);
            }
        });

        lblFilterKey.setText("Filter:");

        lblFilter.setText("All");

        btnOrder.setBackground(new java.awt.Color(230, 126, 34));
        btnOrder.setForeground(new java.awt.Color(236, 240, 241));
        btnOrder.setText("Order");
        btnOrder.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btnOrderMouseClicked(evt);
            }
        });

        btnClear.setBackground(new java.awt.Color(230, 126, 34));
        btnClear.setForeground(new java.awt.Color(236, 240, 241));
        btnClear.setText("Reset");
        btnClear.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btnClearMouseClicked(evt);
            }
        });

        javax.swing.GroupLayout pnSearchLayout = new javax.swing.GroupLayout(pnSearch);
        pnSearch.setLayout(pnSearchLayout);
        pnSearchLayout.setHorizontalGroup(
            pnSearchLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnSearchLayout.createSequentialGroup()
                .addComponent(lblFilterKey)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(lblFilter)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 217, Short.MAX_VALUE)
                .addComponent(txtSearch, javax.swing.GroupLayout.PREFERRED_SIZE, 238, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(btnSearch)
                .addGap(209, 209, 209)
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
                    .addComponent(lblFilterKey)
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

    private void btnLogoutMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnLogoutMouseClicked
        // TODO add your handling code here:
        dispose();
        State.ResetAll();
        (new Login()).setVisible(true);
    }//GEN-LAST:event_btnLogoutMouseClicked

    private void btnOrderMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnOrderMouseClicked
        (new EnterCustomer()).setVisible(true);
    }//GEN-LAST:event_btnOrderMouseClicked

    private void btnClearMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnClearMouseClicked
        State.ResetProduct();
    }//GEN-LAST:event_btnClearMouseClicked

    private void btnSearchMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnSearchMouseClicked
        products = bulProduct.smartSearch(txtSearch.getText());
        System.out.println(products.get(0));
        initProducts(products);
    }//GEN-LAST:event_btnSearchMouseClicked

    private final void initProducts(ArrayList<DTOProduct> products)
    {
        int rows = 2;
        int columns = 3;
        
        lblFilter.setText(this.filter);
        //products = bulProduct.getProducts(this.filter, limit, offset);
        pnList.removeAll();
        pnList.revalidate();
        pnList.repaint();
        pnList.setLayout(new GridLayout(rows, columns, -1, -1));
        
        for(int i = 0; i < products.size(); i++)
        {
            final DTOProduct product = products.get(i);
            final JPanel p = new JPanel();
            p.setLayout(new GridLayout(3, 1));
            //p.setName("product-"+i);
            //p.setBackground(color[i]);
            p.setBorder(BorderFactory.createLineBorder(Helpers.mainBordercolor));
            
            JLabel lbl = new JLabel(products.get(i).getName());
            lbl.setLayout(null);
            lbl.setFont(new Font("Serif", Font.BOLD, 18));
            lbl.setHorizontalAlignment(JLabel.CENTER);
            lbl.setForeground(Helpers.mainFgColor);
            p.add(lbl); 
            
            
            JLabel labelImage = new JLabel();
            String image_url = String.format("./src/forms/pictures/%s/%s", products.get(i).getCatName() ,products.get(i).getImage());
            labelImage.setHorizontalAlignment(JLabel.CENTER);
            p.add(labelImage);
            try {
                BufferedImage image = ImageIO.read(new File(image_url));
                ImageIcon icon = new ImageIcon(image.getScaledInstance(200, 75, image.SCALE_SMOOTH));
                labelImage.setIcon(icon);
            } catch (IOException ex) {
                Logger.getLogger(IndexStaff.class.getName()).log(Level.SEVERE, null, ex);
            }
            
            p.addMouseListener(new MouseAdapter() {
                public void mouseClicked(MouseEvent ev){
                    //System.out.println(((JPanel)ev.getSource()).getName());
                    
                    (new ProductDetails(product)).setVisible(true);
                }
            });
            
            JLabel labelPrice = new JLabel("Price: " + products.get(i).getPrice());
            labelPrice.setHorizontalAlignment(JLabel.CENTER);
            labelPrice.setForeground(Helpers.mainFgColor);
            p.add(labelPrice);
            p.setBackground(new Color(241, 196, 15));
            pnList.add(p);
            
            if(products.size() < this.limit && i == products.size()-1){
                //System.out.println("out");
                for(int j = 0; j < this.limit - products.size(); j++){
                    //System.out.println("added");
                    JPanel pn = new JPanel();
                    pn.setBackground(Helpers.mainBgColor);
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
                lbl.setForeground(Helpers.mainFgColor);
                lbl.setBorder(BorderFactory.createLineBorder(Helpers.mainBordercolor));
                lbl.setBounds(x, 10, 20, 20);
                x = x + 25;
                
                lbl.addMouseListener(new MouseAdapter() {
                    public void mouseClicked(MouseEvent ev){
                        int currentPage = Integer.parseInt(((JLabel)ev.getSource()).getName());
                        
                        offset = (currentPage - 1) * limit;
                        products = bulProduct.getProducts(filter, limit, offset);
                        initProducts(products);
                        
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
        pnCategories.removeAll();
        pnCategories.setLayout(new GridLayout(rows, columns, -1, -1));
        
        // Add tab all
        JLabel lblAll = new JLabel("All", JLabel.CENTER);
        lblAll.setForeground(Helpers.mainFgColor);
        if(filter.equals("All") == true){
            lblAll.setBackground(Helpers.subBgColor);
        } else {
            lblAll.setBackground(Helpers.mainBgColor);
        }
        lblAll.setOpaque(true);
        lblAll.setBorder(BorderFactory.createLineBorder(Helpers.mainBordercolor));
        lblAll.setPreferredSize(new Dimension(100, 50));
        lblAll.addMouseListener(new MouseAdapter() {
            public void mouseClicked(MouseEvent ev){
                filter = "All";
                products = bulProduct.getProducts(filter, limit, offset);
                initProducts(products);
                initCategories();
            }
        });
        pnCategories.add(lblAll);
        
        for(int i = 0; i < categories.size(); i++)
        {
            final DTOCategory category = categories.get(i);
            final JLabel l = new JLabel(categories.get(i).getName(), JLabel.CENTER);
            l.setForeground(Helpers.mainFgColor);
            l.setBorder(BorderFactory.createLineBorder(Helpers.mainBordercolor));
            l.setPreferredSize(new Dimension(100, 50));
            l.setBackground(Helpers.mainBgColor);
            if(filter.equals(category.getName()) == true){
                l.setBackground(Helpers.subBgColor);
            } else {
                l.setBackground(Helpers.mainBgColor);
            }
            l.setOpaque(true);
            l.addMouseListener(new MouseAdapter() {
                public void mouseClicked(MouseEvent ev){
                    filter = category.getName();
                    products = bulProduct.getProducts(filter, limit, offset);
                    initProducts(products);
                    initCategories();
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
    private javax.swing.JButton btnLogout;
    private javax.swing.JButton btnOrder;
    private javax.swing.JButton btnSearch;
    private javax.swing.JLabel lblFilter;
    private javax.swing.JLabel lblFilterKey;
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
