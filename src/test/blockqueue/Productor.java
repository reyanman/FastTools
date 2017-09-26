package test.blockqueue;

public class Productor extends Thread{
	private Queue queue;
	private Object o;
	public Productor(Queue queue,Object o){
		this.queue = queue;
		this.o = o;
	}
	
	public void run(){
		
			queue.put(o);
	}
}
