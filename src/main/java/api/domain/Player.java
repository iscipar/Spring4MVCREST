package api.domain;

public class Player {

	String id;
	String name;
	String nationality;
	String position;
	String current;

	public Player() {

	}

	public Player(String id, String name, String nationality, String position, String current) {
		this.id = id;
		this.name = name;
		this.nationality = nationality;
		this.position = position;
		this.current = current;
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

}