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
import java.awt.List;
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
public class DAOProduct {
    Database db;
    Connection conn;

    public DAOProduct() {
        this.db = State.db;
        conn = db.getConnection();
    }
    
    
    // Cach 1
    public int Insert(DTOProduct p){
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
    public int Add(DTOProduct p){
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
    
    public int Update(DTOProduct p) {
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
    
    public int ToggleStatus(DTOProduct p){
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
    
    public ArrayList<DTOProduct> List(String filter, int limit, int offset) {
        String query = "";
        ArrayList<DTOProduct> products = new ArrayList<DTOProduct>();
        switch(filter){
            case "All":
                query = String.format("SELECT products.*, categories.id as catID, categories.name as catName, categories.status as catStatus "
                        + "FROM products INNER JOIN categories ON products.category_id = categories.id "
                        + "ORDER BY id "
                        + "OFFSET %d ROWS "
                        + "FETCH NEXT %d ROWS ONLY;", offset, limit);
                break;
            default:
                query = String.format("SELECT products.*, categories.id as catID, categories.name as catName, categories.status as catStatus "
                        + "FROM products INNER JOIN categories ON products.category_id = categories.id "
                        + "WHERE categories.name = N'%s' "
                        + "ORDER BY id "
                        + "OFFSET %d ROWS "
                        + "FETCH NEXT %d ROWS ONLY;", filter, offset, limit);
                break;
        }
        //System.out.println(query);
        ResultSet rs = db.getData(query);
        
        try {
            while(rs.next()){
                //DTOCategory cat = new DTOCategory(rs.getInt("catID"), rs.getInt("catStatus"), rs.getString("catName"));
                DTOProduct p = new DTOProduct(rs.getString("id"), rs.getInt("quantity"), rs.getInt("status"), rs.getInt("category_id"), rs.getString("name"), rs.getDouble("price"), rs.getString("image"), rs.getString("catName"));
                products.add(p);
            }
        } catch (SQLException ex) {
            Logger.getLogger(DAOProduct.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        return products;
    }

    public ArrayList<DTOProduct> List(String filter) {
        String query = "";
        ArrayList<DTOProduct> products = new ArrayList<DTOProduct>();
        switch(filter){
            case "All":
                query = String.format("SELECT products.*, categories.id as catID, categories.name as catName, categories.status as catStatus "
                        + "FROM products INNER JOIN categories ON products.category_id = categories.id ");
                break;
            default:
                query = String.format("SELECT products.*, categories.id as catID, categories.name as catName, categories.status as catStatus "
                        + "FROM products INNER JOIN categories ON products.category_id = categories.id WHERE categories.name = N'%s'", filter);
                break;
        }
        System.out.println(query);
        ResultSet rs = db.getData(query);
        
        try {
            while(rs.next()){
                //DTOCategory cat = new DTOCategory(rs.getInt("catID"), rs.getInt("catStatus"), rs.getString("catName"));
                DTOProduct p = new DTOProduct(rs.getString("id"), rs.getInt("quantity"), rs.getInt("status"), rs.getInt("category_id"), rs.getString("name"), rs.getDouble("price"), rs.getString("image"));
                products.add(p);
            }
        } catch (SQLException ex) {
            Logger.getLogger(DAOProduct.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        return products;
    }
    
     public DTOProduct Get(String id) {
        String query = String.format("SELECT * FROM products WHERE id = '%s'", id);
        
        ResultSet rs = db.getData(query);
        
        try {
            if(rs.next()){
                //DTOCategory cat = new DTOCategory(rs.getInt("catID"), rs.getInt("catStatus"), rs.getString("catName"));
                DTOProduct product = new DTOProduct(rs.getString("id"), rs.getInt("quantity"), rs.getInt("status"), rs.getInt("category_id"), rs.getString("name"), rs.getDouble("price"), rs.getString("image"));
                return product;
            }
        } catch (SQLException ex) {
            Logger.getLogger(DAOProduct.class.getName()).log(Level.SEVERE, null, ex);
            return null;
        }
        
        return null;
    }

    
    
    
}
