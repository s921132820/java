package basic.exam;
//1에서부터 6까지의 눈을 가진 3개의 주사위를 던져서 다음과 같은 규칙에 따라
//상금을 받는 게임이 있다.
//
//ⓐ 같은 눈이 3개가 나오면
//    -- 상금 : 10,000원 + (같은 눈) × 1,000원
//ⓑ 같은 눈이 2개만 나오는 경우에는
//    -- 상금 : 1,000원 + (같은 눈) × 100원
//ⓒ 모두 다른 눈이 나오는 경우에는
//    -- 상금 : (그 중 가장 큰 눈) × 100원
//
//예를 들어, 3개의 눈 3, 3, 6이 주어지면 상금은 1,000 + 3 × 100으로 계산되어
//    1,300원을 받게 된다.
//또 3개의 눈이 2, 2, 2로 주어지면 10,000 + 2 × 1,000 으로 계산되어
//    12,000원을 받게 된다.
//3개의 눈이 6, 2, 5로 주어지면 그중 가장 큰 값이 6이므로 6 × 100으로 계산되어
//    600원을 상금으로 받게 된다.
//
//3개 주사위의 나온 눈이 주어질 때, 상금을 계산하는 프로그램을 작성 하시오.
//
//- 3개 주사위 값을 순서대로 입력받는다.
//
//- 출력
//첫째 줄에 게임의 상금을 출력 한다.
//
//- 예제입력
//3 3 6
//
//2 2 2
//
//6 2 5
//
//- 예제출력
//1300
//
//12000
//
//600

import java.util.Scanner;

public class 문제14 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("첫번째 주사위 값 : ");
        int dice_1 = sc.nextInt();
        System.out.println("두번째 주사위 값 : ");
        int dice_2 = sc.nextInt();
        System.out.println("세번째 주사위 값 : ");
        int dice_3 = sc.nextInt();

        // 가장 큰 값 구하기
        int max = 0;
        if (dice_1 > max) max = dice_1;
        if (dice_2 > max) max = dice_2;
        if (dice_3 > max) max = dice_3;
        System.out.println("max = " + max);

        // 몇개 주사위 값이 같은지 확인
        // 같은 주사위 수 : same
        int same = 0;
        // 같은 눈의 수
        int sameNumber = 0;

        if(dice_1 == dice_2) {
            same = same + 1;
            sameNumber = dice_1;
        }
        if(dice_1 == dice_3) {
            same = same + 1;
            sameNumber = dice_1;
        }
        if(dice_2 == dice_3) {
            same = same + 1;
            sameNumber = dice_2;
        }
        System.out.println("same = " + same);

        // 상금 계산
        int result = 0;
        switch (same) {
            case 3 :
                result = 10000 + (sameNumber * 1000);
                break;
            case 1 :
                result = 1000 + (sameNumber * 100);
            default:
                result = max * 100;
        }
        System.out.println("상금은 " + result);
    }
}
