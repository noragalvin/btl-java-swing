/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package controllers;

import entities.DTOStaff;
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
}
