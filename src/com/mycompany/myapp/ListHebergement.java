/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.myapp;

import com.codename1.components.SpanLabel;
import com.codename1.io.CharArrayReader;
import com.codename1.io.ConnectionRequest;
import com.codename1.io.JSONParser;
import com.codename1.io.NetworkEvent;
import com.codename1.io.NetworkManager;
import com.codename1.ui.Button;
import com.codename1.ui.Container;
import com.codename1.ui.Form;
import com.codename1.ui.events.ActionEvent;
import com.codename1.ui.events.ActionListener;
import com.codename1.ui.layouts.BorderLayout;
import com.codename1.ui.layouts.BoxLayout;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

/**
 *
 * @author asus
 */
public class ListHebergement {
    
    
           public ArrayList<Hebergement> getListHebergements(String json) {
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
           
           // h.setRating((int) Float.parseFloat(obj.get("rating").toString()));
                listHebergements.add(h);
            }
            
        } catch (IOException ex) {
        }
        return listHebergements;

       }
           
           
 

    
}
