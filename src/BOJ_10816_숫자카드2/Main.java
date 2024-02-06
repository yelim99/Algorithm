package BOJ_10816_숫자카드2;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {

	public static void main(String[] args) throws IOException {
		
		/* 문제)
		 * 갖고있는 숫자카드 개수 n, n 값 입력받아 배열에 저장
		 * 비교할 숫자 개수 m, m 값 입력받아 배열에 저장
		 * n에 각 m이 몇 개 있는지 출력
		 */
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		int n = Integer.parseInt(st.nextToken());
		st = new StringTokenizer(br.readLine());
		
		int[] nArr = new int[n];
		
		for(int i=0; i<n; i++) {
			nArr[i] = Integer.parseInt(st.nextToken());
		}
		
		st = new StringTokenizer(br.readLine());
		int m = Integer.parseInt(st.nextToken());
		st = new StringTokenizer(br.readLine());
		
		int[] mArr = new int[m];
		for(int i=0; i<m; i++) {
			mArr[i] = Integer.parseInt(st.nextToken());
		}
		
		Arrays.sort(nArr);
		
		int left = 0;
		int right = n-1;
		int[] count = new int[m];
		
		
		while (left < right) {
			for(int i=0; i<m; i++) {
				int mid = (left+right)/2;
				if (mArr[i] == mid) {
					count[i]++;
				}
				else if (mArr[i] < mid) {
					right = mid-1;
				}
				else {
					left = mid+1;
				}
			}
		}
		
		for(int x:count) {
			System.out.print(x+" ");
		}

	}

}
