package arrayList;

import oopEating.fruit.Apple;
import oopEating.fruit.Fruit;
import oopEating.fruit.Mango;
import oopEating.fruit.orange;

import java.util.ArrayList;
import java.util.List;

public class FruitList {
    public static void main(String[] args) {
        List<Fruit> fruits = new ArrayList<>();
        Apple apple = new Apple();
        fruits.add(apple);
        fruits.add(new Mango());
        fruits.add(new orange());

        // 사이즈 확인하기
        System.out.println("사이즈 : " + fruits.size());

        // 전체 출력하기
        System.out.println(fruits);

        // index = 1인 오브젝트 출력해보기
        Fruit a = fruits.get(1);
        System.out.println(a.getName() + a.getTaste());

        // 이름이 오렌지인 것을 찾아서 맛을 출력
        for (int i=0; i< fruits.size(); i++) {
            if (fruits.get(i).getName().equals("오렌지")) {
                System.out.println(fruits.get(i).getTaste());
                break;
            }
        }

        // 사과 맛을 "사과본연의 맛"으로 수정
        // name = 사과 인것을 찾아서 taste를 수정
        for (Fruit x : fruits) {
            if (x.getName().equals("사과")) {
                x.setTaste("사과 본연의 맛");
            }
            System.out.println(x.toString());
            break;
        }

        System.out.println("==========================");

        // 사과 삭제하고 출력해보기
        // 사과 있는 인덱스 찾아서 삭제하기
        for (Fruit x : fruits) {
            if (x.getName().equals("사과")) {
                fruits.remove(x);
            }
            break;
        }
        System.out.println(fruits);

        // 망고를 사과로 바꾸기
        // 망고 위치 찾고 사과로 바꾸기
        for (Fruit x : fruits) {
            if (x.getName().equals("망고")) {
                int update = fruits.indexOf(x);
                // 수정하기
                fruits.set(update, new Apple());
            }
            break;
        }
        System.out.println(fruits);
    }
}
