package com.ssafy.hwang;

import java.util.*;

public class Day87_BOJ_11727 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int N = sc.nextInt();

        int[] dp = new int[N+1];
        dp[0] = 0;
        dp[1] = 1;
        if(N>1) {
            dp[2] = 3;
        }
        for(int i =3 ; i<N+1;i++) {
            dp[i] = (dp[i-1]+ 2*dp[i-2]) % 10007;
        }

        System.out.println(dp[N]);
    }
}