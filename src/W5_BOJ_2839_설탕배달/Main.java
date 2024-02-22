package W5_BOJ_2839_설탕배달;

import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		/* 문제) 설탕배달
		 * 봉지는 3킬로그램 봉지와 5킬로그램 봉지가 있다.
		 * 상근이가 설탕을 정확하게 N킬로그램 배달해야 할 때, 
		 * 봉지 몇 개를 가져가면 되는지 그 수를 구하는 프로그램을 작성하시오.
		 * 
		 * 상근이가 배달하는 봉지의 최소 개수를 출력
		 */

		Scanner sc = new Scanner(System.in);
		
		int total = sc.nextInt();
		int[] arr = {5, 3};
		int cnt = 0;
		
		for(int kg : arr) {
			cnt += total/kg;
			total %= kg;
		}
		
		if (total != 0) {
			System.out.println(-1);
		}
		else {
			System.out.println(cnt);
		}
	}

}
