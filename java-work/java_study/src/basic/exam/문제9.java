package basic.exam;

import java.util.Scanner;
// 별찍기
//
//- 문제
//첫째 줄에는 별 5개, 둘째 줄에는 별 4개 .... 마지막 1개
//
//- 입력
//정수로 출력할 줄 수를 입력받는다.
//
//- 출력
//첫째 줄부터 N번째 줄까지 차례대로 별을 출력한다.
//
//- 예제입력
//5
//
//- 예제출력
//*****
//****
//***
//**
//*
public class 문제9 {
    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);
        System.out.println("출력할 라인수를 입력 : ");
        int line = scanner.nextInt();

        String star = "";

        // for loop를 두번 사용
        for (int i = 1; i <=line; i++) {
            for (int j = 1; j <=line; j++) {
                star = star + "*";
            }
            System.out.println(star); // 빈 라인 출력
        }
    }
}
