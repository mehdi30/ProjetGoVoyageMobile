/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.myapp;

import com.codename1.io.ConnectionRequest;
import com.codename1.io.NetworkEvent;
import com.codename1.io.NetworkManager;
import com.codename1.l10n.SimpleDateFormat;
import com.codename1.ui.Button;
import com.codename1.ui.Container;
import com.codename1.ui.Dialog;
import com.codename1.ui.Form;
import com.codename1.ui.Label;
import com.codename1.ui.Slider;
import com.codename1.ui.TextField;
import com.codename1.ui.events.ActionEvent;
import com.codename1.ui.events.ActionListener;
import com.codename1.ui.spinner.Picker;
import com.codename1.ui.util.Resources;
import com.codename1.ui.util.UIBuilder;
import javafx.beans.property.SimpleDoubleProperty;

/**
 *
 * @author nizar
 */
public class AddOffre {
    Form f;
    public AddOffre(Resources theme,String typee,String refe,String reference,String list)
    {
         UIBuilder ui = new UIBuilder();
         UIBuilder.registerCustomComponent("Picker", Picker.class);
         
    // f= ui.createContainer(theme, "AddOffre").getComponentForm();
         Container ct=ui.createContainer(theme, "AddOffre");
         Form f=(Form)ct;
         SimpleDateFormat format = new SimpleDateFormat("y-M-d");
         Slider promotion = (Slider) ui.findByName("Slider", ct);
             //   TextField promotion = (TextField) ui.findByName("TextField", ct);
                Label type = (Label) ui.findByName("Label2", ct);
                Label ref = (Label) ui.findByName("Label3", ct);
                Picker dateD = (Picker) ui.findByName("Picker", ct);
                dateD.setFormatter(format);
                Picker dateF = (Picker) ui.findByName("Picker1", ct);
                dateF.setFormatter(format);
                Label lab = (Label) ui.findByName("Label4", ct);
                type.setText(typee);
                ref.setText(refe);
                 
         promotion.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent evt) {
                
                lab.setText("note:"+promotion.getProgress()); 
                //System.out.println(sl.getProgress());
            }
        });
               //  System.out.println(dateD.getText());
               //  System.out.println(dateF.getText());
                 Button bt = new Button();
         bt=(Button) ui.findByName("Button", ct);
         bt.addActionListener(new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent evt) {

                ConnectionRequest req = new ConnectionRequest();
                if(dateD.getText().compareTo(dateF.getText())<=0)
                {
                if (type.getText()=="Hebergement")
                
                req.setUrl("http://localhost/GoVoyage/web/app_dev.php/GoVoyage/newh?spec="+
                        promotion.getProgress() +"&type=" +type.getText() +"&dated=" +dateD.getText()+"&datef=" +
                        dateF.getText()+ "&ref=" +reference+"&List=" +list+"");
                   
                else
                
                req.setUrl("http://localhost/GoVoyage/web/app_dev.php/GoVoyage/newv?spec="+
                        promotion.getProgress() +"&type=" +type.getText() +"&dated=" +dateD.getText()+"&datef=" +
                        dateF.getText()+ "&ref=" +reference+"&List=" +list+"");
                      

                req.addResponseListener(new ActionListener<NetworkEvent>() {

                    @Override
                    public void actionPerformed(NetworkEvent evt) {
                        byte[] data = (byte[]) evt.getMetaData();
                        String s = new String(data);
                      //  System.out.println(s);
                       // if (s.equals("success")) {
                            Dialog.show("Confirmation", "ajout ok", "Ok", null);
                        //}
                    }
                });
                
                NetworkManager.getInstance().addToQueue(req);
                
                }
                else
                     Dialog.show("Warning", "Date debut Doit etre inférieure a la date fin", "Ok", null);
            }
        });
        f.getToolbar().addCommandToLeftBar("",theme.getImage("back_left_pressed.png"),new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent evt) {
                menu m= new menu(theme);
                m.getF().show();
            }
        });
        f.show();
    }

    public Form getF() {
        return f;
    }

    public void setF(Form f) {
        this.f = f;
    }
    
}
