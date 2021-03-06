package main;


import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import service.FactoryService;
import service.ShapeService;

public class AOPMain {
	
	@SuppressWarnings("resource")
	public static void main(String[] args) {
		
		//INSTANTIATE SPRING APP CONTEXT
//		ApplicationContext ctx = new ClassPathXmlApplicationContext("config/spring.xml");
//		ShapeService shapeService = ctx.getBean("shapeService", ShapeService.class);
//		
//		//ARG CHANGE
//		shapeService.getCircle().setNameAndReturn("@setNameAndReturn DUMMY NAME");
//		System.out.println("@Main " + shapeService.getCircle().getName() + "\n");

		/* OR ######################### */
		
		//INSTANTIATE FACTORY SERVICE (NO SPRING USED IN THIS IMPLEMENTATION)
//		FactoryService factoryService = new FactoryService();
//		ShapeService shapeService = (ShapeService) factoryService.getBean("shapeService");
//		
//		//PRINT
//		shapeService.getCircle();
		
		/* OR ######################### */
		
		//INSTANTIATE FACTORY SERVICE (NO SPRING USED IN THIS IMPLEMENTATION)
		FactoryService factoryService = new FactoryService();
		ShapeService shapeService = (ShapeService) factoryService.getBean("shapeService");
		
		//PRINT
		shapeService.getCircle();

	}

}
