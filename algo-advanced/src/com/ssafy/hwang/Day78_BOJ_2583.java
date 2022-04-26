package com.ssafy.hwang;

import java.util.ArrayList;
import java.util.Collections;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.Scanner;

public class Day78_BOJ_2583 {
	static class Point {
		int r;
		int c;

		public Point(int r, int c) {
			this.r = r;
			this.c = c;
		}

	}

	static boolean map[][];
	static List<Integer> sizeS;
	static int M, N;

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		M = sc.nextInt();
		N = sc.nextInt();
		int K = sc.nextInt();
		// 인덱스 0번부터 쓰자
		map = new boolean[N][M]; // 입력겸 체크겸.. 동시에 가능할듯

		// 왼아래 오른위 위치 저장해주는 배열
		int[] tmp = new int[4];
		for (int repeat = 0; repeat < K; repeat++) { // 주어지는 직사각형 수만큼 반복
			for (int data = 0; data < 4; data++) {
				tmp[data] = sc.nextInt();
			}

			for (int i = tmp[0]; i < tmp[2]; i++) { // 높이
				for (int j = tmp[1]; j < tmp[3]; j++) { // 너비
					map[i][j] = true;
				}
			}

		}
		int cnt = 0; // 분리된 공간 수
		sizeS = new ArrayList<>(); // 담아주자 공간별 크기를

		for (int i = 0; i < N; i++) {
			for (int j = 0; j < M; j++) {
				if (map[i][j])
					continue;
				map[i][j] = true;
				cnt++;
				bfs(i, j);
			}
		}
		Collections.sort(sizeS);
		System.out.println(cnt);
		for(int i =0 ; i<sizeS.size();i++) {
			System.out.print(sizeS.get(i)+" ");
		}
		
	}// 메인 메서드 종료

	static int[] dr = { -1, 1, 0, 0 };
	static int[] dc = { 0, 0, -1, 1 };

	private static void bfs(int r, int c) {
		int cnt = 0; // 각 공간의 크기 담아줄 변수
		Queue<Point> q = new LinkedList<>();
		q.add(new Point(r, c));
		while (!q.isEmpty()) {
			Point p = q.poll();
			for (int i = 0; i < 4; i++) {
				int nr = p.r + dr[i];
				int nc = p.c + dc[i];
				// 조건 걸때 순서 잘챙기셔
				if (isNotRange(nr, nc)) continue;
				if (map[nr][nc]) continue;
				map[nr][nc] = true;
				cnt++;
				q.add(new Point(nr, nc));
			}

		}
		sizeS.add(cnt+1); // 맨처음 들어오는애 안세줘서 +1
	}

	private static boolean isNotRange(int r, int c) {
		if (r < 0 || c < 0 || r >= N || c >= M)
			return true;
		return false;
	}
}