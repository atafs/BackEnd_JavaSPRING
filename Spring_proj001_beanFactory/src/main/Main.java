package main;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import dao.Triangle;

public class Main {

	public static void main(String[] args) {

//		//INSTANCIATE (no spring)
//		Triangle triangle = new Triangle();
//		triangle.draw();
		
		//OR
		
//		//INSTANTIATE WITH SPRING
//		BeanFactory factory = new XmlBeanFactory(new FileSystemResource("config/spring.xml"));
//		Triangle triangle = (Triangle)factory.getBean("Triangle");
//		triangle.draw();
		
		//OR
		
		//INSTANTIATE WITH SPRING ApplicationContext and Property Initialization
		//config need to be inside src package
		ApplicationContext context = new ClassPathXmlApplicationContext("config/spring.xml");
		Triangle triangle = (Triangle)context.getBean("Triangle");
		triangle.draw();
	}

}
