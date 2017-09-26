package test.proxy;

import test.proxy.cglib.CglibProxy;

public class TestProxy {

	public static void main(String[] args) {
		
		/*
		 * Test Proxy
		 */
//		BasicProxy proxy = new BasicProxy();
//		Count c = (Count) proxy.bind(new CountImpl());
//		c.mc1();
		
		/*
		 * cglib proxy
		 */
		CglibProxy cg = new CglibProxy();
		CountImpl2 c = (CountImpl2) cg.getInstance(new CountImpl2());
		c.mc1();
		
	}
}
