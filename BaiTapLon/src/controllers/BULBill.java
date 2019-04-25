/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package controllers;

import entities.DTOBill;
import models.DAOBill;

/**
 *
 * @author aboyb
 */
public class BULBill {
    DAOBill daoBill = new DAOBill();
    
    public int Insert(DTOBill b) {
        return daoBill.Insert(b);
    }
    
    public DTOBill GetLastRecord() {
        return daoBill.GetLastRecord();
    }
}
