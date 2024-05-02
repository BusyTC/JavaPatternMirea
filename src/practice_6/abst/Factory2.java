package practice_6.abst;

public class Factory2 implements IFactory {
    @Override
    public IProduct1 createProduct1() {
        return new Product12();
    }

    @Override
    public IProduct2 createProduct2() {
        return new Product22();
    }
}
