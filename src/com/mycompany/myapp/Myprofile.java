/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.myapp;

import Entity.Utilisateur;
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
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

/**
 *
 * @author Kouka
 */
public class Myprofile extends Form {
  static  Form f,f2,home,f3,f4,f5;
     int idco;
    public ArrayList<Utilisateur> getListUsers(String json){
        ArrayList<Utilisateur> listUsers = new ArrayList<>();
        try {
            JSONParser j = new JSONParser();
            Map <String,Object> users = j.parseJSON(new CharArrayReader(json.toCharArray()));
            List<Map<String,Object>> list = (List<Map<String,Object>>) users.get("root");
            for(Map<String,Object>obj : list){
                Utilisateur e = new Utilisateur ();
                e.setRef((int) Float.parseFloat(obj.get("ref").toString()));
                e.setCin(obj.get("cin").toString());
                e.setDatenaissance(obj.get("datenaissance").toString());
                e.setEmail(obj.get("email").toString());
                e.setMdp(obj.get("mdp").toString());
                e.setNationalite(obj.get("nationalite").toString());
                e.setNom(obj.get("nom").toString());
                e.setPrenom(obj.get("prenom").toString());
                e.setNumpassport(obj.get("numpassport").toString());
                e.setRole(obj.get("role").toString());
                e.setSexe(obj.get("sexe").toString());
                e.setTelephone(obj.get("telephone").toString());
                e.setUsername(obj.get("username").toString());
                listUsers.add(e);
                System.out.println(e.toString());
                
            }
            
        }
        catch (IOException ex ) {
            
        }
        return listUsers;
    }
    public Myprofile (Resources theme, int idco, Form home) {
          f3 = new Form("My profile");
                
                                 
        Image img = theme.getImage("back-command.png");
       
           ConnectionRequest cnx = new ConnectionRequest();
                cnx.setUrl("http://localhost/GoVoyage/web/app_dev.php/GoVoyage/User/find?ref="+idco);
                        
                       
                        
                 cnx.addResponseListener(new ActionListener<NetworkEvent>() {

                             @Override
                             public void actionPerformed(NetworkEvent evt) {
                                 Container aff = new Container();
                                   
                                  for (Utilisateur e :getListUsers(new String(cnx.getResponseData()))) {
                                      
                                 aff.add(CreateContainerUser(e));
                                      
                                   
                                         
                                         
                                  }
                                  f3.add(aff);
                                  f3.show();
                                  
                                         
                                         
                f3.getToolbar().addCommandToLeftBar("back", img, new ActionListener() {

                                             @Override
                                             public void actionPerformed(ActionEvent evt) {
                                                 
                            home.show();
                                             }
                                         });
         
    

                             } 
                            
    
}); 
                 NetworkManager.getInstance().addToQueue(cnx);
                 
                                                         

    }
  public Container CreateContainerUser(Utilisateur e)
    {
         Label nom = new Label ("");
                                         Label nom1 = new Label ("");
                                         Label prenom = new Label ("");
                                            Label prenom1 = new Label ("");

                                         Label username = new Label ("");
                                         Label username1 = new Label ("");
                                         Label email = new Label ("");
                                         Label email1 = new Label ("");
                                         Label datenaissance = new Label ("");
                                         Label numPassport = new Label ("");
                                         Label telephone = new Label ("");
                                         Label cin = new Label ("");
                                         Label sexe = new Label ("");
                                         Label mdp = new Label ("55555");
                                         Label datenaissance1 = new Label ("");
                                         Label numPassport1 = new Label ("");
                                         Label telephone1 = new Label ("");
                                         Label cin1 = new Label ("5555555");
                                         Label sexe1 = new Label ("5555");
                                         Label mdp1 = new Label ("");
    
                   nom1.setText("Nom :");
                                          nom.setText(e.getNom());
                                         prenom1.setText("Prenom :");
                                          prenom.setText(e.getPrenom());
                                          username1.setText("Username :");
                                          username.setText(e.getUsername());
                                         mdp1.setText("Mot de passe :");
                                          mdp.setText(e.getMdp());
                                         email1.setText("Email :");
                                          email.setText(e.getEmail());
                                          telephone1.setText("Numero de telephone :");
                                          telephone.setText(e.getTelephone());
                                          cin1.setText("Numero CIN :");
                                          cin.setText(e.getCin());
                                         numPassport1.setText("Numero Passeport :");
                                          numPassport.setText(e.getNumpassport());
                                          sexe1.setText("Sexe :");
                                         sexe.setText(e.getSexe());
                                          datenaissance1.setText("Date De Naissance :");
                                          datenaissance.setText(e.getDatenaissance());
        
         
        
        Container cnt = new Container (new BoxLayout (BoxLayout.Y_AXIS) );
        cnt.add(nom1);
        cnt.add(prenom1);
        cnt.add(username1);
        cnt.add(mdp1);
        cnt.add(email1);
        cnt.add(sexe1);
        cnt.add(cin1);
        cnt.add(datenaissance1);
        cnt.add(numPassport1);
        cnt.add(telephone1);
        
        
        
             //sp.setText(getListCovoiturages(new String(con.getResponseData())) + "");
              Container cnt0 = new Container (new BoxLayout (BoxLayout.Y_AXIS) );
              cnt.add(nom);
        cnt0.add(prenom);
        cnt0.add(username);
        cnt0.add(mdp);
        cnt0.add(email);
        cnt0.add(sexe);
        cnt0.add(cin);
        cnt0.add(datenaissance);
        cnt0.add(numPassport);
        cnt0.add(telephone);
          
        
        Container cnt2 = new Container (new BoxLayout (BoxLayout.X_AXIS) );
        cnt2.add(cnt);
        cnt2.add(cnt0);
        return cnt2;
        }
}
