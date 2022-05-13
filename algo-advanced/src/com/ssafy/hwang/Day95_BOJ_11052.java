package com.ssafy.hwang;

import java.util.*;

public class Day95_BOJ_11052 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int N = sc.nextInt();
        int[] arr = new int[N+1];
        for(int i =1 ; i<=N;i++){
            arr[i] = sc.nextInt();
        }
        int[] dp = new int[N+1];


        dp[1] = arr[1];
        if(N>1){
            dp[2] = Math.max(dp[1]+dp[1], arr[2]);
        }
        for(int i =3; i <= N; i++){
            for(int j =1 ; j <= i/2; j++){
                dp[i] = Math.max(dp[i-j]+dp[j],dp[i]);
            }
            dp[i] = Math.max(dp[i],arr[i]);

        }
        System.out.println(dp[N]);
    }
}