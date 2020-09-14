/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package rms;

import javax.swing.*;
import rms.screens.Login;

/**
 *
 * @author soupa
 */
public class RMS {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {

        SwingUtilities.invokeLater(new Runnable(){

            @Override
            public void run(){

                Login loginForm = new Login();
                loginForm.setVisible(true);

            }

        });
        
    }
    
}
