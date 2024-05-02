package practice_6.factory;

public abstract class Creator {
    public abstract IProduct factoryMethod();

    public void printName() {
        IProduct product = factoryMethod();
        System.out.println(product.getName());
    }
}
