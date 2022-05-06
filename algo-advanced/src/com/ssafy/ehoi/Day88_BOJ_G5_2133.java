package com.ssafy.ehoi;

import java.util.Scanner;

public class Day88_BOJ_G5_2133 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		int N = sc.nextInt();
		int[] dp = new int[N + 1];
		if (N % 2 == 1) {
			System.out.println(0);
			sc.close();
			return;
		}
		
		dp[0] = 1;
		dp[2] = 3;
		
		for (int i = 4; i <= N; i = i + 2) {
			dp[i] += dp[i-2];
			for (int j = 2; j <= i; j = j + 2) {
				dp[i] += dp[i - j] * 2;
			}
		}
		
		System.out.println(dp[N]);

		sc.close();
	}
}
