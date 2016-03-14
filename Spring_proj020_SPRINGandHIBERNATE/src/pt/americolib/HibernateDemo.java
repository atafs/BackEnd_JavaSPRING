package pt.americolib;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import pt.americolib.dao.HibernateDaoImpl;

public class HibernateDemo {
	
	public static void main(String[] args) {
		//TIMER:START
		long tStart = System.currentTimeMillis();
		
		//DEPENDENCY INJECTION(bean)
		ApplicationContext ctx = new ClassPathXmlApplicationContext("pt/americolib/config/spring.xml");
		HibernateDaoImpl dao = ctx.getBean("hibernateDaoImpl", HibernateDaoImpl.class);
		
		//GET COUNT
		System.out.println("\n---------PRINT CIRCLE TOTAL------------");
		System.err.println(dao.getCircleCount());
		
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
