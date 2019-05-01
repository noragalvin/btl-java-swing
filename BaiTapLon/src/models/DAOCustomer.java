/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package models;

import baitaplon.State;
import entities.DTOCategory;
import entities.DTOCustomer;
import entities.DTOProduct;
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
public class DAOCustomer {
    Database db;
    Connection conn;

    public DAOCustomer() {
        this.db = State.db;
        conn = db.getConnection();
    }
    
    public DTOCustomer getCustomer(String phone) {
        String query = String.format("SELECT * FROM customers WHERE phone = '%s'", phone);
        
        ResultSet rs = db.getData(query);
        
        try {
            if(rs.next()){
                //DTOCategory cat = new DTOCategory(rs.getInt("catID"), rs.getInt("catStatus"), rs.getString("catName"));

                DTOCustomer customer = new DTOCustomer(rs.getInt("id"), rs.getString("name"), rs.getString("address"), rs.getString("phone"));
                return customer;
            }
        } catch (SQLException ex) {
            Logger.getLogger(DAOProduct.class.getName()).log(Level.SEVERE, null, ex);
            return null;
        }
        
        return null;
    }
    
    public int Insert(DTOCustomer c){
        int n = 0;
        String query = String.format("insert into customers(name, address, phone) values (N'%s', N'%s', '%s')", c.getName(), c.getAddress(), c.getPhone());
        try {
            Statement state = conn.createStatement();
            n = state.executeUpdate(query);
            return n;
        } catch (SQLException ex) {
            Logger.getLogger(DAOProduct.class.getName()).log(Level.SEVERE, null, ex);
            return n;
        }
        
    }
    
    public int Add(DTOCustomer c){
        int n = 0;
        String query = "insert into customers(name, phone, address) values (?, ?, ?)";
        PreparedStatement pre;
        try {
            pre = conn.prepareStatement(query);
            
            pre.setString(1, c.getName());
            pre.setString(2, c.getPhone());
            pre.setString(3, c.getAddress());

            
            n = pre.executeUpdate();
        } catch (SQLException ex) {
            Logger.getLogger(DAOProduct.class.getName()).log(Level.SEVERE, null, ex);
        }
        return n;
    }
    
    public int Update(DTOCustomer c) {
        int n = 0;
        
        String query = "UPDATE customers SET name = ?, phone = ?, address = ? WHERE id = ?";
        PreparedStatement pre;
        
        try {
            pre = conn.prepareStatement(query);
            
            pre.setString(1, c.getName());
            pre.setString(2, c.getPhone());
            pre.setString(3, c.getAddress());
            pre.setInt(4, c.getId());

            
            n = pre.executeUpdate();
        } catch (SQLException ex) {
            Logger.getLogger(DAOProduct.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        return n;
    }
    
    public int ToggleStatus(DTOCustomer c){
        int n = 0;
                
        String query = "UPDATE customers SET status = 1 - status WHERE id = ?";
        PreparedStatement pre;
        
        try {
            pre = conn.prepareStatement(query);
            
            pre.setInt(1, c.getId());
            
            n = pre.executeUpdate();
        } catch (SQLException ex) {
            Logger.getLogger(DAOProduct.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        return n;
    }
    
    public ArrayList<DTOCustomer> List() {
        String query = "";
        ArrayList<DTOCustomer> categories = new ArrayList<DTOCustomer>();

        query = String.format("SELECT * FROM customers WHERE status = 1");
        
        ResultSet rs = db.getData(query);
        
        try {
            while(rs.next()){
                //DTOCategory cat = new DTOCategory(rs.getInt("catID"), rs.getInt("catStatus"), rs.getString("catName"));
                DTOCustomer c = new DTOCustomer(rs.getInt("id"), rs.getString("name"), rs.getString("phone"), rs.getString("address"));
                categories.add(c);
            }
        } catch (SQLException ex) {
            Logger.getLogger(DAOProduct.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        return categories;
    }
    
    public ArrayList<DTOCustomer> List(int offset, int limit) {
        String query = "";
        ArrayList<DTOCustomer> categories = new ArrayList<DTOCustomer>();

        query = String.format("SELECT * FROM customers "
                        + "WHERE status = 1 "
                        + "ORDER BY id "
                        + "OFFSET %d ROWS "
                        + "FETCH NEXT %d ROWS ONLY;", offset, limit);
        
        ResultSet rs = db.getData(query);
        
        try {
            while(rs.next()){
                //DTOCategory cat = new DTOCategory(rs.getInt("catID"), rs.getInt("catStatus"), rs.getString("catName"));
                DTOCustomer c = new DTOCustomer(rs.getInt("id"), rs.getString("name"), rs.getString("address"), rs.getString("phone"));
                categories.add(c);
            }
        } catch (SQLException ex) {
            Logger.getLogger(DAOProduct.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        return categories;
    }
    
    public DTOCustomer Get(int id) {
        String query = String.format("SELECT * FROM customers WHERE id = %d", id);
        System.out.println(query);
        
        ResultSet rs = db.getData(query);
        
        try {
            if(rs.next()){
                //DTOCategory cat = new DTOCategory(rs.getInt("catID"), rs.getInt("catStatus"), rs.getString("catName"));
                DTOCustomer c = new DTOCustomer(rs.getInt("id"), rs.getString("name"), rs.getString("phone"), rs.getString("address"));
                return c;
            }
        } catch (SQLException ex) {
            Logger.getLogger(DAOProduct.class.getName()).log(Level.SEVERE, null, ex);
            return null;
        }
        
        return null;
    }
    
    
}
