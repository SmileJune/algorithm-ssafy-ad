package com.ssafy.yun;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class BOJ_2293_2 {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static StringTokenizer st;
	static int[] arr, coins;
	static int n, k;

	public static void main(String[] args) throws IOException {
		st = new StringTokenizer(br.readLine());
		n = Integer.parseInt(st.nextToken());
		k = Integer.parseInt(st.nextToken());

		arr = new int[k + 1];
		coins = new int[n];

		for (int i = 0; i < coins.length; i++) {
			coins[i] = Integer.parseInt(br.readLine());
		}

		Arrays.sort(coins);
		arr[0] = 1;
		for (int i = 0; i < coins.length; i++) {
			for (int j = coins[i]; j < arr.length; j++) {
				arr[j] += arr[j - coins[i]];
			}
		}

		System.out.println(arr[k]);
	}
}
