package practice_6.factory;

public class Creator1 extends Creator {
    @Override
    public IProduct factoryMethod() {
        return new Product1();
    }
}
