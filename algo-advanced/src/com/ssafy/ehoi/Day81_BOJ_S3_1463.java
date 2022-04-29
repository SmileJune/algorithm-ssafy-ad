package com.ssafy.ehoi;

import java.util.Arrays;
import java.util.Scanner;

// 차근차근 다른 dp문제부터 풀어보기
public class Day81_BOJ_S3_1463 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		int INF = Integer.MAX_VALUE;

		int[] dp = new int[n + 1];
		Arrays.fill(dp, INF);

		dp[0] = 0;
		dp[1] = 0;
		for (int i = 2; i <= n; i++) {
			dp[i] = Math.min(i % 3 == 0 ? dp[i / 3] + 1 : INF,
					Math.min(i % 2 == 0 ? dp[i / 2] + 1 : INF, dp[i - 1] + 1));
		}

		System.out.println(dp[n]);
		sc.close();
	}
}
