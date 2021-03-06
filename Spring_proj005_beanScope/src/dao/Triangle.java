package dao;

import org.springframework.beans.BeansException;
import org.springframework.beans.factory.BeanNameAware;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;

public class Triangle implements ApplicationContextAware, BeanNameAware{
	
	//ATTRIBUTES
	private Point pointA;
	private Point pointB;
	private Point pointC;
	
	private ApplicationContext context = null;;
	
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
	
	public ApplicationContext getContext() {
		return context;
	}

	/** PROCEDURE: print a message */
	public void draw() {
		System.out.println("POINT_A = " + getPointA().toString());
		System.out.println("POINT_B = " + getPointB().toString());
		System.out.println("POINT_C = " + getPointC().toString());

	}

	//INTERFACE ApplicationContextAware
	@Override
	public void setApplicationContext(ApplicationContext applicationContext) throws BeansException {
		this.context = context;
	}

	//INTERFACE BeanNameAware
	@Override
	public void setBeanName(String beanName) {
		System.out.println("BEAN NAME IS: " + beanName);
	}
}
