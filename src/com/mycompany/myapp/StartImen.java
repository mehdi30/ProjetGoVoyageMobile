/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.myapp;

import com.codename1.messaging.Message;
import com.codename1.ui.Display;
import com.codename1.ui.Form;
import com.codename1.ui.Toolbar;
import com.codename1.ui.events.ActionEvent;
import com.codename1.ui.events.ActionListener;
import com.codename1.ui.util.Resources;

/**
 *
 * @author Imen
 */
public class StartImen {
    
    public StartImen(Resources theme)
    {
              
        Form fMenuReservation= new Form("Mes Reservations");
      Toolbar tb =new Toolbar();
         fMenuReservation.getToolbar().addCommandToSideMenu("Reservation de Vol", null, new ActionListener() {
           
            @Override
            public void actionPerformed(ActionEvent evt) {
                showRVolForm showf = new showRVolForm(theme);
            }
        });
          fMenuReservation.getToolbar().addCommandToSideMenu("Reservation d''Hotel", null, new ActionListener() {
           
            @Override
            public void actionPerformed(ActionEvent evt) {
                showRHotelForm showf = new showRHotelForm(theme);
            }
        });
          
        
           fMenuReservation.getToolbar().addCommandToSideMenu("Reservation de Hote", null, new ActionListener() {
           
            @Override
            public void actionPerformed(ActionEvent evt) {
                showRHoteForm showf = new showRHoteForm(theme);
            }
        });
           
           fMenuReservation.getToolbar().addCommandToSideMenu("SMS", null, new ActionListener() {
           
            @Override
            public void actionPerformed(ActionEvent evt) {
                SmsReservation showf = new SmsReservation(theme);
            }
        });
            fMenuReservation.getToolbar().addCommandToSideMenu("Capture", null, new ActionListener() {
           
            @Override
            public void actionPerformed(ActionEvent evt) {
                CaptureimageReser showf = new CaptureimageReser(theme);
            }
        });
               fMenuReservation.getToolbar().addCommandToSideMenu("Contact par email", null, new ActionListener() {
           
            @Override
            public void actionPerformed(ActionEvent evt) {
                Message m = new Message("Body of message:raison pour annuler ma reservation");
Display.getInstance().sendMessage(new String[] {"imen.brahim@esprit.tn"}, "Subject of message : contact admin about a problem ", m);
            }
        });
               
                    fMenuReservation.getToolbar().addCommandToSideMenu("Signature", null, new ActionListener() {
           
            
          

            @Override
            public void actionPerformed(ActionEvent evt) {
                  SignatureReservation s =new SignatureReservation(theme);
            }
         
        });
//                    fMenuReservation.getToolbar().addCommandToSideMenu("Retour", null, new ActionListener() {
//           
//            
//          
//
//            @Override
//            public void actionPerformed(ActionEvent evt) {
//                   home.show();
//            }
//         
//        });
                 
           
           
//           
//           fMenuReservation.setToolbar(new Toolbar());
//Style s = UIManager.getInstance().getComponentStyle("Title");
//FontImage icon = FontImage.createMaterial(FontImage.MATERIAL_CAMERA, s);
//
//ImageViewer iv = new ImageViewer(icon);
//
//fMenuReservation.getToolbar().addCommandToRightBar("", icon, (ev) -> {
//    String filePath = Capture.capturePhoto();
//    if(filePath != null) {
//        try {
//            DefaultListModel<Image> m = (DefaultListModel<Image>)iv.getImageList();
//            Image img = Image.createImage(filePath);
//            if(m == null) {
//                m = new DefaultListModel<>(img);
//                iv.setImageList(m);
//                iv.setImage(img);
//            } else {
//                m.addItem(img);
//            }
//            m.setSelectedIndex(m.getSize() - 1);
//        } catch(IOException err) {
//            Log.e(err);
//        }
//    }
//});
//
//fMenuReservation.add(BorderLayout.CENTER, iv);
            
fMenuReservation.show();
       
       //showf.getF().show();
       /////////what u need to date format 
//        SimpleDateFormat format = new SimpleDateFormat("y-M-y"); 
//        Picker dateD =(Picker) ui.FindByname("Picker", ct ); 
//        dateD.setFormatter(Format); 
        
       
    
    
    }
    
    
}
