/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package models;

import baitaplon.State;
import entities.DTOAnalytic;
import entities.DTOProduct;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author aboyb
 */
public class DAOAnalytic {
    Database db;
    Connection conn;

    public DAOAnalytic() {
        this.db = new Database();
        conn = db.getConnection();
    }
    
    public ArrayList<DTOAnalytic> List(String filter) {
        System.out.println(filter);
        String query = "";
        ArrayList<DTOAnalytic> data = new ArrayList<DTOAnalytic>();
        switch(filter){
            case "Today":
                query = "SET DATEFIRST 1 " +
                        "SELECT products.name, bills.total_prices, bills.discount_prices, bills.created_at, product_bills.product_quantity, product_bills.price " +
                        "FROM products INNER JOIN product_bills ON products.id = product_bills.product_id " +
                        "INNER JOIN bills on bills.id = product_bills.bill_id " +
                        "WHERE bills.created_at >= DATEADD(DAY, 0, DATEDIFF(DAY, 0, CURRENT_TIMESTAMP)) " +
                        "AND bills.created_at <  DATEADD(DAY, 1, DATEDIFF(DAY, 0, CURRENT_TIMESTAMP));";
                break;
            case "Week":
                query = "SET DATEFIRST 1 " +
                        "SELECT products.name, bills.total_prices, bills.discount_prices, bills.created_at, product_bills.product_quantity, product_bills.price " +
                        "FROM products INNER JOIN product_bills ON products.id = product_bills.product_id " +
                        "INNER JOIN bills on bills.id = product_bills.bill_id " +
                        "WHERE bills.created_at >= dateadd(day, 1-datepart(dw, getdate()), CONVERT(date,getdate())) " +
                        "AND bills.created_at <  dateadd(day, 8-datepart(dw, getdate()), CONVERT(date,getdate()))";
                break;
            case "Month":
                query = "SET DATEFIRST 1 " +
                        "SELECT products.name, bills.total_prices, bills.discount_prices, bills.created_at, product_bills.product_quantity, product_bills.price " +
                        "FROM products INNER JOIN product_bills ON products.id = product_bills.product_id " +
                        "INNER JOIN bills on bills.id = product_bills.bill_id " +
                        "WHERE bills.created_at >= dateadd(m, datediff(m, 0, GetDate()), 0) " +
                        "AND bills.created_at < dateadd(m, datediff(m, -1, GetDate()), 0)";
                break;
            default:
                query = "SET DATEFIRST 1 -- Define beginning of week as Monday\n" +
                        "SELECT * from product_bills " +
                        "AND WorkDate >= dateadd(day, 1-datepart(dw, getdate()), CONVERT(date,getdate())) " +
                        "AND WorkDate <  dateadd(day, 8-datepart(dw, getdate()), CONVERT(date,getdate()))";
        }
        System.out.println(query);
        ResultSet rs = db.getData(query);
        
        try {
            while(rs.next()){
                //DTOCategory cat = new DTOCategory(rs.getInt("catID"), rs.getInt("catStatus"), rs.getString("catName"));
                DTOAnalytic a = new DTOAnalytic(rs.getString("name"), rs.getString("created_at"), rs.getDouble("price"), rs.getInt("product_quantity"));
                data.add(a);
            }
        } catch (SQLException ex) {
            Logger.getLogger(DAOProduct.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        return data;
    }
    
    
}
