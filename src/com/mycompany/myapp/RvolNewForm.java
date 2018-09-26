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
public class RvolNewForm {
      
    Form f ;
    TextField tfLogin;
    
    //////////
   

     public RvolNewForm(Resources theme,String ref_vol_fk){



        Form f = new Form("Insert", BoxLayout.y());

      //  TextField type = new TextField("", "type");
        TextField nbreAdultes = new TextField("", "Nombre d'adultes");
        TextField nbreEnfants = new TextField("", "Nombre d'enfants");
        TextField prixTotal = new TextField("", "Prix total:");
         int refClientFk=1; 
         
             Picker dateC =new Picker();
                
        SimpleDateFormat format = new SimpleDateFormat("y-M-dd"); 

         dateC.setFormatter(format); 
   
        
        f.add(nbreAdultes);
        f.add(nbreEnfants);
        f.add(prixTotal);
              f.getToolbar().addCommandToLeftBar("Back",theme.getImage("back-command.png"),new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent evt) {
                showRVolForm f2 = new showRVolForm(theme);
            }
        });
     
       Button btnOk = new Button("Formulaire de reservation");

        f.add(btnOk);
        btnOk.addActionListener(new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent evt) {

                ConnectionRequest req = new ConnectionRequest();
//                req.setUrl("http://pidev.justsmart.tn/api/tasks/new?id="+tfId.getText()
//                        +"&name="+tfName.getText() +"&status=0" +tfStatus.getText() + "");
                req.setUrl("http://localhost/GoVoyage/web/app_dev.php/GoVoyage/newMR?type=Vol"
                       +"&nbreAdultes="+nbreAdultes.getText()+"&nbreEnfants="+nbreEnfants.getText()+"&prixTotal="+prixTotal.getText()
                +"&refClientFk="+refClientFk+"&refVolFk="+ref_vol_fk+"&dateC="+dateC.getText());

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


