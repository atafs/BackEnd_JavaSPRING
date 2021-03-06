package dao;

import org.springframework.beans.factory.DisposableBean;
import org.springframework.beans.factory.InitializingBean;

public class Triangle implements InitializingBean, DisposableBean{
	
	//ATTRIBUTES
	private Point pointA;
	private Point pointB;
	private Point pointC;
	
	
	//GETTERS AND SETTERS
	public Point getPointA() {
		return pointA;
	}

	public void setPointA(Point pointA) {
		this.pointA = pointA;
	}

	public Point getPointB() {
		return pointB;
	}

	public void setPointB(Point pointB) {
		this.pointB = pointB;
	}

	public Point getPointC() {
		return pointC;
	}

	public void setPointC(Point pointC) {
		this.pointC = pointC;
	}

	/** PROCEDURE: print a message */
	public void draw() {
		System.out.println("POINT_A = " + getPointA().toString());
		System.out.println("POINT_B = " + getPointB().toString());
		System.out.println("POINT_C = " + getPointC().toString());
	}
	
	/** PROCEDURE: NOT BOUND TO SPRING, it will print a message when a class is initialised */
	public void myInit() {
		System.out.println("LOW PRIORITY Initializing Beans INIT method called for Triangle");

	}
	
	/** PROCEDURE: NOT BOUND TO SPRING, it will print a message when a class is destroyed */
	public void cleanUp() {
		System.out.println("LOW PRIORITY Disposable beans DESTROY method called for Triangle");

	}

	//INTERFACE InitializingBean
	@Override
	public void afterPropertiesSet() throws Exception {
		System.out.println("Initializing Beans INIT method called for Triangle");
	}

	//INTERFACE DisposableBean
	@Override
	public void destroy() throws Exception {
		System.out.println("Disposable beans DESTROY method called for Triangle");

	}
}
