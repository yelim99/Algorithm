package Stack_Queue;

import java.util.Arrays;
import java.util.Scanner;

public class BOJ_Solution_10845_큐 {
	
	private static int[] que;
	static int front = 0;
	static int rear = 0;
	static int num = 0;
	
	public static int push(int x) {
//		if (que.length < capacity) {
		que[rear++] = x;
		num++;
		return x;
//		}
//		return -1;
	}
	
	public static int pop() {
		if (num <= 0) {
			return -1;
		}
		else {
			int x = que[front++];
			num--;
			return x;
		}
		
	}
	
	public static int size() {
		return num;
	}
	
	public static int empty() {
		if (num == 0) {
			return 1;
		}
		else return 0;
	}
	
	public static int front() {
		if (num == 0) {
			return -1;
		} else {
			return que[front];
		}
	}
	
	public static int back() {
		if (num == 0) {
			return -1;
		} else {
			return que[rear];
		}
	}

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		int n = sc.nextInt();
		sc.nextLine();
		
		int[] q = new int[n];
		
		for (int i=0; i<n; i++) {
			String s = sc.nextLine();
			String[] sArr = s.split(" ");
			System.out.println(Arrays.toString(sArr));
			
			switch (sArr[0]) {
			case "push" :
				push(Integer.parseInt(sArr[1]));
				break;
			case "pop" :
				pop();
				break;
			case "size" :
				size();
				break;
			case "empty" :
				empty();
				break;
			case "front" :
				front();
				break;
			case "back" :
				back();
				break;
				
			}
		}
		

	}

}
