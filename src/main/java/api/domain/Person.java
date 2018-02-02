package api.domain;

public class Person {

	String name;
	String country;
	String email;

	public Person() {

	}

	public Person(String name, String country, String email) {
		this.name = name;
		this.country = country;
		this.email = email;
	}

	public String getName() {
		return name;
	}

	public String getCountry() {
		return country;
	}

	public String getEmail() {
		return email;
	}

}