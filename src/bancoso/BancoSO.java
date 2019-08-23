/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package bancoso;

import javax.swing.UIManager;

/**
 *
 * @author Enrique
 */
public class BancoSO {
    public static void main(String[] args) {
        try{
            UIManager.setLookAndFeel("com.jtattoo.plaf.aluminium.AluminiumLookAndFeel");
        }catch(Exception ex){
        }
        new Login().setVisible(true);
    }
}
