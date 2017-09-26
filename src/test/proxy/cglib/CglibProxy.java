package test.proxy.cglib;

import java.lang.reflect.Method;
import java.util.Stack;

import net.sf.cglib.proxy.Enhancer;
import net.sf.cglib.proxy.MethodInterceptor;
import net.sf.cglib.proxy.MethodProxy;

public class CglibProxy implements MethodInterceptor{

	private Object target;
	
	public Object getInstance(Object o){
		this.target = o;
		Enhancer en = new Enhancer();
		en.setSuperclass(this.target.getClass());
		en.setCallback(this);
		return en.create();
	}
	
	/**
	 * obj 动态生成后的代理对象
	 * method 被代理原的方法
	 * args 方法参数
	 * proxy 代理对象方法
	 */
	@Override
	public Object intercept(Object obj, Method method, Object[] args, MethodProxy proxy) throws Throwable {
		// TODO Auto-generated method stub
		System.out.println("start");
		
		proxy.invokeSuper(obj, args);
		method.invoke(target, args);
		System.out.println(method);
		System.out.println(proxy);
		System.out.println("end");
		return null;
	}

}
