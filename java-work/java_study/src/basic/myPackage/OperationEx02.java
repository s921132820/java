package basic.myPackage;

public class OperationEx02 {
    public static void main(String[] args) {
        /*
        int a = 8;
        long b = 20;
        System.out.println(a + b);

        // b의 값을 5로 변경
        b = 5; // 재선언
        long x = a * b;
        System.out.println("a*b = " + x);

        // a ÷ b =  결과를 result 에 담아서 출력
        double result = (double) a / b; // (double) a와 b는 정수인데 강제로 실수로 바꾸겠다는 뜻
        System.out.println("a / b = " + result);
        */

        int numberA = 3;
        int numberB = 7;
        int answer = numberA % numberB; // 나머지를 구하는 연산자 %
        System.out.println(numberA + "을 " + numberB + "로 나눈 나머지는? " + answer + "입니다.");
    }
}


// 상수 선언, 상수는 final로 선언
// final double PI = 3.14;
// PI = 4;
// ""는 string