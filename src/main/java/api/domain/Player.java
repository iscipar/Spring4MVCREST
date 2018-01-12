package api.domain;

public class Player {

	Long id;
	String name;
	String nationality;
	String position;
	String current;

	public Player() {

	}

	public Player(Long id, String name, String nationality, String position, String current) {
		this.id = id;
		this.name = name;
		this.nationality = nationality;
		this.position = position;
		this.current = current;
	}

	public Long getId() {
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