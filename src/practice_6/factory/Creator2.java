package practice_6.factory;

public class Creator2 extends Creator {

    @Override
    public IProduct factoryMethod() {
        return new Product2();
    }
}
