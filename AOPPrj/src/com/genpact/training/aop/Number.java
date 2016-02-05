package com.genpact.training.aop;

import org.springframework.stereotype.Component;

@Component
public class Number {
	public int add(int a,int b)
	{
		return a+b;
	}

}
