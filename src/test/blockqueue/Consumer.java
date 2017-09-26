package test.blockqueue;

import java.util.List;

public class Consumer extends Thread{

	private Queue queue;
	public Consumer(Queue queue){
		this.queue = queue;
	}
	
	public void run(){
			 queue.get();
	}
	
}
