package basic.exam;

import java.util.Scanner;

public class SeheeTest {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in); // Scanner 객체 생성

        System.out.print("정수를 입력하세요: ");
        int num = scanner.nextInt(); // 사용자가 입력한 정수 읽기

        System.out.println("입력한 정수는: " + num);

        scanner.close(); // Scanner 객체 닫기

        }
    }

