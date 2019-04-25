/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package controllers;

import entities.DTOProductBill;
import models.DAOProductBill;

/**
 *
 * @author aboyb
 */
public class BULProductBill {
    DAOProductBill daoProductBill = new DAOProductBill();
    
    public int Insert(DTOProductBill db) {
        return daoProductBill.Insert(db);
    }
}
