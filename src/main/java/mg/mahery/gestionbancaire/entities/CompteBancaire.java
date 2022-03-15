/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mg.mahery.gestionbancaire.entities;

import java.io.Serializable;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

/**
 *
 * @author Mahery
 */
@Entity
public class CompteBancaire implements Serializable {

   private static final long serialVersionUID = 1L;
   @Id
   @GeneratedValue(strategy = GenerationType.AUTO)
   private Long id;
   private String nom;
   private int solde;

   public CompteBancaire(String nom, int solde) {
      this.nom = nom;
      this.solde = solde;
   }

  


   public Long getId() {
      return id;
   }
   
      /**
    * Get the value of nom
    *
    * @return the value of nom
    */
   public String getNom() {
      return nom;
   }

   /**
    * Set the value of nom
    *
    * @param nom new value of nom
    */
   public void setNom(String nom) {
      this.nom = nom;
   }
   
   
   /**
    * Get the value of solde
    *
    * @return the value of solde
    */
   public int getSolde() {
      return solde;
   }

   /**
    * Set the value of solde
    *
    * @param solde new value of solde
    */
   public void setSolde(int solde) {
      this.solde = solde;
   }

   
   public void deposer(int montant){
      solde+=montant;
   }
   
   public void retirer(int montant){
      if(montant<solde){
         solde-=montant;
      }else{
         solde=0;
      }
   }
   
   @Override
   public int hashCode() {
      int hash = 0;
      hash += (id != null ? id.hashCode() : 0);
      return hash;
   }

   @Override
   public boolean equals(Object object) {
      // TODO: Warning - this method won't work in the case the id fields are not set
      if (!(object instanceof CompteBancaire)) {
         return false;
      }
      CompteBancaire other = (CompteBancaire) object;
      if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
         return false;
      }
      return true;
   }

   @Override
   public String toString() {
      return "mg.mahery.gestionbancaire.CompteBancaire[ id=" + id + " ]";
   }
   
}
