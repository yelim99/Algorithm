package BOJ_2805_나무자르기;

import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		/* 문제)
		 * 나무의 수 n과 필요한 나무 길이 m
		 * 나무의 수만큼 높이 입력
		 * m미터의 나무를 가져가기 위해 절단기에 설정할 수 있는 높이의 최댓값 출력
		 */

		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		int m = sc.nextInt();
		
		int[] arr = new int[n];
		for(int i=0; i<n; i++) {
			arr[i] = sc.nextInt();
		}
		
//		int left = 0;
//		int right = n-1;
		int sum = 0;
		int h = arr[n/2];
		
		while (sum != m) {
			for(int i=0; i<n; i++) {
				if (arr[i]-h > 0) {
					sum += arr[i];
				}
			}
			
			if (sum > m) {
				h++;
				sum = 0;
			}
			else if (sum < m) {
				h--;
				sum = 0;
			}
		}
		System.out.println(sum);
		
		
	}

}
