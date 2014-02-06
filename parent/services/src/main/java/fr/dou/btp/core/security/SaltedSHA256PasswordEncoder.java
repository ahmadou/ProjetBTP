/**
 * 
 */
package fr.dou.btp.core.security;

import java.io.UnsupportedEncodingException;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

import javax.annotation.PostConstruct;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.security.crypto.codec.Hex;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Component;

/**
 * Encrypteur pour password.
 * @author Diouf
 *
 */
@Component("passwordEncoder")
public class SaltedSHA256PasswordEncoder implements PasswordEncoder {

	/**
	 * Salt
	 */
	@Value("${passwordEncoder.salt}")
	private String salt;

	/**
	 * Digester
	 */
	private MessageDigest digest;

	/**
	 * Le nom de l'algorythme d encryption des mots de passe.
	 */
	@Value("${passwordEncoder.algorithm}")
	private String algorithm;


	/**
	 * Constructeur
	 * @param salt
	 * @throws NoSuchAlgorithmException
	 */
	public SaltedSHA256PasswordEncoder() {
	}
	
	/**
	 * Initialisation du bean
	 * @throws NoSuchAlgorithmException
	 */
	@PostConstruct
	public void init() throws NoSuchAlgorithmException {
		this.digest = MessageDigest.getInstance(algorithm);
	}


	@Override
	public String encode(CharSequence rawPassword) {

		String saltedPassword = rawPassword + this.salt;
		try {
			return new String(Hex.encode(this.digest.digest(saltedPassword.getBytes("UTF-8"))));
		} catch (UnsupportedEncodingException e) {
			throw new RuntimeException("UTF-8 not supported");
		}
	}


	@Override
	public boolean matches(CharSequence rawPassword, String encodedPassword) {

		String encode = this.encode(rawPassword);
		System.out.println(encode);
		return encode.equals(encodedPassword);
	}

}
