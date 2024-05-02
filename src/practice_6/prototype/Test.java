package practice_6.prototype;

public class Test {
    public static void main(String[] args) {
        Prototype prototype1 = new Prototype("name");
        Prototype prototype2 = prototype1.clone();
        System.out.println(prototype1 + " = " + prototype2);
    }
}
