package WEEK_02;

import java.util.Arrays;
import java.util.Scanner;

public class Main_1253 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		int n = sc.nextInt();
		int[] arr = new int[n];
		
		for(int i=0; i<n; i++) {
			arr[i] = sc.nextInt();
		}
		Arrays.sort(arr);
		
		int left;
		int right;
		int cnt = 0;
		
		for(int i=0; i<n; i++) {
			left = 0;
			right = n-1;
			while(left<right) {
				int sum = arr[left]+arr[right];
				if (sum == arr[i]) {
					if (left != i && right != i) {
						cnt++;
						break;
					}
					else if (left == i) {
						left++;
					}
					else if (right == i) {
						right--;
					}
				}
				else if (sum > arr[i]) {
					right--;
				}
				else {
					left++;
				}
			}
		}
		
		System.out.println(cnt);
		
		

	}

}
