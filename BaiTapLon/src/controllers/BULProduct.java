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
    
    public void calculatePage(String filter) {
        ArrayList<DTOProduct> list = daoProduct.List(filter);
        State.totalPages = list.size() / 6;
            
        if((float)list.size() / 6 > list.size() / 6){
            State.totalPages = list.size() / 6 + 1;
        }
    }
}
