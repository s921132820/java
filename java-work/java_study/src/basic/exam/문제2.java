package basic.exam;

public class 문제2 {
    public static void main(String[] args) {
        // 10부터 1까지의 수를 출력하세요. (단, 숫자가 3일 때는 출력하지 마세요)
        // for와 do~while 문 두 문법을 사용해서 만드세요.

        for (int i = 10; i >= 1; i--) {
            if (i == 3) {
                continue;
            }
            System.out.println(i);
        }


        // while
        int j = 11;
        for (int i = 10; i >= 1; i--) {
            int num = i;
            do {
                if (num == 3) {
                    break;
                }
                System.out.println(num);
                num--;
            } while (num >= i);
        }

    }
}
