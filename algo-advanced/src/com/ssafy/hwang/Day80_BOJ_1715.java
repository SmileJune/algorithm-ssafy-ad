package com.ssafy.hwang;

import java.util.*;

/**
 * 1715 카드 정렬하기
 * 
 * 출력 : 최소 비교 횟수
 * 
 * 입력 : N : 카드뭉치 갯수
 * 		  N줄 동안 카드 뭉치의 크기 입력됨.
 * 
 * 풀이 : 먼저 합한 뭉치는 다음 연산에도 관여하기 때문에 
 * 		  크기가 작은 뭉치들 순서대로 연산해주면 최소값이다.
 *        PQ사용 
 *      무조건 작은 값 2개를 비교해야하기 때문에 연산후에 다시 큐에 넣어준다
 *
 */
public class Day80_BOJ_1715 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		PriorityQueue<Integer> pq = new PriorityQueue<>();
		int N = sc.nextInt();
		for(int i=0;i<N;i++	) {
			pq.add(sc.nextInt());
		}
		int res =0;
		int tmp = 0;
		while(pq.size()>1) {
			tmp = pq.poll() + pq.poll();
			res += tmp;
			pq.add(tmp);
		}
		System.out.println(res);
	}
}
