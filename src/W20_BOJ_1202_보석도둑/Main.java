package W20_BOJ_1202_보석도둑;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class Main {

	public static void main(String[] args) throws IOException {
		/* 문제) 1202_보석도둑
		 * 
		 * 상덕이가 털 보석점에는 보석이 총 N개 있다. 각 보석은 무게 Mi와 가격 Vi를 가지고 있다. 
		 * 상덕이는 가방을 K개 가지고 있고, 각 가방에 담을 수 있는 최대 무게는 Ci이다. 
		 * 가방에는 최대 한 개의 보석만 넣을 수 있다.
		 * 상덕이가 훔칠 수 있는 보석의 최대 가격을 구하는 프로그램을 작성하시오.
		 */
		
		/* 설계)
		 * 
		 * 냅색?
		 * 
		 */
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		int n = Integer.parseInt(st.nextToken());	// 보석 개수
		int k = Integer.parseInt(st.nextToken());	// 가방 개수
		
		// 가격 기준 정렬할 것.
		PriorityQueue<int[]> treasures = new PriorityQueue<>((o1, o2) -> o1[1]-o2[1]);
//		List<int[]> treasures = new ArrayList<>();
		int[][] t = new int[n][2];
		for(int i=0; i<n; i++) {
			st = new StringTokenizer(br.readLine());
			for(int j=0; j<2; j++) {
//				int a = Integer.parseInt(st.nextToken());
//				int b = Integer.parseInt(st.nextToken());
//				treasures.add(new int[] {a, b});	// 무게, 가격
				t[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		
		int[] bags = new int[k];	// 가방 최대 무게 담을 배열
		for(int i=0; i<k; i++) {
			st = new StringTokenizer(br.readLine());
			bags[i] = Integer.parseInt(st.nextToken());
		}
		
		// 가방 최대 무게 오름차순 정렬
		Arrays.sort(bags);
		
		int sum = 0;
		
		for(int i=0; i<k; i++) {
			for(int j=0; j<n; j++) {
				// 가방 최대 무게보다 보석의 무게가 작거나 같을 경우
				if (bags[i] >= t[j][0]) {
					treasures.add(new int[] {t[j][0], t[j][1]});
				}
			}
			
			// 가격 기준으로 정렬된 우선순위큐 만들어짐.
			// 여기서 가격 큰 것 sum에 더해주기
//			sum = treasures.poll();
		}
		

	}

}
