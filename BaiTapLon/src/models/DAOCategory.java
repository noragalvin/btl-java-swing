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
        this.db = State.db;
        conn = db.getConnection();
    }
    
    
    public int Remove(int id) {
        int n = 0;
        
        String query = "DELETE  from categories WHERE id = "+ id;
        String queryJoin = "SELECT products.*, categories.id as catID, categories.name as catName, categories.status as catStatus FROM products INNER JOIN categories ON products.category_id = categories.id";
        ResultSet rsJoin = db.getData(queryJoin);
        try {
            if(rsJoin.next()){
                System.out.println("cant delete, update status");
                // update status categories
            } else {
                Statement state = conn.createStatement();
                n = state.executeUpdate(query);
            }
        } catch (SQLException ex) {
            Logger.getLogger(DAOCategory.class.getName()).log(Level.SEVERE, null, ex);
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
}
