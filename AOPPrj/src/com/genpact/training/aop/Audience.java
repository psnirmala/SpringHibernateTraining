package com.genpact.training.aop;

import org.springframework.stereotype.Component;

@Component
public class Audience {
	public void takeSeats()
	{
		System.out.println("audience taking seats");
	}
	public void switchOffMobilePhones()
	{
		System.out.println("audience switching off mobile phones");
	}
	public void applaud()
	{
		System.out.println("audience clapping");
	}
	public void demandRefund()
	{
		System.out.println("Not satisfied with performance, demanding refund");
	}
	public void leaveAuditorium()
	{
		System.out.println("Audience leaving auditorium");
	}

}
