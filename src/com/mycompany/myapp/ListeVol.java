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
import com.codename1.ui.Button;
import com.codename1.ui.Container;
import com.codename1.ui.Form;
import com.codename1.ui.Label;
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
public class ListeVol {
    Form f ;
       Container cnt = new Container(new BoxLayout(BoxLayout.Y_AXIS));
     public ListeVol(Resources theme){
     
     UIBuilder ui = new UIBuilder();
     f= ui.createContainer(theme, "list").getComponentForm();
     
 
     ConnectionRequest con = new ConnectionRequest();
     con.setUrl("http://localhost/GoVoyage/web/app_dev.php/GoVoyage/trouvervol");
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
                     f.getToolbar().addCommandToRightBar("Vols en Promotion",null,new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent evt) {
                VolPromo m= new VolPromo(theme);
                m.getF().show();
            }
            
        });
             
                 
 }
      public Container createContainer(String c1,String c,Resources theme,String list){
    Label lbmail = new Label(c);
    Button btnom = new Button("Ajouter Offre");
    btnom.addActionListener(new ActionListener() {
        @Override
        public void actionPerformed(ActionEvent evt) {
          AddOffre addoffre = new AddOffre(theme,"Vol",c,c1,list);
          
//          addoffre.getF().show();
        }
    });

   // Label image = new Label(c.getImg());
    
    Container cnt = new Container(new BoxLayout(BoxLayout.Y_AXIS));
    cnt.add(lbmail);
    cnt.add(btnom);
    Container cnt2 = BorderLayout.center(cnt);
   // cnt2.add(BorderLayout.EAST, image);
    cnt2.setLeadComponent(btnom);
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
