package main;

import org.springframework.context.support.AbstractApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import dao.Triangle;

public class Main {

	//MAIN
	public static void main(String[] args) {
		@SuppressWarnings("resource")
		AbstractApplicationContext context = new ClassPathXmlApplicationContext("config/spring.xml");
		
		//CLOSE AND DESTRY ALL THE BEANS
		context.registerShutdownHook();
		
		//INSTANTIATE
		Triangle triangle = (Triangle)context.getBean("triangle");
		triangle.draw();
	}
}
