package practice_5;

import java.util.Random;

public class Singleton1 {
    private static Singleton1 instance;
    private final int x;
    private Singleton1() {
        x = new Random().nextInt();
    }

    public int getX() {
        return x;
    }

    public static Singleton1 getInstance() {
        if (instance == null) {
            instance = new Singleton1();
        }
        return instance;
    }
}
