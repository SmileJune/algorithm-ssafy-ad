package com.ssafy.ehoi;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class Day80_BOJ_G4_1715 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		int N = Integer.parseInt(br.readLine()); // 카드 묶음 수

		if (N == 1) {
			System.out.println(0);
			return;
		}

		PriorityQueue<Integer> pq = new PriorityQueue<>();
		for (int i = 0; i < N; i++) {
			pq.add(Integer.parseInt(br.readLine()));
		}

		long cnt = 0;
		while (pq.size() >= 2) { // pq가 두개 이상일 때만!
			int tmp = pq.poll() + pq.poll();
			cnt += tmp;
			pq.add(tmp);
		}

		System.out.println(cnt);

	}
}
