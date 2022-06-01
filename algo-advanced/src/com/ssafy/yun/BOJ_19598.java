package com.ssafy.yun;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class BOJ_19598 {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static StringTokenizer st;
	static PriorityQueue<Integer> pq;
	static int N;

	static class Node implements Comparable<Node> {
		int start;
		int end;

		Node(int start, int end) {
			this.start = start;
			this.end = end;
		}

		@Override
		public int compareTo(Node o) {
			return this.start - o.start;
		}

		@Override
		public String toString() {
			return "Node [start=" + start + ", end=" + end + "]";
		}
		
		
	}

	public static void main(String[] args) throws NumberFormatException, IOException {
		N = Integer.parseInt(br.readLine());
		List<Node> list = new ArrayList<>();
		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			list.add(new Node(Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken())));
		}
		//start 기준으로 정렬
		Collections.sort(list);
//		System.out.println(list);
		
		pq = new PriorityQueue<>();
		pq.offer(0);
		for(Node node : list) {
			if(pq.peek() <= node.start) {
				pq.poll();
			}
			pq.offer(node.end);
		}
		
		System.out.println(pq.size());
	}
}
