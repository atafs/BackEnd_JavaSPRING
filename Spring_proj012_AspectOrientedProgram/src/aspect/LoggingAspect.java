package aspect;

import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;

@Aspect
public class LoggingAspect {
	
	//@BEFORE: calls
	@Before("allGetters() && allCircleMethods()")
	public void loggingAdvice() {
		System.out.println("ADVICE RUN MULTIPLE POINTCUTS... GET METHOD CALLED!!");
	}
	@Before("allGetters()")
	public void secondAdvice() {
		System.out.println("ADVICE RUN SECOND... GET METHOD CALLED!!");
	}
	
	@Before("allCircleMethods()")
	public void circleMethodsAdvice() {
		System.out.println("ADVICE RUN CIRCLE... GET METHOD CALLED!!");
	}
	
	@Before("allMethods()")
	public void allMethodsAdvice() {
		System.out.println("ADVICE RUN CLASSES AND SUBCLASSES... GET METHOD CALLED!!");
	}
	
	//@POINTCUTS: is a specific REGEX
	@Pointcut("execution(* get*())")
	public void allGetters() {}
	
	//@POINTCUTS: within METHOD
	@Pointcut("within(model.Circle)")
	public void allCircleMethods() {}
	
	//ALL CLASSES AND SUBCLASSES IN MODEL PACKAGE
	@Pointcut("within(model..*)")
	public void allMethods() {}
	

	
	
	
	/* OR ############################################ */
	
	//WILDCARDS: any return type, starts with get:
	// *  = one args; 
	// .. = zero or more args
//	@Before("execution(public * get*(..))")
//	public void LoggingAdvice() {
//		System.out.println("ADVICE RUN WILDCARD... GET METHOD CALLED!!");
//	}
//	
//	@Before("execution(public String getName())")
//	public void LoggingAdvice() {
//		System.out.println("ADVICE RUN CIRCLE... GET METHOD CALLED!!");
//	}
	
	/* OR ############################################ */
	
//	@Before("execution(public String model.Circle.getName())")
//	public void LoggingAdviceCir() {
//		System.out.println("ADVICE RUN CIRCLE... GET METHOD CALLED!!");
//	}
//	
//	@Before("execution(public String model.Triangle.getName())")
//	public void LoggingAdviceTri() {
//		System.out.println("ADVICE RUN TRIANGLE... GET METHOD CALLED!!");
//	}

}
