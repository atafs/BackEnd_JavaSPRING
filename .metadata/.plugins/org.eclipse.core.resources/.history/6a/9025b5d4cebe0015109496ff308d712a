package main;

import interfaces.Shape;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import dao.Circle;
import dao.Triangle;

public class Main {

	//MAIN
	public static void main(String[] args) {

		//INSTANTIATE
		@SuppressWarnings("resource")
		ApplicationContext context = new ClassPathXmlApplicationContext("config/spring.xml");
		
		//OBJETC TRIANGLE
		Triangle triangle = (Triangle)context.getBean("triangle");
		triangle.draw();
		
		//OBJECT CIRCLE
		Circle circle = (Circle)context.getBean("circle");
		circle.draw();
		
		//INTERFACE SHAPE
		Shape shape = (Shape)context.getBean("circle");
		shape.draw();
	}

}
