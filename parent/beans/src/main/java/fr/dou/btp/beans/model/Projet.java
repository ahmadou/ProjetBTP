/**
 * 
 */
package fr.dou.btp.beans.model;

import org.joda.time.DateTime;

/**
 * Modele representant un projet BTP.
 * @author Diouf
 *
 */
public class Projet {
	
	/**
	 * Nom du projet
	 */
	private String libelle;
	
	/**
	 * Date de creation du projet.
	 */
	private DateTime dateCreation;
	
	/**
	 * L utilisateur proprietaire du projet.
	 */
	private User propietaire;

	/**
	 * @return la valeur de libelle
	 */
	public String getLibelle() {
		return libelle;
	}

	/**
	 * @param libelle la valeur a affecter a libelle
	 */
	public void setLibelle(String libelle) {
		this.libelle = libelle;
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

	/**
	 * @return la valeur de propietaire
	 */
	public User getPropietaire() {
		return propietaire;
	}

	/**
	 * @param propietaire la valeur a affecter a propietaire
	 */
	public void setPropietaire(User propietaire) {
		this.propietaire = propietaire;
	}

}
