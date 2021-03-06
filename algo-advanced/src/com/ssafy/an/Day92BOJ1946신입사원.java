package com.ssafy.an;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Day92BOJ1946신입사원 { // 1946 신입사원
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		StringTokenizer st = null;
		int T = Integer.parseInt(br.readLine());
		for (int tc = 1; tc <= T; tc++) {
			int N = Integer.parseInt(br.readLine());
			int[] arr = new int[N + 1];
			for (int i = 0; i < N; i++) {
				st = new StringTokenizer(br.readLine());				
				arr[Integer.parseInt(st.nextToken())] = Integer.parseInt(st.nextToken());
			}

			int ans = 1;
			int c = arr[1];
			for (int i = 2; i <= N; i++) {
				if (c > arr[i]) {
					c = arr[i];
					ans++;
				}
			}
			sb.append(ans).append("\n");
		}
		System.out.println(sb);
		br.close();
	}
}
