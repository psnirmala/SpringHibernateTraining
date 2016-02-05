package com.genpact.training.aop;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class Test {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		ApplicationContext context=new ClassPathXmlApplicationContext("beans.xml");
	/*	Instrumentalist instrumentalist=(Instrumentalist)context.getBean("instrumentalist");
		instrumentalist.play();*/
		Number number=(Number)context.getBean("number");
		System.out.println(number.add(10, 5));

	}

}
