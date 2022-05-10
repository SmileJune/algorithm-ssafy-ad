package com.ssafy.yun;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.StringTokenizer;

public class BOJ_1946 {
	static class Person implements Comparable<Person> {
		int a;
		int b;

		public Person(int a, int b) {
			super();
			this.a = a;
			this.b = b;
		}

		@Override
		public int compareTo(Person o) {
			return this.a - o.a;
		}

	}

	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static StringTokenizer st;
	static StringBuffer sb = new StringBuffer();
	static ArrayList<Person> list;

	public static void main(String[] args) throws NumberFormatException, IOException {
		int T = Integer.parseInt(br.readLine());
		for (int tc = 1; tc <= T; tc++) {
			solution();
		}
		System.out.println(sb);
	}

	private static void solution() throws NumberFormatException, IOException {
		int N = Integer.parseInt(br.readLine());
		list = new ArrayList<>();
		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			int a = Integer.parseInt(st.nextToken());
			int b = Integer.parseInt(st.nextToken());
			list.add(new Person(a, b));
		}

		int min = 100001;
		int num = 0;
		Collections.sort(list);
		for (Person p : list) {
			if(p.b < min) {
				min = p.b;
				num++;
			}
		}
		sb.append(num).append("\n");
	}
}
