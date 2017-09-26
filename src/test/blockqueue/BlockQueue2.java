package test.blockqueue;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.ReentrantLock;

/**
 * ���������⣺
 * �߳�ִ��˳��ȷ����ԭ�򣬵������޴ε�put���߶��get,�˷�cpu��Դȥ�����߳��������л���
 * �����
 * ͨ��������������ֿ�ע�������̺߳������̣߳����� ��ʱ���Ѱ��߳�
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
				System.out.println("�����������ȴ���");
				wait();
			}
			list.add(o);
			System.out.println("����:"+o+",size="+list.size());
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
				System.out.println("�����ѿգ��ȴ���");
				wait();
				
			}
			
			o = list.get(0);
			list.remove(o);
			System.out.println("����:"+o+",size="+list.size());
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
