/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package controllers;

import entities.DTOCategory;
import entities.DTOProduct;
import java.util.ArrayList;
import models.DAOCategory;
import models.DAOProduct;

/**
 *
 * @author aboyb
 */
public class BULCategory {
    
    DAOCategory daoCategory = new DAOCategory();
    
    public ArrayList<DTOCategory> getCategories(){
        return daoCategory.List();
    }
}
