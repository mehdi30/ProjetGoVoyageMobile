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
import com.codename1.ui.Container;
import com.codename1.ui.Dialog;
import com.codename1.ui.Form;
import com.codename1.ui.Label;
import com.codename1.ui.TextField;
import com.codename1.ui.events.ActionEvent;
import com.codename1.ui.events.ActionListener;
import com.codename1.ui.spinner.Picker;
import com.codename1.ui.util.Resources;
import com.codename1.ui.util.UIBuilder;

/**
 *
 * @author nizar
 */
public class ModifOffre {
    
    public ModifOffre(Resources theme,String typee,String spec,String reference,String id)
    {
          UIBuilder ui = new UIBuilder();
         UIBuilder.registerCustomComponent("Picker", Picker.class);
         
    // f= ui.createContainer(theme, "AddOffre").getComponentForm();
         Container ct=ui.createContainer(theme, "ModifOffre");
         Form f=(Form)ct;
                TextField promotion = (TextField) ui.findByName("TextField", ct);
                Label type = (Label) ui.findByName("Label2", ct);
                Label ref = (Label) ui.findByName("Label3", ct);
                Picker dateD = (Picker) ui.findByName("Picker", ct);
                Picker dateF = (Picker) ui.findByName("Picker1", ct);
                promotion.setText(spec);
                type.setText(typee);
                ref.setText(reference);
             //    System.out.println(dateD.getText());
              //   System.out.println(dateF.getText());
                 Button bt = new Button();
         bt=(Button) ui.findByName("Button", ct);
         bt.addActionListener(new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent evt) {
  
                ConnectionRequest req = new ConnectionRequest(); 
                 if(    Dialog.show("Confirmation", "ete vous sure de Modifier cet Offre?", "oui", "Cancel"))
                 {
                req.setUrl("http://localhost/GoVoyage/web/app_dev.php/GoVoyage/update?spec="+
                        promotion.getText() +"&type=" +type.getText() +"&dated=" +dateD.getText()+"&datef=" +
                        dateF.getText()+ "&ref=" +reference+"&List=" +id+"");

                req.addResponseListener(new ActionListener<NetworkEvent>() {

                    @Override
                    public void actionPerformed(NetworkEvent evt) {
                        byte[] data = (byte[]) evt.getMetaData();
                        String s = new String(data);
                        System.out.println(s);
                    }
                });
                
                NetworkManager.getInstance().addToQueue(req);
                ListOffers ls = new ListOffers(theme);
                 }

            }
        });
        f.getToolbar().addCommandToLeftBar("",theme.getImage("back_left_pressed.png"),new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent evt) {
                         ListOffers ls = new ListOffers(theme);

            }
        });
        f.show();
    }
    
}
