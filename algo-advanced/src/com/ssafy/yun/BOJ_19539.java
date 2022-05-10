package com.ssafy.yun;

import java.util.Arrays;
import java.util.Scanner;

public class BOJ_19539 {
	static int[] arr;
	static int N, idx;
	static Scanner sc = new Scanner(System.in);

	public static void main(String[] args) {
		N = sc.nextInt();
		arr = new int[N];

		for (int i = 0; i < N; i++) {
			arr[i] = sc.nextInt() % 6;
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
