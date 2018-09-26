/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.myapp;

import Entity.Reclamation;
import com.codename1.io.CharArrayReader;
import com.codename1.io.ConnectionRequest;
import com.codename1.io.JSONParser;
import com.codename1.io.NetworkEvent;
import com.codename1.io.NetworkManager;
import com.codename1.ui.Container;
import com.codename1.ui.Form;
import com.codename1.ui.Image;
import com.codename1.ui.Label;
import com.codename1.ui.events.ActionEvent;
import com.codename1.ui.events.ActionListener;
import com.codename1.ui.layouts.BoxLayout;
import com.codename1.ui.util.Resources;
import static com.mycompany.myapp.Myprofile.f3;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

/**
 *
 * @author Kouka
 */
public class Reclam {
     Form f,f2,home,f3,f4,f5;
     int idco;
    
    public Reclam (Resources theme, int idco, Form home) {
         Image img = theme.getImage("back-command.png");
         f5= new Form ("Mes reclamations");
          
                                        
                                         ConnectionRequest cnx = new ConnectionRequest();
                cnx.setUrl("http://localhost/GoVoyage/web/app_dev.php/GoVoyage/Reclamation/afficher?idc="
                        
                        +idco
                       
                        );
                 cnx.addResponseListener(new ActionListener<NetworkEvent>() {

                             @Override
                             public void actionPerformed(NetworkEvent evt) {
                                                                  Container aff = new Container();

                                 
                                 for(Reclamation r : getListReclamation(new String(cnx.getResponseData())))
                                 {
                                 aff.add(CreateContainerReclamation(r));
                                         
                                       


                                         
                                        
                             } 
                                                                   f5.add(aff);

                                 f5.show();
                             }
                         });
                 NetworkManager.getInstance().addToQueue(cnx);
                 
               
                       
                                  f5.getToolbar().addCommandToLeftBar("back", img, new ActionListener() {
                    @Override
                    public void actionPerformed(ActionEvent evt) {
                        
                          home.show();  
                            
                    }
                });
    }
     public ArrayList<Reclamation> getListReclamation(String json){
        ArrayList<Reclamation> listReclamation = new ArrayList<>();
        try {
            JSONParser j = new JSONParser();
            Map <String,Object> reclamations = j.parseJSON(new CharArrayReader(json.toCharArray()));
            List<Map<String,Object>> list = (List<Map<String,Object>>) reclamations.get("root");
            for(Map<String,Object>obj : list){
                Reclamation r = new Reclamation ();
                r.setRef((int) Float.parseFloat(obj.get("ref").toString()));
                r.setDescription(obj.get("description").toString());
                r.setEtat(obj.get("etat").toString());
                r.setIdc((int) Float.parseFloat(obj.get("idc").toString()));
                listReclamation.add(r);
                System.out.println(r.toString());
            }
            }
        catch (IOException ex ) {
            
        }
        return listReclamation;
    }
       public Container CreateContainerReclamation(Reclamation r)
    {
                         Label taktak = new Label ("------------------------------------------");

                 Label description = new Label ("");
                                  Label description1 = new Label ("");

                                         Label etat = new Label ("");
                                         Label ref2 = new Label ("");
                                         Label etat1 = new Label ("");
                                         Label ref3 = new Label ("");
         description1.setText("Description :");
                                          description.setText(r.getDescription());
                                          etat.setText("Etat :");
                                          etat1.setText(r.getEtat());
                                          ref2.setText("Ref :");
                                          ref3.setText(Integer.toString(r.getRef()));
        
         
        
        Container cnt = new Container (new BoxLayout (BoxLayout.Y_AXIS) );
        cnt.add(description1);
                                         cnt.add(etat);
                                           cnt.add(ref2);
        
        
              Container cnt0 = new Container (new BoxLayout (BoxLayout.Y_AXIS) );
             cnt0.add(description);
                                         cnt0.add(etat1);
                                           cnt0.add(ref3);
          
        
        Container cnt2 = new Container (new BoxLayout (BoxLayout.X_AXIS) );
        cnt2.add(cnt);
        cnt2.add(cnt0);
        Container cnt3 = new Container (new BoxLayout (BoxLayout.Y_AXIS) );
        cnt3.add(cnt2);
                cnt3.add(taktak);

        
        return cnt3;
        
       
        
         
       

    
}}
