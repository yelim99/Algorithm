package S7_IM;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main_BOJ_17471 {
	
	static int n;
	static List<List<Integer>> graph = new ArrayList<>();
	static int[] pop;
	static boolean[] visited;
	static int cnt;

	public static void main(String[] args) {
		/* 문제) 게리맨더링1
		 * 공평하게 선거구를 나누기 위해 두 선거구에 포함된 인구의 차이를 최소로 하려고 한다. 
		 * 백준시의 정보가 주어졌을 때, 인구 차이의 최솟값을 구해보자.
		 * 
		 * 첫째 줄에 구역의 개수 N이 주어진다. 
		 * 둘째 줄에 구역의 인구가 1번 구역부터 N번 구역까지 순서대로 주어진다. 인구는 공백으로 구분되어져 있다.
		 * 셋째 줄부터 N개의 줄에 각 구역과 인접한 구역의 정보가 주어진다. 
		 * 각 정보의 첫 번째 정수는 그 구역과 인접한 구역의 수이고, 이후 인접한 구역의 번호가 주어진다. 
		 * 모든 값은 정수로 구분되어져 있다.
		 * 
		 * 구역 A가 구역 B와 인접하면 구역 B도 구역 A와 인접하다. 인접한 구역이 없을 수도 있다.
		 */

		Scanner sc = new Scanner(System.in);
		
		n = sc.nextInt();
		
		pop = new int[n+1];
		visited = new boolean[n+1];
		
		// 인구 수 입력받아서 배열에 저장
		for(int i=1; i<=n; i++) {
			pop[i] = sc.nextInt();
		}
		
		// 인접 리스트 만들 리스트 생성
		for(int i=1; i<=n; i++) {
			graph.add(new ArrayList<>());
		}
		
		// 인접 리스트에 값 저장
		for(int i=1; i<=n; i++) {
			int num = sc.nextInt();
			for(int j=0; j<num; j++) {
				int x = sc.nextInt();
				graph.get(i).add(x);
				graph.get(x).add(i);
			}	
		}
		
		cnt = 0;
		
		
		
	}
	
	static void dfs(int n) {
		visited[n] = true;
		
		
	}

}
