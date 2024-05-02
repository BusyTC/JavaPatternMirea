package practice_6.builder;

public class Builder implements IBuilder {
    Product product = new Product();

    @Override
    public void setName(String name) {
        product.setName(name);
    }

    @Override
    public void setCost(int cost) {
        product.setCost(cost);
    }

    @Override
    public void setCount(int count) {
        product.setCount(count);
    }

    public Product getResult() {
        return product;
    }
}
