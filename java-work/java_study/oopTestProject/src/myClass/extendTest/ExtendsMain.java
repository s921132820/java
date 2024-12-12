package myClass.extendTest;

import myClass.chicken.Chicken;

public class ExtendsMain {
    public static void main(String[] args) {
        CheeseHamburger cheeseburger = new CheeseHamburger();
        System.out.println(cheeseburger.getName());
        System.out.println(cheeseburger.get재료1());
        System.out.println(cheeseburger.get재료2());
        System.out.println(cheeseburger.get재료3());

        System.out.println("=====================");
        ChickenBurger chickenBurger = new ChickenBurger();
        System.out.println(chickenBurger.getName());
        System.out.println(chickenBurger.get재료2());
        System.out.println(chickenBurger.get재료3());
        System.out.println("=====================");

        Hamburger burger = new Hamburger();
        System.out.println(burger.toString());
    }
}
