/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package models;

import baitaplon.State;
import entities.DTOVoucher;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.logging.Level;

/**
 *
 * @author aboyb
 */
public class DAOVoucher {
    Database db;
    Connection conn;

    public DAOVoucher() {
        this.db = State.db;
        conn = db.getConnection();
    }
    
    public DTOVoucher Get(String code) {
        String query = String.format("SELECT * FROM vouchers WHERE code = '%s'", code);
        
        ResultSet rs = db.getData(query);
        
        try {
            if(rs.next()){
                DTOVoucher voucher = new DTOVoucher(rs.getInt("status"), rs.getInt("discount_percent"), rs.getString("id"), rs.getString("code"));
                return voucher;
            }
        } catch (SQLException ex) {
            //Logger.getLogger(DAOProduct.class.getName()).log(Level.SEVERE, null, ex);
            return null;
        }
        
        return null;
    }

}
