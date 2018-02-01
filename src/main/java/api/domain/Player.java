package api.domain;

import javax.validation.constraints.NotNull;

import org.apache.bval.constraints.Email;
import org.apache.bval.extras.constraints.checkdigit.IBAN;

public class Player {

	@NotNull
	String id;

	@NotNull
	String name;

	@NotNull
	String nationality;

	@NotNull
	String position;

	@NotNull
	String current;

	@NotNull
	@Email
	String email;
	
	@NotNull
	@IBAN
	String iban;

	public Player() {

	}

	public Player(String id, String name, String nationality, String position, String current, String email, String iban) {
		this.id = id;
		this.name = name;
		this.nationality = nationality;
		this.position = position;
		this.current = current;
		this.email = email;
		this.iban = iban;
	}

	public String getId() {
		return id;
	}

	public String getName() {
		return name;
	}

	public String getNationality() {
		return nationality;
	}

	public String getPosition() {
		return position;
	}

	public String getCurrent() {
		return current;
	}

	public String getEmail() {
		return email;
	}
	
	public String getIban() {
		return iban;
	}

}