package dao;

public class Triangle {
	
	//ATTRIBUTES
	private String type;
	private int height;
	
	//CONSTRUCTOR INJECTION (overload)
	public Triangle(String type) {
		this.type = type;
	}
	
	public Triangle(int height) {
		this.height = height;
	}
	
	public Triangle(String type, int height) {
		this.type = type;
		this.height = height;
	}
	
	//GETTER
	public String getType() {
		return type;
	}
	
	public int getHeight() {
		return height;
	}

//	//SETTER INJECTION
//	public void setType(String type) {
//		this.type = type;
//	}

	/** PROCEDURE: print a message */
	public void draw() {
		System.out.println("SPRING INJECTION ###############");
		System.out.println(getType() + " = \tTriangle draw!!");
		System.out.println(getHeight() + " = \t\tTriangle height!!");

	}
}
