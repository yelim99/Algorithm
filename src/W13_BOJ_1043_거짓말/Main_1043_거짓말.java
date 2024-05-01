package W13_BOJ_1043_거짓말;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main_1043_거짓말 {
	
	static int n, m;
	static int x;	// 진실을 아는 사람의 수
	static Queue<Integer> truth = new LinkedList<>();	// 진실을 아는 사람 번호 배열
	static List<Integer>[] party;	// 각 파티에 오는 사람의 번호 배열
	

	public static void main(String[] args) throws IOException {
		/* 문제) 1043_거짓말
		 * 
		 */
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		n = Integer.parseInt(st.nextToken());
		m = Integer.parseInt(st.nextToken());
		st = new StringTokenizer(br.readLine());
		
		x = Integer.parseInt(st.nextToken());
		for(int i=0; i<x; i++) {
			truth.add(Integer.parseInt(st.nextToken()));
		}
		
		party = new ArrayList[m];
		
		for(int i=0; i<m; i++) {
			party[i] = new ArrayList<>();
		}
		
		for(int i=0; i<m; i++) {
			st = new StringTokenizer(br.readLine());
			int a = Integer.parseInt(st.nextToken());
			for(int j=0; j<a; j++) {
				int num = Integer.parseInt(st.nextToken());
				party[i].add(num);
			}
		}
		
		// 진실을 말하는지
		int[] talk = new int[m];
		
		
		while(!truth.isEmpty()) {
			int t = truth.poll();
			
			for(int i=0; i<m; i++) {
				out: for(int j=0; j<party[i].size(); j++) {
					if (party[i].get(j) == t) {
						for(int num : party[i]) {
							truth.add(num);
						}
						talk[i] = 1;
						break out;
					}
				}
			}
		}
		
		int cnt = 0;
		for(int i=0; i<m; i++) {
			if (talk[i] == 0) {
				cnt++;
			}
		}
		System.out.println(cnt);
		
//		int[] talk = new int[m];	// 파티에서 거짓말하는지 / 1=거짓말
//		out: for(int i=0; i<m; i++) {
//			for(int j=0; j<party.get(i).length; j++) {
//				for(int t=0; t<x; t++) {
//					// 파티에 truth가 있으면
//					if (party.get(i)[j] == truth[t]) {
//						talk[i] = 1;
//						continue out;
//					}
//					else {
//						// 이전 파티에...?
//					}
//				}
//			}
//		}
		
	}

}
