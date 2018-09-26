/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.myapp;


import com.codename1.io.CharArrayReader;
import com.codename1.io.ConnectionRequest;
import com.codename1.io.JSONParser;
import com.codename1.io.NetworkEvent;
import com.codename1.io.NetworkManager;
import com.codename1.ui.Container;
import com.codename1.ui.Form;
import com.codename1.ui.Image;
import com.codename1.ui.Label;
import com.codename1.ui.URLImage;
import com.codename1.ui.animations.Timeline;
import com.codename1.ui.events.ActionEvent;
import com.codename1.ui.events.ActionListener;
import com.codename1.ui.layouts.BorderLayout;
import com.codename1.ui.layouts.BoxLayout;
import com.codename1.ui.util.Resources;
import com.codename1.ui.util.UIBuilder;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

/**
 *
 * @author nizar
 */
public class VolPromo {
 Form f ;
       Container cnt = new Container(new BoxLayout(BoxLayout.Y_AXIS));
     public VolPromo(Resources theme){
     
     UIBuilder ui = new UIBuilder();
     f= ui.createContainer(theme, "list").getComponentForm();
     
 
     ConnectionRequest con = new ConnectionRequest();
     con.setUrl("http://localhost/GoVoyage/web/app_dev.php/GoVoyage/trouvervolpromo");
     con.addResponseListener((NetworkEvent evt) -> {
            //System.out.println(getListEtudiant(new String(con.getResponseData())));
          //  sp.setText(getListEtudiant(new String(con.getResponseData())) + "");
            getListvol(new String(con.getResponseData()),theme);
          f.refreshTheme();
        });
   NetworkManager.getInstance().addToQueue(con); 
           
                f.add(cnt);
                 f.getToolbar().addCommandToLeftBar("",theme.getImage("back_left_pressed.png"),new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent evt) {
                menu m= new menu(theme);
                m.getF().show();
            }
            
        });
            
 }
    // Image im;
      Timeline im = null;
      public Container createContainer(String c1,String c,Resources theme,String list){
        
         Label lbmail = new Label(c);
       
//     try {
//         im = Image.createImage("/promotion-icon.gif").scaled(50, 50);
//         } catch (IOException ex) {  }
      

    try {
        im = (Timeline) Resources.openLayered("/theme").getImage("promotion-icon.gif").scaled(50, 50);
    } catch (IOException e) {
    }
         //f.getAllStyles().setBgImage(im);
          Label image = new Label(im);
        
        
         
         Container cnt = new Container(new BoxLayout(BoxLayout.Y_AXIS));
         cnt.add(lbmail);
         
         Container cnt2 = BorderLayout.center(cnt);
          cnt2.add(BorderLayout.EAST, im);

         
     
     return cnt2;
       
       
}
       public ArrayList<Vol> getListvol(String json,Resources theme) {
        ArrayList<Vol> listEtudiants = new ArrayList<>();
        try {

            JSONParser j = new JSONParser();
            
            Map<String, Object> etudiants = j.parseJSON(new CharArrayReader(json.toCharArray()));

            List<Map<String, Object>> list = (List<Map<String, Object>>) etudiants.get("root");

            for (Map<String, Object> obj : list) {
                Vol e = new Vol();//id, json, status);
                //e.setReference((int) Float.parseFloat(obj.get("ref").toString()));
                
                e.setNumVol(obj.get("numvol").toString());
                e.setRef(Double.parseDouble(String.valueOf(obj.get("ref"))));
                
                 cnt.add(createContainer(e.getRef()+"",e.toStrings()+"",theme,e.getNumVol()+""));
                //e.setVol(obj.get("refVol").toString());
                listEtudiants.add(e);

            }

        } catch (IOException ex) {
        }
        return listEtudiants;
    }

    public Form getF() {
        return f;
    }

    public void setF(Form f) {
        this.f = f;
    }

}