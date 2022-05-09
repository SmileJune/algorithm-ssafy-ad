package com.ssafy.ehoi;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Day91_BOJ_S1_19539 {
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;

		int N = Integer.parseInt(br.readLine());
		int[] arr = new int[N];

		st = new StringTokenizer(br.readLine());
		int[] ans = new int[2];
		for (int i = 0; i < N; i++) {
			arr[i] = Integer.parseInt(st.nextToken());
			ans[0] += arr[i] % 2; // 1에는 2로 나눈 나머지의 값을
			ans[1] += arr[i] / 2; // 2에는 2로 나눈 몫의 값을 넣는다
		}

		String ok = "NO";
		if (ans[1] >= ans[0]) {
			if ((ans[1] - ans[0]) % 3 == 0) {
				ok = "YES";
			}
		}

		System.out.println(ok);

	}
}
