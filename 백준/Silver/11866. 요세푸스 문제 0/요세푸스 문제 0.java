import java.util.LinkedList;
import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		int k = sc.nextInt();
		
		LinkedList<Integer> list = new LinkedList<>();
		
		for(int i=0; i<n; i++) {
			list.add(i+1);
		}

		int[] arr = new int[list.size()];
		int idx = 0;	// 삭제하는 인덱스의 값 저장	
		int cIdx = 0;	// 현재 위치

		while (list.size() != 0) {
			cIdx += k-1;
			if (cIdx < list.size()) {
				arr[idx] = list.remove(cIdx);
			}
			else {
				while (cIdx >= list.size()) {
					cIdx -= list.size();
				}
				arr[idx] = list.remove(cIdx);
			}
			idx++;
		}
		
		
		
		System.out.print("<");
		for(int i=0; i<n-1; i++) {
			System.out.print(arr[i]+", ");
		}
		System.out.print(arr[n-1]);
		System.out.print(">");

	}

}