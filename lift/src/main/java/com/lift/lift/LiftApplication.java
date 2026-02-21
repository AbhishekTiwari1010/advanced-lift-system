package com.lift.lift;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;


@SpringBootApplication
public class LiftApplication {

	public static void main(String[] args) {
		ApplicationContext context= SpringApplication.run(LiftApplication.class, args);

	}
}


//		String[] beanNames = context.getBeanDefinitionNames();
//
//		for(String beanName : beanNames) {
//			System.out.println("objects returned "  + context.getBean(beanName).getClass().getName());
//		}
