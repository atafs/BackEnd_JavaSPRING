package dao;

import org.springframework.beans.factory.annotation.Required;

import interfaces.Shape;

public class Circle implements Shape{

	//ATTRIBUTES
	private Point center;
	
	//GETTERS AND SETTERS
	public Point getCenter() {
		return center;
	}

	@Required
	public void setCenter(Point center) {
		this.center = center;
	}

	@Override
	public void draw() {
		System.out.println("\nDRAWING Circle:");
		System.out.println("CIRCLE Point is: " + center.getX() + ", " + center.getY());
	}

}
