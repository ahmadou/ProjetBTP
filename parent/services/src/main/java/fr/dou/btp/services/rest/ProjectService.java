/**
 * 
 */
package fr.dou.btp.services.rest;

import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import fr.dou.btp.beans.dto.ProjectDTO;

/**
 * 
 * Service rest pour interagir avec les projet d'un utilisateur
 * @author Diouf
 *
 */
@Controller
@RequestMapping("secure/project")
public class ProjectService {
	
	/**
	 * Recupère la liste des projets en cours pour cet utilisateur
	 * @param session
	 * @return
	 */
	@RequestMapping(value="getProjectList", method=RequestMethod.GET)
	@ResponseBody
	public List<ProjectDTO> getProjectList(HttpSession session) {

		System.out.println(session.getAttribute("test"));
		return createDummyList();
	}

	/**
	 * A fin de test
	 * @return
	 */
	private List<ProjectDTO> createDummyList() {
		List<ProjectDTO> list = new ArrayList<ProjectDTO>();
		ProjectDTO projet = new ProjectDTO();
		projet.setId(1);
		projet.setLibelle("Projet 1");
		list.add(projet);
		ProjectDTO projet2 = new ProjectDTO();
		projet2.setId(2);
		projet.setLibelle("Projet 2");
		list.add(projet2);
		return list;
	}

}
