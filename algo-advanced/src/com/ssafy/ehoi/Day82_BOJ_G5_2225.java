package com.ssafy.ehoi;

import java.util.Scanner;

public class Day82_BOJ_G5_2225 {
	static int dp[][], MOD;

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		int N = sc.nextInt();
		int K = sc.nextInt();

		MOD = 1_000_000_000;

		dp = new int[N + 1][K + 1];
		for (int i = 0; i <= N; i++) {
			for (int j = 0; j <= K; j++) {
				dp[i][j] = -1;
			}
		}

		System.out.println(dp(N, K));
		System.out.println(1496803892 % MOD);

		sc.close();
	}

	private static int dp(int n, int k) {
		if (dp[n][k] != -1)
			return dp[n][k];
		if (k == 1 || n == 0)
			return dp[n][k] = 1;

//		int sum = 0;
//		for (int i = 0; i <= n; i++) {
//			sum += dp[i][k-1] = dp(i, k-1) % MOD;
//		} 

		return dp[n][k] = (dp(n - 1, k) + dp(n, k - 1))%MOD;
	}
}
