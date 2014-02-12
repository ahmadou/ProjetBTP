/**
 * 
 */
package fr.dou.btp.services.rest;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

/**
 * Classe de base pour les services.
 * @author Diouf
 *
 */
public class BaseService {
	
	/**
	 * Declaration de l'entity manager
	 */
	@PersistenceContext
	private EntityManager em;
	

}
