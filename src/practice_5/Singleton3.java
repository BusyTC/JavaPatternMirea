package practice_5;

import java.util.Random;

public class Singleton3 {
    public static final Singleton3 instance = new Singleton3();

    private final int x;
    private Singleton3() {
        x = new Random().nextInt();
    }

    public int getX() {
        return x;
    }

    public static Singleton3 getInstance() {
        return instance;
    }
}
