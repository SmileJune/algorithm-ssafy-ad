package com.ssafy.yun;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class BOJ_2156 {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static int[] dp = new int[10001];
	static int[] arr = new int[10001];

	public static void main(String[] args) throws NumberFormatException, IOException {
		int n = Integer.parseInt(br.readLine());
		for (int i = 1; i <= n; i++) {
			arr[i] = Integer.parseInt(br.readLine());
		}

		dp[1] = arr[1];
		dp[2] = arr[1] + arr[2];
//		dp[3]=
//		dp[4]=
		for (int i = 3; i <= n; i++) {
			int a = dp[n - 2] + arr[n - 2] + arr[n - 1];
			int b1 = dp[n - 5] + arr[n - 3] + arr[n];
			int b2 = dp[n - 4] + arr[n - 3] + arr[n - 2];
			int c = dp[n - 3] + arr[n - 1] + arr[n];
			dp[i] = Math.max(a, Math.max(b1 + b2, c));
		}
	}
}
