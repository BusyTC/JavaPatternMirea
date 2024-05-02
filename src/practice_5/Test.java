package practice_5;

public class Test {
    public static void main(String[] args) {
        var sin11 = Singleton1.getInstance();
        var sin12 = Singleton1.getInstance();
        System.out.println(sin11.getX() + " = " + sin12.getX());

        var sin21 = Singleton2.INSTANCE;
        var sin22 = Singleton2.INSTANCE;
        System.out.println(sin21.getX() + " = " + sin22.getX());

        var sin31 = Singleton3.instance;
        var sin32 = Singleton3.instance;
        System.out.println(sin31.getX() + " = " + sin32.getX());
    }
}
