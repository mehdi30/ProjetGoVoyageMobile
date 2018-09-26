/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.myapp;

import com.codename1.io.ConnectionRequest;
import com.codename1.io.NetworkEvent;
import com.codename1.ui.Button;
import com.codename1.ui.Dialog;
import com.codename1.ui.Form;
import com.codename1.ui.TextArea;
import com.codename1.ui.TextField;
import com.codename1.ui.events.ActionEvent;
import com.codename1.ui.events.ActionListener;
import com.codename1.ui.util.Resources;

/**
 *
 * @author Imen
 */
public class SmsReservation {
    
    public SmsReservation(Resources theme){
        
         Form f=new Form();
         
        f.getToolbar().addCommandToLeftBar("Back",theme.getImage("back-command.png"),new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent evt) {
                  StartImen i = new StartImen(theme);
            }
        });
        
                TextField numero = new TextField("","Votre numero");
                TextArea sujet = new TextArea();
         Button bt = new Button("send");
         f.add(numero);
          f.add(sujet);
           f.add(bt);
         
        
         bt.addActionListener(new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent evt) {
                ConnectionRequest cntRqst = new ConnectionRequest() ;
                cntRqst.setPost(false);
    cntRqst.setUrl("https://rest.nexmo.com/sms/json?api_key=518db94c&api_secret=b3c037f398f6c675"
                    +"&to="+numero.getText()
                    +"&from=NEXMO"
                    +"&text="+sujet.getText()
                   );
                 cntRqst.addResponseListener(new ActionListener<NetworkEvent>() {

                    @Override
                    public void actionPerformed(NetworkEvent evt) {
                        byte[] data = (byte[]) evt.getMetaData();
                        String s = new String(data);
                       // System.out.println(s);
                       // if (s.equals("success")) {
                            Dialog.show("SMS", "sms successfully sent", "OK", null);
                        //}
                    }

                 });
            }});
    
 f.show();
        
    }
    
    
    
    
}
