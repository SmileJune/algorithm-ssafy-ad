package com.ssafy.yun;

import java.util.ArrayList;
import java.util.Collections;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.Scanner;

public class BOJ_2583 {

	static class Node {
		int r;
		int c;

		public Node(int r, int c) {
			super();
			this.r = r;
			this.c = c;
		}
	}

	static int[] dr = { -1, 1, 0, 0 };
	static int[] dc = { 0, 0, -1, 1 };
	static int[][] map;
	static int cnt, N, M, K;
	static Queue<Node> q;
	static List<Integer> list;
	static Scanner sc = new Scanner(System.in);

	public static void main(String[] args) {

		M = sc.nextInt();
		N = sc.nextInt();
		K = sc.nextInt();

		list = new ArrayList<>();
		map = new int[N][M];
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < M; j++) {
				map[i][j] = 1;
			}
		}

		for (int i = 0; i < K; i++) {
			int r1 = sc.nextInt();
			int c1 = sc.nextInt();
			int r2 = sc.nextInt();
			int c2 = sc.nextInt();

			for (int j = r1; j < r2; j++) {
				for (int k = c1; k < c2; k++) {
					map[j][k] = 0;
				}
			}
		}

		bfs();
		Collections.sort(list);

		StringBuffer sb = new StringBuffer();
		sb.append(list.size()).append("\n");
		for (int cnt : list) {
			sb.append(cnt).append(" ");
		}
		System.out.println(sb);
	}

	private static void bfs() {
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < M; j++) {
				if (map[i][j] != 0) {
					q = new LinkedList<>();
					cnt = 0;
					q.add(new Node(i, j));
					map[i][j] = 0;

					while (!q.isEmpty()) {
						Node node = q.poll();
						cnt++;

						for (int d = 0; d < 4; d++) {
							int nr = node.r + dr[d];
							int nc = node.c + dc[d];

							if (!isInRange(nr, nc))
								continue;

							if (map[nr][nc] == 0)
								continue;

							q.offer(new Node(nr, nc));
							map[nr][nc] = 0;
						}
					}

					list.add(cnt);
				}
			}
		}

	}

	static boolean isInRange(int r, int c) {
		if (r < 0 || N <= r || c < 0 || M <= c)
			return false;
		return true;
	}

}
