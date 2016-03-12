package pt.americolib;

import pt.americolib.dao.JdbcDaoImpl;
import pt.americolib.model.Circle;

public class JdbcDemo {
	
	public static void main(String[] args) {
		
		//INSTANCIATE
		Circle circle = new JdbcDaoImpl().getCircle(1);
		
		//PRINT
		System.err.println("---------PRINT CIRCLE------------");
		System.err.println("circle = " + circle.getId());
		System.err.println("circle = " + circle.getName());
		
	}
}
