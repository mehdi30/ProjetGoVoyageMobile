/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.myapp;

import com.codename1.components.SpanLabel;
import com.codename1.io.CharArrayReader;
import com.codename1.io.ConnectionRequest;
import com.codename1.io.JSONParser;
import com.codename1.io.NetworkEvent;
import com.codename1.io.NetworkManager;
import com.codename1.messaging.Message;
import com.codename1.ui.Button;
import com.codename1.ui.Container;
import com.codename1.ui.Dialog;
import com.codename1.ui.Display;
import com.codename1.ui.Form;
import com.codename1.ui.Tabs;
import com.codename1.ui.TextField;
import com.codename1.ui.events.ActionEvent;
import com.codename1.ui.events.ActionListener;
import com.codename1.ui.layouts.BorderLayout;
import com.codename1.ui.spinner.Picker;
import com.codename1.ui.util.Resources;
import com.codename1.ui.util.UIBuilder;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

/**
 *
 * @author Mehdi Chaabene
 */
public class afficher {
  
    public afficher(Resources theme,Form home) {
        UIBuilder ub = new UIBuilder();
        UIBuilder.registerCustomComponent("Picker", Picker.class);
        UIBuilder.registerCustomComponent("Picker1", Picker.class);

        Container ct = ub.createContainer(theme, "GUI 1");
        Container ct1 = ub.createContainer(theme, "GUI 2");
        Container ct2 = ub.createContainer(theme, "GUI 3");

        Tabs tb = new Tabs();
        tb.addTab("Aller-Retour", ct);
        tb.addTab("Aller Simple", ct1);

        Form hii = new Form("Vols", new BorderLayout());
        hii.add(BorderLayout.CENTER, tb);
        hii.show();
        
          hii.getToolbar().addCommandToLeftBar("back", null, new ActionListener() {
                    @Override
                    public void actionPerformed(ActionEvent evt) {
                        home.show();
                            
                            
                    }
                });
        Form hi = new Form("Hi World");
        Form f3 = (Form) ct2;

        SpanLabel sp = new SpanLabel();
        f3.add(sp);
        // hi.show();
        Button bt = new Button();
        Button m = new Button();

        bt = (Button) ub.findByName("Button", ct);
        m = (Button) ub.findByName("Button1", ct);

        TextField name = (TextField) ub.findByName("TextField", ct);
        TextField arrivee = (TextField) ub.findByName("TextField1", ct);

        // ConnectionRequest con = new ConnectionRequest();
        /* bt.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent evt) {

                sp.setText(findVols(new String(con.getResponseData()),name1) + "");
                hi.refreshTheme();
                f3.show();
            }

        });*/
        f3.getToolbar().addCommandToLeftBar("Retour", null, new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent evt) {
                hii.showBack();
            }
        });

        m.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent evt) {
                Vol f = new Vol();
                Message m = new Message("bonjour monsieur je veux plus d'infomations sur les vols");
                Display.getInstance().sendMessage(new String[]{"mehdi.chaabane@esprit.tn"}, "demande d'info", m);
                System.out.println("ok");

            }
        });

        //NetworkManager.getInstance().addToQueue(con);
