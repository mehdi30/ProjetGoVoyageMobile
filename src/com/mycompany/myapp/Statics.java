/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.myapp;

import com.codename1.ui.Button;
import com.codename1.ui.Font;
import com.codename1.ui.Label;
import com.codename1.ui.events.ActionEvent;
import com.codename1.ui.events.ActionListener;

/**
 *
 * @author azuz
 */
class Statics {
    public static void setLabelStyle(Label l){
        l.getUnselectedStyle().setFgColor(-16777216);
        l.getUnselectedStyle().setFont(Font.createSystemFont(Font.FACE_SYSTEM, Font.STYLE_ITALIC, Font.SIZE_MEDIUM));
    }
     
     public static Button createBackBtn(){
         Button b=new Button("Retour");
      //   b.getUnselectedStyle().setFgColor(5542241);
         b.addActionListener((ActionListener) (ActionEvent evt) -> {
          SeeAllVols ds=new SeeAllVols();
 
        ds.show();    // Accueil. ctnAccueil.show();
         });
         return b;
     }
    
     /*
     public static Toolbar createtoolbar(){
     
           SeeAllCars cc= new SeeAllCars();
          //Toolbar
           Toolbar tt = new Toolbar();
        tt.setGlobalToolbar(true);
        Style s = UIManager.getInstance().getComponentStyle("TitleCommand");
        FontImage icon = FontImage.createMaterial(FontImage.MATERIAL_HOME, s);
        cc.getToolbar().addCommandToLeftBar("Home", icon, (e) -> {

            Log.p("Clicked");
                cc.show();

                });
     return  tt;
     }
     */
    
}
