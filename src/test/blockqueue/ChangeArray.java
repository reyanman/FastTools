package test.blockqueue;

import java.util.ArrayDeque;
import java.util.Deque;
import java.util.Stack;

public class ChangeArray {

	public Stack<Integer> stack = new Stack<Integer>();
	
	public Deque<Integer> deque = new ArrayDeque<Integer>();
	
	public void test2(){
		int[] a1 = {3,1,5,9,7};
		int[] a2 = {1,3,7,9,5};
		int[] a3 = new int[5];
		int m=0;
		int n=0;
		int k=0;
		while(n<=5){
			for(int i=0;i<5;i++){
				if(a1[i]==a2[0]){
					deque.push(a1[i]);
					m=i;
					
					break;
				}else{
					deque.push(a1[i]);
				}
			}
			for(int j=0;j<=m;j++){
				a1[j] = deque.pop();
			}
			n++;
		}
			
		
		
		for(int i=0;i<5;i++){
			System.out.println(a1[i]);
		}
	}
	
	
	public void test(){
		int[] a1 = {3,1,5,9,7};
		int[] a2 = {1,3,7,9,5};
		int[] a3 = new int[5];
		int m=0;
		int n=0;
		int k=0;
		while(n<=2){
			for(int i=0;i<5;i++){
				if(a1[i]==a2[0]){
					deque.push(a1[i]);
					m=i;
					
					break;
				}else{
					deque.push(a1[i]);
				}
			}
			for(int j=0;j<=m;j++){
				a1[j] = deque.pop();
			}
			n++;
		}
			
		
		
		for(int i=0;i<5;i++){
			System.out.println(a1[i]);
		}
	}
	
	public static void main(String[] args) {
		ChangeArray c = new ChangeArray();
		c.test();
	}
}
