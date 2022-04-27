package com.ssafy.ehoi;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

// 3차원
// bfs
public class Day79_BOJ_G5_7569 {
	static int M, N, H, map[][][];

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());

		M = Integer.parseInt(st.nextToken()); // 가로 칸의 수
		N = Integer.parseInt(st.nextToken()); // 세로 칸의 수
		H = Integer.parseInt(st.nextToken()); // 높이의 수

		map = new int[H][N][M]; // 높이, 세로, 가로 순

		Queue<int[]> q = new LinkedList<>();
		boolean flag = true; // 다 익었을 거야
		for (int k = 0; k < H; k++) { // 높이
			for (int i = 0; i < N; i++) { // 세로
				st = new StringTokenizer(br.readLine());
				for (int j = 0; j < M; j++) { // 가로
					map[k][i][j] = Integer.parseInt(st.nextToken());
					if (map[k][i][j] == 0)
						flag = false; // 안 익었구나
					
				}
			}
		}
		
		// 0인 토마토가 없다 = 이미 다 익었다 = flag가 여전히 true다 = 0을 출력
		if (flag) {
			System.out.println(0);
		} else { // 0인 토마토가 하나라도 있다 그러면 bfs 돌려야해
			bfs();
			// 0인 토마토가 있는지 검사 : 있다면 -1을 출력
			// 다 익혔다면 최댓값 - 1 을 출력
			System.out.println(made() ? max - 1 : -1);
		}

	}

	/**
	 * @return 토마토가 다 익으면 = 0이 없으면 true를 리턴
	 */
	private static boolean made() {
		for (int k = 0; k < H; k++) { // 높이
			for (int i = 0; i < N; i++) { // 세로
				for (int j = 0; j < M; j++) { // 가로
					if (map[k][i][j] == 0) {
						return false; // 어 안익었다 바로 false 리턴
					}
				}
			}
		}
		return true;
	}

	// 위층 아래층 상 하 좌 우
	static int[] dh = { 1, -1, 0, 0, 0, 0 };
	static int[] dr = { 0, 0, -1, 1, 0, 0 };
	static int[] dc = { 0, 0, 0, 0, -1, 1 };
	static int max = 0;

	// 전체 순회를 하면서 1인 애들을 모두 큐에 담고
	// 탐색을 하면서 0인 토마토를 현재 숫자에서 +1을 먹여서 저장하고
	private static void bfs() {
		Queue<int[]> q = new LinkedList<>();
		for (int k = 0; k < H; k++) {
			for (int i = 0; i < N; i++) {
				for (int j = 0; j < M; j++) {
					if (map[k][i][j] == 1) // 익은 토마토 먼저 싹 다 넣어
						q.add(new int[] { k, i, j });
				}
			}
		}

		while (!q.isEmpty()) {
			int[] curr = q.poll();
			int currH = curr[0];
			int currR = curr[1];
			int currC = curr[2];

			for (int d = 0; d < 6; d++) {
				int nh = currH + dh[d];
				int nr = currR + dr[d];
				int nc = currC + dc[d];

				// 범위 체크
				if (nh < 0 || nh >= H || nr < 0 || nr >= N || nc < 0 || nc >= M || map[nh][nr][nc] != 0)
					continue;
				q.add(new int[] { nh, nr, nc });
				max = map[nh][nr][nc] = map[currH][currR][currC] + 1;
			}

		}
	}
}
