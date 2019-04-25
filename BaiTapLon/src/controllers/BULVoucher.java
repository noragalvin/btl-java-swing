/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package controllers;

import entities.DTOVoucher;
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
}
