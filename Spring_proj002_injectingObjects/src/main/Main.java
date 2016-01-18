package main;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import dao.Triangle;

public class Main {

	//MAIN
	public static void main(String[] args) {

		//INSTANTIATE
		ApplicationContext context = new ClassPathXmlApplicationContext("config/spring.xml");
		Triangle triangle = (Triangle)context.getBean("triangle-alias");
		triangle.draw();
	}

}
