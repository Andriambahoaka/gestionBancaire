/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mg.mahery.gestionbancaire.ejb;

import javax.annotation.PostConstruct;
import javax.ejb.EJB;
import javax.ejb.Singleton;
import javax.ejb.Startup;
import mg.mahery.gestionbancaire.entities.CompteBancaire;

/**
 *
 * @author Mahery
 */
@Singleton
@Startup
public class Init {

   // Add business logic below. (Right-click in editor and choose
   // "Insert Code > Add Business Method")
   @EJB
   private GestionnaireCompte gestionnaireCompte;
   
   @PostConstruct
   public void initComptes() {
      if (gestionnaireCompte.nbComptes() != 0) {
         return;
      }
      gestionnaireCompte.creerCompte(new CompteBancaire("John Lennon", 150000));
      gestionnaireCompte.creerCompte(new CompteBancaire("Paul McCartney", 950000));
      gestionnaireCompte.creerCompte(new CompteBancaire("Ringo Starr", 20000));
      gestionnaireCompte.creerCompte(new CompteBancaire("Georges Harrisson", 100000));
   }
}
