package myClass;

import myClass.createClass.Cat;
import myClass.createClass.Dog;

public class DogMain {
    public static void main(String[] args) {

        Dog toto = new Dog();
        System.out.println(toto.type);
        System.out.println(toto.name);
        System.out.println(toto.age);
        System.out.println(toto.color);
        //toto.color -> toto 다음에 오는 .은 클래스 접근자라고 함

        // 1년 후
        toto.age++; // toto.age = toto.age +1;
        toto.color = "노란색";
        // toto.type = "푸들"; // 오류남, final이기 때문에
        System.out.println("== 1년 후");
        System.out.println(toto.color);
        System.out.println(toto.age);
    }

    public static class CatMain {
        public static void main(String[] args) {
            Cat 야옹이 = new Cat();
            야옹이.catName = "야옹이";
            야옹이.catColor = "검정색";

            System.out.println(야옹이.catName);
            System.out.println(야옹이.catColor);

            // 토토입양
            Cat toto = new Cat("토토", "노랑색");
            System.out.println(toto.catName);
            System.out.println(toto.catColor);

            Cat tutu = new Cat("투투", "흰색");
            System.out.println(tutu.catName);
            System.out.println(tutu.catColor);
        }
    }
}