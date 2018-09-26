/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.myapp;

import com.codename1.io.ConnectionRequest;
import com.codename1.io.NetworkEvent;
import com.codename1.io.NetworkManager;
import com.codename1.l10n.SimpleDateFormat;
import com.codename1.ui.Button;
import com.codename1.ui.Dialog;
import com.codename1.ui.Form;
import com.codename1.ui.TextField;
import com.codename1.ui.events.ActionEvent;
import com.codename1.ui.events.ActionListener;
import com.codename1.ui.layouts.BoxLayout;
import com.codename1.ui.spinner.Picker;
import com.codename1.ui.util.Resources;

/**
 *
 * @author Imen
 */
public class RHotelNewForm {
     Form f ;
    TextField tfLogin;
    
    //////////
   

     public RHotelNewForm(Resources theme,int ref_hebergement_fk){



        Form f = new Form("Insert", BoxLayout.y());

       // TextField type = new TextField("", "type");
        TextField nbreAdultes = new TextField("", "Nombre d'adultes:");
        TextField nbreEnfants = new TextField("", "Nombre d'enfants:");
        TextField nbreNuits = new TextField("", "Nombre de nuits:");
        TextField nbreChbreSingle = new TextField("", "Nombre de chambres Single:");
        TextField nbreChbreDouble = new TextField("", "Nombre de chambres Double");
        TextField prixTotal = new TextField("", "Prix total:");
        int refClientFk=1; 
        //int ref_hebergement_fk;
         Picker dateC =new Picker();
                
        SimpleDateFormat format = new SimpleDateFormat("y-M-dd"); 

         dateC.setFormatter(format); 
          Picker dateArriveeH =new Picker();
          dateArriveeH.setFormatter(format); 
          Picker dateSortieH =new Picker();
          dateSortieH.setFormatter(format);   
       


       
        f.add(nbreAdultes);
        f.add(nbreEnfants);
        f.add(nbreNuits);
        f.add(nbreChbreSingle);
        f.add(nbreChbreDouble);
        f.add(prixTotal);
           
        f.add(dateArriveeH);
        f.add(dateSortieH);
      
          

          f.getToolbar().addCommandToLeftBar("Back",theme.getImage("back-command.png"),new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent evt) {
                showRHoteForm f2 = new showRHoteForm(theme);
            }
        });
        Button btnOk = new Button("Insert");

        f.add(btnOk);
        btnOk.addActionListener(new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent evt) {

                ConnectionRequest req = new ConnectionRequest();
//                req.setUrl("http://pidev.justsmart.tn/api/tasks/new?id="+tfId.getText()
//                        +"&name="+tfName.getText() +"&status=0" +tfStatus.getText() + "");
                req.setUrl("http://localhost/GoVoyage/web/app_dev.php/GoVoyage/addMRHotel?type=Hotel"
                       +"&nbreAdultes="+nbreAdultes.getText()+"&nbreEnfants="+nbreEnfants.getText()
                +"&nbreNuits="+nbreNuits.getText()+"&nbreChbreSingle="+nbreChbreSingle.getText()
                +"&nbreChbreDouble="+nbreChbreDouble.getText()+"&prixTotal="+prixTotal.getText()
                +"&refClientFk="+refClientFk+"&refHebergementFk="+ref_hebergement_fk+"&dateC="+dateC.getText()
                +"&dateArriveeH="+dateArriveeH.getText()+"&dateSortieH="+dateSortieH.getText());

                req.addResponseListener(new ActionListener<NetworkEvent>() {

                    @Override
                    public void actionPerformed(NetworkEvent evt) {
                        byte[] data = (byte[]) evt.getMetaData();
                        String s = new String(data);
                        System.out.println(s);
                       // if (s.equals("success")) {
                            Dialog.show("Confirmation", "Reservation effectuée avec succés", "Ok", null);
                        //}
                    }
                });
                
                NetworkManager.getInstance().addToQueue(req);
                

            }
        });

        f.show();

    }
      public TextField getTfLogin() {
        return tfLogin;
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
