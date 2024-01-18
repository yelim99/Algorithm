package Loop;

import java.util.Scanner;

public class solution_2739 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		Scanner sc = new Scanner(System.in);
		
		int n = sc.nextInt();
		
		for(int i=1; i<10; i++) {
			System.out.printf("%d * %d = %d\n", n, i, n*i);
		}

	}

}
