package basic.arrayTest;
//최댓값과 인덱스찾기
//
//9개의 서로 다른 자연수
//3, 29, 38, 12, 57, 74, 40, 85, 61
//가 주어질 때, 이들 중 최댓값을 찾고 그 최댓값이 몇 번째
//수인지를 구하는 프로그램을 작성하시오.
//
//이 주어지면, 이들 중
//최댓값은 85이고, 이 값은 8번째 수이다.
//최솟값은 3이고, 이 값은 1번째 수이다.
//
//출력 :
//
//최댓값 : 85, 인덱스 : 7
//최솟값 : 3, 인덱스 : 1
public class ex01 {
    public static void main(String[] args) {
        int[] number = {3, 29, 38, 12, 57, 74, 40, 85, 61};

        int max = number[0];
        int maxIndex = 0;
        int min = number[0];
        int minIndex = 0;

        for (int i=0; i < number.length; i++) {
            if (number[i] > max) {
                max = number[i];
                maxIndex = i;
            }
            if (number[i] < min) {
                min = number[i];
                minIndex = i;
            }
        }
        System.out.println("최대값 : " + max + ", " + "인덱스 : " + maxIndex);
        System.out.println("최소값 : " + min + ", " + "인덱스 : " + minIndex);
    }
}
