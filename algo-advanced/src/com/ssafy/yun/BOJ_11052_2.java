package com.ssafy.yun;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ_11052_2 {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static StringTokenizer st;
	static int[] arr, dp;

	public static void main(String[] args) throws NumberFormatException, IOException {
		int N = Integer.parseInt(br.readLine());
		arr = new int[N + 1];
		dp = new int[N + 1];

		st = new StringTokenizer(br.readLine());
		for (int i = 1; i <= N; i++) {
			arr[i] = Integer.parseInt(st.nextToken());
		}

		System.out.println(recur(N));
	}

	private static int recur(int n) {
		if (n == 1)
			return arr[1];
		if (dp[n] != 0)
			return dp[n];

		int max = 0;
		for (int i = 1; i <= n / 2; i++) {
			max = Math.max(max, recur(n - i) + recur(i));
		}
		max = Math.max(max, arr[n]);
		return dp[n] = max;
	}
}
