package com.ssafy.ehoi;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Day85_BOJ_G5_1759 {
	static int L, C;
	static char arr[], select[];
	static boolean[] visit;
	static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());

		L = Integer.parseInt(st.nextToken()); // 비밀번호 L개
		C = Integer.parseInt(st.nextToken()); // 총 C개의 후보를 준대
		visit = new boolean[C];
		select = new char[L];

		arr = new char[C];
		st = new StringTokenizer(br.readLine());
		for (int i = 0; i < C; i++) {
			arr[i] = st.nextToken().charAt(0);
		}
		Arrays.sort(arr); // 미리 오름차순으로 정렬해두면 뽑을때도 이미 정렬된 상태일듯!

		// 4개 고르는 조합
		comb(0, 0);
		bw.close();

	}

	private static void comb(int cnt, int sel) throws IOException {
		if (cnt == L) {
			// 최소 한 개의 모음 + 최소 두 개의 자음으로 구성이 되어있는지 검사
			if (ok()) {
				// 참이면
				// 출력
				for (int i = 0; i < L; i++) {
					bw.append(select[i]);
//					System.out.print(select[i]);
				}
//				System.out.println();
				bw.append("\n");
			}
			return;
		}

		for (int i = sel; i < C; i++) {
			select[cnt] = arr[i];
			comb(cnt + 1, i + 1);
		}

	}

	private static boolean ok() {
		int ja = 0;
		int mo = 0;
		for (int i = 0; i < select.length; i++) {
			if ("aeiou".contains(select[i] + "")) { // 해당 인덱스의 값이 모음이라면 모음 카운트 올리고
				mo++;
			} else
				ja++; // 자음이라면 자음 카운트 올리고!
		}

		return ja >= 2 && mo >= 1; // 자음이 두개 이상이고 모음이 한개 이상이면 true 반환
	}
}
