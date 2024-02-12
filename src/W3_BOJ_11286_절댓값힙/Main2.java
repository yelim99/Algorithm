package W3_BOJ_11286_절댓값힙;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main2 {

	public static void main(String[] args) {
		
		/* 문제)절댓값 힙
		 * 배열에 정수를 넣고, 배열에서 절댓값이 가장 작은 값 출력, 그 값을 배열에서 제거
		 * 절댓값이 가장 작은 값이 여러개일 때는 가장 작은 수 출력, 그 값을 배열에서 제거
		 * 
		 * 연산의 개수 n, 연산의 정보 x 
		 * -> x가 0이 아니라면 배열에 값을 넣고, 0이라면 배열에서 절댓값이 가장 작은 값 출력, 제거
		 * 0이 주어진 횟수만큼 답 출력, 배열이 비어있는데 출력해야 할 경우, 0 출력
		 */
		
		// 힙으로 풀어보자..
		
		Scanner sc = new Scanner(System.in);
		
		int n = sc.nextInt();
		List<Integer> list = new ArrayList<>();
		int min = 0;
		
		for(int i=0; i<n; i++) {
			int x = sc.nextInt();
			if (x != 0) {
				list.add(x);
			}
			else {
				if (list.size()==0) {
					System.out.println(0);
				}
				else {
					for(int j=0; j<list.size(); j++) {
						min = Integer.MAX_VALUE;
						if (Math.abs(list.get(j)) < Math.abs(min)) {
							min = list.get(j);
							list.remove(j);
						}
						else if (Math.abs(list.get(j)) == Math.abs(min)) {
							if (list.get(j) < min) {
								min = list.get(j);
								list.remove(j);
							}
							
						}
					}
					System.out.println(min);
				}
			}
		}	// 연산 개수
	}

}
