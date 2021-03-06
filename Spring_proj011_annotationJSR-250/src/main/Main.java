package main;

import interfaces.Shape;

import org.springframework.context.support.AbstractApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class Main {

	//MAIN
	@SuppressWarnings("resource")
	public static void main(String[] args) {

		//INSTANTIATE
		AbstractApplicationContext context = new ClassPathXmlApplicationContext("config/spring.xml");
		context.registerShutdownHook();
		
		//INTERFACE SHAPE
		Shape shape = (Shape)context.getBean("circle");
		shape.draw();

	}

}
