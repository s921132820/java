package oopCh02;

import java.util.Scanner;

public class OverloadingTest {
    public static void main(String[] args) {
        Running runner = new Running("김형민");
        runner.running();
        runner.running(42.195);
        runner.running(10);
        runner.running(5, 20);
    }
}
