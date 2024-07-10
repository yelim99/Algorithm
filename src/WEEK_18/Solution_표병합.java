package WEEK_18;

import java.util.ArrayList;
import java.util.List;

public class Solution_표병합 {
	
	static class Cell {
		String value = null;
		
		@Override
		public String toString() {
			return "Cell [value=" + value + "]";
		}

//		public Cell(String value) {
//			this.value = value;
//		}
	}

	static Cell[][] table;
	
	public static void main(String[] args) {
		/* 카카오 2023 RECRUITMENT - 표 병합 (LEV 3)
		 * 
		 * 병합이 문젠데...
		 * MERGE r1 c1 r2 c2 에서 이 값들만 바꿔주는게 아니라 병합된 셀들도 다 바꿔줘야함! 
		 * 객체를 써야하나
		 */
		
		List<String> ans = new ArrayList<>();
		
//		String[] commands = {"UPDATE 1 1 menu", "UPDATE 1 2 category", "UPDATE 2 1 bibimbap", "UPDATE 2 2 korean", "UPDATE 2 3 rice", "UPDATE 3 1 ramyeon", "UPDATE 3 2 korean", "UPDATE 3 3 noodle", "UPDATE 3 4 instant", "UPDATE 4 1 pasta", "UPDATE 4 2 italian", "UPDATE 4 3 noodle", "MERGE 1 2 1 3", "MERGE 1 3 1 4", "UPDATE korean hansik", "UPDATE 1 3 group", "UNMERGE 1 4", "PRINT 1 3", "PRINT 1 4"};
		String[] commands = {"UPDATE 1 1 a", "UPDATE 1 2 b", "UPDATE 2 1 c", "UPDATE 2 2 d", "MERGE 1 1 1 2", "MERGE 2 2 2 1", "MERGE 2 1 1 1", "PRINT 1 1", "UNMERGE 2 2", "PRINT 1 1"};
		table = new Cell[51][51];
		
		for(int i=0; i<=50; i++) {
			for(int j=0; j<=50; j++) {
				table[i][j] = new Cell();
			}
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
					table[r][c].value = one[3];
				}
				// 숫자가 아니면 one[1] 값을 가진 모든 셀을 one[2] 값으로 변경
				else {
					for(int r=1; r<=50; r++) {
						for(int c=1; c<=50; c++) {
							if (table[r][c].value != null && table[r][c].value.equals(one[1])) {
								table[r][c].value = one[2];
							}
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
				// 두 셀이 다른 셀일 경우
				if (r1 != r2 || c1 != c2) {
					// 병합
					// 그냥 반복 없이 값만 복사하면 병합된 셀들이 다 바뀌지 않음
					if (table[r1][c1].value == null && table[r2][c2].value != null) {
						merge(r1, c1, r2, c2);
//						table[r1][c1] = table[r2][c2];
					}
					else if (table[r1][c1].value != null && table[r2][c2].value == null) {
						merge(r2, c2, r1, c1);
//						table[r2][c2] = table[r1][c1];
					}
					else {
						merge(r2, c2, r1, c1);
//						table[r2][c2] = table[r1][c1];
					}
						
				}
			}
			
			// 명령어가 UNMERGE 일 때
			else if (one[0].equals("UNMERGE")) {
				int r1 = Integer.parseInt(one[1]);
				int c1 = Integer.parseInt(one[2]);
				
				// 선택한 셀 객체 값 저장해두기
				Cell cell = table[r1][c1];
				
				// 반복 돌며 셀을 포함한 병합된 셀들 다 비워주기
				for(int r=1; r<=50; r++) {
					for(int c=1; c<=50; c++) {
						if (table[r][c] == cell) {
							table[r][c] = new Cell();
						}
					}
				}
				// 선택한 셀이 null이 아니면 해당 값 가지기
				if (cell != null) {
					table[r1][c1].value = cell.value;
				}
			}
			
			// 명령어가 PRINT 일 때
			else if (one[0].equals("PRINT")) {
				int r = Integer.parseInt(one[1]);
				int c = Integer.parseInt(one[2]);
				
				if (table[r][c].value == null) {
					ans.add("EMPTY");
				} else {
					ans.add(table[r][c].value);
				}
			}
		}
		
		System.out.println(ans);	
	}
	
	// 병합하는 메소드
	static void merge(int r1, int c1, int r2, int c2) {
		Cell c = table[r1][c1];
		
		System.out.println(r1+", "+c1+" - cell c = "+c);
		
		// 반복 돌리며 병합되는 애들 객체 같게 해준다.
		// 반복문을 돌려주는 이유는 병합되었을 때, 같은 Cell 객체인 애들 다 바꿔주기 위해서!
		for(int i=1; i<=50; i++) {
			for(int j=1; j<=50; j++) {
				if (table[i][j] == c) {
					System.out.println("table "+i+"/"+j+" = "+table[i][j]);
					table[i][j] = table[r2][c2];
				}
			}
		}
		
	}

}
