package service;

import model.Circle;
import model.Triangle;

public class FactoryService {
	
	/** FUNCTION: factory to instantiate ShapeFactory and the classes that implement this interface */
	public Object getBean(String beanType) {
		//INSTANTIATE
		if (beanType.equals("shapeService")) return new ShapeServiceProxy();
		if (beanType.equals("circle")) return new Circle();
		if (beanType.equals("triangle")) return new Triangle();

		//RETURN
		return null;
	}

}
