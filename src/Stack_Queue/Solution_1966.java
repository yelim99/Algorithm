package Stack_Queue;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Solution_1966 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		int t = sc.nextInt();
		
		for(int i=0; i<t; i++) {
			int n = sc.nextInt();	// 문서의 개수
			int m = sc.nextInt();	// 인덱스
			
			int[] arr = new int[n];	// 중요도
			int max = 0;
			int maxIdx = 0;
			
			// 셀렉션 알고리즘
			for(int j=0; j<n; j++) {
				arr[i] = sc.nextInt();
				maxIdx = i;
				for(int z=j+1; j<n; j++) {
					if (arr[z] > arr[maxIdx]) {
						maxIdx = z;
					}
					int temp = arr[z];
					arr[z] = arr[maxIdx];
					arr[maxIdx] = temp;
				}
			}
			
			
			
			
			
//			for(int j=0; j<n-1; j++) {
//				// 이렇게 하면 처음에만 0번째 검사, 두번째부터는 0-1-.. 검사 안됨
//				if (impList.get(j) < impList.get(j+1)) {
//					impList.add(impList.get(j));
//					impList.remove(j);
//				}
//			}
//			System.out.println(impList);
			
		}
		

		
	}

}
