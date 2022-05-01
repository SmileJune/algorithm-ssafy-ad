package com.ssafy.hwang;

import java.util.*;

public class Day82_BOJ_2225 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        int K = sc.nextInt();
        
        int[][] dp = new int[N+1][K+1];
        // N이 0일때 모든 K에 대하여 합분해는 1
        // 0 4 : 0 0 0 0
        for(int i =1;i<=K;i++){
            dp[0][i] = 1;
        }
        // K가 1일때 모든 N에 대하여 합분해는 1
        // 4 1 : 4
        for(int i=0;i<=N;i++){
            dp[i][1] = 1;
        }
        
        for(int i=1;i<=N;i++){
            for(int j =2;j<=K;j++){
            		// 여기가 점화식 부분
                dp[i][j] = dp[i-1][j] + dp[i][j-1]; 
                dp[i][j] %= 1000000000; // 출력 조건 : mod(10^9) 
            }
        }
        System.out.println(dp[N][K]);
    }

}

