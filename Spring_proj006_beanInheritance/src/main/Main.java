package main;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import dao.Triangle;

public class Main {

	//MAIN
	public static void main(String[] args) {

		//INSTANTIATE
		@SuppressWarnings("resource")
		ApplicationContext context = new ClassPathXmlApplicationContext("config/spring.xml");
		
		//
		System.out.println("\n-------PRINT triangleONE ----------");
		Triangle triangleONE = (Triangle)context.getBean("triangle1");
		triangleONE.draw();
		
		System.out.println("\n-------PRINT triangleTWO ----------");
		Triangle triangleTWO = (Triangle)context.getBean("triangle2");
		triangleTWO.draw();
	}

}
