package equalsAndHashcode;

import java.util.Objects;

public class Person {
    String name;
    int age;

    public Person() {}

    public Person(String name, int age) {
        this.name = name;
        this.age = age;
    }

    @Override
    public String toString() {
        return "name" + name + ',' + "age=" + age;
    }
}
