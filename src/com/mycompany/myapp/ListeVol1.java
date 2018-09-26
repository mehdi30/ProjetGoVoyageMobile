/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.myapp;

import com.codename1.ui.Button;
import com.codename1.ui.Container;
import com.codename1.ui.Form;
import com.codename1.ui.Label;
import com.codename1.ui.TextField;
import com.codename1.ui.events.ActionEvent;
import com.codename1.ui.events.ActionListener;
import com.codename1.ui.layouts.BorderLayout;
import com.codename1.ui.layouts.BoxLayout;

/**
 *
 * @author imc
 */
public class ListeVol1 extends Form {

    public static double id_ran;
    private Label l2, l4, l5, l6, l7;
    private TextField t1, t2, t5, t6, t7;
    private Container mainContainer;
    private Button editBtn, removeBtn, backBtn, partage;
    private Vol currentVol;

    public ListeVol1(double ref, String villedepart, String villearrivee, String numVol, String duree, String typeAvion) {

        id_ran = ref;
        this.setLayout(new BorderLayout());
        backBtn = new Button("Retour");
        mainContainer = new Container(new BoxLayout(BoxLayout.Y_AXIS));

        //l1 = new Label("Randonnée: ");
        mainContainer.setScrollableY(true);
        l2 = new Label("villedepart:");
        t1 = new TextField(villedepart);

        l4 = new Label("villearrivee");
        t2 = new TextField(villearrivee);

        l5 = new Label("numvol");
        t5 = new TextField(numVol);

        l6 = new Label("duree");
        t6 = new TextField(numVol);

        l7 = new Label("typeavion");
        t7 = new TextField(numVol);

        editBtn = new Button("Modifier");
        removeBtn = new Button("Supprimer");
        partage = new Button("Partage");

        mainContainer.add(l2);
        mainContainer.add(t1);

        mainContainer.add(l4);
        mainContainer.add(t2);

        mainContainer.add(l5);
        mainContainer.add(t5);
        mainContainer.add(l6);
        mainContainer.add(t6);
        mainContainer.add(l7);
        mainContainer.add(t7);

        mainContainer.add(editBtn);
        mainContainer.add(removeBtn);

        mainContainer.add(backBtn);

        currentVol = new Vol(id_ran, t1.getText(), t2.getText(), t5.getText(), t6.getText(), t7.getText());

        removeBtn.addActionListener(new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent evt) {

                new ServiceVol().removeOffre(currentVol);
                SeeAllVols ds = new SeeAllVols();

                ds.show();
            }
        });

        backBtn.addActionListener(e -> {

            SeeAllVols ds = new SeeAllVols();

            ds.show();
        });

        editBtn.addActionListener((ActionListener) (ActionEvent evt) -> {
            currentVol = new Vol(id_ran, t1.getText(), t2.getText(), t5.getText(), t6.getText(), t7.getText());
            new ServiceVol().updateOffre(currentVol);
            SeeAllVols ds = new SeeAllVols();

            ds.show();
        });

        this.add(BorderLayout.NORTH, mainContainer);

//     
//             vidange.addActionListener(e->{
//        
//            
//            AddVidange f =new AddVidange(id_voi);
//            Form fcom=  f.getComponentForm();
//            fcom.show();
//            
//        });
    }

    public Vol getCurrentVol() {
        return currentVol;
    }

}
