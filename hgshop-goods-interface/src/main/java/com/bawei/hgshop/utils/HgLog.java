package com.bawei.hgshop.utils;

/*String toString();         //连接点所在位置的相关信息
String toShortString();     //连接点所在位置的简短相关信息
String toLongString();     //连接点所在位置的全部相关信息
Object getThis();         //返回AOP代理对象
Object getTarget();       //返回目标对象
Object[] getArgs();       //返回被通知方法参数列表
Signature getSignature();  //返回当前连接点签名
SourceLocation getSourceLocation();//返回连接点方法所在类文件中的位置
String getKind();        //连接点类型
StaticPart getStaticPart(); //返回连接点静态部分
*/
public class HgLog {
	/*
	 * private final static org.slf4j.Logger logger =
	 * LoggerFactory.getLogger(HgLog.class);
	 * 
	 * public void before(JoinPoint joinPoint) { MethodSignature methodSignature =
	 * (MethodSignature)joinPoint.getSignature();
	 * System.out.println("方法名:"+methodSignature.getMethod().getName()+" 参数列表:"
	 * +ArrayToParameterString(methodSignature.getParameterNames(),joinPoint.getArgs
	 * ())); }
	 * 
	 * private String ArrayToParameterString(String[] parameterNames,Object[]
	 * parameterValues) { StringBuffer sb = new StringBuffer(); if (parameterNames
	 * != null && parameterNames.length > 0) { for (int i = 0; i <
	 * parameterNames.length; i++) { sb.append(parameterNames[i]); sb.append(":");
	 * sb.append(parameterValues[i]); sb.append(";"); } } return sb.toString(); }
	 * 
	 * //@After("method()") public void after(JoinPoint joinPoint){
	 * System.err.println("this is after................."); }
	 * 
	 * //@AfterReturning("method()") public void afterReturning(JoinPoint
	 * joinPoint){
	 * 
	 * // 2:通过springAOP切面JoinPoint类对象，获取该类，或者该方法，或者该方法的参数 Class<? extends Object>
	 * clazz = joinPoint.getTarget().getClass(); String controllerOperation =
	 * clazz.getName();
	 * 
	 * // 获取当前方法 MethodSignature signature = (MethodSignature)
	 * joinPoint.getSignature(); Method method = signature.getMethod(); //
	 * clazz类下的所有方法 Method[] methods = clazz.getDeclaredMethods(); String
	 * methodOperation = ""; for (Method m : methods) { if(m.equals(method)){
	 * methodOperation = m.getName();
	 * 
	 * } }
	 * 
	 * 
	 * 
	 * }
	 */
}
