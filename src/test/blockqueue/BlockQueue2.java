package test.blockqueue;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.ReentrantLock;

/**
 * 产生的问题：
 * 线程执行顺序不确定的原因，导致无限次的put或者多次get,浪费cpu资源去进行线程上下文切换。
 * 解决：
 * 通过重入锁解决，分开注册生产线程和消费线程，队列 满时唤醒绑定线程
 * @author snail_geqi
 *
 */
public class BlockQueue2 implements Queue{

	private int num;
	private List list = new ArrayList();
	
	public BlockQueue2(int num){
		this.num = num;
	}
	public synchronized void put(Object o){
				
		try{
			while(list.size()==num){
				System.out.println("队列已满，等待！");
				wait();
			}
			list.add(o);
			System.out.println("生产:"+o+",size="+list.size());
			notify();
			
		}catch (Exception e){
			e.printStackTrace();
		}finally{
		}
		
	}
	
	public synchronized Object get(){
		Object o = null;
		try{
			while(list.size()==0){
				System.out.println("队列已空，等待！");
				wait();
				
			}
			
			o = list.get(0);
			list.remove(o);
			System.out.println("消费:"+o+",size="+list.size());
			notify();
			
		}catch (Exception e){
			e.printStackTrace();
		}finally{
		}
		return o;
	}
	
	public int getSize(){
		return this.list.size();
	}
}
