package BOJ;

import java.util.Scanner;

public class solution_2480 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		int a = sc.nextInt();
		int b = sc.nextInt();
		int c = sc.nextInt();
		
		int sum = 0;
		
		if (a==b && b==c) {
			sum = 10000+(a*1000);
		}
		else if ((a==b && a!=c) || (a==c && a!=b)) {
			sum = 1000+(a*100);
		}
		else if (b==c && a!=b) {
			sum = 1000+(b*100);
		}
		else {
			int max = a;
			if (b>max) max = b;
			if (c>max) max = c;
			sum = max*100;
		}
		
		System.out.println(sum);
	}
}
