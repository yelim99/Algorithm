import java.util.Scanner;

/*
   사용하는 클래스명이 Solution 이어야 하므로, 가급적 Solution.java 를 사용할 것을 권장합니다.
   이러한 상황에서도 동일하게 java Solution 명령으로 프로그램을 수행해볼 수 있습니다.
 */
class Solution
{
	public static void main(String args[]) throws Exception
	{
		Scanner sc = new Scanner(System.in);
		int T = 10;
		/*
		   여러 개의 테스트 케이스가 주어지므로, 각각을 처리합니다.
		*/

		for(int test_case = 1; test_case <= T; test_case++)
		{
			int n = sc.nextInt();
			int[] arr = new int[n];
			
			for(int i=0; i<n; i++) {
				arr[i] = sc.nextInt();
			}
			
			int cnt = 0;
			int max = 0;
			for (int i=2; i<n-2; i++) {
				max = Math.max(arr[i-1], Math.max(arr[i-2], Math.max(arr[i+1], arr[i+2])));
				if (arr[i] > max) {
					cnt += arr[i] - max;
				}
			}
			
			System.out.printf("#%d %d%n", test_case, cnt);

		}
	}
}