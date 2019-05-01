    /*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package models;

import baitaplon.State;
import entities.DTOCategory;
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
public class DAOCategory {
    Database db;
    Connection conn;

    public DAOCategory() {
        this.db = new Database();
        conn = db.getConnection();
    }
    
    
    // Cach 2
    public int Add(DTOCategory c){
        int n = 0;
        String query = "insert into categories(name) values (?)";
        PreparedStatement pre;
        try {
            pre = conn.prepareStatement(query);
            
            pre.setString(1, c.getName());
            
            n = pre.executeUpdate();
        } catch (SQLException ex) {
            Logger.getLogger(DAOProduct.class.getName()).log(Level.SEVERE, null, ex);
        }
        return n;
    }
    
    public int Update(DTOCategory c) {
        int n = 0;
        
        String query = "UPDATE categories SET name = ? WHERE id = ?";
        PreparedStatement pre;
        
        try {
            pre = conn.prepareStatement(query);
            
            pre.setString(1, c.getName());
            pre.setInt(2, c.getId());

            
            n = pre.executeUpdate();
        } catch (SQLException ex) {
            Logger.getLogger(DAOProduct.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        return n;
    }
    
    public int ToggleStatus(DTOCategory c){
        int n = 0;
                
        String query = "UPDATE categories SET status = 1 - status WHERE id = ?";
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
    
    public ArrayList<DTOCategory> List() {
        String query = "";
        ArrayList<DTOCategory> categories = new ArrayList<DTOCategory>();

        query = String.format("SELECT * FROM categories WHERE status = 1");
        
        ResultSet rs = db.getData(query);
        try {
        
            while(rs.next()){
                //DTOCategory cat = new DTOCategory(rs.getInt("catID"), rs.getInt("catStatus"), rs.getString("catName"));
                DTOCategory c = new DTOCategory(rs.getInt("id"), rs.getInt("status"), rs.getString("name"));
                categories.add(c);
            }
        } catch (SQLException ex) {
            Logger.getLogger(DAOProduct.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        return categories;
    }
    
    public DTOCategory Get(int id) {
        String query = String.format("SELECT * FROM categories WHERE id = %d", id);
        System.out.println(query);
        
        ResultSet rs = db.getData(query);
        
        try {
            if(rs.next()){
                //DTOCategory cat = new DTOCategory(rs.getInt("catID"), rs.getInt("catStatus"), rs.getString("catName"));
                DTOCategory category = new DTOCategory(rs.getInt("id"), rs.getInt("status"), rs.getString("name"));
                return category;
            }
        } catch (SQLException ex) {
            Logger.getLogger(DAOProduct.class.getName()).log(Level.SEVERE, null, ex);
            return null;
        }
        
        return null;
    }
}
