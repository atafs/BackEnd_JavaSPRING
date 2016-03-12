package pt.americolib;

import pt.americolib.dao.JdbcDaoImpl;
import pt.americolib.model.Circle;

public class JdbcDemo {
	
	public static void main(String[] args) {
		
		//TIMER:START
		long tStart = System.currentTimeMillis();
		
		//INSTANCIATE
		Circle circle = new JdbcDaoImpl().getCircle(2);
				
		//TIMER: FINISH
		long tEnd = System.currentTimeMillis();
		long operation_performance_mili = tEnd - tStart;
		double operation_performance_sec = operation_performance_mili / 1000.0;
		
		//PRINT
		System.err.println("---------PRINT CIRCLE1------------");
		System.err.println("circle = " + circle.getId());
		System.err.println("circle = " + circle.getName());
		System.err.println("operation_performance_mili = " + operation_performance_mili + "[ms] || " + operation_performance_sec + "[s];");

	}
}
