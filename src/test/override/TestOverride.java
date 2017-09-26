package test.override;

public class TestOverride {

	public static void main(String[] args) {
		A a = new B();
		a.m();
	}
}

class A{
	public static void m(){
		System.out.println("f1");
	}
}

class B extends A{
	public static void m(){
		System.out.println("f2");
	}
}