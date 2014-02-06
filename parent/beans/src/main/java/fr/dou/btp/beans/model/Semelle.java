package fr.dou.btp.beans.model;


/**
 * Les semelles sont les supports aux poteaux dans les fondations.
 * @author Diouf
 *
 */
public class Semelle {
	
	/**
	 * La denomination de la semelle
	 */
	private String libelle;
	
	/**
	 * La longueur
	 */
	private float longueur;
	
	/**
	 * La largeur
	 */
	private float largeur;
	
	/**
	 * LA hauteur
	 */
	private float hauteur;

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
	 * @return la valeur de longueur
	 */
	public float getLongueur() {
		return longueur;
	}

	/**
	 * @param longueur la valeur a affecter a longueur
	 */
	public void setLongueur(float longueur) {
		this.longueur = longueur;
	}

	/**
	 * @return la valeur de largeur
	 */
	public float getLargeur() {
		return largeur;
	}

	/**
	 * @param largeur la valeur a affecter a largeur
	 */
	public void setLargeur(float largeur) {
		this.largeur = largeur;
	}

	/**
	 * @return la valeur de hauteur
	 */
	public float getHauteur() {
		return hauteur;
	}

	/**
	 * @param hauteur la valeur a affecter a hauteur
	 */
	public void setHauteur(float hauteur) {
		this.hauteur = hauteur;
	}
	
}
