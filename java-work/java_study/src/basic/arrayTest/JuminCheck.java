package basic.arrayTest;

import java.util.Arrays;
import java.util.Scanner;

//{1, 4, 0, 4, 1, 6, 4, 1, 4, 0, 8, 1, 8};
public class JuminCheck {
    public static void main(String[] args) {
        int result = 0;
        Scanner scanner = new Scanner(System.in);

        // 1 4 0 4 1 6 4 1 4 0 8 1 8
        String[] strJumin = scanner.next().split("");
        // 정수 담는 연속배열 13개를 선언
        int[] jumin = new int[strJumin.length];
        for (int i=0; i< strJumin.length; i++) {
            jumin[i] = Integer.parseInt(strJumin[i]); // string 타입을 int로 변환
        }
        // 각 자리수에다가 2,3,4,5,6,7,8,2,3,4,5, 곱하기
        for (int i=0; i< jumin.length - 1; i++) {
            if(i < 8) {
                result = result + (jumin[i] * i + 2);
            } else {
                result = result + (jumin[i] * i - 6);
            }
        }
        // 결과 = 11로 나눈 나머지
        result = result % 11;

        // 결과 = 11 - 결과
        result = 11 - result;

        // 결과 = 10- 결과
        result = 10 - result;

        // 맞는지 틀리는지 : 결과 == jumin[12]
        if(result == jumin[12]) {
            System.out.println("올바른 주민번호입니다.");
        } else {
            System.out.println("잘못된 주민번호입니다.");
        }
    }
}
