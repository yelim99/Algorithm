package S7_IM;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Solution_3499_퍼펙트셔플 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		int T = sc.nextInt();
		for(int t=1; t<=T; t++) {
			
			int n = sc.nextInt();
			List<String> first = new ArrayList<>();
			
			// 초기 카드 저장
			for(int i=0; i<n; i++) {
				first.add(sc.next());
			}
			
			// 반으로 나눈 크기
			int size = n/2;
			
			// 반으로 나눈 카드 저장해줄 리스트 두개
			List<String> list1 = new ArrayList<>();
			List<String> list2 = new ArrayList<>();
			
			// 만약 홀수라면, 첫번째 리스트에 하나 더 저장해주기
			if (n%2 == 1) {
				for(int i=0; i<size+1; i++) {
					list1.add(first.get(i));
				}
				for(int i=size+1; i<n; i++) {
					list2.add(first.get(i));
				}
			}
			// 홀수가 아니면 size만큼 둘 다 저장해주기
			else {
				for(int i=0; i<size; i++) {
					list1.add(first.get(i));
				}
				for(int i=size; i<n; i++) {
					list2.add(first.get(i));
				}
			}
			
			// 결과 저장할 리스트
			List<String> result = new ArrayList<>();
			// size 크기만큼 반복하면서 list1, list2 차례대로 result에 저장
			for(int i=0; i<size; i++) {
				result.add(list1.get(i));
				result.add(list2.get(i));
			}
			// 만약 list1의 크기가 size와 다르다면 (홀수라서 하나 더 들어있다면)
			// 마지막 값 result에 저장해주기
			if (list1.size() != size) {
				result.add(list1.get(list1.size()-1));
			}
			
			// 출력
			System.out.printf("#%d ", t);
			for(String s : result) {
				System.out.print(s+" ");
			}
			System.out.println();
			
		}	// 테케 끝

	}

}
