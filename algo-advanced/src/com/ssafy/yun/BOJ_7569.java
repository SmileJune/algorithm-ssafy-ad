package com.ssafy.yun;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class BOJ_7569 {
	static class Node {
		int x;
		int y;
		int z;
		int day;

		public Node(int x, int y, int z, int day) {
			super();
			this.x = x;
			this.y = y;
			this.z = z;
			this.day = day;
		}
	}

	static Queue<Node> q;
	static int[][][] map;
	static int N, M, H;
	static int ans;

	static Scanner sc = new Scanner(System.in);

	public static void main(String[] args) {
		M = sc.nextInt();
		N = sc.nextInt();
		H = sc.nextInt();
		map = new int[N][M][H];
		q = new LinkedList<>();
		for (int k = 0; k < H; k++) {
			for (int i = 0; i < N; i++) {
				for (int j = 0; j < M; j++) {
					map[i][j][k] = sc.nextInt();
					// 익은것들 넣어주기!
					if (map[i][j][k] == 1)
						q.add(new Node(i, j, k, 0));
				}
			}
		}

		bfs();
		// bfs돌고 나서 0이 존재한다면 return -1

		for (int k = 0; k < H; k++) {
			for (int i = 0; i < N; i++) {
				for (int j = 0; j < M; j++) {
					if (map[i][j][k] == 0) {
						System.out.println(-1);
						return;
					}
				}
			}
		}

		// 다 익었다면 return ans;
		System.out.println(ans);
	}

	static int[] dx = { 1, -1, 0, 0, 0, 0 };
	static int[] dy = { 0, 0, -1, 1, 0, 0 };
	static int[] dz = { 0, 0, 0, 0, -1, 1 };

	private static void bfs() {
		while (!q.isEmpty()) {
			Node node = q.poll();
			ans = node.day;

			for (int d = 0; d < 6; d++) {
				int nx = node.x + dx[d];
				int ny = node.y + dy[d];
				int nz = node.z + dz[d];

				if (!isInRange(nx, ny, nz))
					continue;

				if (map[nx][ny][nz] == 0) {
					map[nx][ny][nz] = 1;
					q.add(new Node(nx, ny, nz, node.day + 1));
				}
			}
		}
	}

	private static boolean isInRange(int x, int y, int z) {
		return !(x < 0 || N <= x || y < 0 || M <= y || z < 0 || H <= z);
	}
}
