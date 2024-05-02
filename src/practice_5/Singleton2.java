package practice_5;

import java.util.Random;

public enum Singleton2 {
    INSTANCE;
    private final int x;
    private Singleton2() {
        x = new Random().nextInt();
    }

    public int getX() {
        return x;
    }
    public Singleton2 getInstance() {
        return INSTANCE;
    }
}
