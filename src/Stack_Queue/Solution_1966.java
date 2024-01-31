package Stack_Queue;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;
import java.util.Scanner;

public class Solution_1966 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		int t = sc.nextInt();
		
		for(int i=0; i<t; i++) {
			int n = sc.nextInt();	// 문서의 개수
			int m = sc.nextInt();	// 인덱스
			
			LinkedList<int[]> arr = new LinkedList<>();
			boolean isMax = true;
			int count = 0;
			
			for(int j=0; j<n; j++) {
				arr.add(new int[] {j, sc.nextInt()});
			}
			System.out.println(Arrays.toString(arr.get(1)));
			
			while (!arr.isEmpty()) {
				int[] front = arr.poll();
				
				
				System.out.println("front="+Arrays.toString(front));
				
				for(int j=0; j<arr.size(); j++) {
					if (front[1] < arr.get(j)[1]) {
						arr.offer(front);
						for(int z=0; z<j; z++) {
							arr.offer(arr.poll());
						}
						isMax = false;
						break;
					}
				}
				if (isMax == false) continue;
				count++;
				
				if (front[0] == count) break;			
			}
			
//			for(int j=0; j<n-1; j++) {
//				// 이렇게 하면 처음에만 0번째 검사, 두번째부터는 0-1-.. 검사 안됨
//				if (impList.get(j) < impList.get(j+1)) {
//					impList.add(impList.get(j));
//					impList.remove(j);
//				}
//			}
//			System.out.println(impList);
			
			System.out.println(count);
			
		}
		

		
	}

}
