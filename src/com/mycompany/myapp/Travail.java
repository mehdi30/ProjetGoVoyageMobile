/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.myapp;
import Entity.Hotel;
import com.codename1.googlemaps.MapContainer;
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
import com.codename1.ui.TextArea;
import com.codename1.ui.TextField;
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
 * @author asus
 */
public class Travail extends MyApplication{
    
   Container cnts ;
   Container cnts1 ;
   Container pro ;
   com.codename1.ui.Image local;
   com.codename1.ui.Image maping;
       public Travail(Resources theme,Form home)
    {
                      UIBuilder UIB= new UIBuilder();
         Container ct1=UIB.createContainer(theme, "GUI 11");
         Container ct2=UIB.createContainer(theme, "GUI 12");
         Container ct3=UIB.createContainer(theme, "GUI 13");
         Container ct4=UIB.createContainer(theme, "GUI 4");
         Container ct5=UIB.createContainer(theme, "GUI 5");
         Container ct6=UIB.createContainer(theme, "GUI 6");
         Container ct7=UIB.createContainer(theme, "GUI 7");
         Container ct8=UIB.createContainer(theme, "GUI 8");
         Container ct9=UIB.createContainer(theme, "GUI 9");
         
         Form f1=(Form)ct1;
         Form f2=(Form)ct2;
         Form f3=(Form)ct3;
         Form f4=(Form)ct4;
         Form f5=(Form)ct5;
         Form f6=(Form)ct6;
         Form f7=(Form)ct7;
         Form f8=(Form)ct8;
         Form f9=(Form)ct9;
         
        //  SpanLabel sp = new SpanLabel();
        // f2.add(cnts);
          
                   
        //  SpanLabel sp1 = new SpanLabel();
      //    f3.add(cnts);

        SpanLabel sp2 = new SpanLabel();
        f4.add(sp2);
          
                   
        SpanLabel sp3 = new SpanLabel();
         f5.add(sp3);          
          
        TextField tfHotel =  (TextField) UIB.findByName("TextField",ct2);
        TextField tfHote =  (TextField) UIB.findByName("TextField",ct3);

ConnectionRequest con1 = new ConnectionRequest();
con1.setUrl("http://localhost/GoVoyage/web/app_dev.php/GoVoyage/hebergements/findHotel");
         
ConnectionRequest con2 = new ConnectionRequest();
con2.setUrl("http://localhost/GoVoyage/web/app_dev.php/GoVoyage/hebergements/findHote");
         


       try {
           local = com.codename1.ui.Image.createImage("/localisation.png").scaled(30, 30);
          
           Button bt = new Button();
           Button bt1 = new Button();

           bt=(Button) UIB.findByName("Button", ct2);

           bt1=(Button) UIB.findByName("Button", ct3);
           bt.setIcon(local);
           bt1.setIcon(local);

            maping = com.codename1.ui.Image.createImage("/mapping1.png").scaled(50, 50);
            Button btmap = new Button();
            btmap=(Button) UIB.findByName("Button1", ct2);
            btmap.setIcon(maping);
       } catch (IOException ex) {
         
       }
 
    
       
                  
           Button bt = new Button();
           bt=(Button) UIB.findByName("Button", ct2);
           
           Button bt1 = new Button();
           bt1=(Button) UIB.findByName("Button", ct3);

           Button btmap = new Button();
           btmap=(Button) UIB.findByName("Button1", ct2);


           btmap.addActionListener(new ActionListener() {
            @Override
          public void actionPerformed(ActionEvent evt) {
          MapContainer map = new MapContainer();
           f9.add(map);
           f9.show();
           
                          }
                      });
  
          

         
        TextField numero = (TextField) UIB.findByName("TextField", ct7);
        TextArea sujet = (TextArea) UIB.findByName("TextArea", ct7);
         
        Button btsms = new Button();
        btsms=(Button) UIB.findByName("Button", ct7);
 
 
        bt.addActionListener(new ActionListener() {
            
            @Override
            public void actionPerformed(ActionEvent evt) {
                 ConnectionRequest conHotel = new ConnectionRequest();
                 conHotel.setUrl("http://localhost/GoVoyage/web/app_dev.php/GoVoyage/hebergements/"
                 + "findHotelAdress/"+tfHotel.getText());
          
                conHotel.addResponseListener(new ActionListener<NetworkEvent>() {
            @Override
            public void actionPerformed(NetworkEvent evt) {
            cnts = new Container(new BoxLayout(BoxLayout.Y_AXIS));

                    f4.add(cnts);
               f4.show();
         
            //  sp2.setText(getListHebergements(new String(conHotel.getResponseData())) + "");
             getListHebergements(new String(conHotel.getResponseData()),theme);
             f4.refreshTheme();

            }
        });
            NetworkManager.getInstance().addToQueue(conHotel);
            }
        }); 

        
        
            
        bt1.addActionListener(new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent evt) {
                ConnectionRequest conHote = new ConnectionRequest();
                conHote.setUrl("http://localhost/GoVoyage/web/app_dev.php/GoVoyage/hebergements/"
                + "findHoteAdress/"+tfHote.getText());
                
                conHote.addResponseListener(new ActionListener<NetworkEvent>() {
                @Override
                public void actionPerformed(NetworkEvent evt) {
                    cnts = new Container(new BoxLayout(BoxLayout.Y_AXIS));
                    f5.add(cnts);
                    
                    f5.show();
              //  sp3.setText(getListHebergements(new String(conHote.getResponseData())) + "");
           getListHebergements(new String(conHote.getResponseData()),theme);
             f5.refreshTheme();
               
            }
        });
        
       NetworkManager.getInstance().addToQueue(conHote);
            }
        }); 
         
 
         btsms.addActionListener(new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent evt) {
                ConnectionRequest cntRqst = new ConnectionRequest() ;
                cntRqst.setPost(false);
    cntRqst.setUrl("https://rest.nexmo.com/sms/json?api_key=518db94c&api_secret=b3c037f398f6c675"
                    +"&to="+numero.getText()
                    +"&from=NEXMO"
                    +"&text="+sujet.getText()
                   );
                 cntRqst.addResponseListener(new ActionListener<NetworkEvent>() {

                    @Override
                    public void actionPerformed(NetworkEvent evt) {
                        byte[] data = (byte[]) evt.getMetaData();
                        String s = new String(data);
                            Dialog.show("SMS", "sms successfully sent", "OK", null);
                    }
});
                  NetworkManager.getInstance().addToQueue(cntRqst);
            }});
    
                  
   /*       
         f1.getToolbar().addCommandToSideMenu("Maps", null, new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent evt) {
               MapContainer map = new MapContainer();
                f9.add(map);
                f9.show();
            }
        });
        
  */
                
          
        f1.getToolbar().addCommandToSideMenu("Hotels", null, new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent evt) {
              con1.addResponseListener(new ActionListener<NetworkEvent>() {
            @Override
            public void actionPerformed(NetworkEvent evt) {
            cnts = new Container(new BoxLayout(BoxLayout.Y_AXIS));
          //  img1 =com.codename1.ui.Image.createImage("/maps.png");
               
              f2.add(cnts);
              f2.show();
              // sp.setText(getListHebergements(new String(con1.getResponseData())) + "");
               getListHebergements(new String(con1.getResponseData()),theme);
              f2.refreshTheme();
               
            }
        });
        NetworkManager.getInstance().addToQueue(con1);
        }
        });
                
       f1.getToolbar().addCommandToSideMenu("Hotes", null, new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent evt) {
                        
              con2.addResponseListener(new ActionListener<NetworkEvent>() {
            @Override
            public void actionPerformed(NetworkEvent evt) {
                cnts = new Container(new BoxLayout(BoxLayout.Y_AXIS));
                f3.add(cnts);
                 
                f3.show();
                getListHebergements1(new String(con2.getResponseData()),theme);
            //   sp1.setText(getListHebergements(new String(con2.getResponseData())) + "");
               f3.refreshTheme();
               
            }
        });
        
       NetworkManager.getInstance().addToQueue(con2);
            }
        });
               f1.getToolbar().addCommandToSideMenu("SMS", null, new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent evt) {
                f7.show();
            }
        });
 f1.getToolbar().addCommandToSideMenu("retour", null, new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent evt) {
                home.show();
            }
        });
                
        f1.show();
        f2.getToolbar().addCommandToLeftBar("Back",theme.getImage("back-left-pressed.png"),new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent evt) {
                f1.show();
            }
        });
        f3.getToolbar().addCommandToLeftBar("Back",theme.getImage("back-left-pressed"),new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent evt) {

                f1.show();
            }
        });
        
        f4.getToolbar().addCommandToLeftBar("Back",theme.getImage("back-left-pressed"),new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent evt) {
                f1.show();
            }
        });
        
        f5.getToolbar().addCommandToLeftBar("Back",theme.getImage("back-left-pressed"),new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent evt) {
                f1.show();
            }
        });
        f6.getToolbar().addCommandToLeftBar("Back",theme.getImage("back-left-pressed"),new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent evt) {
                f1.show();
            }
        });
        f7.getToolbar().addCommandToLeftBar("Back",theme.getImage("back-left-pressed"),new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent evt) {
                f1.show();
            }
        });
        
        f8.getToolbar().addCommandToLeftBar("Back",theme.getImage("back-left-pressed"),new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent evt) {
                f1.show();
            }
        });  
        
                f9.getToolbar().addCommandToLeftBar("Back",theme.getImage("back-left-pressed"),new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent evt) {
                f1.show();
            }
        }); 

        } 
        
        
        
        

    
    
         public ArrayList<Hebergement> getListHebergements(String json,Resources theme) {
        ArrayList<Hebergement> listHebergements = new ArrayList<>();
        System.out.println("JSON*************\n"+json);
        try {

            JSONParser j = new JSONParser();
            
            Map<String, Object> hebergements = j.parseJSON(new CharArrayReader(json.toCharArray()));

            System.out.println();
            List<Map<String, Object>> list = (List<Map<String, Object>>) hebergements.get("root");

            for (Map<String, Object> obj : list) {
                Hebergement h = new Hebergement();//id, json, status);
               
            h.setId((int) Float.parseFloat(obj.get("id").toString()));
            h.setNom(obj.get("nom").toString());
            h.setAdresse(obj.get("adresse").toString());
            h.setAdresseMail(obj.get("adressemail").toString());
            h.setNumerotel((int) Float.parseFloat(obj.get("numerotel").toString()));
            h.setType(obj.get("type").toString());
            h.setImage(obj.get("image").toString());
            h.setRating((int) Float.parseFloat(obj.get("rating").toString()));
     cnts.add(createContainer(h+"",(int) Float.parseFloat(obj.get("rating").toString()),h.getImage(),theme,h.getId()));
  /* System.out.println(h.feten());
String x=h.feten();
     pro =new Container(new BoxLayout(BoxLayout.Y_AXIS));
     SpanLabel spdet = new SpanLabel(x);
    pro.add(spdet);
     */

                listHebergements.add(h);
            }
            
        } catch (IOException ex) {
        }
        return listHebergements;

       }
          public ArrayList<Hebergement> getListHebergements1(String json,Resources theme) {
        ArrayList<Hebergement> listHebergements = new ArrayList<>();
        System.out.println("JSON*************\n"+json);
        try {

            JSONParser j = new JSONParser();
            
            Map<String, Object> hebergements = j.parseJSON(new CharArrayReader(json.toCharArray()));

            System.out.println();
            List<Map<String, Object>> list = (List<Map<String, Object>>) hebergements.get("root");

            for (Map<String, Object> obj : list) {
                Hebergement h = new Hebergement();//id, json, status);
               
            h.setId((int) Float.parseFloat(obj.get("id").toString()));
            h.setNom(obj.get("nom").toString());
            h.setAdresse(obj.get("adresse").toString());
            h.setAdresseMail(obj.get("adressemail").toString());
            h.setNumerotel((int) Float.parseFloat(obj.get("numerotel").toString()));
            h.setType(obj.get("type").toString());
            h.setImage(obj.get("image").toString());
            h.setRating((int) Float.parseFloat(obj.get("rating").toString()));
     cnts.add(createContainer2(h+"",(int) Float.parseFloat(obj.get("rating").toString()),h.getImage(),theme,h.getId()));
  /* System.out.println(h.feten());
String x=h.feten();
     pro =new Container(new BoxLayout(BoxLayout.Y_AXIS));
     SpanLabel spdet = new SpanLabel(x);
    pro.add(spdet);
     */

                listHebergements.add(h);
            }
            
        } catch (IOException ex) {
        }
        return listHebergements;

       }
         /*
                  public ArrayList<Hebergement> getListHotels(String json,Resources theme) {
        ArrayList<Hebergement> listHebergements = new ArrayList<>();
        System.out.println("JSON*************\n"+json);
        try {
            JSONParser j = new JSONParser();        
            Map<String, Object> hebergements = j.parseJSON(new CharArrayReader(json.toCharArray()));
            System.out.println();
            List<Map<String, Object>> list = (List<Map<String, Object>>) hebergements.get("root");
            for (Map<String, Object> obj : list) {
                Hotel h = new Hotel();//id, json, status);   
            h.setId((int) Float.parseFloat(obj.get("id").toString()));
            h.setNom(obj.get("nom").toString());
            h.setAdresse(obj.get("adresse").toString());
            h.setAdresseMail(obj.get("adressemail").toString());
            h.setNumerotel((int) Float.parseFloat(obj.get("numerotel").toString()));
            h.setType(obj.get("type").toString());
            h.setImage(obj.get("image").toString());
            h.setRating((int) Float.parseFloat(obj.get("rating").toString()));
            h.setRating((int) Float.parseFloat(obj.get("nbetoile").toString()));
            h.setRating((int) Float.parseFloat(obj.get("prixsingle").toString()));
            h.setRating((int) Float.parseFloat(obj.get("prixdouble").toString()));
            h.setRating((int) Float.parseFloat(obj.get("prixenfant").toString()));
           cnts.add(createContainer(h+"",(int) Float.parseFloat(obj.get("rating").toString()),h.getImage(),theme));
                System.out.println(h.fetenM());
             String y=h.fetenM();
           //     cnts1.add(createContainer1(x, theme));
           
           pro=new Container(new BoxLayout(BoxLayout.Y_AXIS));
           SpanLabel spy = new SpanLabel(y);
           pro.add(spy);
                listHebergements.add(h);
            }
            
            } catch (IOException ex) {
            }
            return listHebergements;

       }
                  */
         
             public Hotel findHotel(String json) {
        System.out.println("JSON***** v nh******\n"+json);
        Hotel h = new Hotel();
        try {

            JSONParser j = new JSONParser();

            Map<String, Object> hotel = j.parseJSON(new CharArrayReader(json.toCharArray()));
 List<Map<String, Object>> list = (List<Map<String, Object>>) hotel.get("root");
        //    System.out.println(list.get("id").toString());
 for (Map<String, Object> obj : list) {
           h.setId((int) Float.parseFloat(obj.get("id").toString()));
            h.setNom(obj.get("nom").toString());
            h.setAdresse(obj.get("adresse").toString());
            h.setAdresseMail(obj.get("adressemail").toString());
            h.setNumerotel((int) Float.parseFloat(obj.get("numerotel").toString()));
            h.setType(obj.get("type").toString());
            h.setImage(obj.get("image").toString());
            h.setRating((int) Float.parseFloat(obj.get("rating").toString()));
            h.setRating((int) Float.parseFloat(obj.get("nbetoile").toString()));
            h.setRating((int) Float.parseFloat(obj.get("prixsingle").toString()));
            h.setRating((int) Float.parseFloat(obj.get("prixdouble").toString()));
            h.setRating((int) Float.parseFloat(obj.get("prixenfant").toString()));
 }
   /*  String x=h.fetenM();
     pro =new Container(new BoxLayout(BoxLayout.Y_AXIS));
     SpanLabel spdet = new SpanLabel(x);
     pro.add(spdet);
            */
        } catch (IOException ex) {
        }
        return h;

    }
 


