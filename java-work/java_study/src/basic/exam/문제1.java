package basic.exam;

public class 문제1 {
    // 문제1. 1부터 10까지의 수를 출력하세요. (단, 숫자가 6일 때는 출력하지 마세요)
    // for와 while 문 두 문법을 사용해서 만드세요.

    public static void main(String[] args) {
        // 1. 1부터 10까지 출력
        // 2. 6일 때 출력 제외
        // for문으로 만들기
        for (int i = 1; i <= 10; i++) {
            if (i == 6) {
                continue;
            }
            System.out.println("i = " + i);
        }

        // while로 만들기
        int j = 0;
        while (j < 10) { //참일 때만 실행
            j++;
            if (j== 6) {
                continue;
            }
            System.out.println("j = " + j);
        }
    }
}
