/**
 * 
 */
package fr.dou.btp.beans.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

import org.springframework.security.core.GrantedAuthority;

/**
 * @author Diouf
 *
 */
@Entity
@Table(name="adm_roles")
public class Role implements GrantedAuthority {
	
	/**
	 * Serial version UID
	 */
	private static final long serialVersionUID = 2402127734610702277L;

	/**
	 * Identifiant technique.
	 */
	@Id
	@GeneratedValue
	@Column(name="id")
	private long id;
	
	/**
	 * Libelle
	 */
	@Column(name="libelle")
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

	/* (non-Javadoc)
	 * @see org.springframework.security.core.GrantedAuthority#getAuthority()
	 */
	@Override
	public String getAuthority() {
		return libelle;
	}
	
	

}
