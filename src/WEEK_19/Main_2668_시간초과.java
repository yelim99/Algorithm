package WEEK_19;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

public class Main_2668_시간초과 {
	
	static int n;
	static int[] num, num2;
	static boolean[] visited;
	static List<Integer> sel;
	static boolean ans;

	public static void main(String[] args) throws IOException {
		/* 문제) 2668_숫자 고르기
		 * 
		 * 조합 시간초과... 쉣
		 */

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		n = Integer.parseInt(br.readLine());
		
		num = new int[n];
		for(int i=0; i<n; i++) {
			num[i] = i+1;
		}
		
		num2 = new int[n];
		for(int i=0; i<n; i++) {
			num2[i] = Integer.parseInt(br.readLine());
		}
		
		visited = new boolean[n];
		sel = new ArrayList<>();
		
		for(int i=n; i>=1; i--) {
			comb(0, 0, i);
			if (ans) {
//				System.out.println("break");
				break;
			}
		}
		
		System.out.println(sel.size());
		for(int x : sel) {
			System.out.println(x);
		}
		
		
	}
	
	static void comb(int idx, int cnt, int numCount) {
		if (cnt==numCount) {
//			System.out.println(sel);
			
			for(int i=0; i<sel.size(); i++) {
				boolean check = false;
				int dup = 0;	// 반복체크
				for(int j=0; j<sel.size(); j++) {
					if (sel.get(i) == num2[sel.get(j)-1]) {
						dup++;
						if (dup == 1) {
							check = true;
							break;
						}
						
					}
				}
//				System.out.println(check);
				if (!check) {
//					System.out.println(sel.get(i));
//					System.out.println("size="+sel.size());
					ans = false;
					return;
				}
			}
//			System.out.println("??");
			ans = true;
			return;
		}
		
		for(int i=idx; i<n; i++) {
			if (!visited[i]) {
				sel.add(i+1);
				visited[i] = true;
				comb(i+1, cnt+1, numCount);
				if(ans) return;
				visited[i] = false;
				sel.remove(sel.size()-1);
			}
		}
	}

}
