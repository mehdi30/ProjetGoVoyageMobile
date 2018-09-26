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
public class Hotel extends Hebergement {
    
    private int nbEtoile ;

    float PrixSingle ;
    float PrixDouble ;
    float PrixEnfant ;
    
     public Hotel() {
    }

    public Hotel(int nbEtoile, float PrixSingle, float PrixDouble, float PrixEnfant, int id, String nom, String adresse, String adresseMail, int numerotel, String type, String image, int rating) {
        super(id, nom, adresse, adresseMail, numerotel, type, image, rating);
        this.nbEtoile = nbEtoile;
        this.PrixSingle = PrixSingle;
        this.PrixDouble = PrixDouble;
        this.PrixEnfant = PrixEnfant;
    }

    public int getNbEtoile() {
        return nbEtoile;
    }

    public void setNbEtoile(int nbEtoile) {
        this.nbEtoile = nbEtoile;
    }

    public float getPrixSingle() {
        return PrixSingle;
    }

    public void setPrixSingle(float PrixSingle) {
        this.PrixSingle = PrixSingle;
    }

    public float getPrixDouble() {
        return PrixDouble;
    }

    public void setPrixDouble(float PrixDouble) {
        this.PrixDouble = PrixDouble;
    }

    public float getPrixEnfant() {
        return PrixEnfant;
    }

    public void setPrixEnfant(float PrixEnfant) {
        this.PrixEnfant = PrixEnfant;
    }

  

 
  public String fetenM()
          {
     
    return super.feten()+ "nbEtoile=" + nbEtoile + ", PrixSingle=" + PrixSingle + ", PrixDouble=" + PrixDouble + ", PrixEnfant=" + PrixEnfant + '}';
    
}
}