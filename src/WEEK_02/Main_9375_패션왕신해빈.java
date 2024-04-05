package WEEK_02;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;
import java.util.StringTokenizer;

public class Main_9375_패션왕신해빈 {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		int T = Integer.parseInt(st.nextToken());	// 테스트 케이스
		
		// 테스트케이스만큼 반복
		for(int t=0; t<T; t++) {
			
			int n = Integer.parseInt(st.nextToken());	// 의상의 수
			st = new StringTokenizer(br.readLine());
			
			// 의상 종류와 이름 저장할 해시맵
			Map<String, String> clothes = new HashMap<>();
			
			for(int i=0; i<n; i++) {
				clothes.put(br.readLine(), br.readLine());
			}
			
			for(int i=0; i<n; i++) {
				
			}
			
			
		}	// 테스트케이스 끝

	}

}