//        bt.addActionListener(new ActionListener() {
//            @Override
//            public void actionPerformed(ActionEvent evt) {
//                ConnectionRequest con = new ConnectionRequest();
//                con.setUrl("http://localhost/GoVoyage/web/app_dev.php/GoVoyage/afficherCode");
//
//                con.addResponseListener(new ActionListener<NetworkEvent>() {
//                
//                    @Override
//                    public void actionPerformed(NetworkEvent evt) {
//                        String nom = name.getText();
//                        String arrive = arrivee.getText();
//
//                        if (nom == null || nom.length() == 0) {
//                            Dialog.show("Error", "saisie invalide", "OK", "Cancel");
//                            //sp.setText(getListClub(new String(con.getResponseData()))+"\n");
//                            //f4.refreshTheme();}
//                        } // System.out.println(getListClub(new String(con.getResponseData())));
//                        /*else if(findVols(new String(con.getResponseData()),nom).isEmpty())
//                { 
//                    Dialog.show("Error", "pas de resultat", "OK", "Cancel"); }
//                //   sp.setText("");   */ else {
//                            sp.setText(getListVols(new String(con.getResponseData()),nom) + "");
//                         
//                          
//                            hi.refreshTheme();
//                            f3.show();
//                        }
//                    }
//                });
//                
//                NetworkManager.getInstance().addToQueue(con);
//            }
//        });
        bt.addActionListener(new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent evt) {
                ConnectionRequest con = new ConnectionRequest();
                con.setUrl("http://localhost/GoVoyage/web/app_dev.php/GoVoyage/afficherCodeOne/"+name.getText()+"/"+arrivee.getText());

                con.addResponseListener(new ActionListener<NetworkEvent>() {
                    @Override
                    public void actionPerformed(NetworkEvent evt) {
                              String depart = name.getText();

                        if (depart == null || depart.length() == 0) {
                            Dialog.show("Error", "saisie invalide", "OK", "Cancel");
                            
                     }
                        else {
                        sp.setText(getListVols(new String(con.getResponseData())) + "");

                        hi.refreshTheme();
                        f3.show();
                        }
                    }
                });

                NetworkManager.getInstance().addToQueue(con);
            }
        });

        //f.show();
    }

    public ArrayList<Vol> getListVols(String json) {
        ArrayList<Vol> listVols = new ArrayList<>();
        //System.out.println("JSON*************\n" + json);
        try {

            JSONParser j = new JSONParser();

            Map<String, Object> vols = j.parseJSON(new CharArrayReader(json.toCharArray()));

            System.out.println();
            List<Map<String, Object>> list = (List<Map<String, Object>>) vols.get("root");

            for (Map<String, Object> obj : list) {
                Vol e = new Vol();

                /*
                    if ((((String) obj.get("villedepart")).equals(villedepart))&&(((String) obj.get("villearrivee")).equals(villearrivee))) {
                    e.setVilleDepart((String) obj.get("villedepart"));
                    e.setVilleArrivee((String) obj.get("villearrivee"));*/
                // if (((String) obj.get("villedepart")).equals(villedepart)) {
                e.setVilleDepart((String) obj.get("villedepart"));
                e.setVilleArrivee((String) obj.get("villearrivee"));
                 e.setCie_aerienne((String) obj.get("cieAerienne"));

                    e.setHeureDepart((String) obj.get("heuredepart"));
                    e.setTypeAvion((String) obj.get("typeavion"));

                listVols.add(e);
                // }
                System.out.println(e.toString());
                ;

            }

        } catch (IOException ex) {
        }
        return listVols;

    }

    public Vol findVols(String json, String villedepart) {
        Vol c = new Vol();

        try {

            JSONParser j = new JSONParser();

            Map<String, Object> clubs = j.parseJSON(new CharArrayReader(json.toCharArray()));

            List<Map<String, Object>> list = (List<Map<String, Object>>) clubs.get("root");
            for (Map<String, Object> obj : list) {
                //id, json, status);
                if (((String) obj.get("villedepart")).equals(villedepart)) {
                    c.setCie_aerienne((String) obj.get("cie_aerienne"));

                    c.setVilleDepart((String) obj.get("villedepart"));
                    c.setVilleArrivee((String) obj.get("villearrivee"));
                    c.setHeureDepart((String) obj.get("heuredepart"));
                    c.setTypeAvion((String) obj.get("typeavion"));
                    c.setTarif((Float) obj.get("tarif"));

                }

            }
        } catch (IOException ex) {
        }
        return c;

    }

    public Vol findTasks(String json) {
        System.out.println("JSON***********\n" + json);
        Vol e = new Vol();
        try {

            JSONParser j = new JSONParser();

            Map<String, Object> task = j.parseJSON(new CharArrayReader(json.toCharArray()));

            System.out.println();

            //e.setRef((int) Float.parseFloat(task.get("ref").toString()));
            //e.setStatus((int) Float.parseFloat(task.get("status").toString()));
            e.setVilleDepart(task.get("villedepart").toString());
            e.setVilleArrivee(task.get("villearrivee").toString());

        } catch (IOException ex) {
        }
        return e;

    }

}
