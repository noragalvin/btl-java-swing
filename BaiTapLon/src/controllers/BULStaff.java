/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package controllers;

import entities.DTOCustomer;
import entities.DTOStaff;
import java.util.ArrayList;
import models.DAOCustomer;
import models.DAOStaff;

/**
 *
 * @author aboyb
 */
public class BULStaff {
    private DAOStaff daoStaff = new DAOStaff();
    
    public DTOStaff getStaff(String username, String password){
        return daoStaff.getStaff(username, password);
    }
    
    public ArrayList<DTOStaff> getStaffs(int offset, int limit){
        return daoStaff.List(offset, limit);
    }
    
    public int Add(DTOStaff s){
        return daoStaff.Add(s);
    }
    
    public int Update(DTOStaff s){
        return daoStaff.Update(s);
    }
    
    public int ToggleStatus(DTOStaff s){
        return daoStaff.ToggleStatus(s);
    }
    
    public DTOStaff Get(int id) {
        return daoStaff.Get(id);
    }
}
