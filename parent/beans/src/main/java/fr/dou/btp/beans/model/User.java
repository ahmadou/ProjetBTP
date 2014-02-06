/**
 * 
 */
package fr.dou.btp.beans.model;

import java.util.Collection;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Transient;

import org.joda.time.DateTime;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

/**
 * Utilisateur de l'application
 * @author Diouf
 *
 */
@Entity
@Table(name="adm_users")
public class User implements UserDetails {
	
	/**
	 * VERSION UID.
	 */
	private static final long serialVersionUID = -2414290757248811061L;

	/**
	 * Identifiant technique
	 */
	@Id
	@Column(name="id")
	@GeneratedValue
	private long id;
	
	/**
	 * Identifiant de connexion
	 */
	@Column(name="identifiant")
	private String userName;
	
	@Column(name="password")
	private String password;
	
	/**
	 * Date de creation
	 */
	@Transient
	private DateTime dateCreation;
	
	@OneToMany
	@JoinTable(
            name="adm_users_roles",
            joinColumns = @JoinColumn( name="user_id"),
            inverseJoinColumns = @JoinColumn( name="role_id"))
	private List<Role> roles;

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

	/**
	 * @return la valeur de roles
	 */
	public List<Role> getRoles() {
		return roles;
	}

	/**
	 * @param roles la valeur a affecter a roles
	 */
	public void setRoles(List<Role> roles) {
		this.roles = roles;
	}

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

	/* (non-Javadoc)
	 * @see org.springframework.security.core.userdetails.UserDetails#getAuthorities()
	 */
	@Override
	public Collection<? extends GrantedAuthority> getAuthorities() {
		return this.roles;
	}

	/* (non-Javadoc)
	 * @see org.springframework.security.core.userdetails.UserDetails#getUsername()
	 */
	@Override
	public String getUsername() {
		return userName;
	}

	/* (non-Javadoc)
	 * @see org.springframework.security.core.userdetails.UserDetails#isAccountNonExpired()
	 */
	@Override
	public boolean isAccountNonExpired() {
		return true;
	}

	/* (non-Javadoc)
	 * @see org.springframework.security.core.userdetails.UserDetails#isAccountNonLocked()
	 */
	@Override
	public boolean isAccountNonLocked() {
		return true;
	}

	/* (non-Javadoc)
	 * @see org.springframework.security.core.userdetails.UserDetails#isCredentialsNonExpired()
	 */
	@Override
	public boolean isCredentialsNonExpired() {
		return true;
	}

	/* (non-Javadoc)
	 * @see org.springframework.security.core.userdetails.UserDetails#isEnabled()
	 */
	@Override
	public boolean isEnabled() {
		return true;
	}
}
