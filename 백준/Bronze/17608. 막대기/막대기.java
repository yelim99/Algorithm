import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		int n = sc.nextInt();
		List<Integer> arr = new ArrayList<>();
		
		for(int i=0; i<n; i++) {
			arr.add(i, sc.nextInt());
		}
		
		int cnt = 1;
		int max = arr.get(n-1);
		
		for(int i=n-2; i>=0; i--) {
			if (arr.get(i) > max) {
				max = arr.get(i);
				cnt++;
			}
		}
		
		System.out.println(cnt);

	}

}