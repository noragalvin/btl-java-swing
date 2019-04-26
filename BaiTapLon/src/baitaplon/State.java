/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package baitaplon;

import entities.DTOProduct;
import entities.DTOStaff;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import models.Database;

/**
 *
 * @author aboyb
 */
public class State {
    public static HashMap<String, Integer> currentProducts = new HashMap<String, Integer>();
    public static Database db;
    public static DTOStaff currentUser;
    public static int totalPages;
    
    
    public static void AddProduct(DTOProduct p, int quantity) {
        if (currentProducts.containsKey(p.getId()) == true) {
            currentProducts.put(p.getId(), quantity);
            int newQuantity = (int) currentProducts.get(p.getId()) + quantity;
            currentProducts.put(p.getId(), newQuantity);
        } else {
            System.out.println("No such key");
            currentProducts.put(p.getId(), quantity);
        }
    }
    
    public static void ResetAll() {
        currentProducts = new HashMap<String, Integer>();
        db = null;
        currentUser = null;
        totalPages = 0;
    }
    
    public static void ResetProduct() {
        currentProducts = new HashMap<String, Integer>();
    }
}
