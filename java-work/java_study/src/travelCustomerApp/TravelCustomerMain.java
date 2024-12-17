package travelCustomerApp;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

public class TravelCustomerMain {
    public static void main(String[] args) {
        List<Customer> customers = new ArrayList<>();

        Customer jang = new Customer("장원영", 20, 100);
        Customer ahn = new Customer("안유진", 21, 100);
        Customer hong = new Customer("홍길동", 50, 80);
        customers.add(jang);
        customers.add(ahn);
        customers.add(hong);

        // 1. 고객명단을 추가된 순서대로 출력하기
        System.out.println("고객명단을 추가된 순서대로 출력하기");
        customers.stream()
                .forEach(x-> System.out.println(x));

        // 2. 고객명단에 추가된 순서대로 이름만 출력하기
        System.out.println("고객명단에 추가된 순서대로 이름만 출력하기");
        customers.stream()
                .forEach(x-> System.out.println(x.getName()));

        customers.stream()
                .map(x -> x.getName())
                .forEach(x -> System.out.println(x));


        // 3. 총 여행비용 출력하기
        System.out.println("총 여행비용 출력하기");
        int sumPrice = customers.stream()
                .mapToInt(x -> x.getPrice())
                .sum();
        System.out.println("총 여행 경비는 : " + sumPrice);

        // 4. 21세 이상 고객 명단의 이름만 오름차순으로 출력하기
        customers.stream()
                .filter(x -> x.getAge() >= 21)
                .map(x->x.getName())
                .sorted()
                .forEach(x-> System.out.println(x));

        // 5. 21세 이상 고객명단 전체를 내림차순으로 출력하기
        customers.stream()
                .filter(x->x.getAge() >=21)
                .sorted(Comparator.comparing(Customer::getName)
                        .reversed()) // 객체 정렬할 때는 sorted가 아니라 reversed를 사용
                .forEach(System.out::println); // .forEach(x-> System.out.println(x)); 와 같음
    }
}

// stream 방식은 체이닝 방식이라고 함