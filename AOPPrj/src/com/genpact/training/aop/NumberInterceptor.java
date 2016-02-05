package com.genpact.training.aop;

import java.lang.reflect.Method;

import org.aopalliance.intercept.MethodInterceptor;
import org.aopalliance.intercept.MethodInvocation;
import org.springframework.stereotype.Component;

@Component
public class NumberInterceptor implements MethodInterceptor{

	@Override
	public Object invoke(MethodInvocation invocation) throws Throwable {
		// TODO Auto-generated method stub
		Object[] arguments=invocation.getArguments();
		int first=(Integer)arguments[0];
		int second=(Integer)arguments[1];
		first=first*first;
		second=second*second;
		Method method=invocation.getMethod();
		Object object=invocation.getThis();
		
		return method.invoke(object, first,second);
	}

}
