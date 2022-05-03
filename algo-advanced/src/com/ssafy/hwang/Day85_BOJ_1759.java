package com.ssafy.hwang;
import java.util.*;
/*
    [BOJ_1759 암호만들기]

    출력 : 각 줄에 하나씩 사전식으로 가능성 잇는 암호를 모두 출력
    입력 : L C ( 3 <= L,C <= 15 .
                L : 암호의 길이, C : 주어진 문자의 개수)
    조건 : 1. 모음 최소 1개, 자음 최소 2개로 구성 되어야한다.
          2. 알파벳이 오름차순으로 배열되어야 한다.

    접근 : 정렬후 뽑은 순서를 기억하며 문자를 L개 만큼 뽑아서,
           조건 1 확인 후 StringBuilder에 넣어준다.
 */
public class Day85_BOJ_1759 {
    static int L,C;
    static char arr[];
    static StringBuilder sb;
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        sb = new StringBuilder();
        L = sc.nextInt();
        C = sc.nextInt();

        arr = new char[C];
        sel = new char[L];
        for(int i =0 ; i<C;i++){
            arr[i] = sc.next().charAt(0);
        } // 입력 처리 끝

        // 조건2를 위해 오름차순 정렬
        Arrays.sort(arr);

        comb(0,0);
        System.out.println(sb);
    }
    static char[] sel;
    private static void comb(int sidx, int idx) {
        if( sidx == L) {
            check();
            return;
        }
        for(int i=idx;i<C;i++) {
            sel[sidx] = arr[i];
            comb(sidx+1,i+1);
        }
    }

    private static void check() {
        String s = "";
        for(char c : sel) s+=c;
        String vowels = "aeiou";
        int cnt = 0; // 모음 갯수 세줄 변수 선언
        for(int i = 0 ; i<L;i++){
            // 포함 안되있으면 -1 뱉는 점으로 조건식 만든다.
            if( 0<=vowels.indexOf( s.charAt(i) ) ){
                // 모음이라면
                cnt++;
            }
        }
        // 모음이 1개 이상 && 자음이 2개이상
        if( cnt>=1 && L-cnt >= 2){
            sb.append(s+"\n");
        }
    }
}
