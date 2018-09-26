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
import com.codename1.messaging.Message;
import com.codename1.ui.Button;
import com.codename1.ui.CheckBox;
import com.codename1.ui.Container;
import com.codename1.ui.Dialog;
import com.codename1.ui.Display;
import com.codename1.ui.Form;
import com.codename1.ui.Image;
import com.codename1.ui.Label;
import com.codename1.ui.events.ActionEvent;
import com.codename1.ui.events.ActionListener;
import com.codename1.ui.layouts.BoxLayout;
import com.codename1.ui.util.Resources;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

/**
 *
 * @author Kouka
 */
public class AdminReclamation extends Form {
    Form home,reclam;
    Resources theme;
    
    public AdminReclamation (Resources theme, Form home) {
        this.theme=theme;
        this.home=home;
        Image img = theme.getImage("back-command.png");
         reclam= new Form ("Les reclamations");
          
                                       
                                         
                                      
                                         
                                         ConnectionRequest cnx = new ConnectionRequest();
                cnx.setUrl("http://localhost/GoVoyage/web/app_dev.php/GoVoyage/Reclamation/show"
                        
                        
                       
                        );
                 cnx.addResponseListener(new ActionListener<NetworkEvent>() {

                             @Override
                             public void actionPerformed(NetworkEvent evt) {
                                             Container aff = new Container();

                                 
                                 for(Reclamation r : getListReclamation(new String(cnx.getResponseData())))
                                 {
                                     if(r.getEtat().equals("En cours")) {
                                 
                                        aff.add(CreateContainerReclamation(r));   
                                        

                                     }
                                         
                                        
                             } 
                                  reclam.add(aff);

                                 reclam.show();
                             
                             }
                         });
                 NetworkManager.getInstance().addToQueue(cnx);
                 
               
                       
                                  reclam.getToolbar().addCommandToLeftBar("back", img, new ActionListener() {
                    @Override
                    public void actionPerformed(ActionEvent evt) {
                        
                         menu mn = new menu(theme);
                                            mn.getF().show();
                            
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
                                         CheckBox c = new CheckBox("Traitée");
                                         c.addActionListener(new ActionListener() {

                             @Override
                             public void actionPerformed(ActionEvent evt) {
                                 ConnectionRequest cnx = new ConnectionRequest();
                cnx.setUrl("http://localhost/GoVoyage/web/app_dev.php/GoVoyage/Reclamation/update?ref="
                        +r.getRef()
                        
                        
                       
                        );
                 cnx.addResponseListener(new ActionListener<NetworkEvent>() {

                             @Override
                             public void actionPerformed(NetworkEvent evt) {
                                 
                                 boolean v = Dialog.show("Confirmation", "Traitement Done", "Ok", null);
                                 if (v) {
                                     Message m = new Message("bonjour monsieur, votre reclamation a ete traitee ");
Display.getInstance().sendMessage(new String[] {"jkhouloud@live.fr"}, "Etat de la Demande", m);
                System.out.println("ok");
                                     Image img = theme.getImage("back-command.png");
         reclam= new Form ("Les reclamations");
          
                                       
                                         
                                      
                                         
                                         ConnectionRequest cnx = new ConnectionRequest();
                cnx.setUrl("http://localhost/GoVoyage/web/app_dev.php/GoVoyage/Reclamation/show"
                        
                        
                       
                        );
                 cnx.addResponseListener(new ActionListener<NetworkEvent>() {

                             @Override
                             public void actionPerformed(NetworkEvent evt) {
                                             Container aff = new Container();

                                 
                                 for(Reclamation r : getListReclamation(new String(cnx.getResponseData())))
                                 {
                                     if(r.getEtat().equals("En cours")) {
                                 
                                        aff.add(CreateContainerReclamation(r));   
                                        

                                     }
                                         
                                        
                             } 
                                  reclam.add(aff);

                                 reclam.show();
                             
                             }
                         });
                 NetworkManager.getInstance().addToQueue(cnx);
                 
               
                       
                                  reclam.getToolbar().addCommandToLeftBar("back", img, new ActionListener() {
                    @Override
                    public void actionPerformed(ActionEvent evt) {
                        
                         menu mn = new menu(theme);
                                            mn.getF().show(); 
                            
                    }
                });
                                     
                                     
                                 }
                                            

                             
                             }
                         });
                 NetworkManager.getInstance().addToQueue(cnx);
                 
                                 
                             }
                         });

                                         Button supp =  new Button("supprimer");
                                         supp.addActionListener(new ActionListener() {

                             @Override
                             public void actionPerformed(ActionEvent evt) {
                                 ConnectionRequest cnx = new ConnectionRequest();
                cnx.setUrl("http://localhost/GoVoyage/web/app_dev.php/GoVoyage/Reclamation/delete?ref="
                        +r.getRef()
                        
                        
                       
                        );
                 cnx.addResponseListener(new ActionListener<NetworkEvent>() {

                             @Override
                             public void actionPerformed(NetworkEvent evt) {
                                 
                                 boolean v = Dialog.show("Confirmation", "Suppression Done", "Ok", null);
                                 if (v) {
                                     Image img = theme.getImage("back-command.png");
         reclam= new Form ("Les reclamations");
          
                                       
                                         
                                      
                                         
                                         ConnectionRequest cnx = new ConnectionRequest();
                cnx.setUrl("http://localhost/GoVoyage/web/app_dev.php/GoVoyage/Reclamation/show"
                        
                        
                       
                        );
                 cnx.addResponseListener(new ActionListener<NetworkEvent>() {

                             @Override
                             public void actionPerformed(NetworkEvent evt) {
                                             Container aff = new Container();

                                 
                                 for(Reclamation r : getListReclamation(new String(cnx.getResponseData())))
                                 {
                                     if(r.getEtat().equals("En cours")) {
                                 
                                        aff.add(CreateContainerReclamation(r));   
                                        

                                     }
                                         
                                        
                             } 
                                  reclam.add(aff);

                                 reclam.show();
                             
                             }
                         });
                 NetworkManager.getInstance().addToQueue(cnx);
                 
               
                       
                                  reclam.getToolbar().addCommandToLeftBar("back", img, new ActionListener() {
                    @Override
                    public void actionPerformed(ActionEvent evt) {
                        
                      menu mn = new menu(theme);
                                            mn.getF().show();
                            
                    }
                });
                                     
                                     
                                 }
                                            

                             
                             }
                         });
                 NetworkManager.getInstance().addToQueue(cnx);
                                 
                             }
                         });
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
                                           cnt.add(c);
                                           cnt.add(supp);
        
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
        
       
       
        
         
       

    
}
     
       
        
         
       

    }