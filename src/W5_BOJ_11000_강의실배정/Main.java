package W5_BOJ_11000_강의실배정;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.PriorityQueue;
import java.util.Queue;
import java.util.StringTokenizer;

class Meeting {
	int start;
	int end;
	
	public Meeting() {}
	
	public Meeting(int start, int end) {
		this.start = start;
		this.end = end;
	}
	
	
}

public class Main {

	public static void main(String[] args) throws IOException {
		
		/* 문제)
		 * Si에 시작해서 Ti에 끝나는 N개의 수업이 주어지는데, 최소의 강의실을 사용해서 모든 수업을 가능하게 해야 한다. 
		 * 강의실의 개수
		 */

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		int n = Integer.parseInt(st.nextToken());
		
		Meeting[] arr = new Meeting[n];
		List<Meeting> list = new ArrayList<>();
//		Meeting m = new Meeting();
		
		for(int i=0; i<n; i++) {
			st = new StringTokenizer(br.readLine());
			int start = Integer.parseInt(st.nextToken());
			int end = Integer.parseInt(st.nextToken());
			
			list.add(new Meeting(start, end));
			
			// 이렇게... 생성자로 넣어줘야 값이 제대로 나오는데 왜일까?
			// 왜 객체 생성해서 값을 넣어주면 3이 나올까..?
			
//			m.start = Integer.parseInt(st.nextToken());
//			m.end = Integer.parseInt(st.nextToken());
//			
//			list.add(m);
			
//			arr[i] = m;
			
		}
		
		// 시작시간 기준 정렬
		// 시작시간이 같다면 종료시간 기준 정렬
		Collections.sort(list, (o1, o2) -> {
			if (o1.start == o2.start) {
				return (o1.end-o2.end);
			}
			else {
				return (o1.start-o2.start);
			}
		});
		
		Queue<Integer> pq = new PriorityQueue<>();
		
		int endTime = 0;
		for(Meeting me : list) {
			endTime = me.end;
			
			if (!pq.isEmpty() && pq.peek() <= me.start) {
				pq.poll();
			}
			pq.add(endTime);
		}
			
		System.out.println(pq.size());
		
	}

}
