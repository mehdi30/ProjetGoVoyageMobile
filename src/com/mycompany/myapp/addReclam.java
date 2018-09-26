/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.myapp;

import com.codename1.io.ConnectionRequest;
import com.codename1.io.NetworkEvent;
import com.codename1.io.NetworkManager;
import com.codename1.ui.Button;
import com.codename1.ui.Dialog;
import com.codename1.ui.Form;
import com.codename1.ui.Image;
import com.codename1.ui.TextArea;
import com.codename1.ui.TextField;
import com.codename1.ui.events.ActionEvent;
import com.codename1.ui.events.ActionListener;
import com.codename1.ui.util.Resources;

/**
 *
 * @author Kouka
 */
public class addReclam extends Form {
  Form f,f2,f3,f4,f5;
  static Form home;
   
    
    public addReclam (Resources theme, int idco, Form home) {
        Image img = theme.getImage("back-command.png");
        f4 = new Form("je reclame");
        
               
                TextArea description  = new TextField("","Description");
                f4.add(description);
                Button add = new Button("add");
                f4.add(add);
                add.addActionListener(new ActionListener() {

                    @Override
                    public void actionPerformed(ActionEvent evt) {
                         ConnectionRequest cnx = new ConnectionRequest();
                cnx.setUrl("http://localhost/GoVoyage/web/app_dev.php/GoVoyage/Reclamation/add?"
                        + "description="+description.getText()
                        + "&idc="+idco
                        + "&etat=En cours"
                        
                        
                        );
                 cnx.addResponseListener(new ActionListener<NetworkEvent>() {

                             @Override
                             public void actionPerformed(NetworkEvent evt) {
                                  byte[] data =(byte[]) evt.getMetaData();
                        String s = new String(data);
                        System.out.println(s);
                        boolean v = Dialog.show("Confirmation", "ajout successful", "Ok", null);
                        if (v) {
                           home.show();
                            
                            
                            
                            
                        }
                                 
                             }
                         });
                 NetworkManager.getInstance().addToQueue(cnx);
               
                        
                        
                    }
                });
                f4.getToolbar().addCommandToLeftBar("back", img, new ActionListener() {
                    @Override
                    public void actionPerformed(ActionEvent evt) {
                        home.show();
                            
                            
                    }
                });
                 f4.show();
    }
    
}
