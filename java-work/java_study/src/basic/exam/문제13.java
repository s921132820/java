package basic.exam;

import java.util.Scanner;

//훈제오리구이를 시작하는 시각과 오븐구이를 하는 데 필요한 시간이 분단위로 주어졌을 때,
//오븐구이가 끝나는 시각을 계산하는 프로그램을 작성하시오.
//
//- 입력(input_6.txt)
//첫째 입력 값은 현재 시간,(0 ≤ A ≤ 23)
//두번째 입력 값은 현재 분, (0 ≤ B ≤ 59)
//세번째 입력값은 요리하는 데 필요한 시간
//	C (0 ≤ C ≤ 1,000)가 분 단위로 주어진다.
//
//- 출력
//첫째 줄에 종료되는 시각의 시와 분을 공백을 사이에 두고 출력한다.
//(단, 시는 0부터 23까지의 정수, 분은 0부터 59까지의 정수이다.
//디지털 시계는 23시 59분에서 1분이 지나면 0시 0분이 된다.)
//
//- 예제입력
//14 30
//20
//
//17 40
//80
//
//23 48
//25
//
//- 예제출력
//14 50
//
//19 0
//
//0 13
public class 문제13 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("현재 시간 : ");
        int hour = sc.nextInt();
        System.out.println("현재 분 : ");
        int minute = sc.nextInt();
        System.out.println("요리 시간 : ");
        int time = sc.nextInt();
        // 현재시각 + 요리시간 = 전체 요리 -> 분으로 표시
        int totalTime = (hour*60) + minute + time;
        // 출력 시간 (총시간을 60으로 나눈 몫)
        hour = (totalTime / 60)%24;
        // 출력 분
        minute = totalTime % 60;
        System.out.println(hour + " " + minute);


    }
}
