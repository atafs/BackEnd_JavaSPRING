package dao;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;
import javax.annotation.Resource;

import org.springframework.stereotype.Component;

import interfaces.Shape;

/* ANNOTATIONS - Stereotype (class roles): 
 * @Component or @Service: Bean Object 
 * @Repository: Data Object
 * @Controller: Controller Object
 * 
 * - level of documentation
 * */

@Component
public class Circle implements Shape{

	//ATTRIBUTES
	private Point center;
	
	//GETTERS AND SETTERS
	public Point getCenter() {
		return center;
	}

	//INTERFACE Shape
	public void draw() {
		System.out.println("\nDRAWING Circle:");
		System.out.println("CIRCLE Point is: " + center.getX() + ", " + center.getY() + "\n");
	}
	
	//JSR-250 Annotations (Java Specific Request)
	@Resource(name="pointC")
	public void setCenter(Point center) {
		this.center = center;
	}
	
	//after the constructor is called
	@PostConstruct
	public void initializeCircle() {
		System.out.println("INIT THE CIRCLE");
	}
	
	//before the object is destroyed
	@PreDestroy
	public void destroyCircle() {
		System.out.println("DESTROY THE CIRCLE");
	}
}
