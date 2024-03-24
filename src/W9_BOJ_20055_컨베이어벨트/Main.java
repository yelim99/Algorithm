package W9_BOJ_20055_컨베이어벨트;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

	public static void main(String[] args) throws IOException {
		/* 문제) 컨베이어 벨트 위의 로봇
		 * 로봇을 올리는 위치에 올리거나 로봇이 어떤 칸으로 이동하면 그 칸의 내구도는 즉시 1만큼 감소한다.
		 * 
		 * 벨트가 각 칸 위에 있는 로봇과 함께 한 칸 회전한다.
		 * 가장 먼저 벨트에 올라간 로봇부터, 벨트가 회전하는 방향으로 한 칸 이동할 수 있다면 이동한다. 
		 * 로봇이 이동하기 위해서는 이동하려는 칸에 로봇이 없으며, 그 칸의 내구도가 1 이상 남아 있어야 한다.
		 * 올리는 위치에 있는 칸의 내구도가 0이 아니면 올리는 위치에 로봇을 올린다.
		 * 내구도가 0인 칸의 개수가 K개 이상이라면 과정을 종료한다. 그렇지 않다면 1번으로 돌아간다.
		 * 
		 * 종료되었을 때 몇 번째 단계가 진행 중이었는지 구하기
		 * 
		 * n = 컨베이어벨트 길이 / k = 내구도가 0인 칸의 최대 개수
		 * 
		 */
		
		/* 설계)
		 * 모듈러 % ? 원처럼 벨트가 돌아가야하니까! 1 다음에는 2N이 올리는 위치가 됨.
		 * 1. 로봇을 1번에 올려? 1번 내구성 1 감소
		 * 2. 벨트, 로봇 한 칸 이동
		 * 3. 로봇 오른쪽으로 한 칸 이동할 수 있으면 이동, 내구성 1 감소
		 * 4. 2N의 내구성 1이상이면 로봇 올리기
		 * 5. 내구성 0인 칸이 k개 이상인지 확인
		 */
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		int n = Integer.parseInt(st.nextToken());
		int k = Integer.parseInt(st.nextToken());
		
		int[] durability = new int[n*2];
		
		int point = 0;
		// 처음 로봇 올리고 내구성 1 감소
		durability[0] -= 1;
		
		int cnt = 0;
		
		if(durability[0]==1) cnt = 1;
		
		while(cnt < k) {
			// 컨베이어벨트 회전
			
		}

	}
 
}
