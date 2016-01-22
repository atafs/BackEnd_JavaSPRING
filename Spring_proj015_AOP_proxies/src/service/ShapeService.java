package service;

import aspect.annotation.Loggable;
import model.Circle;
import model.Triangle;

public class ShapeService {
	
	//ATTRIBUTES
	private Circle circle;
	private Triangle triangle;
	
	//GETTERS AND SETTERS
	@Loggable
	public Circle getCircle() {
		System.out.println("Circled getter called...");
		return circle;
	}
	public void setCircle(Circle circle) {
		this.circle = circle;
	}
	public Triangle getTriangle() {
		return triangle;
	}
	public void setTriangle(Triangle triangle) {
		this.triangle = triangle;
	}
}
