import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		
		/* 문제)
		 * 포켓몬 개수 n개, 문제 개수 m개
		 * n개의 줄에 1번부터 n번까지 포켓몬 이름 입력
		 * m개 줄에 문제
		 * 번호 -> 이름으로
		 * 이름 -> 번호로 대답.
		 */
		
		Scanner sc = new Scanner(System.in);
		
		int n = sc.nextInt();	// 포켓몬 개수
		int m = sc.nextInt();	// 문제 개수
		sc.nextLine();
		
		// key(번호), value(이름) 을 가지는 map 생성
		Map<Integer, String> pokemon = new HashMap<>();
		
		// key(이름), value(번호) 를 가지는 map 생성
		Map<String, Integer> pokemon2 = new HashMap<>();
		
		
		for(int i=1; i<=n; i++) {
			pokemon.put(i, sc.nextLine());
			pokemon2.put(pokemon.get(i), i);
		}
		
		
		String result1;
		int result2 = 0;
		
		for(int i=0; i<m; i++) {
			String s = sc.nextLine();
			if (Character.isDigit(s.charAt(0))){
				result1 = pokemon.get(Integer.parseInt(s));
				System.out.println(result1);
			}
			else {
				result2 = pokemon2.get(s);
				System.out.println(result2);
			}
			
		}

	}

}
