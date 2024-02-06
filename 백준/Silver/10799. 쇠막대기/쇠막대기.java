import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {
	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		
        // 괄호(쇠막대기 상태)입력받기
        String s = sc.nextLine();

        int cnt = 0;	// 여는 괄호(쇠막대기 수) 저장할 변수
        int sum = 0;	// ()일 때, 괄호가 닫혔을 때 잘린 수 저장할 변수

        // 괄호 길이만큼 반복
        for(int i=0; i<s.length(); i++) {
            char c = s.charAt(i);
            // 여는 괄호일 때
            if (c == '(') {
                cnt++;	// 1 증가
            }
            // 닫는 괄호일 때
            else {
                cnt--;	// 1 감소
                // 직전 괄호가 여는 괄호일 경우 (레이저)
                if (s.charAt(i-1)=='(') {
                    // sum에 cnt만큼(막대기 수만큼) 더해주기
                    sum += cnt;
                }
                else {
                    // 아닌 경우 sum 1 증가
                    sum++;
                }
            }
        }

        System.out.println(sum);
	}
}