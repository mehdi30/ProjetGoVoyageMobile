/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.myapp;


import com.codename1.l10n.SimpleDateFormat;
import com.codename1.ui.Button;
import com.codename1.ui.Component;
import com.codename1.ui.Container;
import com.codename1.ui.Font;
import com.codename1.ui.Form;
import com.codename1.ui.Label;
import com.codename1.ui.TextField;
import com.codename1.ui.events.ActionEvent;
import com.codename1.ui.events.ActionListener;
import com.codename1.ui.layouts.BorderLayout;
import com.codename1.ui.layouts.BoxLayout;
import com.codename1.ui.util.Resources;

/**
 *
 * @author imc
 */
class AddVol extends Form{
    
    
    
    Form f ;
Label l,l1,l2,l3,l4,l5,l6,l7,l8;
Button    addBtn,backBtn;
TextField t1,t2,t3,t5,t7,t8,t6,t4;


private  final Container mainContainer;
public Form current;
public Resources theme;
    
    

   public AddVol(){
      
       this.setLayout(new BorderLayout());
       mainContainer = new Container(new BoxLayout(BoxLayout.Y_AXIS));
       mainContainer.setScrollableY(true);
       l = new Label("aaa ");
       l.getUnselectedStyle().setAlignment(Component.CENTER);

       Font l1_font = Font.createSystemFont(Font.FACE_SYSTEM, Font.STYLE_BOLD, Font.SIZE_LARGE);
   
       l = new Label("Ajouter Un Vol ");
     
       l1 = new Label("Ville de depart");
       t1 = new TextField("");
       
       l2 = new Label("Ville d'Arrivee:");
        t2 = new TextField("");
        
      

 
     
        
       
        addBtn= new Button("Ajouter");
      
        mainContainer.add(l); 
        mainContainer.add(new Label());

        mainContainer.add(l1);

           mainContainer.add(t1);
        mainContainer.add(l2);
     
        mainContainer.add(t2);
    
      
   
       
        
        mainContainer.add(addBtn);
        addBtn.getUnselectedStyle().setFgColor(5542241);
        //backBtn = Statics.createBackBtn(); 
        
        
        //mainContainer.add(backBtn);
     
        backBtn = Statics.createBackBtn(); 
        
        
        mainContainer.add(backBtn);
        
         addBtn.addActionListener((ActionListener) (ActionEvent evt) -> {
           
         
           
           Vol v = new Vol(
                   t1.getText(), t2.getText());
//System.out.println("le prix est:"+Float.parseFloat((String) t8.getText()));
           new ServiceVol().AddOffre(v);
           SeeAllVols ds = new SeeAllVols();
 
        ds.show();  
            });
      
       
       this.add(BorderLayout.CENTER, mainContainer);
        
        
//            backBtn.addActionListener(e->{
//        
//        SeeAllRandonnees ds=new SeeAllRandonnees();
// 
//        ds.show();  
//        });
            
       
    
}
    
}
