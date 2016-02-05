package com.genpact.training;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;

import org.springframework.stereotype.Component;

@Component
public class B {

	B()
	{
		System.out.println("constructor of B");
		
		
	}
	
	@PostConstruct
	public void create()
	{
		System.out.println("creation of b over");
	}

	@PreDestroy
	public void remove()
	{
		System.out.println("b is to be removed");
	}
}
