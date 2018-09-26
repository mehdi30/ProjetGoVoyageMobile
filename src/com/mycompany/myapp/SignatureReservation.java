/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.myapp;

import com.codename1.components.SignatureComponent;
import com.codename1.ui.Form;
import com.codename1.ui.Image;
import com.codename1.ui.TextField;
import com.codename1.ui.events.ActionEvent;
import com.codename1.ui.events.ActionListener;
import com.codename1.ui.layouts.BoxLayout;
import com.codename1.ui.util.Resources;

/**
 *
 * @author Imen
 */
public class SignatureReservation {
    
    SignatureReservation(Resources theme){
    
     Form hi = new Form("Signature Component");
           hi.getToolbar().addCommandToLeftBar("Back",theme.getImage("back-command.png"),new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent evt) {
                  StartImen i = new StartImen(theme);
            }
        });
        hi.setLayout(new BoxLayout(BoxLayout.Y_AXIS));
        hi.add("Enter Your Name:");
        hi.add(new TextField());
        hi.add("Signature:");
        SignatureComponent sig = new SignatureComponent();
        sig.addActionListener((evt)-> {
            System.out.println("The signature was changed");
            Image img = sig.getSignatureImage();
            // Now we can do whatever we want with the image of this signature.
        });
        hi.addComponent(sig);
        hi.show();
    }
    
}
