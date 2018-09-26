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
import com.codename1.ui.Button;
import com.codename1.ui.Dialog;
import com.codename1.ui.Form;
import com.codename1.ui.Image;
import com.codename1.ui.Label;
import com.codename1.ui.TextArea;
import com.codename1.ui.TextField;
import com.codename1.ui.events.ActionEvent;
import com.codename1.ui.events.ActionListener;
import com.codename1.ui.layouts.BoxLayout;
import com.codename1.ui.spinner.Picker;
import com.codename1.ui.util.Resources;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

/**
 *
 * @author Kouka
 */
public class login extends Form {
      Form f,f2;
       boolean v; boolean v1;
        
      static Form      home,  f3,f4,f5;
     int idco;

    public Form getF() {
        return f;
    }

    public void setF(Form f) {
        this.f = f;
    }

    public Form getF2() {
        return f2;
    }

    public void setF2(Form f2) {
        this.f2 = f2;
    }

    public Form getHome() {
        return home;
    }

    public void setHome(Form home) {
        this.home = home;
    }

    public Form getF3() {
        return f3;
    }

    public void setF3(Form f3) {
        this.f3 = f3;
    }

    public Form getF4() {
        return f4;
    }

    public void setF4(Form f4) {
        this.f4 = f4;
    }

    public Form getF5() {
        return f5;
    }

    public void setF5(Form f5) {
        this.f5 = f5;
    }

    public int getIdco() {
        return idco;
    }

    public void setIdco(int idco) {
        this.idco = idco;
    }
     
