package basic.exam;

import java.util.Scanner;

//두 정수 A와 B를 입력받은 다음, A+B를 출력하는 프로그램을 작성하시오.
//- 입력(intA, intB) (A > 0, B < 10)
//
//- 예제 입력(input_1.txt)
//7 9
//
//- 출력
//첫째 줄에 A+B를 출력한다.
//
//7 + 9 = 16

public class 문제6 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("첫번째 수를 입력하세요 :");
        int intA = sc.nextInt();
        System.out.println("두번째 수를 입력하세요 :");
        int intB = sc.nextInt();
        System.out.println("두 수의 합은 : " + (intA + intB));
    }
}




//        // Scanner 객체를 사용해 사용자 입력을 받는다.
//        Scanner scanner = new Scanner(System.in);
//
//        // 두 정수 A와 B를 입력받는다.
//        int A = scanner.nextInt();
//        int B = scanner.nextInt();
//
//        // A + B의 값을 출력한다.
//        System.out.println(A + " + " + B + " = " + (A + B));
//
//        // Scanner 객체를 닫는다.
//        scanner.close();
//    }