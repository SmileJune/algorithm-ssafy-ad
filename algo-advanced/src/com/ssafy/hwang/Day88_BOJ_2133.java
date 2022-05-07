package com.ssafy.hwang;

import java.util.*;

public class Day88_BOJ_2133 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		int N = sc.nextInt();
		
		int[] dp = new int[N+1];
		dp[0] = 1;
		if(N>1) {
			dp[2] = 3;
		}
		
		for(int i = 4; i < N+1; i+=2) {
//			if(i%2!=0) continue;
			dp[i] = dp[i-2]*3;
			for(int j=0; j<=i-4 ; j+=2) {
				dp[i] += dp[j] * 2;
			}
		}
		System.out.println(N%2==0? dp[N] : 0);
	}
}
