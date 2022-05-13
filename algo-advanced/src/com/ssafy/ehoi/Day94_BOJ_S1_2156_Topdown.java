package com.ssafy.ehoi;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Day94_BOJ_S1_2156_Topdown {
	static int n, wine[], dp[][];
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		// 포도주의 잔의 개수
		n = Integer.parseInt(br.readLine());
		// 포도주 배열 생성
		wine = new int[n];
		dp = new int[n][3];
		// 배열 입력받기
		for (int i = 0; i < n; i++) {
			wine[i] = Integer.parseInt(br.readLine());
			
			// 메모이제이션용 dp 초기화
			for (int j = 0; j < 3; j++) {
				dp[i][j] = -1;
			}
		}
		
		// 아 탑다운에서는 초기화 필요없구나
//		dp[0][1] = wine[0];
		
		int ans = 0;
		for (int i = 0; i < 3; i++) {
			// ans는 n-1번째 잔의 세가지 경우의 수 중에 최대 값
			ans = Math.max(ans, recur(n-1, i));
		}
		
		System.out.println(ans);
		
	}
	private static int recur(int N, int cnt) {
		// base
		if(N < 0) return 0; 
		
		// memoization
		if(dp[N][cnt] != -1) return dp[N][cnt];
		
		// recur
		if(cnt == 0) {
			return dp[N][cnt] = Math.max(Math.max(recur(N-1, 0), recur(N-1, 1)), recur(N-1, 2));
		} else if (cnt == 1) {
			return dp[N][cnt] = recur(N-1, 0) + wine[N];
		} else {
			return dp[N][cnt] = recur(N-1, 1) + wine[N];
		}
		
	}
}
