/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package controllers;

import entities.DTOCustomer;
import models.DAOCustomer;
import models.DAOProduct;

/**
 *
 * @author aboyb
 */
public class BULCustomer {
    DAOCustomer daoCustomer = new DAOCustomer();
    
    public DTOCustomer getCustomer(String phone) {
        return daoCustomer.getCustomer(phone);
    }
    
    public int Insert(DTOCustomer c){
        return daoCustomer.Insert(c);
    }
}
