package org.demo.guicedemo.service.impl;

import java.lang.reflect.Method;

import org.aopalliance.intercept.MethodInterceptor;
import org.aopalliance.intercept.MethodInvocation;

import com.google.common.base.Joiner;
import com.google.inject.Inject;

public class LoggingInterceptor implements MethodInterceptor {
	@Inject
	@SessionId
	private Long sessionId;

	@Override
	public Object invoke(MethodInvocation invocation) throws Throwable {
		Method method = invocation.getMethod();
		String className = method.getDeclaringClass().getName();
		String methodName = method.getName();
		Object[] args = invocation.getArguments();
		System.out.println(String.format("In session %d: Calling %s#%s(%s)", sessionId, className, methodName, Joiner.on(",").join(args)));
		return invocation.proceed();
	}
}