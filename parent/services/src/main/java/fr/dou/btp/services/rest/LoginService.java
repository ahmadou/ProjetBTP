/**
 * 
 */
package fr.dou.btp.services.rest;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import fr.dou.btp.beans.dto.UtilisateurDTO;

/**
 * @author Diouf
 *
 */
@Controller
@RequestMapping("login")
public class LoginService {
	
	/**
	 * Service rest pour l'authentification
	 * @return
	 */
	@RequestMapping(value="authenticate", method=RequestMethod.POST)
	@ResponseBody
	public UtilisateurDTO authenticate(@RequestBody UtilisateurDTO user ) {
		user.setLogged(true);
		user.setToken("BigMeanToken");
		return user;
	}

}
