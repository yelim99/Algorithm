package W15_BOJ_1339_단어수학;

import java.util.HashMap;
import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		/* 문제) 1339_단어수학
		 * n개의 단어
		 * 알파벳에 0-9까지 숫자 붙이고 수의 합이 최대가 되도록
		 */
		
		Scanner sc = new Scanner(System.in);
		
		int n = sc.nextInt();
		String[] tmp = new String[n];
		int[] length = new int[n];
		
		int maxLen = 0;
		for(int i=0; i<n; i++) {
			tmp[i] = sc.next();
			length[i] = tmp[i].length();
			
			maxLen = Math.max(maxLen, length[i]);
		}
		
		for(int m=0; m<maxLen; m++) {
			
		}

	}

}
