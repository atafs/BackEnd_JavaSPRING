package dao;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;
import javax.annotation.Resource;

import listener.DrawEvent;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationEventPublisher;
import org.springframework.context.ApplicationEventPublisherAware;
import org.springframework.context.MessageSource;
import org.springframework.stereotype.Controller;

import interfaces.Shape;

/* ANNOTATIONS - Stereotype (class roles): 
 * @Component or @Service: Bean Object 
 * @Repository: Data Object
 * @Controller: Controller Object
 * 
 * - level of documentation
 * */

@Controller
public class Circle implements Shape, ApplicationEventPublisherAware{

	//ATTRIBUTES
	private Point center;
	//EVENT
	private ApplicationEventPublisher publisher;
	//INJECTION
	@Autowired
	private MessageSource messageSource;
	
	//GETTERS AND SETTERS
	public Point getCenter() {
		return center;
	}

	//INTERFACE Shape
	public void draw() {
		//PRINT
		System.out.println(this.messageSource.getMessage("drawing.circle", null, "DEFAULT drawing.circle!!!", null));
		System.out.println(this.messageSource.getMessage("drawing.point", new Object[] {center.getX(), center.getY()},  "DEFAULT drawing.point!!!", null));
		System.out.println(this.messageSource.getMessage("greeting", null, "DEFAULT GREETING!!!", null));
		
		//LISTENER
		DrawEvent drawEvent = new DrawEvent(this);
		publisher.publishEvent(drawEvent);
	}
	
	//JSR-250 Annotations (Java Specific Request)
	@Resource(name="pointC")
	public void setCenter(Point center) {
		this.center = center;
	}
	
	public MessageSource getMessageSource() {
		return messageSource;
	}

	public void setMessageSource(MessageSource messageSource) {
		this.messageSource = messageSource;
	}

	//after the constructor is called
	@PostConstruct
	public void initializeCircle() {
		System.out.println("INIT THE CIRCLE");
	}
	
	//before the object is destroyed
	@PreDestroy
	public void destroyCircle() {
		System.out.println("DESTROY THE CIRCLE");
	}

	//INTERFACE ApplicationEventPublisherAware
	@Override
	public void setApplicationEventPublisher(ApplicationEventPublisher publisher) {
		this.publisher = publisher;
	}
}
