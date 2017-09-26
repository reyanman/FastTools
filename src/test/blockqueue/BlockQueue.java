package test.blockqueue;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.ReentrantLock;

public class BlockQueue implements Queue{

	private int num;
	private List list = new ArrayList();
	private ReentrantLock lock = new ReentrantLock();
	private Condition notFull = lock.newCondition();
	private Condition notEmpty = lock.newCondition();
	
	public BlockQueue(int num){
		this.num = num;
	}
	public void put(Object o){
		lock.lock();
		try{
			
			while(list.size()==num){
				System.out.println(notFull.toString()+"�����������ȴ���");
				notFull.await();
			}
			list.add(o);
			System.out.println("����:"+o+",size="+list.size());
			notEmpty.signal();
			
		}catch (Exception e){
			e.printStackTrace();
		}finally{
			lock.unlock();
		}
		
	}
	
	public Object get(){
		Object o = null;
		lock.lock();
		try{
			
			while(list.size()==0){
				System.out.println(notEmpty.toString()+"�����ѿգ��ȴ���");
				notEmpty.await();
				
			}
			
			o = list.get(0);
			list.remove(o);
			System.out.println("����:"+o+",size="+list.size());
			notFull.signal();
			
		}catch (Exception e){
			e.printStackTrace();
		}finally{
			lock.unlock();
		}
		return o;
	}
}
