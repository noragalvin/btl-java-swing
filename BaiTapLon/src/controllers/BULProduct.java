/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package controllers;

import entities.DTOProduct;
import java.util.ArrayList;
import models.DAOProduct;

/**
 *
 * @author aboyb
 */
public class BULProduct {
    DAOProduct daoProduct = new DAOProduct();
    
    public ArrayList<DTOProduct> getProducts(String filter){
        return daoProduct.List(filter);
    }
}
