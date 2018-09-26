/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.myapp;

/**
 *
 * @author asus
 */
public class Hebergement {
    private int id ;
    String nom ;
    private String adresse ;
    private String adresseMail ;
    private int numerotel ;
    private String type ;
    private String image ;
    private int rating ;
    
    
     public Hebergement(){
     }

    public Hebergement(int id, String nom, String adresse, String adresseMail, int numerotel, String type, String image, int rating) {
        this.id = id;
        this.nom = nom;
        this.adresse = adresse;
        this.adresseMail = adresseMail;
        this.numerotel = numerotel;
        this.type = type;
        this.image = image;
        this.rating = rating;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNom() {
        return nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public String getAdresse() {
        return adresse;
    }

    public void setAdresse(String adresse) {
        this.adresse = adresse;
    }

    public String getAdresseMail() {
        return adresseMail;
    }

    public void setAdresseMail(String adresseMail) {
        this.adresseMail = adresseMail;
    }

    public int getNumerotel() {
        return numerotel;
    }

    public void setNumerotel(int numerotel) {
        this.numerotel = numerotel;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }

    public int getRating() {
        return rating;
    }

    public void setRating(int rating) {
        this.rating = rating;
    }



   @Override
    public String toString() {
        return    " " + nom + " " ;
    }
                
           /*    ", adresseMail=" + adresseMail + 
   ", numerotel=" + numerotel + ", type=" + type + ", image=" + image + ", rating=" + rating + 
*/


    public String feten() {
        return "Hebergement{" + "nom=" + nom + ", adresse=" + adresse + ", adresseMail=" + adresseMail + ", numerotel=" + numerotel + ", type=" + type + ", image=" + image + ", rating=" + rating + '}';
    }
    }

    

