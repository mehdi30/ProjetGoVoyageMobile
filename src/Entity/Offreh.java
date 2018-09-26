/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Entity;

/**
 *
 * @author nizar
 */
public class Offreh {
     private int reference;
    private String duree;
    private int specification;
    private String type;
    private String dateDebut;
    private String dateFin;
 //   private Hebergement hebergement;
    private String heberg;

    public Offreh() {
    }

    @Override
    public String toString() {
                return  "\n  Promotion :" + specification + "%"+"\n  type: " + type + "\n  dateDebut: " + dateDebut + "\n  dateFin: " + dateFin + "\n  Hebergement: " + heberg +"\n ";

    }

    public Offreh(int reference, String duree, int specification, String type, String dateDebut, String dateFin, String heberg) {
        this.reference = reference;
        this.duree = duree;
        this.specification = specification;
        this.type = type;
        this.dateDebut = dateDebut;
        this.dateFin = dateFin;
        this.heberg = heberg;
    }

    public int getReference() {
        return reference;
    }

    public void setReference(int reference) {
        this.reference = reference;
    }

    public String getDuree() {
        return duree;
    }

    public void setDuree(String duree) {
        this.duree = duree;
    }

    public int getSpecification() {
        return specification;
    }

    public void setSpecification(int specification) {
        this.specification = specification;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getDateDebut() {
        return dateDebut;
    }

    public void setDateDebut(String dateDebut) {
        this.dateDebut = dateDebut;
    }

    public String getDateFin() {
        return dateFin;
    }

    public void setDateFin(String dateFin) {
        this.dateFin = dateFin;
    }

    public String getHeberg() {
        return heberg;
    }

    public void setHeberg(String heberg) {
        this.heberg = heberg;
    }
    
}
