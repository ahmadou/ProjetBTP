/**
 * 
 */
package fr.dou.btp.beans.dto;

/**
 * POJO representant les projet disponibles pour un utilisateur.
 * @author Diouf
 *
 */
public class ProjectDTO {
	
	/**
	 * Identifiant technique
	 */
	private long id;
	
	/**
	 * Libelle du projet
	 */
	private String libelle;

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
	
}
