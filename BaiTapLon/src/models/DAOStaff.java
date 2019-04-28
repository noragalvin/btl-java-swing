/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package models;

import baitaplon.State;
import entities.DTOCustomer;
import entities.DTOStaff;
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
public class DAOStaff {
    Database db;
    Connection conn;
    DTOStaff user;

    public DAOStaff() {
        this.db = State.db;
        conn = db.getConnection();
    }
    
    public DTOStaff getStaff(String username, String password) {
        String query = String.format("SELECT * FROM staffs WHERE username='%s' AND password='%s'", username, password);
        System.out.println(query);
        
        ResultSet rs = db.getData(query);
        try {
            if(rs.next()) {
                this.user = new DTOStaff(rs.getInt("id"), rs.getString("name"), rs.getString("username"), rs.getString("password"), rs.getString("type"));
            }
        } catch (SQLException ex) {
            Logger.getLogger(DAOStaff.class.getName()).log(Level.SEVERE, null, ex);
        }
        return user;
    }

    
    public int Add(DTOStaff s){
        int n = 0;
        String query = "insert into staffs(name, username, password, type) values (?, ?, ?, ?)";
        PreparedStatement pre;
        try {
            pre = conn.prepareStatement(query);
            
            pre.setString(1, s.getName());
            pre.setString(2, s.getUsername());
            pre.setString(3, s.getPassword());
            pre.setString(4, s.getType());

            
            n = pre.executeUpdate();
        } catch (SQLException ex) {
            Logger.getLogger(DAOProduct.class.getName()).log(Level.SEVERE, null, ex);
        }
        return n;
    }
    
    public int Update(DTOStaff s) {
        int n = 0;
        
        String query = "UPDATE staffs SET name = ?, username = ?, password = ?, type = ? WHERE id = ?";
        PreparedStatement pre;
        
        try {
            pre = conn.prepareStatement(query);
            
            pre.setString(1, s.getName());
            pre.setString(2, s.getUsername());
            pre.setString(3, s.getPassword());
            pre.setString(4, s.getType());
            pre.setInt(5, s.getId());

            System.out.println(pre.toString());
            n = pre.executeUpdate();
        } catch (SQLException ex) {
            Logger.getLogger(DAOProduct.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        return n;
    }
    
    public int ToggleStatus(DTOStaff s){
        int n = 0;
                
        String query = "UPDATE staffs SET status = 1 - status WHERE id = ?";
        PreparedStatement pre;
        
        try {
            pre = conn.prepareStatement(query);
            
            pre.setInt(1, s.getId());
            
            n = pre.executeUpdate();
        } catch (SQLException ex) {
            Logger.getLogger(DAOProduct.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        return n;
    }
    
    public ArrayList<DTOStaff> List() {
        String query = "";
        ArrayList<DTOStaff> staffs = new ArrayList<DTOStaff>();

        query = String.format("SELECT * FROM staffs WHERE status = 1");
        
        ResultSet rs = db.getData(query);
        
        try {
            while(rs.next()){
                //DTOCategory cat = new DTOCategory(rs.getInt("catID"), rs.getInt("catStatus"), rs.getString("catName"));
                DTOStaff s = new DTOStaff(rs.getInt("id"), rs.getString("name"), rs.getString("username"), rs.getString("password"), rs.getString("type"));
                staffs.add(s);
            }
        } catch (SQLException ex) {
            Logger.getLogger(DAOProduct.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        return staffs;
    }
    
    public ArrayList<DTOStaff> List(int offset, int limit) {
        String query = "";
        ArrayList<DTOStaff> staffs = new ArrayList<DTOStaff>();

        query = String.format("SELECT * FROM staffs "
                        + "WHERE status = 1 "
                        + "ORDER BY id "
                        + "OFFSET %d ROWS "
                        + "FETCH NEXT %d ROWS ONLY;", offset, limit);
        
        ResultSet rs = db.getData(query);
        
        try {
            while(rs.next()){
                //DTOCategory cat = new DTOCategory(rs.getInt("catID"), rs.getInt("catStatus"), rs.getString("catName"));
                DTOStaff s = new DTOStaff(rs.getInt("id"), rs.getString("name"), rs.getString("username"), rs.getString("password"), rs.getString("type"));
                staffs.add(s);
            }
        } catch (SQLException ex) {
            Logger.getLogger(DAOProduct.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        return staffs;
    }
    
    public DTOStaff Get(int id) {
        String query = String.format("SELECT * FROM staffs WHERE id = %d", id);
        System.out.println(query);
        
        ResultSet rs = db.getData(query);
        
        try {
            if(rs.next()){
                //DTOCategory cat = new DTOCategory(rs.getInt("catID"), rs.getInt("catStatus"), rs.getString("catName"));
                DTOStaff s = new DTOStaff(rs.getInt("id"), rs.getString("name"), rs.getString("username"), rs.getString("password"), rs.getString("type"));
                return s;
            }
        } catch (SQLException ex) {
            Logger.getLogger(DAOProduct.class.getName()).log(Level.SEVERE, null, ex);
            return null;
        }
        
        return null;
    }
    
    
    
}
