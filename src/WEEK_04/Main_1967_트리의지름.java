package WEEK_04;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main_1967_트리의지름 {
	
	static int[][] graph;
	static int[][] value;
	static boolean[][] visited;
	static int n;
	static int sum;

	public static void main(String[] args) throws IOException {
		
		/* 트리의 지름
		 * 트리에서 어떤 두 노드를 선택해서 양쪽으로 쫙 당길 때, 가장 길게 늘어나는 경우가 있을 것이다. 
		 * 이럴 때 트리의 모든 노드들은 이 두 노드를 지름의 끝 점으로 하는 원 안에 들어가게 된다.
		 * 
		 * 이런 두 노드 사이의 경로의 길이를 트리의 지름이라고 한다. 
		 * 정확히 정의하자면 트리에 존재하는 모든 경로들 중에서 가장 긴 것의 길이를 말한다.
		 */
		
		/* 문제)
		 * 입력으로 루트가 있는 트리를 가중치가 있는 간선들로 줄 때, 트리의 지름을 구해서 출력하는 프로그램을 작성하시오.
		 * 
		 * 첫 번째 줄은 노드의 개수 n(1 ≤ n ≤ 10,000)
		 * 둘째 줄부터 n-1개의 줄에 각 간선에 대한 정보가 들어온다. 간선에 대한 정보는 세 개의 정수로 이루어져 있다. 
		 * 첫 번째 정수는 간선이 연결하는 두 노드 중 부모 노드의 번호
		 * 두 번째 정수는 자식 노드를, 세 번째 정수는 간선의 가중치를 나타낸다.
		 * 루트 노드의 번호는 항상 1이라고 가정
		 */

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		n = Integer.parseInt(st.nextToken());
		
		graph = new int[n+1][n+1];
		value = new int[n+1][n+1];
		visited = new boolean[n+1][n+1];
		
		for(int i=0; i<n-1; i++) {
			int p = Integer.parseInt(st.nextToken());
			int c = Integer.parseInt(st.nextToken());
			int v = Integer.parseInt(st.nextToken());
			
			graph[p][c] = 1;
			value[p][c] = v;
			
		}
		
		// 리프노드 탐색
		for(int i=1; i<=n; i++) {
			
		}
		
	}
	
	

}
