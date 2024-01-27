package Simulation;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Solution_9012 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		int t = sc.nextInt();
		sc.nextLine();
		
		
		
		for(int i=0; i<t; i++) {
			int top = -1;
			List<Character> arrList = new ArrayList<>();
			
			String s = sc.nextLine();
			char[] charArr = s.toCharArray();
			
			for(int j=0; j<charArr.length; j++) {
				if (charArr[j] == '(') {
					arrList.add(charArr[j]);
					top++;
				}
				else {
					if (top >= 0) {
						arrList.remove(top);
						top--;
					}
					else {
						top--;
						break;
					}
				}
			}
			if (top < -1) {
				System.out.println("NO");
			}
			else if (arrList.size() == 0) {
				System.out.println("YES");
			}
			else {
				System.out.println("NO");
			}
		}

	}

}
