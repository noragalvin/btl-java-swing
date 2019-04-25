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
import models.Database;

/**
 *
 * @author aboyb
 */
public class State {
    public static ArrayList<HashMap> currentProducts = new ArrayList<HashMap>();
    public static Database db;
    public static DTOStaff currentUser;
    public static int totalPages;
    
    
    public static void AddProduct(DTOProduct p, int quantity) {
        if(currentProducts.size() > 0 ){
            // Print keys
            for (HashMap hmProduct : currentProducts) {
                if((int) hmProduct.get(p.getId()) > 0) {
                    int newQuantity = (int) hmProduct.get(p.getId()) + quantity;
                    hmProduct.put(p.getId(), newQuantity);
                }
                System.out.println(hmProduct);
            }
        } else {
            System.out.println(p);
            HashMap<String, Integer> product = new HashMap<String, Integer>();
            product.put(p.getId(), quantity);
            currentProducts.add(product);
        }
    }
}
