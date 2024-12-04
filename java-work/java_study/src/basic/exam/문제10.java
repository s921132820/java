package basic.exam;

import java.util.Scanner;

// 입력받은 구구단 출력하기
//
//- 문제
//파일에서 입력받은 수의 구구단 출력.
//
//- 입력
//구하고자 하는 구구단의 수를 입력받는다.
//N(2 ≤ N ≤ 9)이 주어진다.
//
//- 출력
//차례대로 구구단을 출력한다.
//
//- 예제입력(input_8.txt)
//3
//
//- 예제출력
//3 × 1 = 3
//3 × 2 = 6
//3 × 3 = 9
//3 × 4 = 12
//....
public class 문제10 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("출력할 구구단의 단수를 입력 : ");
        int dan = sc.nextInt();
        for (int i = 1; i <=9; i++) {
            System.out.println(dan + " * " + i + " = " + (dan*i));
        }
    }
}
