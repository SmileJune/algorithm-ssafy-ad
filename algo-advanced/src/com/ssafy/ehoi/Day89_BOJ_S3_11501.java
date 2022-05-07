package com.ssafy.ehoi;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Day89_BOJ_S3_11501 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());

		int T = Integer.parseInt(st.nextToken()); // 테스트 케이스 수 입력

		for (int tc = 1; tc <= T; tc++) {
			int day = Integer.parseInt(br.readLine()); // 날의 수 입력
			int[] arr = new int[day]; // 배열 만들고

			st = new StringTokenizer(br.readLine());

			for (int i = 0; i < arr.length; i++) {
				arr[i] = Integer.parseInt(st.nextToken()); // 배열에 주가 넣기 끝
			}

			int ans = 0;
			int i = day - 1;
			for (int j = i - 1; j >= 0; j--) {
				if (arr[i] >= arr[j]) {
					ans += arr[i] - arr[j];
				} else { // j가 더 커버렸어! 그러면 팔아야 하는 주가를 새로 갱신해줘야지
					i = j;
					j = i;
				}
			}
			System.out.println(ans);

		}
	}
}
