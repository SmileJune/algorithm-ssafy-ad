package com.ssafy.yun;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.PriorityQueue;

public class BOJ_1715 {
	static int N, ans;
	static int[] arr;
	static PriorityQueue<Integer> pq;
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

	public static void main(String[] args) throws NumberFormatException, IOException {
		N = Integer.parseInt(br.readLine());

		pq = new PriorityQueue<>();
		for (int i = 0; i < N; i++) {
			pq.offer(Integer.parseInt(br.readLine()));
		}

		while (pq.size() != 1) {
			int sum = pq.poll() + pq.poll();
			ans += sum;
			pq.offer(sum);
		}
		
		System.out.println(ans);

	}
}
