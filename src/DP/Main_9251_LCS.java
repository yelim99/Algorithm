package DP;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main_9251_LCS {
	
	static char[] c1;
	static char[] c2;
	static int[][] arr;
	
	static int len1;
	static int len2;

	public static void main(String[] args) throws IOException {
		/* 문제) LCS
		 * 두 수열이 주어졌을 때, 모두의 부분 수열이 되는 수열 중 가장 긴 것을 찾는 문제이다.
		 * 예를 들어, ACAYKP와 CAPCAK의 LCS는 ACAK가 된다.
		 */
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		String s1 = br.readLine();
		String s2 = br.readLine();
		
		c1 = s1.toCharArray();
		c2 = s2.toCharArray();
		
		len1 = c1.length;
		len2 = c2.length;

		arr = new int[len1][len2];
		
		int ans = LCS(s1, s2);
		System.out.println(ans);
		
	}

	static int LCS(String s1, String s2) {
		// 두 문자 배열 중 하나라도 길이가 0이면 0이 됨.
		if (len1==0 || len2==0) {
			return 0;
		}
		
		if (s1.charAt(len1-1) == s2.charAt(len2-1)) {
			return LCS(s1.substring(0, len1-2), s2.substring(0, len2-2))+1;
		}
		else {
			return Math.max((LCS(s1.substring(0, len1-2), s2.substring(0, len2-1))), 
							(LCS(s1.substring(0, len1-1), s2.substring(0, len2-2))));
		}
		
	}
	
}
