package basic.condition;

import java.util.Scanner;

public class SwitchTest {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
//        scanner.nextInt();
        // 스캐너라는 장치는 터미널에 입력할 수 있도록 해줌
        int n = scanner.nextInt();
        n = n / 10;
        switch (n) {
            case 10 :
                System.out.println("수");
                break;
            case 9 :
                System.out.println("수");
                break;
            case 8 :
                System.out.println("우");
                break;
            case 7 :
                System.out.println("미");
                break;
            case 6 :
                System.out.println("양");
                break;
            default:
                System.out.println("가");
        }
    }
}

// if 와 달리 조건에 맞으면 종료되는게 아니므로 강제로 나가야 함(break)
// 그래서 case 마다 break 입력해야함