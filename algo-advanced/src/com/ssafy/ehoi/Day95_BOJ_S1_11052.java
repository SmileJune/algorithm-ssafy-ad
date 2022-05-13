package com.ssafy.ehoi;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Day95_BOJ_S1_11052 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());

		int N = Integer.parseInt(st.nextToken());
		int[] p = new int[N + 1];
		st = new StringTokenizer(br.readLine());
		for (int i = 1; i <= N; i++) {
			p[i] = Integer.parseInt(st.nextToken());
		}

		int[] dp = new int[N + 1];
		dp[1] = p[1];
		for (int i = 2; i <= N; i++) {
			dp[i] = p[i];
			for (int j = i - 1; j >= 1; j--) {
				dp[i] = Math.max(dp[i], dp[i - j] + dp[j]);
			}
		}

		System.out.println(dp[N]);
	}
}
