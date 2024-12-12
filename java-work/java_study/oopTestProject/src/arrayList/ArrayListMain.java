package arrayList;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class ArrayListMain {
    public static void main(String[] args) {
        // ArrayList의 부모타입
        // <> 꺽쇠는 Generic(제네릭)이라 부름
        // 꺽쇠 안에는 타입이 들어감
        List<Integer> intData = new ArrayList<>();
        List<String> strData = new ArrayList<>();

        //리스트 생성 시 초기값 부여하는 방법
        List<Integer> init = new ArrayList<>(Arrays.asList(1,2,3));
        System.out.println(init);

        // 출력하기
        for(Integer i : init) {
            System.out.println(i);
        }
        // CRUD(Create, Read, Update, Delete)
        // Crete : 데이터 입력
        strData.add("홍길동");
        strData.add("장원영");
        strData.add("로제");
        System.out.println(strData);
        // 개수 확인
        System.out.println(strData.size());
        // index로 값 찾기
        System.out.println(strData.get(0));
        // 로제 출력(로제가 몇번에 있는지 모름)
        // 1. 로제의 인덱스 값 찾기
        int index = strData.indexOf("로제");
        System.out.println(index);
        // 로제 출력하기
        System.out.println(strData.get(index)); // 출력 : 로제

        // 삭제하기
        strData.remove("홍길동");
        System.out.println(strData); // 출력 [장원영, 로제]

        // 데이터의 수정
        // 홍길동 다시 추가
        strData.add("홍길동");
        System.out.println(strData); // 출력 [장원영, 로제, 홍길동]

        // 홍길동을 둘리로 수정
        // 1. 홍길동의 위치 찾기
        // 2. 해당 인덱스를 찾으면 값 수정하기
        index = strData.indexOf("홍길동");
        strData.set(index, "둘리");
        System.out.println(strData); // 출력 [장원영, 로제, 둘리]
    }
}