public Container createContainer(String Text, int njoum ,String image,Resources theme,int id) throws IOException
{
    SpanLabel sp =new SpanLabel(Text);
    SpanLabel spdetails =new SpanLabel();

    com.codename1.ui.Image stars = com.codename1.ui.Image.createImage("/"+njoum+".png").scaled(300, 80);
    com.codename1.ui.Image img = com.codename1.ui.Image.createImage("/"+image).scaled(300, 250);

    Button detail = new Button("Afficher Details");
    Button reserve = new Button("Reserver");
   
    reserve.addActionListener(new ActionListener() {
        @Override
        public void actionPerformed(ActionEvent evt) {
            RHotelNewForm   f1 =new RHotelNewForm(theme,id) ;
        }
    });
    

 detail.addActionListener(new ActionListener() {
        @Override
        public void actionPerformed(ActionEvent evt) {
    //   Hebergement h = new Hebergement();
        ConnectionRequest confind = new ConnectionRequest();
        confind.setUrl("http://localhost/GoVoyage/web/app_dev.php/GoVoyage/hebergements/findHotelName/"+Text.trim());
       
                 confind.addResponseListener(new ActionListener<NetworkEvent>() {
                @Override
                public void actionPerformed(NetworkEvent evt) {
      //              pro = new Container(new BoxLayout(BoxLayout.Y_AXIS));
                   SpanLabel spdetail = new SpanLabel();
                           spdetail.setText(findHotel(new String(confind.getResponseData())).fetenM()+"");   

                   Form fet = new Form();
                   fet.add(spdetail);
                   fet.show();

              //  sp3.setText(getListHebergements(new String(conHote.getResponseData())) + "");
             fet.refreshTheme();
               
            }

          
        });
        
       NetworkManager.getInstance().addToQueue(confind);
            }
        
        
        
        
        
    });
 
    
    Container nizar =new Container(new BoxLayout(BoxLayout.Y_AXIS));
    nizar.add(sp);
    nizar.add(stars);
    nizar.add(img);
    nizar.add(detail);
    nizar.add(reserve);
    
    Container imen =BorderLayout.center(nizar);
    return imen ;
}

