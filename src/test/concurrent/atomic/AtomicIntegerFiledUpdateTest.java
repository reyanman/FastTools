package test.concurrent.atomic;

import java.util.concurrent.atomic.AtomicIntegerFieldUpdater;

public class AtomicIntegerFiledUpdateTest {

	private static AtomicIntegerFieldUpdater<User> a = AtomicIntegerFieldUpdater.newUpdater(User.class, "old");

	public static void main(String[] args) {
		User con = new User("geqi",1);
		System.out.println(a.getAndIncrement(con));
		System.out.println(a.get(con));
		System.out.println(con.old);
	}
	
	public static class User{
		public volatile String name;
		public volatile int old;
		
		public User(String name,int old){
			this.name = name;
			this.old = old;
		}
	}
}
