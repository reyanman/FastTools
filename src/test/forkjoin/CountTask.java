package test.forkjoin;

import java.util.concurrent.ExecutionException;
import java.util.concurrent.ForkJoinPool;
import java.util.concurrent.ForkJoinTask;
import java.util.concurrent.RecursiveTask;

public class CountTask extends RecursiveTask<Integer>{

	private static final int THRESHOLD = 2;
	private int start;
	private int end;
	
	public CountTask(int start,int end){
		this.start = start;
		this.end = end;
		
	}
	
	
	@Override
	protected Integer compute() {
		// TODO Auto-generated method stub
		
		int sum = 0;
		boolean canCompute = (end - start) <= THRESHOLD;	
		
		if(canCompute){
			for(int i=start;i<=end;i++){
				sum += i;
			}
		}else{
			int middle = (end - start )/2;
			CountTask left = new CountTask(start, middle);
			CountTask right = new CountTask(middle+1, end);
			left.fork();
			right.fork();
			
			int leftResult= left.join();
			int rightResult = right.join();
			sum = leftResult + rightResult;
		}
		return sum;
	}

	public static void main(String[] args) {
		ForkJoinPool fjp = new ForkJoinPool();
		
		CountTask left = new CountTask(1, 1);
		
		ForkJoinTask<Integer> i = fjp.submit(left);
		try {
			System.out.println(i.get());
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (ExecutionException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
