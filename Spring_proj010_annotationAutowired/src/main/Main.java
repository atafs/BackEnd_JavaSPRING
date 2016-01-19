package main;

import interfaces.Shape;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class Main {

	//MAIN
	public static void main(String[] args) {

		//INSTANTIATE
		@SuppressWarnings("resource")
		ApplicationContext context = new ClassPathXmlApplicationContext("config/spring.xml");
		
		//INTERFACE SHAPE
		Shape shape = (Shape)context.getBean("circle");
		shape.draw();
	}

}
