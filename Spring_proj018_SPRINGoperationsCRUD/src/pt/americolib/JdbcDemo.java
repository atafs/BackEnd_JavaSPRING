package pt.americolib;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import pt.americolib.dao.JdbcDaoImpl;
import pt.americolib.model.Circle;

public class JdbcDemo {
	
	@SuppressWarnings("resource")
	public static void main(String[] args) {
		
		//TIMER:START
		long tStart = System.currentTimeMillis();
		
		//DEPENDENCY INJECTION(bean)
		ApplicationContext ctx = new ClassPathXmlApplicationContext("pt/americolib/config/spring.xml");
		JdbcDaoImpl dao = ctx.getBean("jdbcDaoImpl", JdbcDaoImpl.class);
		
		//GET COUNT
		System.out.println("\n---------PRINT CIRCLE TOTAL------------");
		System.err.println("Circle TOTAL Count LINES = " + dao.getCircleCount());

		//GET NAME
		System.out.println("\n---------PRINT CIRCLE NAME------------");
		System.err.println("Circle Circle NAME = " + dao.getCircleName(2));
		
		//GET NAME
		System.out.println("\n---------PRINT CIRCLE FROM AN ID------------");
		System.err.println("Circle Circle ID = " + dao.getCircleForId(2).getId() + ", " + dao.getCircleForId(2).getName() + ";");
		
		//GET LIST
		System.out.println("\n---------PRINT CIRCLE LIST------------");
		dao.getAllCircles().forEach(n -> {System.err.println(n.getId() + ", " + n.getName() + ";");});
	
		//INSERT CIRCLE
		System.out.println("\n---------PRINT INSERT CIRCLE------------");
		int i = dao.getAllCircles().size() - 1;
		dao.insertCircle(new Circle(i, "A.F._" + i + "Circle"));
		System.err.println(i + " -> " + dao.getCircleForId(i).getName() + ";");
		
		//nao posso criar duas vezes a mesma table
		//CREATE TRIANGLE
//		System.out.println("\n---------PRINT CREATE TRIANGLE------------");
//		dao.createTriangleTable();

		
		//PERFORMANCE
		getPerformmance(tStart);
	}
	
	/** Procedure that will give me the values for the amount of time the app toke to run */
	private static void getPerformmance(long tStart) {
		//TIMER: FINISH
		long tEnd = System.currentTimeMillis();
		long operation_performance_mili = tEnd - tStart;
		double operation_performance_sec = operation_performance_mili / 1000.0;
		
		//PRINT
		System.out.println("\n- Performance = " + operation_performance_mili + "[ms] || " + operation_performance_sec + "[s];");

	}
}