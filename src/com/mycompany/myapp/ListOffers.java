/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.myapp;

import Entity.Offreh;
import Entity.Offrev;
import com.codename1.components.SpanLabel;
import com.codename1.io.CharArrayReader;
import com.codename1.io.ConnectionRequest;
import com.codename1.io.JSONParser;
import com.codename1.io.NetworkEvent;
import com.codename1.io.NetworkManager;
import com.codename1.ui.Button;
import com.codename1.ui.Container;
import com.codename1.ui.Dialog;
import com.codename1.ui.Form;
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
public class ListOffers extends Form{
  // Form f;
      Container cnts = new Container(new BoxLayout(BoxLayout.Y_AXIS));
    int compteur=0; int i=0;
    double[] tableau = new double[20]; 
    public ListOffers(Resources theme)
    {
         UIBuilder ui = new UIBuilder();
   //  f= ui.createContainer(theme, "ListOffre").getComponentForm();
Container ct=ui.createContainer(theme, "ListOffre");

         Form f=(Form)ct;
           f.add(cnts);
            f.refreshTheme();
         f.show();

           ConnectionRequest con = new ConnectionRequest();
        ConnectionRequest con1 = new ConnectionRequest();
      // con.setUrl("http://pidev.justsmart.tn/api/tasks/find/259");
   //     con.setUrl("http://pidev.justsmart.tn/api/tasks/all"); //Pour la liste des étudiants
    
   con.setUrl("http://localhost/GoVoyage/web/app_dev.php/GoVoyage/alla");   
        con.addResponseListener((NetworkEvent evt) -> {
            //System.out.println(getListEtudiant(new String(con.getResponseData())));
          //  sp.setText(getListEtudiant(new String(con.getResponseData())) + "");
            getListEtudiant(new String(con.getResponseData()),theme);
         f.refreshTheme();
        });
        NetworkManager.getInstance().addToQueue(con);
         
         con1.setUrl("http://localhost/GoVoyage/web/app_dev.php/GoVoyage/allaa");
        con1.addResponseListener((NetworkEvent evt) -> {
            //System.out.println(getListEtudiant(new String(con.getResponseData())));
           // sp.setText(sp.getText()+getListEtudiant1(new String(con1.getResponseData())) + "");
           getListEtudiant1(new String(con1.getResponseData()),theme);
            f.refreshTheme();
        });
        
        
        NetworkManager.getInstance().addToQueue(con1);  
        
         f.getToolbar().addCommandToLeftBar("",theme.getImage("back_left_pressed.png"),new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent evt) {
                menu m= new menu(theme);
                m.getF().show();
            }
        });
          f.getToolbar().addCommandToLeftBar("Statistiques", null, new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent evt) {
               
             
      
    
        ApiStat af = new ApiStat();
      
        af.createPieChartForm(theme,compteur,tableau).show();
   
            }
            
        });
    }
// public TaskEtudiant findTasks(String json) {
//        System.out.println("JSON*\n"+json);
//        TaskEtudiant e = new TaskEtudiant();
//   
//            JSONParser j = new JSONParser();
//
//            Map<String, Object> task;
//        try {
//            task = j.parseJSON(new CharArrayReader(json.toCharArray()));
//        
//
//            System.out.println();
//
//           e.setId((int) Float.parseFloat(task.get("id").toString()));
//            e.setStatus((int) Float.parseFloat(task.get("status").toString()));
//            e.setNom(task.get("name").toString());
//} catch (IOException ex) {
//        }
//       
//        return e;
//
//    }

    public ArrayList<Offrev> getListEtudiant(String json,Resources theme) {
        ArrayList<Offrev> listEtudiants = new ArrayList<>();
        try {

            JSONParser j = new JSONParser();
            
            Map<String, Object> etudiants = j.parseJSON(new CharArrayReader(json.toCharArray()));

            List<Map<String, Object>> list = (List<Map<String, Object>>) etudiants.get("root");
            
           
            for (Map<String, Object> obj : list) {
               Map<String, Object> list1 = (Map<String, Object>) obj.get("refVol");
               
                Offrev e = new Offrev();//id, json, status);
                e.setReference((int) Float.parseFloat(obj.get("ref").toString()));
                e.setSpecification((int) Float.parseFloat(obj.get("specification").toString()));
                e.setType(obj.get("type").toString());
                e.setDateDebut(obj.get("datedebut").toString());
                e.setDateFin(obj.get("datefin").toString());		
                e.setVol(list1.get("numvol").toString());
                 cnts.add(createContainer(e+"",e.getReference()+"",e.getSpecification()+"",e.getType(),e.getVol(),theme));
                 compteur++;
                 tableau[i]=(double) Float.parseFloat(obj.get("specification").toString());
                 i++;
                //e.setVol(obj.get("refVol").toString());
                listEtudiants.add(e);

            }

        } catch (IOException ex) {
        }
        return listEtudiants;
    }
     public ArrayList<Offreh> getListEtudiant1(String json,Resources theme) {
        ArrayList<Offreh> listEtudiants = new ArrayList<>();
        try {

            JSONParser j = new JSONParser();
            
            Map<String, Object> etudiants = j.parseJSON(new CharArrayReader(json.toCharArray()));

            List<Map<String, Object>> list = (List<Map<String, Object>>) etudiants.get("root");

            for (Map<String, Object> obj : list) {
                 Map<String, Object> list1 = (Map<String, Object>) obj.get("refHeberg");
                Offreh e = new Offreh();//id, json, status);
                e.setReference((int) Float.parseFloat(obj.get("ref").toString()));
                e.setSpecification((int) Float.parseFloat(obj.get("specification").toString()));
                e.setType(obj.get("type").toString());
                e.setDateDebut(obj.get("datedebut").toString());
                e.setDateFin(obj.get("datefin").toString());
                e.setHeberg(list1.get("nom").toString());
                     cnts.add(createContainer(e+"",e.getReference()+"",e.getSpecification()+"",e.getType(),e.getHeberg(),theme));
                compteur++;
                 tableau[i]=(double) Float.parseFloat(obj.get("specification").toString());
                 i++;
                listEtudiants.add(e);

            }

        } catch (IOException ex) {
        }
        return listEtudiants;
    }
     public Container createContainer(String text,String id,String spec,String type,String reference,Resources theme){
  SpanLabel sp = new SpanLabel(text);
    Button btmodif = new Button("Modifier Offre");
    Button btsupp = new Button("Supprimer Offre");
    btsupp.addActionListener(new ActionListener() {
        @Override
        public void actionPerformed(ActionEvent evt) {
   ConnectionRequest req = new ConnectionRequest();
         if(    Dialog.show("Confirmation", "ete vous sure de Supprimer?", "oui", "Cancel"))
                        {   
                         
                req.setUrl("http://localhost/GoVoyage/web/app_dev.php/GoVoyage/delete?spec="+
                        spec +"&type=" +type+"&id=" +id
                        + "&num=" +reference+"");
                           
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
    btmodif.addActionListener(new ActionListener() {
        @Override
        public void actionPerformed(ActionEvent evt) {
                      ModifOffre modifoffre = new ModifOffre(theme,type,spec,reference,id);
        }
    });
   // Label image = new Label(c.getImg());
    
    Container cnt = new Container(new BoxLayout(BoxLayout.Y_AXIS));
    cnt.add(sp);
    cnt.add(btsupp);
    cnt.add(btmodif);
    Container cnt2 = BorderLayout.center(cnt);
   // cnt2.add(BorderLayout.EAST, image);
   // cnt2.setLeadComponent(btnom);
    return cnt2;
}

   
    
}
