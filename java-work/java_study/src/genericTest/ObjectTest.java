package genericTest;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class ObjectTest {
    public static void main(String[] args) {
        Object dog = new Dog();
        Object cat = new Cat();
        List<Object> animalist = new ArrayList<>();
        animalist.add(dog);
        animalist.add(cat);

        // 다운캐스팅
        String name = ((Dog)dog).getName();
        System.out.println(name);

        // 다운캐스팅
        Cat myCat = (Cat) cat;
        System.out.println(myCat.getName());
    }
}
