package basic.exam;
//처음 프로그램이 시작되면....
//
//======================
//메뉴를 선택하세요
//======================
//1. 인사하기 2. 춤추기 3. 밥먹기  4. 종료하기
//
//각 번호를 선택하면..
//
//안녕하세요
//삐끼삐끼 춤입니다.
//맛나게 먹었습니다.
//프로그램을 종료합니다.
//
//1~3번을 선택하면 해당 메시지를 보여주고
//다시 메뉴선택화면을 보여줍니다.
//
//4번을 선택하면 메시지를 출력하고 멈춥니다.

import java.util.Scanner;

public class 문제15 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        String userId = "";
        String password = "";

        //로그인 확인용도의 변수
        boolean login = false;

        while (true) {
            if (login == false) {
                while (true) {
                    System.out.println("아이디 : ");
                    userId = sc.next();
                    System.out.println("비밀번호 :");
                    password = sc.next();
                    if (!userId.equals("admin") && !password.equals("1111")) {
                        System.out.println("아이디 또는 비밀번호를 확인하세요");
                    } else if (userId.equals("admin") && !password.equals("1111")) {
                        System.out.println("비밀번호가 일치하지 않습니다");
                    } else {
                        System.out.println("로그인 되었습니다");
                        login = true;
                        break;
                    }
                }
            }

            System.out.println("======================");
            System.out.println("메뉴를 선택하세요(1~4)");
            System.out.println("1. 인사하기 2. 춤추기 3. 밥먹기  4. 로그아웃 5. 종료하기");
            System.out.println("======================");
            int input = 0;
            input = sc.nextInt();
            switch (input) {
                case 1:
                    System.out.println("안녕하세요");
                    break;
                case 2:
                    System.out.println("삐끼삐끼 춤입니다.");
                    break;
                case 3:
                    System.out.println("맛나게 먹었습니다.");
                    break;
                case 4:
                    System.out.println("로그아웃 되었습니다.");
                    login = false;
                    break;
                case 5:
                    System.out.println("프로그램을 종료합니다.");
                    return;
                default:
                    System.out.println("잘못 입력했습니다");
            }
        }
    }
}