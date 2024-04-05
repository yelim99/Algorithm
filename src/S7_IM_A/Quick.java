package S7_IM_A;

public class Quick {
	
	public static void main(String[] args) {
		

	}
	
	static void quickSort(int[] arr, int start, int end) {
		// 원소가 1개인 경우
		if (start >= end) {
			return;
		}
		
		int pivot = start;	// 피벗은 첫번째값
		int l = start+1;
		int r = end;
		int tmp;
		
		while(l<=r) {	// 엇갈릴 때까지
			// 피벗보다 큰 값 나올 때까지 이동
			while(arr[l] <= arr[pivot]) {
				l++;
			}
			// 피벗보다 작은 값 나올 때까지 이동 / 왼쪽 값과 키 값 교체해줄거라서 여기에 조건 추가
			while (arr[r] >= arr[pivot] && r>start) {
				r--;
			}
			
			// 엇갈렸으면 키 값과 교체
			if (l>r) {
				tmp = arr[r];
				arr[r] = arr[pivot];
				arr[pivot] = tmp;
			} else {
				// 엇갈리지 않았다면 큰 값과 작은 값 위치 바꿔주기
				tmp = arr[r];
				arr[r] = arr[l];
				arr[l] = tmp;
			}
		}
		
		quickSort(arr, start, r-1);
		quickSort(arr, r+1, end);
	}

}
