package basic.exam;
//바로 "45분 일찍 알람 설정하기"이다.
//- 입력(input_5.txt)
//첫째 줄에 두 정수 H와 M이 주어진다. (0 ≤ H ≤ 23, 0 ≤ M ≤ 59)
//그리고 이것은 현재 상근이가 설정한 알람 시간 H시 M분을 의미한다.
//
//입력 시간은 24시간 표현을 사용한다.
//24시간 표현에서 하루의 시작은 0:0(자정)이고, 끝은 23:59(다음날 자정 1분 전)이다.
//시간을 나타낼 때, 불필요한 0은 사용하지 않는다.
//
//- 출력
//첫째 줄에 상근이가 창영이의 방법을 사용할 때, 설정해야 하는 알람 시간을 출력한다.
//(입력과 같은 형태로 출력하면 된다.)
//
//- 예제입력
//10 10
//0 30
//23 40
//1 20
//
//- 예제출력
//9 25
//23 45
//22 55
//0 35

import java.util.Scanner;

public class 문제12 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("시간입력 : ");
        int hour = sc.nextInt();
        System.out.println("분입력 : ");
        int minute = sc.nextInt();
        if (minute > 45) {
            minute = minute - 45;
        } else if(hour == 0 && minute < 45) {
            hour = 23;
            minute = minute + 15;
        } else {
            hour = 23 - 1;
            minute = minute + 15;
        }
        System.out.println(hour + " " + minute);
    }
}
