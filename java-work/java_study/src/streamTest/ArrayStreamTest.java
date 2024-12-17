package streamTest;

import java.util.ArrayList;
import java.util.List;

public class ArrayStreamTest {
    public static void main(String[] args) {
        List<String> list = new ArrayList<>();
        list.add("Tomas");
        list.add("Adward");
        list.add("Jack");
        list.stream().forEach(x -> System.out.println( x +"\t"));

        System.out.println("");

        // 리스트 내용 정렬해서 출력하기
        list.stream().sorted().forEach(name -> System.out.println(name));

        // 리스트 각 내용의 길이를 출력, map()
        // 가공되면 map
        list
            .stream()
            .map(x -> x.length())
            .forEach(value -> System.out.println(value));

        // 문자열의 길이가 5이상인 자료만 출력
        // 필터는 조건에 맞는 걸 찾음
        // 출력할 원본이 변하지 않음
        list.stream()
                .filter(x->x.length() >= 5)
                .sorted()
                .forEach(x-> System.out.println(x));

        // 정수 자료의 처리
        List<Integer> integerList = new ArrayList<>();
        integerList.add(1);
        integerList.add(2);
        integerList.add(3);
        integerList.add(4);
        integerList.add(5);

        // 전체 데이터 출력
        integerList.stream()
                .forEach(x-> System.out.println(x));

        // 합계 출력
        // Integer는 객체이므로 privitive type으로 바꿔줘야함 -> 바꾸는 것이므로 map()
        // 바꾸기 전에는 .sum() 못 붙임
        // sum은 최종 연산이므로 foreach로 출력할 수 없음
        // 그래서 sumValue라는 변수에 담아 시스템아웃으로 출력해야함
        int sumValue = integerList.stream()
                .mapToInt(x -> x.intValue())
                .sum();
        System.out.println("리스트의 합은 " + sumValue);

    }
}
