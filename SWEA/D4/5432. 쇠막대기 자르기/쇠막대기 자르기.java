import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

class Solution
{
	public static void main(String args[]) throws Exception
	{
		Scanner sc = new Scanner(System.in);
		
		int T = sc.nextInt();
		sc.nextLine();
		for(int t=1; t<=T; t++) {
			String s = sc.nextLine();
			
			int cnt = 0;
			int sum = 0;
			
			for(int i=0; i<s.length(); i++) {
				char c = s.charAt(i);
				if (c == '(') {
					cnt++;
				}
				else {
					cnt--;
					if (s.charAt(i-1)=='(') {
						sum += cnt;
					}
					else {
						sum++;
					}
				}
			}
			
			System.out.printf("#%d %d%n", t, sum);
			
			
		}	// 테스트케이스 끝
	}
}