package W4_BOJ_1991_트리순회;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

class Node {
	char data;
	Node left;
	Node right;
	
	Node() {}
	
	Node(char data) {
		this.data = data;
	}
	
}


public class Main {
	
	static Node[] nodes;
	static int n;
	
	public static void main(String[] args) throws IOException {
		/* 문제)
		 * 이진 트리를 입력받아 전위 순회(preorder traversal), 중위 순회(inorder traversal), 
		 * 후위 순회(postorder traversal)한 결과를 출력하는 프로그램을 작성하시오.
		 * 
		 * 첫째 줄에는 이진 트리의 노드의 개수 N(1 ≤ N ≤ 26)이 주어진다.
		 * 둘째 줄부터 N개의 줄에 걸쳐 각 노드와 그의 왼쪽 자식 노드, 오른쪽 자식 노드가 주어진다.
		 * 노드의 이름은 A부터 차례대로 알파벳 대문자로 매겨지며, 항상 A가 루트 노드가 된다. 
		 * 자식 노드가 없는 경우에는 .으로 표현
		 */
		
		/* 설계)
		 * 루트에 저장하고, 해당 루트를 찾아서 왼쪽, 오른쪽 값 넣어주기
		 */
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		n = Integer.parseInt(st.nextToken());
//		st = new StringTokenizer(br.readLine());
		
		nodes = new Node[n+1];
		
//		for(int i=1; i<=n; i++) {
//			nodes[i] = new Node((char)(i+64));
//		}
		
		for(int i=1; i<=n; i++) {
			String input[] = br.readLine().split(" ");
			System.out.println(Arrays.toString(input));
			char char1 = input[0].charAt(0);
			char char2 = input[1].charAt(0);
			char char3 = input[2].charAt(0);
			
//			nodes[i] = new Node(char1);
			
			if (nodes[char1-'A'] == null) {
				nodes[char1-'A'] = new Node(char1);
			}
			
//			System.out.print(i+"-"+nodes[i].data+"/");
			
			if (char2 != '.') {
				nodes[i].left = new Node(char2);
				System.out.print(nodes[i].left.data+"/");
			}
			else {
				nodes[i].left = new Node('0');
				System.out.print(nodes[i].left.data+"/");
			}
			
			if (char3 != '.' ) {
				nodes[i].right = new Node(char3);
				System.out.print(nodes[i].right.data);
			}
			else {
				nodes[i].right = new Node('0');
				System.out.print(nodes[i].right.data);
			}
			System.out.println();
			
		}
		
		
		
		preorder(1);
		System.out.println();
		
	}
	
	
	// 전위 순회
	static void preorder(int i) {
		// 기저조건
		if (i >= nodes.length || nodes[i] == null) {
			return;
		}
		
		if (nodes[i].data != '0') {
			System.out.print(nodes[i].data);
		}
		
		preorder(i*2);
		preorder(i*2+1);
		
	}

}
