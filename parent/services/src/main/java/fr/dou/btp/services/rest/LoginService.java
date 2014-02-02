/**
 * 
 */
package fr.dou.btp.services.rest;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;
import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import fr.dou.btp.beans.dto.UtilisateurDTO;
import fr.dou.btp.beans.model.Utilisateur;

/**
 * @author Diouf
 *
 */
@Controller
@RequestMapping("secure/login")
public class LoginService {
	
	@PersistenceContext
	private EntityManager em;
	/**
	 * Service rest pour l'authentification
	 * @return
	 */
	@RequestMapping(value="authenticate", method=RequestMethod.POST)
	@ResponseBody
	public UtilisateurDTO authenticate(@RequestBody UtilisateurDTO user, HttpSession session ) {
		user.setLogged(true);
		user.setToken("BigMeanToken");
		session.setAttribute("test", "VOillaaaaa");
		CriteriaQuery<Utilisateur> createQuery = em.getCriteriaBuilder().createQuery(Utilisateur.class);
		Root<Utilisateur> from = createQuery.from(Utilisateur.class);
		List<Utilisateur> resultList = em.createQuery(createQuery).getResultList();
		System.out.println(resultList);
		return user;
	}

}
