package basic.exam;

public class 문제5 {
    public static void main(String[] args) {
        // money 변수 3780원의 금액이 있습니다.
        // 이를 다음과 같은 결과가 나오도록 출력합니다.
        // 1000원 : 3개
        // 남은금액 : 780원
        // 500원 : 1개
        // 남은금액 : 280원
        // 100원 : 2개
        // 남은금액 : 80원
        // 10원 : 8개
        // 남은금액 : 0원

        int money = 3_780;
        // 자바의 경우 , 대신에 _를 사용함 (자바 6버전부터 지원), 안써도 상관없음
        // 값이 크다면 정수값을 이렇게 표현하면 가독성이 높음

        System.out.println("1000원 ; " + (money/1000) + "개");
        money = money % 1000;
        System.out.println("남은금액 : " + money + "원");

        System.out.println("500원 ; " + (money/500) + "개");
        money = money % 500;
        System.out.println("남은금액 : " + money + "원");

        System.out.println("100원 ; " + (money/100) + "개");
        money = money % 1000;
        System.out.println("남은금액 : " + money + "원");

        System.out.println("10원 ; " + (money/10) + "개");
        money = money % 10;
        System.out.println("남은금액 : " + money + "원");








//        while (money > 0) {
//            if (money >= 1000) { // 1000원 처리
//                int count = money / 1000;
//                money %= 1000;
//                System.out.println("1000원 : " + count + "개");
//            } else if (money >= 500) { // 500원 처리
//                int count = money / 500;
//                money %= 500;
//                System.out.println("500원 : " + count + "개");
//            } else if (money >= 100) { // 100원 처리
//                int count = money / 100;
//                money %= 100;
//                System.out.println("100원 : " + count + "개");
//            } else if (money >= 10) { // 10원 처리
//                int count = money / 10;
//                money %= 10;
//                System.out.println("10원 : " + count + "개");
//            }
//            // 남은 금액 출력
//            System.out.println("남은금액 : " + money + "원");
//        }



//        int money = 3780;  // 주어진 금액
//        int[] units = {1000, 500, 100, 10};  // 화폐 단위 배열
//
//        for (int unit : units) {  // 각 화폐 단위에 대해 반복
//            int count = money / unit;  // 화폐 단위별 개수 계산
//            money %= unit;  // 남은 금액 업데이트
//
//            System.out.println(unit + "원: " + count + "개");
//            System.out.println("남은금액: " + money + "원");
//        }
    }
}