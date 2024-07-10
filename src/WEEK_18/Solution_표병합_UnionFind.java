package WEEK_18;

import java.util.ArrayList;
import java.util.List;

public class Solution_표병합_UnionFind {
	
	static int[] parent;	// 병합된 셀 부모 인덱스 저장
	static String[] values;	// 값
	static int n = 2501;	// 50*50
	
	static int find (int idx) {
		if (parent[idx] == idx) return idx;
		return parent[idx] = find(parent[idx]);
	}
	
	static void union(int x, int y) {
		x = find(x);
		y = find(y);
		
		if (x != y) {
			parent[y] = x;
		}
	}
	
	// 50*50 이차원 배열이 아닌 일차원 배열로 만들어야 해서 인덱스 지정해주기
	// r=1, c=1 => 1 / r=2, c=1 => 51 ..
	static int convertIdx(int r, int c) {
		return 50*(r-1)+c;
	}
	
	public static void main(String[] args) {
		/* 카카오 2023 RECRUITMENT - 표 병합 (LEV 3)
		 * 
		 * union-find
		 */
		
		List<String> ans = new ArrayList<>();
		
//		String[] commands = {"UPDATE 1 1 menu", "UPDATE 1 2 category", "UPDATE 2 1 bibimbap", "UPDATE 2 2 korean", "UPDATE 2 3 rice", "UPDATE 3 1 ramyeon", "UPDATE 3 2 korean", "UPDATE 3 3 noodle", "UPDATE 3 4 instant", "UPDATE 4 1 pasta", "UPDATE 4 2 italian", "UPDATE 4 3 noodle", "MERGE 1 2 1 3", "MERGE 1 3 1 4", "UPDATE korean hansik", "UPDATE 1 3 group", "UNMERGE 1 4", "PRINT 1 3", "PRINT 1 4"};
		String[] commands = {"UPDATE 1 1 a", "UPDATE 1 2 b", "UPDATE 2 1 c", "UPDATE 2 2 d", "MERGE 1 1 1 2", "MERGE 2 2 2 1", "MERGE 2 1 1 1", "PRINT 1 1", "UNMERGE 2 2", "PRINT 1 1"};
		
		
		parent = new int[n];
		values = new String[n];
		
		// 초기화
		for(int i=1; i<n; i++) {
			parent[i] = i;
			values[i] = null;
		}
		
		for(int i=0; i<commands.length; i++) {
			// 띄어쓰기로 구분하여 하나의 command를 배열로 저장
			String[] one = commands[i].split(" ");
			
			// 명령어가 UPDATE 일 때
			if (one[0].equals("UPDATE")) {
				// 다음 명령어가 숫자이면
				if (one.length == 4) {
					int r = Integer.parseInt(one[1]);
					int c = Integer.parseInt(one[2]);
					int idx = convertIdx(r, c);
					values[find(idx)] = one[3];
				}
				
				// 문자열을 바꾸는 것이면
				else {
					for(int j=1; j<n; j++) {
						if (one[1].equals(values[j])) {
							values[j] = one[2];
						}
					}
				}
			}
			
			// 명령어가 MERGE 일 때
			else if (one[0].equals("MERGE")) {
				int r1 = Integer.parseInt(one[1]);
				int c1 = Integer.parseInt(one[2]);
				int r2 = Integer.parseInt(one[3]);
				int c2 = Integer.parseInt(one[4]);
				
				int idx1 = convertIdx(r1, c1);
				int idx2 = convertIdx(r2, c2);
				
				// 두 셀이 다른 셀일 경우
				if (idx1 != idx2) {
					// 부모 인덱스 찾기
					int p1 = find(idx1);
					int p2 = find(idx2);
					
					// 부모 인덱스가 같다면 이미 병합 되어있는 것
					if (p1 != p2) {
						String val = null;
						// p1의 값이 null이면 p2 값으로 병합
						if (values[p1] == null) {
							val = values[p2];
						} else {
							val = values[p1];
						}
						// p1으로 병합될 것이니까
						values[p2] = null;
						
						// p1 기준으로 병합
						union(p1, p2);
						values[p1] = val;
					}
				}
			}
			
			// 명령어가 UNMERGE 일 때
			else if (one[0].equals("UNMERGE")) {
				int r1 = Integer.parseInt(one[1]);
				int c1 = Integer.parseInt(one[2]);
				int idx = convertIdx(r1, c1);		
				
				// 병합된 셀의 부모 인덱스
				int p = find(idx);
				
				// 부모 인덱스의 값
				String pVal = values[p];
				
				// 병합되어 있던 셀들은 다시 null 값 가짐
				values[p] = null;
				// 선택된 셀은 부모노드 값을 가짐
				values[idx] = pVal;
				
				// 병합 해제
				List<Integer> del = new ArrayList<>();
				// 연결된 같은 부모 인덱스 가진 셀들 찾기
				for(int j=1; j<n; j++) {
					if (find(j) == p) {
						del.add(j);
					}
				}
				
				// 해당 셀들 부모 인덱스를 자신으로 바꾸어 병합 해제
				for(int x : del) {
					parent[x] = x;
				}
				
			}
			
			// 명령어가 PRINT 일 때
			else if (one[0].equals("PRINT")) {
				int r = Integer.parseInt(one[1]);
				int c = Integer.parseInt(one[2]);
				
				int idx = convertIdx(r, c);
				int p = find(idx);
				
				if (values[p] == null) {
					ans.add("EMPTY");
				} else {
					ans.add(values[p]);
				}
			}
				
		}
		
		System.out.println(ans);	
	}


}
