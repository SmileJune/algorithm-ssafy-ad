package com.ssafy.an;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.StringTokenizer;


public class BOJ2583영역구하기BFS { // 2583 영역구하기
	static int N, M, K;
	static int[] dr = { -1, 1, 0, 0 }, dc = { 0, 0, -1, 1 };
	static List<Integer> ans;
	static Queue<int[]> q;
	static boolean[][] map;

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		StringBuilder sb = new StringBuilder();
		M = Integer.parseInt(st.nextToken());
		N = Integer.parseInt(st.nextToken()); // 순서
		K = Integer.parseInt(st.nextToken());
		ans = new ArrayList<>();

		map = new boolean[N][M];
		for (int k = 0; k < K; k++) {
			st = new StringTokenizer(br.readLine());
			int r1 = Integer.parseInt(st.nextToken());
			int c1 = Integer.parseInt(st.nextToken());
			int r2 = Integer.parseInt(st.nextToken());
			int c2 = Integer.parseInt(st.nextToken());

			for (int i = r1; i < r2; i++) {
				for (int j = c1; j < c2; j++) {
					map[i][j] = true;
				} // 선택된 범위 체크, 나머지 구역 번호 메길 예정
			}
		}

		for (int i = 0; i < map.length; i++) {
			for (int j = 0; j < map[i].length; j++) {
				if (!map[i][j])
					bfs(i, j);
			}
		}

		sb.append(ans.size()).append("\n"); // 나뉜 구역 수

		Collections.sort(ans);
		for (int a : ans)
			sb.append(a).append(" "); // 오름차순 출력

		System.out.println(sb);
		br.close();
	}

	private static void bfs(int idx, int jdx) {
		q = new LinkedList<>(); // bfs 델타탐색

		q.add(new int[] { idx, jdx, 0 });
		map[idx][jdx] = true;

		int cnt = 0;
		while (!q.isEmpty()) {
			int[] a = q.poll();
			cnt++;

			for (int i = 0; i < 4; i++) {
				int nr = a[0] + dr[i];
				int nc = a[1] + dc[i];

				if (index(nr, nc)) // 범위 체크
					continue;

				if (!map[nr][nc]) { // 방문한적 없으면,
					map[nr][nc] = true;
					q.add(new int[] { nr, nc, a[2] });
				}
			}
		}
		ans.add(cnt); // 현재구역 갯수 추가
	}

	static boolean index(int nr, int nc) {
		return nr < 0 || nr >= map.length || nc < 0 || nc >= map[0].length;
	}
}
