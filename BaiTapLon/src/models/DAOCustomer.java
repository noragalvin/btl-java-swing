/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package models;

import baitaplon.State;
import entities.DTOCustomer;
import entities.DTOProduct;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
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
        String query = String.format("insert into customer(name, address, phone) values (N'%s', N'%s', '%s')", c.getName(), c.getAddress(), c.getPhone());
        try {
            Statement state = conn.createStatement();
            n = state.executeUpdate(query);
            return n;
        } catch (SQLException ex) {
            Logger.getLogger(DAOProduct.class.getName()).log(Level.SEVERE, null, ex);
            return n;
        }
        
    }
    
    
}
