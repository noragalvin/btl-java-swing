/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package models;

import baitaplon.State;
import entities.DTOCustomer;
import entities.DTOVoucher;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author aboyb
 */
public class DAOVoucher {
    Database db;
    Connection conn;

    public DAOVoucher() {
        this.db = new Database();
        conn = db.getConnection();
    }
    
    public DTOVoucher Get(String code) {
        String query = String.format("SELECT * FROM vouchers WHERE code = '%s'", code);
        
        ResultSet rs = db.getData(query);
        
        try {
            if(rs.next()){
                DTOVoucher voucher = new DTOVoucher(rs.getInt("status"), rs.getInt("discount_percent"), rs.getInt("id"), rs.getString("code"));
                return voucher;
            }
        } catch (SQLException ex) {
            //Logger.getLogger(DAOProduct.class.getName()).log(Level.SEVERE, null, ex);
            return null;
        }
        
        return null;
    }
    
    public int Insert(DTOVoucher v){
        int n = 0;
        String query = String.format("insert into vouchers(code, discount_percent) values ('%s', %d)", v.getCode(), v.getDiscount_percent());
        try {
            Statement state = conn.createStatement();
            n = state.executeUpdate(query);
            return n;
        } catch (SQLException ex) {
            Logger.getLogger(DAOProduct.class.getName()).log(Level.SEVERE, null, ex);
            return n;
        }
        
    }
    
    public int Update(DTOVoucher v) {
        int n = 0;
        
        String query = "UPDATE vouchers SET code = ?, discount_percent = ? WHERE id = ?";
        PreparedStatement pre;
        
        try {
            pre = conn.prepareStatement(query);
            
            pre.setString(1, v.getCode());
            pre.setInt(2, v.getDiscount_percent());
            pre.setInt(3, v.getId());

            
            n = pre.executeUpdate();
        } catch (SQLException ex) {
            Logger.getLogger(DAOProduct.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        return n;
    }
    
    public int ToggleStatus(DTOVoucher v){
        int n = 0;
                
        String query = "UPDATE vouchers SET status = 1 - status WHERE id = ?";
        PreparedStatement pre;
        
        try {
            pre = conn.prepareStatement(query);
            
            pre.setInt(1, v.getId());
            
            n = pre.executeUpdate();
        } catch (SQLException ex) {
            Logger.getLogger(DAOProduct.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        return n;
    }
    
    public ArrayList<DTOVoucher> List() {
        String query = "";
        ArrayList<DTOVoucher> vouchers = new ArrayList<DTOVoucher>();

        query = String.format("SELECT * FROM vouchers WHERE status = 1");
        
        ResultSet rs = db.getData(query);
        
        try {
            while(rs.next()){
                //DTOCategory cat = new DTOCategory(rs.getInt("catID"), rs.getInt("catStatus"), rs.getString("catName"));
                DTOVoucher v = new DTOVoucher(rs.getInt("status"), rs.getInt("discount_percent"), rs.getInt("id"), rs.getString("code"));
                vouchers.add(v);
            }
        } catch (SQLException ex) {
            Logger.getLogger(DAOProduct.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        return vouchers;
    }
    
    public ArrayList<DTOVoucher> List(int offset, int limit) {
        String query = "";
        ArrayList<DTOVoucher> vouchers = new ArrayList<DTOVoucher>();

        query = String.format("SELECT * FROM vouchers "
                        + "WHERE status = 1 "
                        + "ORDER BY id "
                        + "OFFSET %d ROWS "
                        + "FETCH NEXT %d ROWS ONLY;", offset, limit);
        
        ResultSet rs = db.getData(query);
        
        try {
            while(rs.next()){
                //DTOCategory cat = new DTOCategory(rs.getInt("catID"), rs.getInt("catStatus"), rs.getString("catName"));
                DTOVoucher v = new DTOVoucher(rs.getInt("status"), rs.getInt("discount_percent"), rs.getInt("id"), rs.getString("code"));
                vouchers.add(v);
            }
        } catch (SQLException ex) {
            Logger.getLogger(DAOProduct.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        return vouchers;
    }
    
    public DTOVoucher Get(int id) {
        String query = String.format("SELECT * FROM vouchers WHERE id = %d", id);
        System.out.println(query);
        
        ResultSet rs = db.getData(query);
        
        try {
            if(rs.next()){
                //DTOCategory cat = new DTOCategory(rs.getInt("catID"), rs.getInt("catStatus"), rs.getString("catName"));
                DTOVoucher v = new DTOVoucher(rs.getInt("status"), rs.getInt("discount_percent"), rs.getInt("id"), rs.getString("code"));
                return v;
            }
        } catch (SQLException ex) {
            Logger.getLogger(DAOProduct.class.getName()).log(Level.SEVERE, null, ex);
            return null;
        }
        
        return null;
    }

}
