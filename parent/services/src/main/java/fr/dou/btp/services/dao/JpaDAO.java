/**
 * 
 */
package fr.dou.btp.services.dao;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

/**
 * Abstraction des DAO afin de factoriser certains attributs
 * @author Diouf
 *
 */
public abstract class JpaDAO {
	
	/**
	 * Entity Manager
	 */
	@PersistenceContext
	protected EntityManager entityManager;
	

}
