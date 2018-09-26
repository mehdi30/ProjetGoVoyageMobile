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
public class Utilisateur {
      private String username;

    
    private String nom;

   
    private String prenom;

    
    private String cin;

    private String email;

    private String mdp;

    private String nationalite;

  
    private String datenaissance;

   
    private String telephone;

   
    private String numpassport;

  
    private String sexe;

    private String role;

  
   
    private int ref;

    
    

    @Override
    public String toString() {
        return "User{" + "username=" + username + ", nom=" + nom + ", prenom=" + prenom + ", cin=" + cin + ", email=" + email + ", mdp=" + mdp + ", nationalite=" + nationalite + ", datenaissance=" + datenaissance + ", telephone=" + telephone + ", numpassport=" + numpassport + ", sexe=" + sexe + ", role=" + role + ", ref=" + ref + '}';
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public void setPrenom(String prenom) {
        this.prenom = prenom;
    }

    public void setCin(String cin) {
        this.cin = cin;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public void setMdp(String mdp) {
        this.mdp = mdp;
    }

    public void setNationalite(String nationalite) {
        this.nationalite = nationalite;
    }

    public void setDatenaissance(String datenaissance) {
        this.datenaissance = datenaissance;
    }

    public void setTelephone(String telephone) {
        this.telephone = telephone;
    }

    public void setNumpassport(String numpassport) {
        this.numpassport = numpassport;
    }

    public void setSexe(String sexe) {
        this.sexe = sexe;
    }

    public void setRole(String role) {
        this.role = role;
    }

    public void setRef(int ref) {
        this.ref = ref;
    }

    public String getUsername() {
        return username;
    }

    public String getNom() {
        return nom;
    }

    public String getPrenom() {
        return prenom;
    }

    public String getCin() {
        return cin;
    }

    public String getEmail() {
        return email;
    }

    public String getMdp() {
        return mdp;
    }

    public String getNationalite() {
        return nationalite;
    }

    public String getDatenaissance() {
        return datenaissance;
    }

    public String getTelephone() {
        return telephone;
    }

    public String getNumpassport() {
        return numpassport;
    }

    public String getSexe() {
        return sexe;
    }

    public String getRole() {
        return role;
    }

    public int getRef() {
        return ref;
    }
    
}