public Container createContainer1(String Text,Resources theme)
{
    SpanLabel sp =new SpanLabel(Text);
  
    Container pro =new Container(new BoxLayout(BoxLayout.Y_AXIS));
    pro.add(sp);

    Container dobba =BorderLayout.center(pro);
    return dobba ;
}
public Container createContainer2(String Text, int njoum ,String image,Resources theme,int id) throws IOException
{
    SpanLabel sp =new SpanLabel(Text);
    SpanLabel spdetails =new SpanLabel();

    com.codename1.ui.Image stars = com.codename1.ui.Image.createImage("/"+njoum+".png").scaled(300, 80);
    com.codename1.ui.Image img = com.codename1.ui.Image.createImage("/"+image).scaled(300, 250);

    Button detail = new Button("Afficher Details");
    Button reserve = new Button("Reserver");
   
    reserve.addActionListener(new ActionListener() {
        @Override
        public void actionPerformed(ActionEvent evt) {
          RHoteNewForm   f1 =new RHoteNewForm(theme,id) ;
        }
    });
    

 detail.addActionListener(new ActionListener() {
        @Override
        public void actionPerformed(ActionEvent evt) {
    //   Hebergement h = new Hebergement();
        ConnectionRequest confind = new ConnectionRequest();
        confind.setUrl("http://localhost/GoVoyage/web/app_dev.php/GoVoyage/hebergements/findHotelName/"+Text.trim());
       
                 confind.addResponseListener(new ActionListener<NetworkEvent>() {
                @Override
                public void actionPerformed(NetworkEvent evt) {
      //              pro = new Container(new BoxLayout(BoxLayout.Y_AXIS));
                   SpanLabel spdetail = new SpanLabel();
                           spdetail.setText(findHotel(new String(confind.getResponseData())).fetenM()+"");   

                   Form fet = new Form();
                   fet.add(spdetail);
                   fet.show();

              //  sp3.setText(getListHebergements(new String(conHote.getResponseData())) + "");
             fet.refreshTheme();
               
            }

          
        });
        
       NetworkManager.getInstance().addToQueue(confind);
            }
        
        
        
        
        
    });
 
    
    Container nizar =new Container(new BoxLayout(BoxLayout.Y_AXIS));
    nizar.add(sp);
    nizar.add(stars);
    nizar.add(img);
    nizar.add(detail);
    nizar.add(reserve);
    
    Container imen =BorderLayout.center(nizar);
    return imen ;
}


 }

    

