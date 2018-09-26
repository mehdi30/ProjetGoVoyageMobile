/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Entity;

/**
 *
 * @author Kouka
 */
public class Reclamation {
      private int ref;

    
    private String description;

   
    private String etat;

    
    private int idc;

    public int getRef() {
        return ref;
    }

    public void setRef(int ref) {
        this.ref = ref;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getEtat() {
        return etat;
    }

    public void setEtat(String etat) {
        this.etat = etat;
    }

    public int getIdc() {
        return idc;
    }

    public void setIdc(int idc) {
        this.idc = idc;
    }

    @Override
    public String toString() {
        return "Reclamation{" + "ref=" + ref + ", description=" + description + ", etat=" + etat + ", idc=" + idc + '}';
    }
    
    
    
    
}
