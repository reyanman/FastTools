
public class Test {

	public static void a(String[] args) {
		int[] array = new int[] { -1,101,-50,-51,2,7,-2,3,6,8,4,-28,100};// Ê¾ÀıÊı×é
		int sum = 0;
		int start = 0;
		int end = 1;
		int newstart = 0;
		int big = 0;
		for (int i = 0; i < array.length; i++) {
			sum += array[i];
			if (sum <= 0) {
				sum = 0;
				newstart = i + 1;
			} else {
				if (sum > big) {
					big = sum;
					start = newstart;
					end = i + 1;
				}
			}
//			System.out.println(sum);
		}
		for (int i = start; i < end; i++) {
			System.out.println(array[i]);
		}
	}
	
	
	public static void main(String[] args) {
		System.out.println(Math.pow(2, 16));
	}
}
