package com.ssafy.hwang;

import java.util.*;

/**
 * [BOJ_1946_신입사원]
 * 
 * 출력 : 최대 선발 인원은?
 * 
 * 입력 : T (tc 수) N (지원자 수, 1 <= N <= 100,000 ) N개의 줄에 서류성적, 면접성적 입력(공백으로 구분) 조건
 * : 두 성적 순위는 모두 동석차 없이 결정됨.
 */
public class Day91_BOJ_1946 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		int T = sc.nextInt();
		StringBuilder sb = new StringBuilder();
		for (int tc = 1; tc <= T; tc++) {
			int N = sc.nextInt(); // 지원자 수
			int res = 1;
			int[] arr = new int[N];

			for (int i = 0; i < N; i++) {
				arr[sc.nextInt()-1] = sc.nextInt();
			}
			int std = arr[0];
			for (int i = 1; i < N; i++) {
				if (std > arr[i]) {
					res++;
					std = arr[i];
				}
			}sb.append(res + "\n");
			 
		}// tc 종료
		System.out.println(sb.toString());
	}
}