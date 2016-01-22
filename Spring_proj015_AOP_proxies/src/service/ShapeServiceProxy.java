package service;

import aspect.LoggingAspect;
import model.Circle;

public class ShapeServiceProxy extends ShapeService{

	//GETTERS AND SETTERS
	public Circle getCircle() {
		new LoggingAspect().loggingAdvice();
		return super.getCircle();
	}
}
