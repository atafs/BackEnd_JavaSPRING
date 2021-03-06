package dao;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;

import interfaces.Shape;

public class Circle implements Shape{

	//ATTRIBUTES
	private Point center;
	
	//GETTERS AND SETTERS
	public Point getCenter() {
		return center;
	}

	@Autowired
	@Qualifier("circleRelated")
	public void setCenter(Point center) {
		this.center = center;
	}

	public void draw() {
		System.out.println("\nDRAWING Circle:");
		System.out.println("CIRCLE Point is: " + center.getX() + ", " + center.getY());
	}

}
