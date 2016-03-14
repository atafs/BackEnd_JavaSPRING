package pt.americolib.model;

import javax.persistence.Entity;
import javax.persistence.Id;


//DAO
@Entity
public class Circle {
	
	//ATTRIBUTES
	@Id
	private int id;
	private String name;
	
	//CONSTRUCTOR
	public Circle(int circleId, String circleName) {
		setId(circleId);
		setName(circleName);
	}
	
	public Circle() {}

	//GETTERS AND SETTERS
	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}
}
