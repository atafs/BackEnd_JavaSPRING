package dao;

import java.util.List;

import org.springframework.context.ApplicationContext;

public class Triangle {
	
	//ATTRIBUTES
	private List<Point> points;
	private ApplicationContext context = null;;
	
	//GETTERS AND SETTERS
	public ApplicationContext getContext() {
		return context;
	}

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
			System.out.println(point.toString());
		}
	}
}
