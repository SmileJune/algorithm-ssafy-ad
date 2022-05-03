package com.ssafy.ehoi;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Day84_BOJ_G3_11066 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = null;

		int T = Integer.parseInt(br.readLine());

		for (int tc = 1; tc <= T; tc++) {
			int K = Integer.parseInt(br.readLine()); // 챕터 수

			st = new StringTokenizer(br.readLine()); // 챕터당 파일 크기 입력

			int[] arr = new int[K + 1]; // 파일 크기를 입력 받을 배열이다
			int[] sum = new int[K + 1]; // i번째까지의 파일 크기의 합을 저장할 배열이다
			int[][] dp = new int[K + 2][K + 2]; // i번째부터 j번째까지의 합친 파일 크기의 최솟값을 저장할 배열이다
			for (int i = 1; i <= K; i++) {
				arr[i] = Integer.parseInt(st.nextToken());
				sum[i] = sum[i - 1] + arr[i];
			} // 입력 끄읕

			for (int j = 2; j <= K; j++) {
				for (int i = j - 1; i >= 1; i--) {
					dp[i][j] = 987654321; // 최솟값을 비교하기 위해 최대값을 저장해둔다
					for (int s = i; s <= j; s++) { // 변수 s가 i번째부터 j번째까지 훑는다
						dp[i][j] = Math.min(dp[i][j], dp[i][s] + dp[s + 1][j]);
					}

					dp[i][j] += sum[j] - sum[i - 1];
				}
			}
			
			System.out.println(dp[1][K]);

		}
	}
}
