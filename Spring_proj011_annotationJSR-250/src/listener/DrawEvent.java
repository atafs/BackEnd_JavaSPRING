package listener;

import org.springframework.context.ApplicationEvent;

public class DrawEvent extends ApplicationEvent{

	//ATTRIBUTE
	private static final long serialVersionUID = 1L;

	//CONSTRUCTOR
	public DrawEvent(Object source) {
		super(source);
	}
	
	//TOSTRING
	@Override
	public String toString() {
		return "Draw Event Occured!!";
	}
	
	

}
