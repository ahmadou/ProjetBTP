/**
 * 
 */
package fr.dou.btp.beans.model;

import org.joda.time.DateTime;

/**
 * Utilisateur de l'application
 * @author Diouf
 *
 */
public class Utilisateur {
	
	/**
	 * Identifiant technique
	 */
	private long id;
	
	/**
	 * Identifiant de connexion
	 */
	private String identifiant;
	
	/**
	 * Date de creation
	 */
	private DateTime dateCreation;

	/**
	 * @return la valeur de id
	 */
	public long getId() {
		return id;
	}

	/**
	 * @param id la valeur a affecter a id
	 */
	public void setId(long id) {
		this.id = id;
	}

	/**
	 * @return la valeur de identifiant
	 */
	public String getIdentifiant() {
		return identifiant;
	}

	/**
	 * @param identifiant la valeur a affecter a identifiant
	 */
	public void setIdentifiant(String identifiant) {
		this.identifiant = identifiant;
	}

	/**
	 * @return la valeur de dateCreation
	 */
	public DateTime getDateCreation() {
		return dateCreation;
	}

	/**
	 * @param dateCreation la valeur a affecter a dateCreation
	 */
	public void setDateCreation(DateTime dateCreation) {
		this.dateCreation = dateCreation;
	}
	

}
