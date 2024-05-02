package practice_6.abst;

public class Test {
    public static void main(String[] args) {
        Factory1 factory1 = new Factory1();
        System.out.println(factory1.createProduct1().getName());
        System.out.println(factory1.createProduct2().getName());

        Factory2 factory2 = new Factory2();
        System.out.println(factory2.createProduct1().getName());
        System.out.println(factory2.createProduct2().getName());
    }
}
