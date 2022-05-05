package com.ssafy.ehoi;

import java.util.Scanner;

public class Day86_BOJ_S3_11726 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		int n = sc.nextInt();
		int[] dp = new int[n+1];
		int MOD = 10_007;
		
		dp[0] = 1;
		dp[1] = 1;
		for (int i = 2; i <= n; i++) {
			dp[i] = (dp[i-1] + dp[i-2]) % MOD;
		}
		
		System.out.println(dp[n]);
		
		sc.close();
	}
}
