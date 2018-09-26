/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.myapp;

import com.codename1.io.ConnectionRequest;
import com.codename1.io.JSONParser;
import com.codename1.io.Log;
import com.codename1.io.NetworkManager;
import com.codename1.ui.Dialog;
import com.codename1.ui.Form;
import com.codename1.ui.TextArea;
import com.codename1.ui.events.ActionEvent;
import com.codename1.ui.events.ActionListener;
import com.codename1.ui.layouts.BorderLayout;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.Reader;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

/**
 *
 * @author imc
 */
public class ServiceVol {

    private ConnectionRequest connectionRequest;
    public static Form listOfDiscussions;

    public void findAllVols() {
        connectionRequest = new ConnectionRequest() {
            List<Vol> vols = new ArrayList<>();

            @Override
            protected void readResponse(InputStream in) throws IOException {

                JSONParser json = new JSONParser();
                try {
                    Reader reader = new InputStreamReader(in, "UTF-8");

                    Map<String, Object> data = json.parseJSON(reader);
                    List<Map<String, Object>> content = (List<Map<String, Object>>) data.get("root");
                    vols.clear();

                    for (Map<String, Object> obj : content) {

                        vols.add(new Vol(Double.parseDouble(String.valueOf(obj.get("ref"))) ,(String) obj.get("villedepart"),
                                (String) obj.get("villearrivee"),(String) obj.get("numvol")));
//randonnees.add(new Randonnee((String) obj.get("niveauDifficlute")));

                    }
                } catch (IOException err) {
                    Log.e(err);
                }
            }

            protected void postResponse() {
                //System.out.println(libs.size());
                listOfDiscussions = new Form();
                com.codename1.ui.List uiLibsList = new com.codename1.ui.List();
                ArrayList<String> libsNoms = new ArrayList<>();
                for (Vol l : vols) {
                    libsNoms.add(l.getNumVol());

                }
                com.codename1.ui.list.DefaultListModel<String> listModel = new com.codename1.ui.list.DefaultListModel<>(libsNoms);
                uiLibsList.setModel(listModel);
                uiLibsList.addActionListener(new ActionListener() {
                    @Override
                    public void actionPerformed(ActionEvent evt) {
                        Vol v = vols.get(uiLibsList.getCurrentSelected());
                        new ListeVol1(v.getRef(),v.getVilleDepart(),
                                v.getVilleArrivee(),v.getNumVol(),v.getDuree(),v.getTypeAvion()).show();

                    }
                });

                listOfDiscussions.setLayout(new BorderLayout());
                listOfDiscussions.add(BorderLayout.NORTH, uiLibsList);
                //listOfDiscussions.add(BorderLayout.SOUTH,Statics.createBackBtn());
                //   listOfDiscussions.add(BorderLayout.SOUTH,Statics.createtoolbar());
                listOfDiscussions.show();
            }
        };
        connectionRequest.setUrl("http://localhost/GoVoyage/web/app_dev.php/GoVoyage/afficherCode");
        NetworkManager.getInstance().addToQueue(connectionRequest);

    }

    void updateOffre(Vol v) {
        connectionRequest = new ConnectionRequest() {

            @Override
            protected void postResponse() {
                Dialog d = new Dialog();
                TextArea popupBody = new TextArea("Vol modifier");
                popupBody.setUIID("");
                popupBody.setEditable(false);
                d.setLayout(new BorderLayout());
                d.add(BorderLayout.CENTER, popupBody);
                d.show(v.getVilleArrivee(), "modification avec succes", "ok", null);
            }
        };

        connectionRequest.setPost(false);
        connectionRequest.setUrl("http://localhost/Mobile/updateVol.php");
        connectionRequest.addArgument("ref", String.valueOf(v.getRef()));
        connectionRequest.addArgument("villedepart", v.getVilleDepart());
        connectionRequest.addArgument("villearrivee", v.getVilleArrivee());

        System.out.println("hello after url");

        NetworkManager.getInstance().addToQueue(connectionRequest);

    }

    public void removeOffre(Vol v) {

        connectionRequest = new ConnectionRequest() {
            @Override
            protected void postResponse() {
                Dialog d = new Dialog("Effacer Vol");
                TextArea popupBody = new TextArea("Vol supprimer avec succées");
                popupBody.setUIID("PopupBody");
                popupBody.setEditable(false);
                d.setLayout(new BorderLayout());
                d.add(BorderLayout.CENTER, popupBody);
                d.show(v.getVilleDepart(), "Supprimer  avec succes", "ok", null);
            }
        };
        // http://localhost/PIDEVMahmoud/web/app_dev.php/supprimer/15
        //http://localhost/pifin/web/app_dev.php/tm/offresupprimer/11
        //http://localhost/codeNameOne/remove.php
        connectionRequest.setUrl("http://localhost/GoVoyage/web/app_dev.php/GoVoyage/deleteVol1/"+v.getRef());

        System.out.println("Vol" + v.getRef());

        NetworkManager.getInstance().addToQueue(connectionRequest);
    }

    public void AddOffre(Vol v) {
        connectionRequest = new ConnectionRequest() {
            @Override
            protected void postResponse() {
                Dialog d = new Dialog("Ajouter un Vol");
                TextArea popupBody = new TextArea("Vol ajouté avec succées");
                popupBody.setUIID("PopupBody");
                popupBody.setEditable(false);
                d.setLayout(new BorderLayout());
                d.add(BorderLayout.CENTER, popupBody);
                d.show(v.getVilleDepart(), "Ajout avec succes", "ok", null);
            }
        };
        //http://localhost/pi/web/app_dev.php/tm/ajouter?poste=ing&description=aaa
        connectionRequest.setUrl("http://localhost/GoVoyage/web/app_dev.php/GoVoyage/addVol1?villeDepart=" + v.getVilleDepart()
                + "&villeArrivee=" + v.getVilleArrivee()
        );

//System.out.println("hello i m after connection request :  " + connectionRequest.getUrl());
//connectionRequest.getUrl();
        NetworkManager.getInstance().addToQueue(connectionRequest);

    }

}
