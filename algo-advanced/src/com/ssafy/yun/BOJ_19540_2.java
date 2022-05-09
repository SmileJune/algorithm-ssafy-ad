package com.ssafy.yun;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class BOJ_19540_2 {
	static int[] arr;
	static int N, idx;
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static StringTokenizer st;

	public static void main(String[] args) throws IOException {
		N = Integer.parseInt(br.readLine());
		arr = new int[N];

		st = new StringTokenizer(br.readLine());
		for (int i = 0; i < N; i++) {
			arr[i] = Integer.parseInt(st.nextToken());
		}

		System.out.println(solution());
	}

	private static String solution() {
		idx = 0;
		while (idx < arr.length - 1) {
			Arrays.sort(arr);

			if (arr[idx] == 0) {
				idx++;
				continue;
			}

			arr[idx] -= 1;
			arr[arr.length - 1] -= 2;
			if (arr[arr.length - 1] < 0) {
				return "NO";
			}
		}

		if (arr[arr.length - 1] % 3 == 0) {
			return "YES";
		}
		return "NO";
	}

}
