package setTest;

import java.util.*;

public class LottoNumber {
    public static void main(String[] args) {
        // 로또번호를 담는 Set 자료구조
        Set<Integer> lotto = new HashSet<>();
        while (lotto.size() < 6) {
            int num = ((int)(Math.random() * 45)) + 1;
            lotto.add(num);
        }
        System.out.println(lotto);

        // Set을 List로 바꿔보기
        List<Integer> intLotto = new ArrayList<>(lotto);
        // 정렬하기
        Collections.sort(intLotto);
        System.out.println(intLotto);

        // 역으로 정렬하기
        Collections.sort(intLotto, Collections.reverseOrder());
        System.out.println(intLotto);
    }
}

//List, Set, Map을 컬렉션이라고 함
