package test.proxy;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

public class BasicProxy implements InvocationHandler{

	private Object obj;
	
	
	public Object bind(Object o){
		this.obj = o;
		return Proxy.newProxyInstance(o.getClass().getClassLoader(), o.getClass().getInterfaces(), this);

	}
	
	@Override
	public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
		// TODO Auto-generated method stub
		System.out.println("start");
		Object result = method.invoke(obj, args);
		System.out.println("end");
		return result;
	}

	
}
