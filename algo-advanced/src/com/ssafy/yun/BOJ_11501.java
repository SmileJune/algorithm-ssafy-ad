package com.ssafy.yun;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class BOJ_11501 {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

	public static void main(String[] args) throws NumberFormatException, IOException {
		int T = Integer.parseInt(br.readLine());
		for (int tc = 1; tc <= T; tc++) {
			int N = Integer.parseInt(br.readLine());
			String[] input = br.readLine().split(" ");
			int[] arr = new int[input.length];
			for (int i = 0; i < arr.length; i++) {
				arr[i] = Integer.parseInt(input[i]);
			}

			long ans = 0;
			int max = 0;
			for (int i = arr.length - 1; i >= 0; i--) {
				if (arr[i] >= max) {
					max = arr[i];
					continue;
				}

				ans += max - arr[i];
			}
			System.out.println(ans);
		}

	}

}
