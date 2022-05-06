package com.ssafy.yun;

import java.util.Scanner;

public class BOJ_11727 {
	static Scanner sc = new Scanner(System.in);
	static int[] arr;
	static int N;

	public static void main(String[] args) {
		N = sc.nextInt();
		arr = new int[N + 1];
		arr[0] = 1;
		arr[1] = 1;

		for (int i = 2; i <= N; i++) {
			arr[i] = (arr[i - 1] + arr[i - 2] * 2) % 10007;
		}
		
		System.out.println(arr[N]);
	}
}
