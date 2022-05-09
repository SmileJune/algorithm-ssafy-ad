package com.ssafy.hwang;

import java.util.*;

/**
 * @author kwan
 * 조건1. 모든 수의 합 %3 ==0 이어야함 (3의 배수)
 * 조건2. cnt1 <= cnt2
 */
public class Day90_BOJ_19539 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int N = sc.nextInt();
        int[] arr= new int[N];
        // res의 기본값은 "YES"
        String res = "YES";
        
        //조건1용 변수
        int sum = 0;
        
        //조건2용 변수
        int cnt1 = 0;
        int cnt2 = 0;
        
        for(int i=0;i<N;i++){
            arr[i] = sc.nextInt();
            cnt1 += arr[i]%2;
            cnt2 += arr[i]/2;
            sum += arr[i];
        }

        if(sum%3!=0){
            res = "NO";
        }else{
            if(cnt1>cnt2) res = "NO";
        }
        System.out.println(res);
    }
}
