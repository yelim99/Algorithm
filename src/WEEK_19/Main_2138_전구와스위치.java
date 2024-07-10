package WEEK_19;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Scanner;

public class Main_2138_전구와스위치 {
	
	static int n;
	static int[] now, want;
	static int[] zero, nozero;
	static int ans;

	public static void main(String[] args) throws IOException {
		/* 문제) 2138_전구와 스위치
		 * 
		 * n번째 전구를 누르면, n-1, n, n+1이 바뀜.
		 * 순서대로 간다고 생각하면, n번째 전구는 n+1번째 스위치에 따라 달라진다.
		 * 
		 * 
		 * => 0번째 스위치에 따라 달라진다. 두 번의 경우 나눠서 최소값!
		 */
		
		Scanner sc = new Scanner(System.in);
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		// 전구 개수
		n = Integer.parseInt(br.readLine());
		// 전구 상태
		String s1 = br.readLine();
		String s2 = br.readLine();
		
		now = new int[n];
		want = new int[n];
		
		// 현재 상태
		for(int i=0; i<n; i++) {
			now[i] = Character.getNumericValue(s1.charAt(i));
		}
		
		
		// 만들고자 하는 상태
		for(int i=0; i<n; i++) {
			want[i] = Character.getNumericValue(s2.charAt(i));
		}
		
		// 0번째 전구를 눌렀을 때 상태 저장
		zero = now.clone();
		zero[0] = zero[0]==0 ? 1 : 0;
		zero[1] = zero[1]==0 ? 1 : 0;

		
		
		// 안눌렀을 때 상태 저장
		nozero = now.clone();
		
		turn();
		
		System.out.println(ans);
		
 
	}
	
	static void turn() {
		int zeroCnt = 1;	// 0번째 스위치 한 번 눌렀으니까 1로 세팅
		int noCnt = 0;
		
		for(int i=1; i<n; i++) {
			// zero의 i-1번째가 다르다면, i번째 스위치 누르기
			if (zero[i-1] != want[i-1]) {
				zero[i-1] = zero[i-1]==0 ? 1 : 0;
				zero[i] = zero[i]==0 ? 1 : 0;
				if (i<n-1) {
					zero[i+1] = zero[i+1]==0 ? 1 : 0;
				}
				zeroCnt++;
			}
			
			// nozero의 i-1번째가 다르다면, i번째 스위치 누르기
			if (nozero[i-1] != want[i-1]) {
				nozero[i-1] = nozero[i-1]==0 ? 1 : 0;
				nozero[i] = nozero[i]==0 ? 1 : 0;
				if (i<n-1) {
					nozero[i+1] = nozero[i+1]==0 ? 1 : 0;
				}
				noCnt++;
			}
			
			if (Arrays.equals(want, zero)) {
				// 만약, zero와 nozero가 같다면 cnt가 더 작은 값 저장
				if (Arrays.equals(zero, nozero)) {
					ans = Math.min(zeroCnt, noCnt);
					return;
				}
				else {
					ans = zeroCnt;
					return;
				}
			}
			else if (Arrays.equals(want, nozero)) {
				ans = noCnt;
				return;
			}
		}
		// 다 아니면 -1 저장
		ans = -1;
		return;
		
		
	}

}
