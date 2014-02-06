/**
 * 
 */
package fr.dou.btp.services.dao;

import java.util.List;

import org.springframework.security.core.userdetails.UserDetailsService;

import fr.dou.btp.beans.model.User;

/**
 * DAO pour les Users
 * @author Diouf
 *
 */
public interface UserDAO extends UserDetailsService {
	
	/**
	 * Renvoie la liste de tous les utilisateurs.
	 * @return
	 */
	List<User> getAllUsers();

}
