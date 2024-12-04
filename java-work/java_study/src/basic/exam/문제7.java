package basic.exam;

import java.util.Scanner;

// 두 정수 A와 B를 입력받은 다음, 두 수 A와 B 사이의 모든 정수값을 더해
// 출력하는 프로그램을 작성하시오.
//
//- 입력(intA, intB) (A > 0, B < 10)
//
//- 예제 입력 1(input_2.txt)
//2 7
//
//- 예제 입력 1(input_2.txt)
//7 2
//
//- 출력
//27

public class 문제7 {
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        System.out.println("첫번째 수를 입력하세요 :");
        int intA = sc.nextInt();
        System.out.println("두번째 수를 입력하세요 :");
        int intB = sc.nextInt();

        // 두 수를 비교해서 첫째값이 더 크면 두 수를 바꿔준다

        if (intA > intB) {
            int temp = intA;
            intA = intB;
            intB = temp;
        }

        int sum = 0;
        for (int i = intA; i <= intB; i++) {
            sum = sum + i;
        }
        System.out.println("두 수의 합은 : " + sum);
    }
}

