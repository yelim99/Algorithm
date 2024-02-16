package W4_BOJ_11725_트리의부모찾기;

import java.util.Scanner;

class Node {
	int data;
	Node left;
	Node right;
	
	Node() {}
	
	Node(int data) {
		this.data = data;
	}
	
}

public class Main2 {
	
	static Node[] nodes;
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		int n = sc.nextInt();
		
		nodes = new Node[n+1];
		nodes[1] = new Node(1);
		nodes[2] = new Node(sc.nextInt());
		nodes[2].left = new Node(sc.nextInt());
		
		for(int i=2; i<=n; i++) {
			nodes[i] = new Node();
			nodes[i].data = i;
		}
		
		
		for(int i=3; i<=n; i++) {
			int x = sc.nextInt();
			int y = sc.nextInt();
			
			if (nodes[x].left == null) {
				nodes[x].left = nodes[y];
			}
			else {
				nodes[x].right = nodes[y];
			}
			
			
			
			
//			for(int j=1; j<=n; j++) {
//				if (x == nodes[j].data) {
//					if (nodes[x].left == null) {
//						nodes[x].left = nodes[y];
//					}
//					else {
//						nodes[x].right = nodes[y];
//					}
//				}
//				else if (y == nodes[j].data) {
//					if (nodes[y].right == null) {
//						nodes[y].right = nodes[y];
//					}
//					else {
//						nodes[y].right = nodes[y];
//					}
//				}
//				
//			}
			
		}
		
		// 부모 노드의 번호 구하기..
		for(int i=1; i<n; i++) {
			int child = 2;
			if (nodes[i].left.data==child || nodes[i].right.data==child) {
				System.out.println(i);
			}
			child++;
		}
		
		

	}

}
