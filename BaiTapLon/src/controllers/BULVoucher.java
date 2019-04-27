/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package controllers;

import entities.DTOVoucher;
import java.util.ArrayList;
import models.DAOVoucher;

/**
 *
 * @author aboyb
 */
public class BULVoucher {
    DAOVoucher daoVoucher = new DAOVoucher();
    
    public DTOVoucher Get(String code) {
        return daoVoucher.Get(code);
    }
    
    public int Insert(DTOVoucher v){
        return daoVoucher.Insert(v);
    }
    
    public ArrayList<DTOVoucher> getVouchers(int offset, int limit){
        return daoVoucher.List(offset, limit);
    }
    
    public int Add(DTOVoucher v){
        return daoVoucher.Insert(v);
    }
    
    public int Update(DTOVoucher v){
        return daoVoucher.Update(v);
    }
    
    public int ToggleStatus(DTOVoucher v){
        return daoVoucher.ToggleStatus(v);
    }
    
    public DTOVoucher Get(int id) {
        return daoVoucher.Get(id);
    }
}
