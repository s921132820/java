package basic.condition;

public class BreakCondition {
    public static void main(String[] args) {
        // 1부터 10까지 더하는 루프
        // 결과 출력 (sum = 55)
        int sum = 0;
        for (int i = 1; i <= 10; i++) {

            if (i == 5) {
//              break; // 만약에 i가 5면 for loop에서 빠져 나가게 함
//              continue; // i가 5면 5는 빠짐, 현재 조건만 실행 안함
                return; // i가 5면 현재 함수 종료
            }
            sum = sum + i;
        }
        System.out.println("sum = " + sum);
    }
}
