/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.myapp;

import static com.codename1.ui.Component.CENTER;
import com.codename1.ui.Container;
import com.codename1.ui.Form;
import com.codename1.ui.Label;
import com.codename1.ui.layouts.BorderLayout;

/**
 *
 * @author azuz
 */
public class Accueil extends Form {
    
    
  private final Label title ;
    private final  Container  ctnAccueil ;
    
    public Accueil ()
            
    {  this.setLayout(new BorderLayout());
        title = new Label("");
     title.setAlignment(CENTER);
     ctnAccueil = new Container() ;
     ctnAccueil.add(title);
     
      this.add(BorderLayout.NORTH, ctnAccueil);
     
    
    
    
    }
    
    
    
}