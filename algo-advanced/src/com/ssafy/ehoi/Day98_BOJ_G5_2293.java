package com.ssafy.ehoi;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Day98_BOJ_G5_2293 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());

		int n = Integer.parseInt(st.nextToken()); // n가지 종류의 동전
		int k = Integer.parseInt(st.nextToken()); // k원

		int[] dp = new int[k + 1];
		int[] coin = new int[n];
		
		for (int i = 0; i < n; i++) {
			coin[i] = Integer.parseInt(br.readLine());
		}
		
		dp[0] = 1;
		for (int j = 0; j < n; j++) {
			for (int i = coin[j]; i <= k; i++) {
				dp[i] += dp[i - coin[j]];
			}
		}
		
		System.out.println(dp[k]);
	}
}
