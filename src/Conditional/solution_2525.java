package Conditional;

import java.util.Scanner;

public class solution_2525 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		Scanner sc = new Scanner(System.in);
		
		int h = sc.nextInt();
		int m = sc.nextInt();
		int c = sc.nextInt();
		
		h += (c/60);
		m += (c%60);
		
		
		if (m > 59) {
			h += 1;
			m -= 60;
		}
		
		if (h >= 24) {
			h -= 24;
		}
		
		System.out.println(h+" "+m);
	}

}
