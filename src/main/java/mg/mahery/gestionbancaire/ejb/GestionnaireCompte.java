/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mg.mahery.gestionbancaire.ejb;

import java.util.List;
import javax.annotation.sql.DataSourceDefinition;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;
import mg.mahery.gestionbancaire.entities.CompteBancaire;

/**
 *
 * @author Mahery
 */
@DataSourceDefinition(
        className = "com.mysql.cj.jdbc.MysqlDataSource",
        name = "jdbc/banque",
        serverName = "localhost",
        portNumber = 3306,
        user = "root", // nom et
        password = "root", // mot de passe que vous avez donnés lors de la création de la base de données
        databaseName = "banque",
        properties = {
            //"zeroDateTimeBehavior=CONVERT_TO_NULL",
           "useSSL=false",
           "allowPublicKeyRetrieval=true"
        }
)

@Stateless
public class GestionnaireCompte {

  // @PersistenceContext(unitName = "banquePU")
   @PersistenceContext
   private EntityManager em;

   // Add business logic below. (Right-click in editor and choose
   // "Insert Code > Add Business Method")
   public void creerCompte(CompteBancaire compte) {
      em.persist(compte);
   }

   List<CompteBancaire> getAllComptes() {
      TypedQuery query = em.createNamedQuery("CompteBancaire.findAll", CompteBancaire.class);
      return query.getResultList();
   }

   public long nbComptes() {
      TypedQuery<Long> query = em.createNamedQuery("select count(c) from compteBancaire c", Long.class);
      return query.getSingleResult();
   }

}
