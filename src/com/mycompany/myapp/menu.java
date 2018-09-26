/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.myapp;

import com.codename1.ui.Image;
import com.codename1.components.ImageViewer;
import com.codename1.ui.Button;
import com.codename1.ui.Command;
import com.codename1.ui.Display;
import com.codename1.ui.EncodedImage;
import com.codename1.ui.Font;
import com.codename1.ui.FontImage;
import com.codename1.ui.Form;
import com.codename1.ui.Image;
import com.codename1.ui.Label;
import com.codename1.ui.NavigationCommand;
import com.codename1.ui.URLImage;
import com.codename1.ui.events.ActionEvent;
import com.codename1.ui.events.ActionListener;
import com.codename1.ui.layouts.BoxLayout;
import com.codename1.ui.plaf.UIManager;
import com.codename1.ui.util.Resources;
import com.codename1.ui.util.UIBuilder;
import java.io.IOException;

/**
 *
 * @author nizar
 */
public class menu {
    Form f;
      Form home = new Form("Hi", BoxLayout.y());
       private Form home1;
    EncodedImage im;
    Image img;
    ImageViewer imgv;
    String url = "http://localhost/Mobile/b.jpg";
     public menu(Resources theme){
        
        UIBuilder ui = new UIBuilder();
        f= ui.createContainer(theme, "Menu").getComponentForm();
        
         Label lNom =(Label) ui.findByName("Label", f);
         
        lNom.setText(" Bienvenue Dans l'éspace Resensable ");
         
        
         f.getToolbar().addCommandToSideMenu("Hebergements", null, new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent evt) {
         ListeHeberg ls1 = new ListeHeberg(theme);
         ls1.getF().show();
            }
            
        });
         f.getToolbar().addCommandToSideMenu("Vols", null, new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent evt) {
           ListeVol ls = new ListeVol(theme);
          ls.getF().show();
            }
            
        });
        
        f.getToolbar().addCommandToSideMenu("Liste Offres", null, new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent evt) {
           ListOffers ls = new ListOffers(theme);
         // ls.getF().show();
            }
            
        });
         f.getToolbar().addCommandToSideMenu("Les Réclamations", null, new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent evt) {
            AdminReclamation ar = new AdminReclamation(theme,home);
         // ls.getF().show();
            }
            
        });
//        f.getToolbar().addCommandToSideMenu("Gestion des vols", null, new ActionListener() {
//
//            @Override
//            public void actionPerformed(ActionEvent evt) {
//        try {
//            im = EncodedImage.create("/b.jpg");
//        } catch (IOException ex) {
//            //Logger.getLogger(MyApplication.class.getName()).log(Level.SEVERE, null, ex);
//        }
//        img = URLImage.createToStorage(im, "img4", url, URLImage.RESIZE_SCALE);
//        imgv = new ImageViewer(img);//img de type image
//
//        home1 = new Form("Vols");
//        home1.setLayout(new BoxLayout(BoxLayout.Y_AXIS));
//        home1.addComponent(new Label("Accueil"));
//        home1.add(imgv);
////        Form hi = new Form("Hi World");
////        hi.addComponent(new Label("Hi World"));
//
//        Stat st = new Stat();
//        setBackCommand(st);
//        ApiStat1 af = new ApiStat1();
//        setBackCommand(st);
//
////        Button b1 = new Button("Show Chart");
////        b1.addActionListener(new ActionListener() {
////
////            @Override
////            public void actionPerformed(ActionEvent evt) {
////
////                st.show();
////            }
////        });
//
//        Button b2 = new Button("Show Chart api");
//        b2.addActionListener(new ActionListener() {
//
//            @Override
//            public void actionPerformed(ActionEvent evt) {
//
//                af.createPieChartForm().show();
//            }
//        });
//
//        //home.addComponent(b1);
//        home1.addComponent(b2);
//        Form hi = new Form("b.jpg");
//        Font materialFont = FontImage.getMaterialDesignFont();
//        int w = Display.getInstance().getDisplayWidth();
//        FontImage fntImage = FontImage.createFixed("\uE161", materialFont, 0xff0000, w, w);
//        home1.add(fntImage);
//
//       // home1.show();
//      
//
//        Image im = FontImage.createMaterial(FontImage.MATERIAL_MODE_EDIT, UIManager.getInstance().getComponentStyle("Command"));
//        Command edit = new Command("Se déconnecter", im) {
//
//            @Override
//            public void actionPerformed(ActionEvent evt) {
//                System.out.println("Déconnection");
//            }
//        };
//        home1.getToolbar().addCommandToOverflowMenu(edit);
//
//        home1.show();
//            }
//            
//        });
         

//        SeeAllVols form4 = new SeeAllVols();
//        setBackCommand(form4);
//
//        
//
//        NavigationCommand cmd4 = new NavigationCommand("Gestion des vols");
//        cmd4.setNextForm(form4);
//        f.getToolbar().addCommandToSideMenu(cmd4);
//
//       Stat st = new Stat();
//        setBackCommand(st);
//        ApiStat1 af = new ApiStat1();
//        setBackCommand(st);
//        NavigationCommand cmd6 = new NavigationCommand("Statistiques des vols");
//        cmd6.setNextForm(af.createPieChartForm());
//        f.getToolbar().addCommandToSideMenu(cmd6);
//        f.getToolbar().addCommandToSideMenu("SMS", null, new ActionListener() {
//
//            @Override
//            public void actionPerformed(ActionEvent evt) {
//           Sms ls = new Sms(theme);
//         // ls.getF().show();
//            }
//            
//        });
 f.getToolbar().addCommandToRightBar("Déconnexion",theme.getImage("back_left_pressed.png"),new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent evt) {
                login log = new login(theme);
    log.getF().show();
            }
            
        });
         
   
    }
   protected void setBackCommand(Form f) {
        Command back = new Command("") {

            @Override
            public void actionPerformed(ActionEvent evt) {
                home.showBack();
            }

        };
        Image img = FontImage.createMaterial(FontImage.MATERIAL_ARROW_BACK, UIManager.getInstance().getComponentStyle("TitleCommand"));
        back.setIcon(img);
        f.getToolbar().addCommandToLeftBar(back);
        f.getToolbar().setTitleCentered(true);
        f.setBackCommand(back);
    }
    public Form getF() {
        return f;
    }

    public void setF(Form f) {
        this.f = f;
    }
}
