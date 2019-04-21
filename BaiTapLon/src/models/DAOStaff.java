/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package models;

import baitaplon.State;
import entities.DTOStaff;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
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
    
    
}
