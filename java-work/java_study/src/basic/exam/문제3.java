package basic.exam;

public class 문제3 {
    public static void main(String[] args) {
        // 1부터 20까지의 수를 출력하세요. (단, 2의 배수일 때만 출력하세요)
        // for 문법 사용

//        for (int i = 2; i <= 20; i += 2) {
//            System.out.println(i);
//        }

        // 첫번째 방법, 2씩 증가해서 출력하는 방법
        for (int i = 2; i <= 20; i=i+2) {
                System.out.println("i = " + i);
            }

        // 두번째 방법, 짝수를 확인해서 처리하는 방법
        // i % 2 == 0 이면 짝수
        for (int i = 1; i <= 20; i++) {
            if ((i % 2) == 0) {
                System.out.println("i = " + i);
            }
        }
    }
}
