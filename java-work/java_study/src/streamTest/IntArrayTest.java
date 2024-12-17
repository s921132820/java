package streamTest;

import java.util.Arrays;

public class IntArrayTest {
    public static void main(String[] args) {
        int[] arr = {1, 2, 3, 4, 5};
        int sum = Arrays.stream(arr).sum();
        System.out.println(sum);

        //배열에 몇개 들어가있는지 확인
        long count = Arrays.stream(arr).count();
        System.out.println(count);

        for(int x : arr) {
            System.out.println(x);
        }
        System.out.println("----------------------------");
        // 배열을 하나씩 꺼내서 돌림
        Arrays.stream(arr).forEach(x-> System.out.println(x));
    }
}
