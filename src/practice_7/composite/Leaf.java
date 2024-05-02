package practice_7.composite;

public class Leaf implements IComponent {
    private String name;

    public Leaf(String name) {
        this.name = name;
    }

    @Override
    public String getName() {
        return name;
    }
}
