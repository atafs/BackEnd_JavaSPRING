package aspect;

import model.Circle;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.AfterThrowing;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;

@Aspect
public class LoggingAspect {
	
	/* JOINPOINT and Advice ARGS ###############
	 * - all the places in your code were you can apply advice
	 * */
	//BEFORE: calls ###########################
	@Before("allCircleMethods()")
	public void loggingAdvice(JoinPoint joinPoint) {
		//PRINT
		System.out.println("@Before " + joinPoint.toString());
		System.out.println("@Before " + joinPoint.getTarget());
		
		//GET OBJECT
		Circle circle = (Circle) joinPoint.getTarget();
		System.out.println("@Before Circle value= " + circle.getName());
	}
	
	/* ARGS ####################################
	 * - detects changes in attributes of classes (args)
	 * */
	@Before("args(name)")
	public void stringArgsMethodsBefore(String name) {
		System.out.println("@Before A METHOD THAT TAKES STRING ARGS HAS BEEN CALLED = " + name);
	}
	
	/* AFTER and AFTER_RETURNING: ##############
	 * */
	@After("args(name)")
	public void stringArgsMethodsAfter(String name) {
		System.out.println("@After A METHOD THAT TAKES STRING ARGS HAS BEEN CALLED = " + name);
	}
	
	//INPUT AND OUTUT REQUIREMENTS (pointcut=INPUT) (returning=OUTPUT)
	@AfterReturning(pointcut="args(name)", returning="returnString")
	public void stringArgsMethodsAfterReturning(String name, Object returnString) {
		System.out.println("@AfterReturning A METHOD THAT TAKES STRING ARGS HAS BEEN CALLED = " + name + "; And the OUTPUT value is = " + returnString);
	}
	
	@AfterThrowing(pointcut="args(name)", throwing="ex")
	public void exceptionAdvice(String name, Exception ex) {
		System.out.println("@AfterThrowing exceptionAdvice = " + ex);
	}
	
	@AfterThrowing("args(name)")
	public void exceptionAdvice(String name) {
		System.out.println("@AfterThrowing exceptionAdvice = " + name);
	}
	
	/* AROUND: can write code around the target code is executed.
	 * */
	@Around("@annotation(aspect.annotation.Loggable)")
	public Object myAroundDevice(ProceedingJoinPoint proceedingJoinPoint) {
		
		Object returnValue = null;
		try {
			//AROUND BEFORE
			System.out.println("@Around before advice");
			
			returnValue = proceedingJoinPoint.proceed();
			
			//AROUND AFTER
			System.out.println("@Around after advice");

		} catch (Throwable e) {
			System.out.println("@Around after CATCH THROWING advice");
		} 
		
		System.out.println("@Around after FINALLY");
		return returnValue;
	}

	//POINTCUTS: is a specific REGEX
	@Pointcut("execution(* get*())")
	public void allGetters() {}
	
	//POINTCUTS: within METHOD
	@Pointcut("within(model.Circle)")
	public void allCircleMethods() {}

}
