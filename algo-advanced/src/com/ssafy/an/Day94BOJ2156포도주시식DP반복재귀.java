package com.ssafy.an;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Day94BOJ2156포도주시식DP반복재귀 { // 2156 포도주 시식 
	static int N; 
	static int[] arr;
	static Integer[] dp;

	// 72일차에 재귀로 푼 문제여서, 반복으로 올립니다. 
	// 차이는 없습니다.
	
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(br.readLine());
		arr = new int[N];
		dp = new Integer[N];

		for (int i = 0; i < N; i++)
			arr[i] = Integer.parseInt(br.readLine());
		dp[0] = arr[0];
		if (N > 1)
			dp[1] = arr[0] + arr[1];
		if (N > 2)
			dp[2] = Math.max(dp[1], Math.max(dp[0] + arr[2], arr[1] + arr[2]));
		for (int i = 3; i < N; i++) // 반복
			dp[i] = Math.max(dp[i - 1], Math.max(dp[i - 2] + arr[i], dp[i - 3] + arr[i - 1] + arr[i]));

		System.out.println(recur(N - 1));
		br.close();
	}

	private static int recur(int n) { // 재귀
		if (dp[n] == null)
			dp[n] = Math.max(recur(n - 1), Math.max(recur(n - 2) + arr[n], recur(n - 3) + arr[n - 1] + arr[n]));
		return dp[n];
	}
}
