package model;

public class Circle {
	
	//ATTRIBUTES
	private String name;

	//GETTERS AND SETTERS
	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
		System.out.println("@Circle CIRCLE is setter called...");
		//throw (new RuntimeException());
	}
	
	//RETURN METHOD (not getter or setter)
	public String setNameAndReturn(String name) {
		this.name = name;
		System.out.println("@Circle RETURN CIRCLE is setter called...");
		return name;
	}
}
