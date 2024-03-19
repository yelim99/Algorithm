package W8_BOJ_21608_상어초등학교;

public class Main2 {
	
	public static void main(String[] args) {
	//	
//		// like 반복 메소드
//		static void find() {
//			for(int i=0; i<n; i++) {
//				for(int j=0; j<n; j++) {
//					// 이미 자리에 누가 있으면 스킵
//					if (seat[i][j] > 0) {
//						continue;
//					}
//					
//					likeCnt = 0;
//					
//					for (int d=0; d<4; d++) {
//						int nr = i+dr[d];
//						int nc = j+dc[d];
//						
//						if (nr>=0 && nr<n && nc>=0 && nc<n) {
//							// 자리에 좋아하는 학생이 있는지
//							for (int i=0; i<4; i++) {
//								if (like[seat[r][c]][i] == seat[nr][nc]) {
//									likeCnt++;
//								}
//							}
//						}
//					}
//					
//					likeSearch(i, j);
//					// 최대값인지, 최대값이면 해당좌석에 학생 번호 넣어주기
//					if (likeCnt > likeMax) {
//						likeMax = likeCnt;
//						seat[i][j] = order[1];
//					}
//					if (likeCnt == likeMax) {
//						likeCheck = true;
//					}
//					
//					
//				}
//			}
//		}
	//	
//		// 탐색 메소드 (행, 열, 학생 번호)
//		static void likeSearch(int r, int c) {
//			likeCnt = 0;
//			
//			for (int d=0; d<4; d++) {
//				int nr = r+dr[d];
//				int nc = c+dc[d];
//				
//				if (nr>=0 && nr<n && nc>=0 && nc<n) {
//					// 자리에 좋아하는 학생이 있는지
//					for (int i=0; i<4; i++) {
//						if (like[seat[r][c]][i] == seat[nr][nc]) {
//							likeCnt++;
//						}
//					}
//				}
//			}
//			
////			return likeCnt;
//		}
//		
//		// 빈칸 수 찾는 메소드
//		static void empty(int r, int c) {
//			emptyCnt = 0;
//			
//			for(int d=0; d<4; d++) {
//				int nr = r+dr[d];
//				int nc = c+dc[d];
//				
//				if (nr>=0 && nr<n && nc>=0 && nc<n) {
//					if (seat[nr][nc]==0) {
//						emptyCnt++;
//					}
//				}
//			}
//		}
	}

}
