/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package forms;

import baitaplon.Helpers;
import baitaplon.State;
import com.itextpdf.text.*;
import com.itextpdf.text.Document;
import com.itextpdf.text.pdf.*;
import controllers.BULBill;
import controllers.BULProduct;
import controllers.BULProductBill;
import entities.DTOBill;
import entities.DTOCustomer;
import entities.DTOProduct;
import entities.DTOProductBill;
import entities.DTOVoucher;
import java.awt.BorderLayout;
import java.awt.Font;
import java.awt.Graphics2D;
import java.io.FileOutputStream;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Iterator;
import java.util.Map;
import javax.swing.JFrame;
import javax.swing.JScrollPane;
import javax.swing.JTable;


/**
 *
 * @author aboyb
 */
public class Bill extends javax.swing.JFrame {
    DTOCustomer customer;
    BULProduct bulProduct;
    BULBill bulBill;
    BULProductBill bulProductBill;
    double totalPrices = 0;
    DTOVoucher voucher;
    
    /**
     * Creates new form Bill
     */
    public Bill(DTOCustomer customer, DTOVoucher voucher) {
        initComponents();
        this.customer = customer;
        this.bulProduct = new BULProduct();
        this.bulBill = new BULBill();
        this.bulProductBill = new BULProductBill();
        this.voucher = voucher;
        
        setLocationRelativeTo(null);
        
        
        insertCustomerInfo();
        initListCurrentProducts();
    }
    
    public void initListCurrentProducts(){
        String[] headers = new String[]{"Item No:", "Name", "Quantity", "Price (VNĐ)", "Total Amount"};
        
        
        // Add 1 because table has last row to calculate total amount
        int totalOrderProducts = State.currentProducts.size() + 2;
        int columns = 5;
        String data[][] = new String[totalOrderProducts][columns];
        
        //WHILE LOOP & ITERATOR
        System.out.println("While Loop:");
        Iterator iterator = State.currentProducts.entrySet().iterator();
        
        int i = 0;
        while (iterator.hasNext()) {
            Map.Entry hm = (Map.Entry) iterator.next();
            
            // ID
            data[i][0] = (String)hm.getKey();
            // Name
            DTOProduct product = bulProduct.getAProduct((String)hm.getKey());
            if(product != null) {
                data[i][1] = product.getName();
            }
            
            // Quantity
            data[i][2] = Integer.toString((int)hm.getValue());
            
            // Price
            data[i][3] = Double.toString(product.getPrice());
            
            // Total
            double price = product.getPrice() * (int)hm.getValue();
            totalPrices += price;
            data[i][4] = Double.toString(price);
            
            //System.out.println("Key: "+hm.getKey() + " & Value: " + hm.getValue());
            i++;
        }
        
        // Total
        data[i][3] = "DISCOUNT";

        double discount = totalPrices - totalPrices * (double)(100 - voucher.getDiscount_percent())/100;
        // Total
        data[i][4] = Double.toString(discount);
        
        // Total
        data[i+1][3] = "TOTAL";

        // Total
        data[i+1][4] = Double.toString(totalPrices - discount);
        
        JTable table = new JTable(data,headers);
        table.setFont(new Font("Serif", Font.PLAIN, 14));
        table.setAutoResizeMode(JTable.AUTO_RESIZE_OFF);
        table.getColumnModel().getColumn(0).setPreferredWidth(70);
        table.getColumnModel().getColumn(1).setPreferredWidth(200);
        table.getColumnModel().getColumn(2).setPreferredWidth(70);
        table.getColumnModel().getColumn(3).setPreferredWidth(100);
        table.getColumnModel().getColumn(4).setPreferredWidth(100);
        //table.setBounds(0, 0, 1000, 1000);
        
        pnListProduct.setLayout(new BorderLayout());
        pnListProduct.add(table, BorderLayout.CENTER);
        pnListProduct.add(table.getTableHeader(), BorderLayout.NORTH);
    }
    
