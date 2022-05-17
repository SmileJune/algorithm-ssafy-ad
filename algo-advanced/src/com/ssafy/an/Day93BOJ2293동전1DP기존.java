package com.ssafy.an;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Day93BOJ2293동전1DP기존 { // 2293 동전, 기존에 풀었던 것이어서 그대로 올립니다.
	static int N, K;
	static int[] arr;
	static int[] dp;

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String[] str = br.readLine().split(" ");
		N = Integer.parseInt(str[0]);
		K = Integer.parseInt(str[1]);

		arr = new int[N];
		for (int i = 0; i < N; i++)
			arr[i] = Integer.parseInt(br.readLine());
		dp = new int[K + 1];

		// dp[10] = dp[9] + dp[8] + dp[5]
		// dp[9] = dp[8] + dp[7] + dp[4]
		// dp[8] = dp[7] + dp[6] + dp[3]
		// dp[7] = dp[6] + dp[5] + dp[2]
		// dp[6] = dp[5] + dp[4] + dp[1]
		// dp[5] = dp[4] + dp[3] + dp[0]
		// dp[4] = dp[3] + dp[2]
		// dp[3] = dp[2] + dp[1]
		// dp[2] = dp[1] + dp[0]
		// dp[1] = dp[0]
		// dp[0] = 1
		// dp[k] = dp[k-1] + dp[k-2] + dp[k-5]
		// dp[k] = dp[k-arr[0] + dp[k-arr[1]] + dp[k-arr[2]]

		dp[0] = 1;
		for (int a : arr) {
			for (int k = a; k < K + 1; k++) {
				dp[k] += dp[k - a];
			}
			System.out.println(Arrays.toString(dp).replaceAll("[\\[\\],]", ""));
		}

		System.out.println(dp[K]);
		br.close();
	}
	
	// 아래는 당시에 풀고 나서 숏코딩을 참조하여 수정한 부분
	static int N2, K2;
	static int[] dp2;

	public static void BestSol() throws Exception {
		BufferedReader br2 = new BufferedReader(new InputStreamReader(System.in));
		String[] str2 = br2.readLine().split(" ");
		N2 = Integer.parseInt(str2[0]);
		K2 = Integer.parseInt(str2[1]);

		dp2 = new int[K2 + 1];
		dp2[0] = 1;

		for (int i = 0; i < N2; i++) {
			int a = Integer.parseInt(br2.readLine()); // << 여기
			for (int k = a; k < K2 + 1; k++) {
				dp2[k] += dp2[k - a];
			}
		} // 입력과 동시에 사용.. 대단한 사람들..

		System.out.println(dp2[K2]);
		br2.close();
	}
}
// 1 : 1
// 2 : 11 2
// 3 : 12 21
// 4 : 1111 