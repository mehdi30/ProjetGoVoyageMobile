/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.myapp;

/**
 *
 * @author Mehdi Chaabene
 */
public class Vol {

    private double ref;

    private String villeDepart;
    private String villeArrivee;
    private String dateDepartAller;
    private String dateArriveeAller;
    private String heureDepart;

    private String numVol;
    private String typeAvion;
    private String cie_aerienne;
    private String duree;
    private int nbrPlaceEco;
    private int nbrPlaceAffaire;
    private float tarif;
    private String typeVol;

    public Vol() {
    }

    public Vol(String villeDepart, String villeArrivee) {
        this.villeDepart = villeDepart;
        this.villeArrivee = villeArrivee;
    }
 public Vol(double ref, String villeDepart, String villeArrivee, String numVol) {
        this.ref = ref;
        this.villeDepart = villeDepart;
        this.villeArrivee = villeArrivee;
        this.numVol = numVol;
    }

    public Vol(double ref, String villeDepart, String villeArrivee, String numVol, String typeAvion, String duree) {
        this.ref = ref;
        this.villeDepart = villeDepart;
        this.villeArrivee = villeArrivee;
        this.numVol = numVol;
        this.typeAvion = typeAvion;
        this.duree = duree;
    }
 
    public Vol(int ref, String villeDepart, String villeArrivee, String dateDepartAller, String dateArriveeAller, String heureDepart, String numVol, String typeAvion, String cie_aerienne, String duree, int nbrPlaceEco, int nbrPlaceAffaire, float tarif, String typeVol) {
        this.ref = ref;
        this.villeDepart = villeDepart;
        this.villeArrivee = villeArrivee;
        this.dateDepartAller = dateDepartAller;
        this.dateArriveeAller = dateArriveeAller;
        this.heureDepart = heureDepart;
        this.numVol = numVol;
        this.typeAvion = typeAvion;
        this.cie_aerienne = cie_aerienne;
        this.duree = duree;
        this.nbrPlaceEco = nbrPlaceEco;
        this.nbrPlaceAffaire = nbrPlaceAffaire;
        this.tarif = tarif;
        this.typeVol = typeVol;
    }
    

    public double getRef() {
        return ref;
    }

    public void setRef(double ref) {
        this.ref = ref;
    }

    public String getVilleDepart() {
        return villeDepart;
    }

    public void setVilleDepart(String villeDepart) {
        this.villeDepart = villeDepart;
    }

    public String getVilleArrivee() {
        return villeArrivee;
    }

    public void setVilleArrivee(String villeArrivee) {
        this.villeArrivee = villeArrivee;
    }

    public String getDateDepartAller() {
        return dateDepartAller;
    }

    public void setDateDepartAller(String dateDepartAller) {
        this.dateDepartAller = dateDepartAller;
    }

    public String getDateArriveeAller() {
        return dateArriveeAller;
    }

    public void setDateArriveeAller(String dateArriveeAller) {
        this.dateArriveeAller = dateArriveeAller;
    }

    public String getHeureDepart() {
        return heureDepart;
    }

    public void setHeureDepart(String heureDepart) {
        this.heureDepart = heureDepart;
    }

    public String getNumVol() {
        return numVol;
    }

    public void setNumVol(String numVol) {
        this.numVol = numVol;
    }

    public String getTypeAvion() {
        return typeAvion;
    }

    public void setTypeAvion(String typeAvion) {
        this.typeAvion = typeAvion;
    }

    public String getCie_aerienne() {
        return cie_aerienne;
    }

    public void setCie_aerienne(String cie_aerienne) {
        this.cie_aerienne = cie_aerienne;
    }

    public String getDuree() {
        return duree;
    }

    public void setDuree(String duree) {
        this.duree = duree;
    }

    public int getNbrPlaceEco() {
        return nbrPlaceEco;
    }

    public void setNbrPlaceEco(int nbrPlaceEco) {
        this.nbrPlaceEco = nbrPlaceEco;
    }

    public int getNbrPlaceAffaire() {
        return nbrPlaceAffaire;
    }

    public void setNbrPlaceAffaire(int nbrPlaceAffaire) {
        this.nbrPlaceAffaire = nbrPlaceAffaire;
    }

    public float getTarif() {
        return tarif;
    }

    public void setTarif(float tarif) {
        this.tarif = tarif;
    }

    public String getTypeVol() {
        return typeVol;
    }

    public void setTypeVol(String typeVol) {
        this.typeVol = typeVol;
    }

    @Override
    public String toString() {
        return  cie_aerienne +": \n"  +villeDepart +"---->"  + villeArrivee +" "+ heureDepart +" " + typeAvion +" "  ;
    }
     public String toStrings() {
        return  "   "+ numVol  ;
    }


    

   
    public boolean equals(Object o) {
        if (o instanceof Vol) {
            Vol v = (Vol) o;

            if (this.numVol.equals(v.numVol)) {
                return true;
            }
        }
        return false;
    }

   

    

    

}
