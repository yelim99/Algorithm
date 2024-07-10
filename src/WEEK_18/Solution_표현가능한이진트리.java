package WEEK_18;

import java.util.Arrays;

public class Solution_표현가능한이진트리 {

	static int res;
	
	public static void main(String[] args) {
		/* 문제) 카카오 2023 RECRUITMENT_표현 가능한 이진트리
		 * 
		 */
		
		long[] numbers = {7, 42, 5};
		int[] answer = new int[numbers.length];
		
		for(int i=0; i<numbers.length; i++) {
			String binaryNum = Long.toBinaryString(numbers[i]);
			
			int fullNode = 0;	// 포화 이진트리 노드 수
			int n = 1;	// 트리 높이
			
			// 포화 이진트리를 만들기 위한 최소 노드 수 구하기
			while (fullNode < binaryNum.length()) {
				fullNode = (int) Math.pow(2, n++)-1;
			}
			
			// 포화 이진트리
			int[] fullTree = new int[fullNode];
			
			int dummy = fullNode - binaryNum.length();	// 더미 노드 개수
			
			// 더미노드 개수만큼 앞에 0을 채운다고 가정, 그 이후부터 이진수 값 넣어주기
			for(int j=0; j<binaryNum.length(); j++) {
				fullTree[dummy++] = Character.getNumericValue(binaryNum.charAt(j)); 
			}
			
//			System.out.println(Arrays.toString(fullTree));
			
			// 이제! 탐색 돌면서 가능한지 확인?
			// 정답 초기화
			res = 1;
			dfs(0, fullTree.length-1, fullTree, false);
			answer[i] = res;
		}
		
		System.out.println(Arrays.toString(answer));

	}
	
	static void dfs(int s, int e, int[] fullTree, boolean isParentZero) {
		if (res == 0) return;
		
		// 현재 서브트리 내의 부모노드
		int mid = (s+e)/2;
		
		// 현재 서브트리의 부모가 0인데, 자식이 1이면 끝
		if (isParentZero && fullTree[mid]==1) {
			res = 0;
			return;
		}
		
		// s와 e가 다르면 계속 재귀 탐색
		if (s != e) {
			// 왼쪽 서브트리
			dfs(s, mid-1, fullTree, fullTree[mid]==0);
            // 오른쪽 서브트리
			dfs(mid+1, e, fullTree, fullTree[mid]==0);
		}
		
	}

}
