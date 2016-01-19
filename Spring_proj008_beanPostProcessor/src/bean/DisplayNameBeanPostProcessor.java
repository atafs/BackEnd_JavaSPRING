package bean;

import org.springframework.beans.BeansException;
import org.springframework.beans.factory.config.BeanPostProcessor;

public class DisplayNameBeanPostProcessor implements BeanPostProcessor{

	@Override
	public Object postProcessBeforeInitialization(Object bean, String beanName) throws BeansException {
		//PRINT
		System.out.println("In BEFORE Initialization method. BEAN name is: " + beanName);
		return bean;
	}

	@Override
	public Object postProcessAfterInitialization(Object bean, String beanName) throws BeansException {
		//PRINT
		System.out.println("In AFTER Initialization method. BEAN name is: " + beanName);
		return bean;
	}
}
