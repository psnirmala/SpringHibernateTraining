package com.genpact.training.aop;

import org.springframework.stereotype.Component;

@Component
public class Instrumentalist {
	public void play()
	{
		System.out.println("Playing instrument");
	//	throw new RuntimeException("problem with instrument");
	}

}
