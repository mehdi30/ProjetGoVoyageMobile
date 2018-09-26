/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.myapp;
import Entity.Reservation;
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
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

/**
 *
 * @author Imen
 */
public class showRVolForm {
    Form f; 
    Container cnts = new Container(new BoxLayout(BoxLayout.Y_AXIS)); 
    public showRVolForm(Resources theme){
        
       Form hi = new Form("Mes réservations");
           hi.getToolbar().addCommandToLeftBar("Back",theme.getImage("back-command.png"),new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent evt) {
                StartImen i = new StartImen(theme);
            }
        });
          Button addbutt = new Button("Reserver");
       // SpanLabel sp = new SpanLabel();
        hi.add(cnts);
         hi.add(addbutt);
        // hi.refreshTheme();
       // hi.show();
        addbutt.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent evt) {
              RvolNewForm   f1 =new RvolNewForm(theme,"57");
            //   f1.getF().show();
            }
        });
        ConnectionRequest con = new ConnectionRequest();
       //con.setUrl("http://localhost/GoVoyage/web/app_dev.php/GoVoyage/FindMR/7");
      con.setUrl("http://localhost/GoVoyage/web/app_dev.php/GoVoyage/showMR"); //Pour la liste des étudiants 
        con.addResponseListener(new ActionListener<NetworkEvent>() {

            @Override
            public void actionPerformed(NetworkEvent evt) {
                System.out.println(getListReservation(theme,new String(con.getResponseData())));
              // sp.setText(findRVol(new String(con.getResponseData())) + "");
             /// sp.setText((getListReservation(new String(con.getResponseData()))) + "");
             getListReservation(theme,new String(con.getResponseData()));  
            
                hi.refreshTheme();

            }
        });
        NetworkManager.getInstance().addToQueue(con);
         hi.show();
    }

    public Reservation findRVol(String json) {
        System.out.println("JSON***********\n"+json);
        Reservation e = new Reservation();
        try {

            JSONParser j = new JSONParser();

            Map<String, Object> RVol = j.parseJSON(new CharArrayReader(json.toCharArray()));

            System.out.println();

            e.setRef((int) Float.parseFloat(RVol.get("ref").toString()));
//            e.setType((String) Float.parseFloat(RVol.get("type").toString()));
           e.setType(RVol.get("type").toString());
            

        } catch (IOException ex) {
        }
        return e;

    }

    public ArrayList<Reservation> getListReservation(Resources theme,String json) {
        ArrayList<Reservation> listReservations = new ArrayList<>();
        System.out.println("JSON*************\n"+json);
        try {

            JSONParser j = new JSONParser();
            
            Map<String, Object> etudiants = j.parseJSON(new CharArrayReader(json.toCharArray()));

            System.out.println();
            List<Map<String, Object>> list = (List<Map<String, Object>>) etudiants.get("root");
         
            for (Map<String, Object> obj : list) {
                   System.out.println(obj.get("type").toString());
           
                  
                Reservation e = new Reservation();//id, json, status);
//                e.setId((int) Float.parseFloat(obj.get("id").toString()));
//                e.setStatus((int) Float.parseFloat(obj.get("status").toString()));
//                e.setNom(obj.get("name").toString());
    e.setRef((int) Float.parseFloat(obj.get("ref").toString()));
//            e.setType((String) Float.parseFloat(RVol.get("type").toString()));

           e.setType(obj.get("type").toString());
           if(        "Flight".equals(obj.get("type").toString())){
           e.setNombreAdultes((int) Float.parseFloat(obj.get("nbreAdultes").toString()));
           e.setNombreEnfants((int) Float.parseFloat(obj.get("nbreEnfants").toString()));
           
           Map<String, Object> list1 =(Map<String, Object>) obj.get("refVolFk");
           e.setRef_vol_fk(list1.get("numvol").toString());
           
            int  k=(int) Float.parseFloat(list1.get("ref").toString());
              e.setDate_res(obj.get("dateCreation").toString());
            e.setPrixTotal((int) Float.parseFloat(obj.get("prixTotal").toString()));
        //if(        "Flight".equals(obj.get("type").toString())){
               cnts.add(createContainer(theme,e.toStringVol(),e.getRef(),k,
                       e.getNombreAdultes(),e.getNombreEnfants(),
                               e.getPrixTotal(),e.getDate_res()));}
                listReservations.add(e);

            }

        } catch (IOException ex) {
        }
        return listReservations;

    }
    
     public Container createContainer(Resources theme, String text,int ref,int ref_vol_fk, int nombreAdultes , int nombreEnfants ,Float prixTotal1, String dateC )
     {
         SpanLabel sp = new SpanLabel(text); 
         //les butt
         Button modifbutt = new Button("Modifier la reservation");
         Button suppbutt = new Button("supp la reservation");
         suppbutt.addActionListener(new ActionListener() {
             @Override
             public void actionPerformed(ActionEvent evt) {
                   ConnectionRequest req = new ConnectionRequest();
                  if(Dialog.show("Confirmation", "Reservation supprimée", "Ok", null)) 
                  {
                      
               

//                req.setUrl("http://pidev.justsmart.tn/api/tasks/new?id="+tfId.getText()
//                        +"&name="+tfName.getText() +"&status=0" +tfStatus.getText() + "");
                req.setUrl("http://localhost/GoVoyage/web/app_dev.php/GoVoyage/deleteMR?ref="+ref+"");

                req.addResponseListener(new ActionListener<NetworkEvent>() {

                    @Override
                    public void actionPerformed(NetworkEvent evt) {
                        byte[] data = (byte[]) evt.getMetaData();
                        String s = new String(data);
                        System.out.println(s);
                       // if (s.equals("success")) {
                                                    //}
                        
                    }
                });
                
                NetworkManager.getInstance().addToQueue(req);
               showRVolForm f2 = new showRVolForm(theme);}
             }
         });
       
         modifbutt.addActionListener(new ActionListener() {
             @Override
             public void actionPerformed(ActionEvent evt) {
            
                 
            RVolupdateForm v =new RVolupdateForm( theme,  ref ,  nombreAdultes, nombreEnfants, ref_vol_fk, prixTotal1);
             }
         });
         
         Container cnt =new Container(new BoxLayout(BoxLayout.Y_AXIS)); 
         cnt.add(sp);
         cnt.add(modifbutt);
         cnt.add(suppbutt);
         
          Container cnt2 =BorderLayout.center(cnt); 
         // f.refreshTheme();
          return cnt2;
         
         
     }
 
    public Form getF() {
        return f;
    }

    public void setF(Form f) {
        this.f = f;
    }
    
    
    
 public void show(){
     
      f.show(); 
 }
    
}
