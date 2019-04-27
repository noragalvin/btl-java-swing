/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package controllers;

import entities.DTOAnalytic;
import java.util.ArrayList;
import models.DAOAnalytic;

/**
 *
 * @author aboyb
 */
public class BULAnalytic {
    DAOAnalytic daoAna = new DAOAnalytic();
    
    public ArrayList<DTOAnalytic> List(String filter) {
        return daoAna.List(filter);
    }
}
