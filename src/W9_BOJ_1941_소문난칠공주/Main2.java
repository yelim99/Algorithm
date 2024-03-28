package W9_BOJ_1941_소문난칠공주;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class Main2 {
	
	static char[][] arr;
	static boolean[][] visited;
	static List<char[]> select = new ArrayList<>();
	static char[] sel;
	static int[] dr = {-1, 1, 0, 0};
	static int[] dc = {0, 0, -1, 1};

	public static void main(String[] args) throws IOException {
		/* 문제) 소문난 칠공주
		 * 총 25명의 여학생들로 이루어진 여학생반은 5×5의 정사각형 격자 형태로 자리가 배치되었다.
		 * 
		 * 이름이 이름인 만큼, 7명의 여학생들로 구성되어야 한다.
		 * 강한 결속력을 위해, 7명의 자리는 서로 가로나 세로로 반드시 인접해 있어야 한다.
		 * 화합과 번영을 위해, 반드시 ‘이다솜파’의 학생들로만 구성될 필요는 없다.
		 * 그러나 생존을 위해, ‘이다솜파’가 반드시 우위를 점해야 한다. 
		 * 따라서 7명의 학생 중 ‘이다솜파’의 학생이 적어도 4명 이상은 반드시 포함되어 있어야 한다.
		 * 여학생반의 자리 배치도가 주어졌을 때, ‘소문난 칠공주’를 결성할 수 있는 모든 경우의 수를 구하는 프로그램을 작성하시오.
		 */
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		arr = new char[5][5];
		visited = new boolean[5][5];
		sel = new char[7];
		
		for(int i=0; i<5; i++) {
			String s = br.readLine();
			for(int j=0; j<5; j++) {
				arr[i][j] = s.charAt(j);
			}
		}
		
		int cnt = 0;
		int ans = 0;
		
		
		Set<char[]> set = new HashSet<char[]>();
		
		for(int i=0; i<5; i++) {
			for(int j=0; j<5; j++) {
				if (arr[i][j] == 'S') {
					sel[0] = arr[i][j];
					comb(i, j, 1);
					cnt = 1;
					
					System.out.println(Arrays.toString(sel));
					set.add(sel);
					select.add(sel);
//					System.out.println(select.size());
					
//					list = new ArrayList<>(set);
//					for(int k=0; k<list.size(); k++) {
//						if (list.get(k)'S') {
//							
//						}
//					}
					System.out.println("---------------");
					for(int k=0; k<7; k++) {
						if (sel[k] == 'S') {
							cnt++;
						}
					}
					if (cnt>=4) {
//						System.out.println(select.size());
//						set.addAll(select);
						
					}
				}
//				System.out.println(list.size());
				
			}
		}
		
		List<char[]> list = new ArrayList<>(set);
		
		for(int i=0; i<list.size(); i++) {
			System.out.println(Arrays.toString(list.get(i)));
		}
		System.out.println(list.size());
		
		
//		for(int i=0; i<5; i++) {
//			for(int j=0; j<5; j++) {
//				System.out.print(arr[i][j]+" ");
//			}
//			System.out.println();
//		}

	}
	
	
	static void comb(int r, int c, int idx) {
		if (idx==7) {
			return;
		}
		
		for(int d=0; d<4; d++) {
			 int nr = r+dr[d];
			 int nc = c+dc[d];
			 
			 if (nr>=0 && nr<5 && nc>=0 && nc<5) {
				 sel[idx] = arr[nr][nc];
				 comb(nr, nc, idx+1);
			 }
		}
	}

}