    public void insertCustomerInfo(){
        System.out.println(customer);
        lblName.setText(customer.getName());
        lblAddress.setText(customer.getAddress());
        lblPhone.setText(customer.getPhone());
        lblDate.setText(getCurrentDateTime());
    }
    
    public String getCurrentDateTime(){
        DateTimeFormatter dtf = DateTimeFormatter.ofPattern("yyyy/MM/dd HH:mm:ss");  
        LocalDateTime now = LocalDateTime.now();  
        return dtf.format(now);
    }
    
    public int exportToPDF() {
        //print the panel to pdf
        Rectangle pagesize = new Rectangle(602, 543);
        Document document = new Document(pagesize);
        try {
            PdfWriter writer = PdfWriter.getInstance(document, new FileOutputStream("./PDF/Bill.pdf"));
            document.open();
            PdfContentByte contentByte = writer.getDirectContent();
            PdfTemplate template = contentByte.createTemplate(602, 543);
            Graphics2D g2 = template.createGraphics(602, 543);
            pnBill.print(g2);
            g2.dispose();
            contentByte.addTemplate(template, 0, 0);
        } catch (Exception e) {
            e.printStackTrace();
            return 0;
        }
        finally{
            setVisible(false);
            if(document.isOpen()){
                document.close();
            }
            return 1;
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

        pnBill = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        pnListProduct = new javax.swing.JPanel();
        lblName = new javax.swing.JLabel();
        lblAddress = new javax.swing.JLabel();
        lblPhone = new javax.swing.JLabel();
        lblDate = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        btnPrint = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jLabel1.setFont(new java.awt.Font("Tahoma", 1, 24)); // NOI18N
        jLabel1.setText("Minh Ngoc Restaurant");

        jLabel2.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        jLabel2.setText("Bill Receipt");

        jLabel3.setText("Customer Name: ");

        jLabel4.setText("Customer Address: ");

        jLabel5.setText("Customer Phone: ");

        jLabel6.setText("Date: ");

        javax.swing.GroupLayout pnListProductLayout = new javax.swing.GroupLayout(pnListProduct);
        pnListProduct.setLayout(pnListProductLayout);
        pnListProductLayout.setHorizontalGroup(
            pnListProductLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 564, Short.MAX_VALUE)
        );
        pnListProductLayout.setVerticalGroup(
            pnListProductLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 275, Short.MAX_VALUE)
        );

        lblName.setText("jLabel7");

        lblAddress.setText("jLabel8");

        lblPhone.setText("jLabel9");

        lblDate.setText("jLabel10");

        jLabel7.setFont(new java.awt.Font("Tahoma", 3, 18)); // NOI18N
        jLabel7.setText("THANK YOU FOR YOUR BUSINESS");

