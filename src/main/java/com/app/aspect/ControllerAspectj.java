package com.app.aspect;

import java.io.IOException;
import java.lang.reflect.Method;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.Signature;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.AfterThrowing;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.aspectj.lang.reflect.MethodSignature;
import org.springframework.stereotype.Component;

@Aspect
@Component
public class ControllerAspectj {

	@Pointcut("within(com.app.demo.controller.*)")
	public void doManagerActionClass() {
	}

	@Before("execution(public * com.app.demo.controller..*(..))")
	public void getUser(JoinPoint jp) throws IOException {
		System.out.println("任意公共方法的执行");
	}
	
	@Pointcut("execution(* do*(..))")
	public void doMethod(){
	}
	
	@Before(value="com.app.aspect.ControllerAspectj.doMethod() && target(bean)",argNames="bean")
	public void beforeDo(JoinPoint jp,Object bean) throws Exception {
		String sourceLocation=jp.getKind();
		
		Signature signature=jp.getSignature();
		MethodSignature methodSignature = (MethodSignature) signature;  
		Method method = methodSignature.getMethod();  
		method.invoke(jp.getTarget(),jp.getArgs());
		System.out.println("方法名："+method.getName());
		System.out.println("任意以do开头的方法"+sourceLocation);
	}
	
	@Pointcut("within(com.app.test..*)")
	public void before3(){
		System.out.println("test包以及他的子包");
	}
	

	@AfterThrowing(pointcut="com.app.aspect.ControllerAspectj.before3()",throwing="ex")
	public void afterThrows(JoinPoint jp,Throwable ex) {
		ex.printStackTrace();
		System.out.println("test包以及他的子包抛出的异常"+ex.getMessage());
	}
	
	@AfterReturning("this(com.app.demo.controller.IBaseController)")
	public void afterReturn(){
		System.out.println("after return，实现了IBaseController");
	}
	
}
