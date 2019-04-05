/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package models;

import entities.Category;
import entities.Product;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author aboyb
 */
public class DAOProduct {
    Database db;
    Connection conn;

    public DAOProduct(Database db) {
        this.db = db;
        conn = db.getConnection();
    }
    
    
    // Cach 1
    public int Insert(Product p){
        int n = 0;
        String query = String.format("insert into products(id, name, price, quantity, category_id) values ('%s', N'%s', %f, %d, %d)", p.getId(), p.getName(), p.getPrice(), p.getQuantity(), p.getCategory_id());
        try {
            Statement state = conn.createStatement();
            n = state.executeUpdate(query);
            return n;
        } catch (SQLException ex) {
            Logger.getLogger(DAOProduct.class.getName()).log(Level.SEVERE, null, ex);
            return n;
        }
        
    }
    
    // Cach 2
    public int Add(Product p){
        int n = 0;
        String query = "insert into products(id, name, price, quantity, category_id) values (?, ?, ?, ?, ?)";
        PreparedStatement pre;
        try {
            pre = conn.prepareStatement(query);
            
            pre.setString(1, p.getId());
            pre.setString(2, p.getName());
            pre.setDouble(3, p.getPrice());
            pre.setInt(4, p.getQuantity());
            pre.setInt(5, p.getCategory_id());
            
            n = pre.executeUpdate();
        } catch (SQLException ex) {
            Logger.getLogger(DAOProduct.class.getName()).log(Level.SEVERE, null, ex);
        }
        return n;
    }
    
    public int Update(Product p) {
        int n = 0;
        
        String query = "UPDATE Product SET name = ?, price = ?, quantity = ?, category_id = ? WHERE id = ?";
        PreparedStatement pre;
        
        try {
            pre = conn.prepareStatement(query);
            
            pre.setString(1, p.getName());
            pre.setDouble(2, p.getPrice());
            pre.setInt(3, p.getQuantity());
            pre.setInt(4, p.getCategory_id());
            pre.setString(5, p.getId());
            
            n = pre.executeUpdate();
        } catch (SQLException ex) {
            Logger.getLogger(DAOProduct.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        return n;
    }
    
    public int ToggleStatus(Product p){
        int n = 0;
        
        // Toggle 1 to 0 and 0 to 1
        p.setStatus(1 - p.getStatus());
        
        String query = "UPDATE Product SET status = ? WHERE id = ?";
        PreparedStatement pre;
        
        try {
            pre = conn.prepareStatement(query);
            
            pre.setInt(1, p.getStatus());
            pre.setString(2, p.getId());
            
            n = pre.executeUpdate();
        } catch (SQLException ex) {
            Logger.getLogger(DAOProduct.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        return n;
    }
    
    public void List() {
        String query = "SELECT products.*, categories.id as catID, categories.name as catName, categories.status as catStatus FROM products INNER JOIN categories ON products.category_id = categories.id";
        ResultSet rs = db.getData(query);
        
        try {
            while(rs.next()){
                Category cat = new Category(rs.getInt("catID"), rs.getInt("catStatus"), rs.getString("catName"));
                Product p = new Product(rs.getString("id"), rs.getInt("quantity"), rs.getInt("status"), rs.getInt("category_id"), rs.getString("name"), rs.getDouble("price"));
                System.out.println(cat);
                System.out.println(p);
            }
        } catch (SQLException ex) {
            Logger.getLogger(DAOProduct.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    
    public static void main(String[] args) {
        Database db = new Database();
        DAOProduct daoProduct = new DAOProduct(db);
        daoProduct.List();
    }
    
    
    
}