        javax.swing.GroupLayout pnBillLayout = new javax.swing.GroupLayout(pnBill);
        pnBill.setLayout(pnBillLayout);
        pnBillLayout.setHorizontalGroup(
            pnBillLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnBillLayout.createSequentialGroup()
                .addGroup(pnBillLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(pnBillLayout.createSequentialGroup()
                        .addGap(20, 20, 20)
                        .addComponent(pnListProduct, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(pnBillLayout.createSequentialGroup()
                        .addGap(143, 143, 143)
                        .addComponent(jLabel7, javax.swing.GroupLayout.PREFERRED_SIZE, 314, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(18, Short.MAX_VALUE))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, pnBillLayout.createSequentialGroup()
                .addGap(0, 0, Short.MAX_VALUE)
                .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 283, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(152, 152, 152))
            .addGroup(pnBillLayout.createSequentialGroup()
                .addGroup(pnBillLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(pnBillLayout.createSequentialGroup()
                        .addGap(108, 108, 108)
                        .addGroup(pnBillLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel3)
                            .addComponent(jLabel4)
                            .addComponent(jLabel5)
                            .addComponent(jLabel6))
                        .addGap(44, 44, 44)
                        .addGroup(pnBillLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(lblDate)
                            .addComponent(lblPhone)
                            .addComponent(lblAddress)
                            .addComponent(lblName)))
                    .addGroup(pnBillLayout.createSequentialGroup()
                        .addGap(256, 256, 256)
                        .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 116, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(0, 0, Short.MAX_VALUE))
        );
        pnBillLayout.setVerticalGroup(
            pnBillLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnBillLayout.createSequentialGroup()
                .addGap(19, 19, 19)
                .addComponent(jLabel1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jLabel2)
                .addGap(18, 18, 18)
                .addGroup(pnBillLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel3)
                    .addComponent(lblName))
                .addGap(12, 12, 12)
                .addGroup(pnBillLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel4)
                    .addComponent(lblAddress))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(pnBillLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel5)
                    .addComponent(lblPhone))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(pnBillLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel6)
                    .addComponent(lblDate))
                .addGap(18, 18, 18)
                .addComponent(pnListProduct, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jLabel7)
                .addContainerGap(21, Short.MAX_VALUE))
        );

        btnPrint.setText("Print");
        btnPrint.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btnPrintMouseClicked(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(pnBill, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(layout.createSequentialGroup()
                .addGap(232, 232, 232)
                .addComponent(btnPrint, javax.swing.GroupLayout.PREFERRED_SIZE, 109, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(pnBill, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(btnPrint, javax.swing.GroupLayout.PREFERRED_SIZE, 46, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnPrintMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnPrintMouseClicked
        double discount_prices = totalPrices - totalPrices * (double)(100 - voucher.getDiscount_percent())/100;
        System.out.println("discount prices");
        System.out.println(discount_prices);
        DTOBill b = new DTOBill(State.currentUser.getId(), customer.getId(), voucher.getId(), totalPrices, discount_prices);
        int billResult = bulBill.Insert(b);
        System.out.println(billResult);
        if(billResult > 0) {
            DTOBill lastBill = bulBill.GetLastRecord();
            System.out.println("last bill");
            System.out.println(lastBill);
            Iterator iterator = State.currentProducts.entrySet().iterator();
            State.ResetProduct();

            DTOProduct product;
            while (iterator.hasNext()) {
                Map.Entry hm = (Map.Entry) iterator.next();
                product = bulProduct.getAProduct((String)hm.getKey());
                double price = product.getPrice() * (double)((Integer)hm.getValue()).intValue();
                price = price * (double)(100 - voucher.getDiscount_percent())/100;
                DTOProductBill db = new DTOProductBill(lastBill.getId(), (int)hm.getValue(), ((String)hm.getKey()).trim(), price);
                bulProductBill.Insert(db);
                //System.out.println("Key: "+hm.getKey() + " & Value: " + hm.getValue());
            }
            
            if(exportToPDF() != 0 && updateProducts() != 0) {
                Helpers.MessageBox("Success", "Print Successfully", "success");
            } else {
                Helpers.MessageBox("False", "Opps! Something went wrong", "error");
            }
        } else {
            Helpers.MessageBox("False", "Opps! Something went wrong", "error");
        }
        
        
    }//GEN-LAST:event_btnPrintMouseClicked

    
    private int updateProducts() {
        //WHILE LOOP & ITERATOR
        System.out.println("While Loop:");
        Iterator iterator = State.currentProducts.entrySet().iterator();

        while (iterator.hasNext()) {
            Map.Entry hm = (Map.Entry) iterator.next();
            
            int result = bulProduct.updateQuantity((String)hm.getKey(), (int)hm.getValue());
            if(result == 0) {
                return 0;
            }
            //System.out.println("Key: "+hm.getKey() + " & Value: " + hm.getValue());
        }
        return 1;
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnPrint;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel lblAddress;
    private javax.swing.JLabel lblDate;
    private javax.swing.JLabel lblName;
    private javax.swing.JLabel lblPhone;
    private javax.swing.JPanel pnBill;
    private javax.swing.JPanel pnListProduct;
    // End of variables declaration//GEN-END:variables
}
