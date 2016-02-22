package com.app.aspect;

import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.app.demo.controller.support.DemoController;

public class Main {
	public static void main(String[] args) {
		ConfigurableApplicationContext context = new ClassPathXmlApplicationContext(new String[]{"applicationSpringApp.xml"});
		DemoController demoController = (DemoController)context.getBean("demoController");
//		demoController.demo();
		demoController.doDemo();
		context.close();
	}
}