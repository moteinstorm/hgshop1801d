package com.bawei.hgshop.utils;

import java.lang.reflect.Method;

import org.aopalliance.intercept.MethodInterceptor;
import org.aopalliance.intercept.MethodInvocation;
import org.slf4j.LoggerFactory;
import org.springframework.aop.AfterReturningAdvice;
import org.springframework.aop.MethodBeforeAdvice;
import org.springframework.aop.ThrowsAdvice;


/**
 * 前置（before)：在方法执行之前执行通知
后置（after)：在方法执行后通知，无论其结果如何
后置返回（after-returning)：只有方法成功完成后才能在方法执行和执行通知
后置异常（after-throwing)：只有方法抛出异常而退出方法执行后才能运行通知
环绕（around)：在调用通知方法之前和之后运行通知
 ThrowsAdviceInterceptor
 * @author 45466
 *
 */
public class HgLog  implements MethodBeforeAdvice ,AfterReturningAdvice,ThrowsAdvice//,MethodInterceptor 
{

	private final static org.slf4j.Logger logger = LoggerFactory.getLogger(HgLog.class);
	
	// 前置增强
	@Override
	public void before(Method method, Object[] args, Object target) throws Throwable {
		// TODO Auto-generated method stub
		System.out.println("开始执行方法 " + target.getClass().getSimpleName() + "." +  method.getName());
		System.out.println("参数分别为：");
		for (Object object : args) {
			System.out.append(object.toString());
		}
		
	}
	
	 public void afterThrowing(Method method, Object[]  args, Object target, Throwable throwable) {
		System.out.println("some advice  111111111 "); 
	 }
	 public void afterThrowing( Throwable throwable) {
		 
		 System.out.println("some advice 2222222"); 
	 } 
	 
		/*
		 * @Override public Object invoke(MethodInvocation invocation) throws Throwable
		 * { // TODO Auto-generated method stub System.out.println("执行环绕增强。。。" ); return
		 * null; }
		 */

	
	// 后置增强
	@Override
	public void afterReturning(Object returnValue, Method method, Object[] args, Object target) throws Throwable {
		// TODO Auto-generated method stub
		System.out.println("方法执行结束 " + method.getName());
		System.out.println("返回数据是 " + returnValue);
	}



}
