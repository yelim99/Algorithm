import java.util.Scanner;

public class Main {
	
	public static void main(String[] args) {
		/* 문제)
		 * n개의 랜선
		 * k개의 길이가 제각각인 랜선
		 * 기존 k개의 랜선으로 n개의 랜선을 만들 수는 없음.
		 * 만들 수 있는 최대 랜선의 길이
		 */
		
		Scanner sc = new Scanner(System.in);
		
		int k = sc.nextInt();	// 이미 가지고 있는 개수 k
		int n = sc.nextInt();	// 필요한 랜선의 개수 n
		long[] arr = new long[k];
		
		long min = 1;
		long max = 0;
		long mid = 0;
		
		int cnt = 0;
		
		// k의 길이 입력받아서 배열에 저장
		for(int i=0; i<k; i++) {
			arr[i] = sc.nextInt();
			if (arr[i] > max) {
				max = arr[i];
			}
		}
		
        max++;
		while (min < max) {
			mid = (min+max)/2;
			cnt = 0;
			for(int i=0; i<k; i++) {
				cnt += (arr[i]/mid);
			}
			if (cnt < n) {
				max = mid;
			}
			else {
				min = mid+1;
			}
			
		}
		
		// 마지막에 1 더해줬으니까 빼주기!
		System.out.println(min-1);
		
	}

}