package test.blockqueue;

public class Test {

	public static void main(String[] args) {
		BlockQueue queue = new BlockQueue(5);
//		BlockQueue2 queue = new BlockQueue2(5);
		for(int i=0;i<10;i++){
			Consumer c = new Consumer(queue);
			Productor p = new Productor(queue,i);
			c.start();
			p.start();
		}
		
		
		
	}
}
