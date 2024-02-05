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
		
		int min = 0;
		int max = 0;
		int mid = 0;
		
		int[] arr = new int[n];
		for(int i=0; i<n; i++) {
			arr[i] = sc.nextInt();
			
			if (arr[i] > max) {
				max = arr[i];
			}
		}
		
		
		while (min < max) {
			mid = (min+max)/2;
			long sum = 0;
			for(int i=0; i<n; i++) {
				if (arr[i]-mid > 0) {
					sum += (arr[i]-mid);
				}
			}
			if (sum < m) {
				max = mid;
			}
			
			else {
				min = mid+1;
			}

		}

		
		System.out.println(min-1);
		
	}

}