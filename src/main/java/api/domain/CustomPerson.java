package api.domain;

import java.util.Date;

public class CustomPerson {

	String name;
	String country;
	String email;
	String gender;
	Date currentDate;

	public CustomPerson() {

	}

	public CustomPerson(String name, String country, String email, String gender, Date currentDate) {
		this.name = name;
		this.country = country;
		this.email = email;
		this.gender = gender;
		this.currentDate = currentDate;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getCountry() {
		return country;
	}

	public void setCountry(String country) {
		this.country = country;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getGender() {
		return gender;
	}

	public void setGender(String gender) {
		this.gender = gender;
	}

	public Date getCurrentDate() {
		return currentDate;
	}

	public void setCurrentDate(Date currentDate) {
		this.currentDate = currentDate;
	}

}