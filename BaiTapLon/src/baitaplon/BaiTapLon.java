/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package baitaplon;

import forms.Login;
import models.Database;

/**
 *
 * @author aboyb
 */
public class BaiTapLon {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        State.db = new Database();
        new Login().setVisible(true);
    }
    
  
}
    
