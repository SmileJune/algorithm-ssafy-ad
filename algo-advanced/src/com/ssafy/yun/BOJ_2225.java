package com.ssafy.yun;

import java.util.Scanner;

public class BOJ_2225 {
	static int[][] dp;
	static int N, K;
	static Scanner sc = new Scanner(System.in);

	public static void main(String[] args) {
		N = sc.nextInt();
		K = sc.nextInt();

		dp = new int[N + 1][K + 1];
		for (int j = 1; j <= K; j++) {
			for (int i = 1; i <= N; i++) {
				if (j == 1) {
					dp[i][j] = 1;
					continue;
				}

				if (i == 1) {
					dp[i][j] = j;
					continue;
				}

				dp[i][j] = (int) ((dp[i - 1][j] + dp[i][j - 1]) % Math.pow(10, 9));

			}
		}

		System.out.println(dp[N][K]);
	}
}
