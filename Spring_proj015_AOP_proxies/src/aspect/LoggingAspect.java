package aspect;

import org.aspectj.lang.ProceedingJoinPoint;

public class LoggingAspect {
	
	/** */
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
	
	/** */
	public void loggingAdvice() {
		System.out.println("Logging from the advice!!");
	}
}
