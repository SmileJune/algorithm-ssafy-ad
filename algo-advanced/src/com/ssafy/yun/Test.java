package com.ssafy.yun;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Test {
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
		for (int i = 1; i <= k; i++) {
			for (int j = 0; j < coins.length; j++) {
				if (i - coins[j] < 0)
					break;
				arr[i] += arr[i - coins[j]];
			}
			System.out.println(Arrays.toString(arr).replaceAll("[\\[\\],]", ""));
		}
		System.out.println(arr[k]);
	}
}