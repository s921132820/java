package basic.exam;

//시험 점수를 입력받아 90 ~ 100점은 A, 80 ~ 89점은 B,
//70 ~ 79점은 C, 60 ~ 69점은 D, 나머지 점수는 F를 출력하는
//프로그램을 작성하시오.
//
//- 입력(input_4.txt)
//점수는 score 변수로 받는다.
//시험 점수는 0보다 크거나 같고, 100보다 작거나 같은 정수이다.
//
//- 출력
//시험 성적을 출력한다.
//
//- 예제 입력
//100
//
//- 예제 출력
//A

import java.util.Scanner;

public class 문제11 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("점수를 입력하세요");
        int score = sc.nextInt();
        if (score >= 90) {
            System.out.println("당신의 결과는 : A");
        } else if (score >= 80) {
            System.out.println("당신의 결과는 : B");
        } else if (score >= 70) {
            System.out.println("당신의 결과는 : C");
        } else if (score >= 60) {
            System.out.println("당신의 결과는 : D");
        } else {
            System.out.println("당신의 결과는 : F");
        }
    }
}
