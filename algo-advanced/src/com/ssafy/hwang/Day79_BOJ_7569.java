package com.ssafy.hwang;

import java.io.*;
import java.util.*;

/**
 * 3차원 공간에서 토마토가 모두 익을 때 걸리는 최소시간 출력
 *  층을 조건으로 구분하여 2차원으로 풀어보자
 * 
 * 입력 : M N H ( 가로, 세로, 높이)
 * 		  M * N 크기의 배열이 H번 반복되며 띄어쓰기로 구분되어 입력
 * 		  ( 0 : 익지 않은 토마토, 1 : 익은 토마토, -1 : 토마토가 들어있지 않은 칸 )
 * 
 * 출력 : 토마토가 시작부터 다 익었으면 0
 * 				   모두 익을 수 없다면 -1
 * 				   다 익는다면 최소일수 출력
 * 
 * 접근방식 : 1(익은 토마토)를 기준으로 상,하를 포함한 육방탐색을 해야함.
 *           이때, 1층의 맨 위와 2층의 맨 아래(즉, 인접한 서로다른층)이 탐색되지 않도록해야함
 * 			  접근가능한 범위에서 하 = (r-N), 상 = (r+N)으로 표현하여 2차원으로 탐색하자.
 * 			  입력값중 0이 없다면 바로 0출력 후 종료.
 * 			  
 * 			  이외의 경우에는 너비우선탐색으로 6방탐색을하여 1,-1을 제외한 나머지에 대하여 
 *          현재+1값 입력 (1부터 시작하기 때문에 최종값에 -1)
 * 			  최소값을 구해야하기 때문에 접근하려는 인덱스에 해당하는 값과 
 * 				  입력하려는 값을 비교하여 최소값을 넣어준다.
 * 후기 : 2차원이 더 까다로웠던 것 같다.
 *        Scanner 시간초과 => 버퍼사용
 */

public class Day79_BOJ_7569 {

	static class Point{
		int r;
		int c;
		public Point(int r, int c) {
			this.r = r;
			this.c = c;
		}

	}
	static int N,M,H;
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
	    M = Integer.parseInt(st.nextToken()); //col
	    N = Integer.parseInt(st.nextToken()); //row
	    H = Integer.parseInt(st.nextToken()); //height
		int[] dr = new int[]{-1,1,0,0,-N,N};
		int[] dc = new int[]{0,0,-1,1,0,0};
		int[][] map = new int[N*H][M];
		Queue<Point> q = new LinkedList<>();
		boolean find0=false; // 0을 확인해주는 boolean 

		// 입력으로 들어오는 배열을 그대로 2차원으로 담자
		for(int i =0 ; i<N*H;i++) { 
			st = new StringTokenizer(br.readLine());
			for(int j = 0; j<M;j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
				// 1찾으면 바로바로 q.add
				if(map[i][j]==1) q.add(new Point(i, j));
				if(map[i][j]==0) find0 = true;
				
			}
		}
		// 입력에 0이 없으면 종료 (출력조건)
		if(!find0) {
			System.out.println(0);
			return;
		}
		
		// bfs 시작
		while(!q.isEmpty()) {
			Point p = q.poll();
			int nextDay = map[p.r][p.c]+1; // 현 위치 값+1
			for(int i =0 ; i<6;i++) {
				int nr = p.r + dr[i];
				int nc = p.c + dc[i];

				// 인접한 층이면 continue;
				if(p.r % N == N-1 && nr % N ==0 ) continue;
				if(p.r % N == 0 && nr % N ==N-1 ) continue;

				if(isNotRange(nr,nc))continue;
				if(map[nr][nc] ==0 || map[nr][nc] !=1 || map[nr][nc] !=-1) {
					if(map[nr][nc] !=0 && map[nr][nc] <= nextDay) continue;
					map[nr][nc] = nextDay;
					q.add(new Point(nr,nc));
				}
			}
		}
		// 이번에 0찾으면 결과는 -1 (출력 조건)
		find0 = false;
		int res = 0;
		outer: for (int i = 0; i < N * H; i++) {
			for (int j = 0; j < M; j++) {
				if (map[i][j] == 0) {
					find0 = true;
					break outer;
				}
				if (res < map[i][j]) res = map[i][j];
			}
		}
		System.out.println(find0?-1:res-1);
	}// 메인 메소드 종료


	private static boolean isNotRange(int r, int c) {
		return (r<0 || c<0 || r>=N*H || c>=M);
	}
}