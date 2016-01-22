package service;

import model.Circle;
import model.Triangle;

public class ShapeService {
	
	//ATTRIBUTES
	private Circle circle;
	private Triangle triangle;
	
	//GETTERS AND SETTERS
	public Circle getCircle() {
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