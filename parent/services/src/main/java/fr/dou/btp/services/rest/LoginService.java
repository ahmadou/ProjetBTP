/**
 * 
 */
package fr.dou.btp.services.rest;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.context.SecurityContext;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import fr.dou.btp.beans.dto.UserDTO;
import fr.dou.btp.services.dao.UserDAO;

/**
 * @author Diouf.
 *
 */
@Controller
@RequestMapping("login")
public class LoginService extends BaseService {
	
	/**
	 * Cle de session pour le contexte spring security
	 */
	private static final String SPRING_SECURITY_CONTEXT = "SPRING_SECURITY_CONTEXT";

	/**
	 * User DAO
	 */
	@Autowired
	private UserDAO userDao;
	
	/**
	 * Authentification Manager.
	 */
	@Autowired
	@Qualifier("authenticationManager")
	private AuthenticationManager authManager;
	
	/**
	 * Service rest pour l'authentification.
	 * Retourne une representation JSON du user
	 * @return
	 */
	@RequestMapping(value="authenticate", method=RequestMethod.POST)
	@ResponseBody
	@Transactional(readOnly=true)
	public UserDTO authenticate(@RequestBody UserDTO user, HttpSession session ) {
		try {
			UsernamePasswordAuthenticationToken authenticationToken =
					new UsernamePasswordAuthenticationToken(user.getIdentifiant(), user.getPassword());
			Authentication authentication = this.authManager.authenticate(authenticationToken);
			SecurityContext context = SecurityContextHolder.getContext();
			context.setAuthentication(authentication);
			session.setAttribute(SPRING_SECURITY_CONTEXT, context);
			for(GrantedAuthority authority: authentication.getAuthorities()) {
				user.getRoles().put(authority.getAuthority(), true);
			}
			user.setLogged(true);
			user.setPassword("");
		} catch (AuthenticationException e) {
			 user.setLogged(false);
			 user.setPassword("");
		}
		return user;
	}
}
