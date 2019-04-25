/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package models;

import baitaplon.State;
import entities.DTOBill;
import entities.DTOProductBill;
import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author aboyb
 */
public class DAOProductBill {
    Database db;
    Connection conn;

    public DAOProductBill() {
        this.db = State.db;
        conn = db.getConnection();
    }
    
    public int Insert(DTOProductBill db){
        int n = 0;
        String query = String.format("insert into product_bills(product_id, bill_id, product_quantity, price) values ('%s', %d, %d, %f)", db.getProduct_id(), db.getBill_id(), db.getProduct_quantity(), db.getPrice());
        System.out.println(query);
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
