package W16_BOJ_16563_어려운소인수분해;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
	
	static boolean[] isPrime;

	public static void main(String[] args) throws IOException {
		/* 문제) 16563_어려운 소인수분해
		 * 
		 * 2와 500만 사이의 자연수 N개를 소인수분해
		 * N줄에 걸쳐서 자연수 ki의 소인수들을 오름차순으로 출력
		 */
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		int n = Integer.parseInt(st.nextToken());
		st = new StringTokenizer(br.readLine());
		
		for(int i=0; i<n; i++) {
			int k = Integer.parseInt(st.nextToken());
			
		}
		

	}
	
	static void prime(int k) {
		isPrime = new boolean[k+1];
		Arrays.fill(isPrime, true);
		
		isPrime[0] = false;
		isPrime[1] = false;
		
		for(int i=2; i<=(int)Math.sqrt(k); i++) {
			if (isPrime[i]) {
				for(int j=i*i; j<=k; j+=i) {
					isPrime[j] = false;
				}
			}
		}
		
	}

}