    public login (Resources theme){
        String [] characters = { " Feminin", "Masculin" };
        String [] nations = { " Tunisienne" , "Francaise" , "Americaine" , "Allemande" };
        
    TextField login = new TextField("","login");
       TextField mdp = new TextField("","password");
       mdp.addPointerPressedListener(new ActionListener() {
        @Override
        public void actionPerformed(ActionEvent evt) {
            mdp.setConstraint(TextField.PASSWORD);
        }
    });
       f = new Form("GoVoyage",BoxLayout.y());
        home = new Form("home");

       f.add(login);
       f.add(mdp);
       Button go = new Button("Authentification");
              Button inscription = new Button("Inscription");
              

       f.add(go);
              f.add(inscription);
       inscription.addActionListener(new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent evt) {
                f2 = new Form ("Inscription");
                TextField nom = new TextField("","nom");
                TextField prenom = new TextField("","prenom");
                TextField username = new TextField("","username");
                TextField mdp = new TextField("","mdp");
                TextField email = new TextField("","email",20,TextField.EMAILADDR);
                Picker datenaissance = new Picker();
                TextField numPassport = new TextField("","numPassport");
                //TextField nationalite = new TextField("","nationalite");
                TextField telephone = new TextField("","telephone",8,TextField.NUMERIC);
                TextField cin = new TextField("","cin",8,TextField.NUMERIC);
                         //       TextField sexe = new TextField("","sexe");
                         Picker sexe = new Picker ();
                         sexe.setStrings(characters);
                         sexe.setSelectedString(characters[0]);
                         
                         Picker nationalite = new Picker ();
                         nationalite.setStrings(nations);
                         nationalite.setSelectedString(nations[0]);
                         


                f2.add(nom);
                f2.add(prenom);
                f2.add(cin);
                f2.add(sexe);

                f2.add(datenaissance);
                f2.add(email);
                f2.add(mdp);
                f2.add(numPassport);
                f2.add(telephone);
                f2.add(nationalite);
                f2.add(username);
                
                Button add = new Button("add");
                f2.add(add);
                add.addActionListener(new ActionListener() {

                    @Override
                    public void actionPerformed(ActionEvent evt) {
                         ConnectionRequest cnx = new ConnectionRequest();
                cnx.setUrl("http://localhost/GoVoyage/web/app_dev.php/User/add?"
                        + "username="+username.getText()
                        + "&nom="+nom.getText()
                        + "&prenom="+prenom.getText()
                        + "&cin="+cin.getText()
                        + "&email="+email.getText()
                        + "&mdp="+mdp.getText()
                        + "&nationalite="+nationalite.getText()
                        + "&datenaissance="+datenaissance.getText()
                        + "&telephone="+telephone.getText()
                        + "&numPassport="+numPassport.getText()
                        + "&sexe="+sexe.getText());
                cnx.addResponseListener(new ActionListener<NetworkEvent>() {

                    @Override
                    public void actionPerformed(NetworkEvent evt) {
                        byte[] data =(byte[]) evt.getMetaData();
                        String s = new String(data);
                        System.out.println(s);
                        boolean v = Dialog.show("Confirmation", "ajout successful", "Ok", null);
                        if (v) {
                            
                            f.show();
                            
                        }
                            
                        
                        
                    }
                });
                NetworkManager.getInstance().addToQueue(cnx);
                nom.clear();
                prenom.clear();
                cin.clear();
//                nationalite.clear();
//                sexe.clear();
                username.clear();
                numPassport.clear();
                mdp.clear();
//                sexe.clear();
                email.clear();
                telephone.clear();
                        
                    }
                });
                f2.show();
                
            }
            
        });
       
       

       go.addActionListener(new ActionListener() {
           
            @Override
            public void actionPerformed(ActionEvent evt) {
                ConnectionRequest cnx = new ConnectionRequest();
                cnx.setUrl("http://localhost/GoVoyage/web/app_dev.php/GoVoyage/User/all");
                cnx.addResponseListener(new ActionListener<NetworkEvent>() {
                   

                    @Override
                    public void actionPerformed(NetworkEvent evt) {
                        boolean i =false;
                        for (Utilisateur e :getListUsers(new String(cnx.getResponseData())))
                        {
                            if ((login.getText().equals(e.getUsername()))&&(mdp.getText().equals(e.getMdp()))) {
                               
                                if((e.getRole().equals("Client")))
                                {
                                idco = e.getRef();
                                f3 = new Form("my profile");
                                f4 = new Form("je reclame");
                                f5 = new Form("mes reclamations");
                                Label role = new Label ("");
 
                                Label user = new Label ("");
                                        Image img = theme.getImage("back-command.png");
                                            home = new Form("home");
                                home.add(role);
                                home.add(user);
                                home.show();
                                user.setText(Integer.toString(idco));
                                role.setText("Client");
                                home.getToolbar().addCommandToSideMenu("my profile", null, new ActionListener() {

                                    @Override
                                    public void actionPerformed(ActionEvent evt) {
                                        Myprofile mp = new Myprofile(theme, idco,home);
                                        
                                    }
                                });
                                home.getToolbar().addCommandToSideMenu("je reclame", null, new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent evt) {
                
                addReclam addrec = new addReclam(theme,idco,home);
                

            }
        });
                                home.getToolbar().addCommandToSideMenu("Mes reclamations ", null, new ActionListener() {

                                    @Override
                                    public void actionPerformed(ActionEvent evt) {
                                        
                                        Reclam rec =new Reclam(theme, idco, home);
                                       
                                         
                                    }
                                    
                                });
                                 home.getToolbar().addCommandToSideMenu("Mes Vols", null, new ActionListener() {

                                    @Override
                                    public void actionPerformed(ActionEvent evt) {
                                        
                                    afficher t = new afficher(theme,home);
                                       // t.show();
                                    }
                                    
                                });
                                  home.getToolbar().addCommandToSideMenu("hebergements ", null, new ActionListener() {

                                    @Override
                                    public void actionPerformed(ActionEvent evt) {
                                        
                                        Travail tv = new Travail(theme, home);
                                       
                                         
                                    }
                                    
                                });
                                     home.getToolbar().addCommandToSideMenu("reservations ", null, new ActionListener() {

                                    @Override
                                    public void actionPerformed(ActionEvent evt) {
                                        
                                       StartImen st = new StartImen(theme);
                                       
                                         
                                    }
                                    
                                });
                      
                      
            
        
                                home.getToolbar().addCommandToSideMenu("deconnexion", null, new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent evt) {
                // f = new Form("GoVoyage",BoxLayout.y());
                //home = new Form("home");
                f.show();
                login.clear();
                mdp.clear();
                
            }
                                });
                                }
                                else if ((e.getRole().equals("Administrateur"))) {
                                    idco = e.getRef();
                               // home = new Form("home");
                               menu mn = new menu(theme);
                                            mn.getF().show();
                                                               Label role = new Label ("");
 
                               Label user = new Label ("");
//                                home.add(user);
//                                        home.add(role);
//                                home.show();
//                                user.setText(Integer.toString(idco));
//                                role.setText("Administrateur");
//                                 home.getToolbar().addCommandToSideMenu("Les reclamations ", null, new ActionListener() {
//
//                                        @Override
//                                        public void actionPerformed(ActionEvent evt) {
//                                            AdminReclamation ar = new AdminReclamation(theme,home);
//                                        }
//                                    });
//                                  home.getToolbar().addCommandToSideMenu("Menu ", null, new ActionListener() {
//
//                                        @Override
//                                        public void actionPerformed(ActionEvent evt) {
//                                            
//                                        }
//                                    });
//                                   home.getToolbar().addCommandToSideMenu("deconnexion", null, new ActionListener() {
//
//                                        @Override
//                                        public void actionPerformed(ActionEvent evt) {
//                                            f.show();
//                login.clear();
//                mdp.clear();
//                                        }
//                                    });
//                                    
                                }
                                
                                
                                
                                
                                i=true;
                            }
                           
                            
                        }
                        if (!i)
                          v =   Dialog.show("Erreur", "Coordonnees incorrectes", "Ok", null);
                        else 
                            v1 =   Dialog.show("Bienvenue", "Coordonnees correctes", "Ok", null);
                        
                        
                    }
                    
                });
                NetworkManager.getInstance().addToQueue(cnx);
                
            }
        });
      // f.show();
    }
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
    
   

}


