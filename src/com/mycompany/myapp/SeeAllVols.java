/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.myapp;

import com.codename1.ui.Button;
import static com.codename1.ui.Component.CENTER;
import com.codename1.ui.Container;
import com.codename1.ui.Dialog;
import com.codename1.ui.Display;
import com.codename1.ui.Form;
import com.codename1.ui.Label;
import com.codename1.ui.events.ActionEvent;
import com.codename1.ui.events.ActionListener;
import com.codename1.ui.layouts.BorderLayout;
import com.codename1.ui.layouts.BoxLayout;
import com.codename1.ui.util.Resources;

/**
 *
 * @author imc
 */
class SeeAllVols extends Form {
    
     private Form current;
    public static Form mainForm;
    private  Label discussion ;
    private  Button ajout3,ajout ,ajout2 , backBtn;
     private  Button alloffres ,allcommentaire;
    private Container cnt1 ;
    private Resources theme;
    
     public SeeAllVols(){
        this.setLayout(new BorderLayout());
         discussion = new Label("Vols");
         ajout =new Button ("Ajouter un Vol ");
     
         alloffres =new Button ("Liste des Vols");
         
        backBtn = new Button("Retour");
        
        
         discussion.setAlignment(CENTER);
         
         
     cnt1 = new Container(new BoxLayout(BoxLayout.Y_AXIS)) ;
     
     cnt1.add(discussion);
     cnt1.add(alloffres);
     cnt1.add(ajout);
    
    
   
   //cnt1.add(backBtn);
     
     
      this.add(BorderLayout.CENTER, cnt1);
      
      
       alloffres.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent evt) {
                new ServiceVol().findAllVols();
            }
        });
     
      
     ajout.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent evt) {

                AddVol aaa = new AddVol();
                aaa.show();
            }
        });
     
//    
//         backBtn.addActionListener(e->{
//        
//        SeeAllRandonnees ds=new SeeAllRandonnees();
// 
//        ds.show();  
//        });
     }
       
 public void stop() {
        current = Display.getInstance().getCurrent();
        if(current instanceof Dialog) {
            ((Dialog)current).dispose();
            current = Display.getInstance().getCurrent();
        }
    }


    
}
