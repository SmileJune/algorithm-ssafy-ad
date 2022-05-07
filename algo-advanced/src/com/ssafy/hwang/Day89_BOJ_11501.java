package com.ssafy.hwang;

import java.util.*;

public class Day89_BOJ_11501 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int T = sc.nextInt();
		
		for (int tc = 1; tc <= T; tc++) {
			int N = sc.nextInt();
			
			int[] costs = new int[N];
			int maxDay = 0;
			// 오늘의 날을 저장해둘 배열 선언
			int now = 0;
			// 몇개 가지고있는지 카운트할 변수 선언
			int get = 0;
			// 이득(결과)을 담아줄 변수 선언
			long res = 0;
			
			for (int i = 0; i < N; i++) {
				costs[i] = sc.nextInt();
				// 같은 가격이 있다면 뒷날로 미루자.
				if (costs[maxDay] <= costs[i])
					maxDay = i;
			} // 입력 처리 끝
			
			// 마지막날까지 돌아볼 필요가있다.
			while (now<N) {
				for(int i =now ;i<N;i++) {
					if(costs[i]>=costs[maxDay]) {
						maxDay = i;
					}
				}
				
				// maxDay 전까지 모두 사기
				for (int i = now; i < maxDay; i++) {
					get++;
					res -= costs[i];
				}
				// maxDay 가격에 모두 팔기
				for(int i =0; i<get;i++) 
					res += costs[maxDay];
				get = 0;
				// 팔았으면 내일을 기준으로 maxDay찾기
				now = maxDay + 1;
				maxDay=now;
				for (int i = now; i < N; i++) {
					if (costs[maxDay] <= costs[i])
						maxDay = i;
				}
			}
			System.out.println(res);
		} // tc문 종료
	}
}
