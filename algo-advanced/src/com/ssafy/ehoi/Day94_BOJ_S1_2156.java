package com.ssafy.ehoi;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Day94_BOJ_S1_2156 {
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		// 포도주의 잔의 개수
		int n = Integer.parseInt(br.readLine());
		// 포도주 배열 생성
		int[] wine = new int[n + 1];
		// 배열 입력받기
		for (int i = 1; i <= n; i++) {
			wine[i] = Integer.parseInt(br.readLine());
		}
		int[][] dp = new int[n + 1][3];
		// 첫번째 잔을 연속으로 한잔 마시는 경우 와인을 마신 양은 wine[1]과 같다
		// dp[1][0] = 0, dp[1][2] = 0
		dp[1][1] = wine[1];
		
		for (int i = 2; i<= n; i++) {
			// i번째 포도주를 연속으로 0잔 마시는 경우 : 안 마시는 경우
			// 직전 마셨던 포도주의 양 중 최댓값으로 갱신
			dp[i][0] = Math.max(Math.max(dp[i-1][0], dp[i-1][1]), dp[i-1][2]);
			// i번째 포도주를 연속으로 1잔 마시는 경우 -> 직전 포도주를 안 마신 경우
			dp[i][1] = dp[i-1][0] + wine[i];
			// i번째 포도주를 연속으로 2잔 마시는 경우 -> 직전 포도주를 한잔 마신 경우
			dp[i][2] = dp[i-1][1] + wine[i];
		}
		
		System.out.println(Math.max(dp[n][0], Math.max(dp[n][1], dp[n][2])));
		
	}
}
