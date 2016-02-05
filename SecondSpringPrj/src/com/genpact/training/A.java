package com.genpact.training;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class A {
@Autowired
private B b;

A()
{
	System.out.println("constructor of A");
	
	
}

@PostConstruct
public void create()
{
	System.out.println("creation of a over");
}

@PreDestroy
public void remove()
{
	System.out.println("a is to be removed");
}
}
