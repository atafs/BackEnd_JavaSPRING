package dao;

import java.util.List;

public class Triangle {
	
	//ATTRIBUTES
	private List<Point> points;
	
	//GETTERS AND SETTERS
	public List<Point> getPoints() {
		return points;
	}

	public void setPoints(List<Point> points) {
		this.points = points;
	}

	/** PROCEDURE: print a message */
	public void draw() {
		//LOOP
		for (Point point : points) {
			System.out.println("POINT = " + point.toString());

		}
	}
}
