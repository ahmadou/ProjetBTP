/**
 * 
 */
package fr.dou.btp.services.dao.impl;

import java.util.List;

import javax.persistence.NoResultException;
import javax.persistence.TypedQuery;
import javax.persistence.criteria.CriteriaQuery;

import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import fr.dou.btp.beans.model.User;
import fr.dou.btp.services.dao.JpaDAO;
import fr.dou.btp.services.dao.UserDAO;

/**
 * Implementation JPA du DAO User
 * 
 * @author Diouf
 * 
 */
@Repository("userDao")
public class UserDAOImpl extends JpaDAO implements UserDAO {

	/*
	 * (non-Javadoc)
	 * 
	 * @see fr.dou.btp.services.dao.UserDAO#getAllUsers()
	 */
	@Override
	@Transactional(readOnly = true)
	public List<User> getAllUsers() {
		CriteriaQuery<User> createQuery = entityManager.getCriteriaBuilder()
				.createQuery(User.class);
		createQuery.from(User.class);
		return entityManager.createQuery(createQuery).getResultList();
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see org.springframework.security.core.userdetails.UserDetailsService#
	 * loadUserByUsername(java.lang.String)
	 */
	@Override
	public UserDetails loadUserByUsername(String userName)
			throws UsernameNotFoundException {
		TypedQuery<User> query = entityManager.createQuery(
				"from User u where u.userName = :userName", User.class);
		query.setParameter("userName", userName);
		User user = null;
		try {
			user = query.getSingleResult();
		} catch (NoResultException e) {
			throw new UsernameNotFoundException(String.format(
					"L identifiant %s n'a pas été trouvé en BDD", userName), e);
		}
		return user;
	}

}
