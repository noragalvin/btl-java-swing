/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package baitaplon;

import java.awt.Color;
import javax.swing.JOptionPane;

/**
 *
 * @author aboyb
 */
public class Helpers {
    public static Color mainBgColor = new Color(241, 196, 15);
    public static Color subBgColor = new Color(243, 156, 18);
    public static Color mainFgColor = new Color(236, 240, 241);
    public static Color mainBordercolor = new Color(52, 73, 94);
    
    public static void MessageBox(String title, String message, String type) {
        int message_type;
        switch(type) {
            case "success":
                message_type = JOptionPane.INFORMATION_MESSAGE;
                break;
            case "error":
                message_type = JOptionPane.ERROR_MESSAGE;
                break;
            default:
                message_type = JOptionPane.INFORMATION_MESSAGE;
                
        }
        JOptionPane.showMessageDialog(null, message, title, message_type);
    }
}
