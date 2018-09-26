/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Entity;

import com.mycompany.myapp.Hebergement;

/**
 *
 * @author asus
 */
public class Hote extends Hebergement {
    
    private float PrixNuit ;

    public Hote() {
    }

    public float getPrixNuit() {
        return PrixNuit;
    }

    public void setPrixNuit(float PrixNuit) {
        this.PrixNuit = PrixNuit;
    }


    public Hote(float PrixNuit, int id, String nom, String adresse, String adresseMail, int numerotel, String type, String image, int rating) {
        super(id, nom, adresse, adresseMail, numerotel, type, image, rating);
        this.PrixNuit = PrixNuit;
    }

    @Override
    public String toString() {
        return "Hote{" + "PrixNuit=" + PrixNuit + '}';
    }

   


    
    
}
