package basic.condition;

public class DoLoopTest {
    public static void main(String[] args) {
        // while(조건) --- 하는 동안 : 조건 안맞으면 실행 안함
        // Do (실행문) ~ while (조건) :일단 실행하고 조건을 나중에 판단함

        // while 구문
        // 실행전에 먼저 조건을 봄(i <= 10)
        int i = 1;
        int sum = 0;
        while (i <= 10) {
            sum = sum + 1;
            i = i + 1;
            System.out.println(i);
        }

        // Do while
        i = 1;
        sum = 0; // 초기화
        do {
            sum = sum + i;
            i = i + 1;
        } while (i <= 10);
        System.out.println(sum);
    }
}

// for 루프는 10번 20번 돌면 끝나지만 사용자에게 입력을 대기 받는 상태가 되었을 때 for 루프를 쓸 수 없음
// 무한정 돌아가게 하고 조건이 맞을 때 실행하게 할 때에는 while 구문을 씀
// db 읽을 때에도 while 구문을 많이 씀