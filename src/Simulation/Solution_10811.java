package Simulation;

import java.util.Arrays;
import java.util.Scanner;

public class Solution_10811 {

	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		
		int n = sc.nextInt();
		int m = sc.nextInt();
		int[] arr = new int[n];
		
		for(int i=0; i<n; i++) {
			arr[i] = i+1;
		}
		
		for (int a=0; a<m; a++) {
			int[] copyArr = Arrays.copyOf(arr, n);
			int i = sc.nextInt();
			int j = sc.nextInt();
			
			if (j-i >= 2) {
				while (j-i >= 1) {
					arr[i-1] = copyArr[j-1];
					arr[j-1] = copyArr[i-1];
					i++;
					j--;
				}
				
			}
			else {
				arr[i-1] = copyArr[j-1];
				arr[j-1] = copyArr[i-1];
			}
		}
		
		for(int o:arr) {
			System.out.print(o+" ");
		}

	}

}
