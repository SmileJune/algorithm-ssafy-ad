package com.ssafy.yun;

import java.util.Scanner;

public class BOJ_2133 {
	static Scanner sc = new Scanner(System.in);
	static int[] arr, sum;
	static int N;

	public static void main(String[] args) {
		N = sc.nextInt();
		if (N % 2 == 1) {
			System.out.println(0);
			return;
		}

		if (N == 2) {
			System.out.println(3);
			return;
		}

		arr = new int[N + 1];
		sum = new int[N + 1];
		arr[2] = 3;
		arr[4] = 11;
		sum[2] = 3;
		sum[4] = 14;
		for (int i = 6; i <= N; i += 2) {
			arr[i] = arr[i - 2] * 3 + sum[i - 4] * 2 + 2;
			sum[i] = sum[i - 2] + arr[i];
		}

		System.out.println(arr[N]);
	}
}
