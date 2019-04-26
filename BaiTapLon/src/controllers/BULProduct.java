/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package controllers;

import baitaplon.State;
import entities.DTOProduct;
import java.util.ArrayList;
import models.DAOProduct;

/**
 *
 * @author aboyb
 */
public class BULProduct {
    DAOProduct daoProduct = new DAOProduct();
    
    public ArrayList<DTOProduct> getProducts(String filter, int limit, int offset){
        return daoProduct.List(filter, limit, offset);
    }
    
    public DTOProduct getAProduct(String id) {
        return daoProduct.Get(id);
    }
    
    public int updateQuantity(String id, int quantity) {
        return daoProduct.updateQuantity(id, quantity);
    }
    
    public void calculatePage(String filter) {
        System.out.println(filter);
        ArrayList<DTOProduct> list = daoProduct.List(filter);
        System.out.println(list.size());
        System.out.println(State.totalPages);
        State.totalPages = list.size() / 6;
        System.out.println(State.totalPages);
            
        if(list.size() < 6) {
            State.totalPages = 1;
        }
        if((float)list.size() / 6 > list.size() / 6){
            State.totalPages = list.size() / 6 + 1;
        }
    }
    
    public int Add(DTOProduct p){
        return daoProduct.Add(p);
    }
    
    public int ToggleStatus(DTOProduct p){
        return daoProduct.ToggleStatus(p);
    }
    
    public int Update(DTOProduct p) {
        return daoProduct.Update(p);
    }
}
