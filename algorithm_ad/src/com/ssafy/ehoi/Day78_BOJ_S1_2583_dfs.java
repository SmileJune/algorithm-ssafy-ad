package com.ssafy.ehoi;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

// dfs
public class Day78_BOJ_S1_2583_dfs {
	static int map[][], N, M, cnt;
	static PriorityQueue<Integer> pq;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());

		M = Integer.parseInt(st.nextToken()); // 행
		N = Integer.parseInt(st.nextToken()); // 열
		int K = Integer.parseInt(st.nextToken()); // 직사각형 갯수

		map = new int[M][N];
		for (int k = 0; k < K; k++) {
			st = new StringTokenizer(br.readLine());
			int c1 = Integer.parseInt(st.nextToken());
			int r1 = Integer.parseInt(st.nextToken());
			int c2 = Integer.parseInt(st.nextToken());
			int r2 = Integer.parseInt(st.nextToken());

			for (int i = r1; i < r2; i++) {
				for (int j = c1; j < c2; j++) {
					map[i][j] = 1;
				}
			}
		}

//		System.out.println(Arrays.deepToString(map));
		pq = new PriorityQueue<>();
		for (int i = 0; i < M; i++) {
			for (int j = 0; j < N; j++) {
				if (map[i][j] == 0) {
					cnt = 0;
					dfs(i, j);
					pq.add(cnt);
				}
			}
		}

		System.out.println(pq.size());
		while (!pq.isEmpty()) {
			System.out.print(pq.poll() + " ");
		}
	}

	static int[] dr = { -1, 1, 0, 0 };
	static int[] dc = { 0, 0, -1, 1 };

	private static void dfs(int r, int c) {
		map[r][c] = 1;
		cnt++;

		for (int d = 0; d < 4; d++) {
			int nr = r + dr[d];
			int nc = c + dc[d];

			if (nr < 0 || nr >= M || nc < 0 || nc >= N || map[nr][nc] == 1)
				continue;
			dfs(nr, nc);
		}

	}
}
