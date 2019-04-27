/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package controllers;

import entities.DTOCategory;
import entities.DTOCustomer;
import java.util.ArrayList;
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
    
    public ArrayList<DTOCustomer> getCustomers(){
        return daoCustomer.List();
    }
    
    public int Add(DTOCustomer c){
        return daoCustomer.Add(c);
    }
    
    public int Update(DTOCustomer c){
        return daoCustomer.Update(c);
    }
    
    public int ToggleStatus(DTOCustomer c){
        return daoCustomer.ToggleStatus(c);
    }
    
    public DTOCustomer Get(int id) {
        return daoCustomer.Get(id);
    }

}
