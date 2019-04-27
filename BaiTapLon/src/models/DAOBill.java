/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package models;

import baitaplon.State;
import entities.DTOBill;
import entities.DTOProduct;
import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author aboyb
 */
public class DAOBill {
    Database db;
    Connection conn;

    public DAOBill() {
        this.db = State.db;
        conn = db.getConnection();
    }

    
    public int Insert(DTOBill b){
        int n = 0;
        String query = "insert into bills(staff_id, customer_id, voucher_id, total_prices, discount_prices, created_at) values (?, ?, ?, ?, ?, ?)";
        System.out.println(query);
        System.out.println(b);
        PreparedStatement pre;
        try {
            pre = conn.prepareStatement(query);
            
            pre.setInt(1, b.getStaff_id());
            pre.setInt(2, b.getCustomer_id());
            if(b.getVoucher_id() != 0) {
                pre.setInt(3, b.getVoucher_id());
            } else {
                pre.setNull(3, java.sql.Types.VARCHAR);
            }
            
            pre.setDouble(4, b.getTotal_prices());
            pre.setDouble(5, b.getDiscount_prices());
            // create a java calendar instance
            Calendar calendar = Calendar.getInstance();

            // get a java date (java.util.Date) from the Calendar instance.
            // this java date will represent the current date, or "now".
            java.util.Date currentDate = calendar.getTime();

            // now, create a java.sql.Date from the java.util.Date
            java.sql.Date date = new java.sql.Date(currentDate.getTime());
            pre.setDate(6, date);
            System.out.println(pre);
            
            n = pre.executeUpdate();
        } catch (SQLException ex) {
            Logger.getLogger(DAOProduct.class.getName()).log(Level.SEVERE, null, ex);
        }
        return n;
    }
    
    public DTOBill GetLastRecord() {
        String query = "SELECT TOP 1 * FROM bills ORDER BY id DESC";
        
        ResultSet rs = db.getData(query);
        
        try {
            if(rs.next()){
                DTOBill b = new DTOBill(rs.getInt("id"), rs.getInt("staff_id"),
                        rs.getInt("customer_id"), rs.getInt("voucher_id"), 
                        rs.getString("created_at"), rs.getDouble("total_prices"),
                        rs.getDouble("discount_prices"));
                return b;
            }
        } catch (SQLException ex) {
            Logger.getLogger(DAOProduct.class.getName()).log(Level.SEVERE, null, ex);
            return null;
        }
        
        return null;
    }
    
    
}
