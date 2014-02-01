/**
 * 
 */
package fr.dou.btp.beans.dto;

import java.io.Serializable;

/**
 * @author Diouf
 *
 */
public class UtilisateurDTO implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = -2897901425472659297L;

	/**
	 * L'idenetifiant
	 */
	private String identifiant;
	
	/**
	 * Le password
	 */
	private String password;
	
	
	/**
	 * Jeton d'authentification
	 */
	private String token;
	
	
	/**
	 * @return la valeur de token
	 */
	public String getToken() {
		return token;
	}

	/**
	 * @param token la valeur a affecter a token
	 */
	public void setToken(String token) {
		this.token = token;
	}

	/**
	 * @return la valeur de identifiant
	 */
	public String getIdentifiant() {
		return identifiant;
	}
	
	/**
	 * Indicateur de connection reussie
	 */
	private boolean isLogged;
	

	/**
	 * @return la valeur de isLogged
	 */
	public boolean isLogged() {
		return isLogged;
	}

	/**
	 * @param isLogged la valeur a affecter a isLogged
	 */
	public void setLogged(boolean isLogged) {
		this.isLogged = isLogged;
	}

	/**
	 * @param identifiant la valeur a affecter a identifiant
	 */
	public void setIdentifiant(String identifiant) {
		this.identifiant = identifiant;
	}

	/**
	 * @return la valeur de password
	 */
	public String getPassword() {
		return password;
	}

	/**
	 * @param password la valeur a affecter a password
	 */
	public void setPassword(String password) {
		this.password = password;
	}
	
	
	

}
