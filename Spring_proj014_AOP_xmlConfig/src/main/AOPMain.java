package main;


import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import service.ShapeService;

public class AOPMain {
	
	@SuppressWarnings("resource")
	public static void main(String[] args) {
		
		//INSTANTIATE SPRING APP CONTEXT
		ApplicationContext ctx = new ClassPathXmlApplicationContext("config/spring.xml");
		ShapeService shapeService = ctx.getBean("shapeService", ShapeService.class);
		
		//ARG CHANGE
		shapeService.getCircle().setNameAndReturn("@setNameAndReturn DUMMY NAME");
		
		//PRINT
		System.out.println("@Main " + shapeService.getCircle().getName() + "\n");
	}

}
