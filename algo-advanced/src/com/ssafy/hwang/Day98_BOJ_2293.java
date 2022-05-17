package com.ssafy.hwang;

import java.util.*;

public class Day98_BOJ_2293 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		int N = sc.nextInt();
		int K = sc.nextInt();
		
		int[] arr = new int[N];
		int[] dp = new int[K+1];
		
		arr[0]=1;
		for(int i = 0 ; i < N ; i ++) {
			arr[i] = sc.nextInt();
		}
		
		dp[0] = 1;
		for(int a : arr) {
			for(int i = a; i < K+1; i++ ) {
				dp[i] += dp[i-a];
			}
		}
		System.out.println(dp[K]);
	}
}
