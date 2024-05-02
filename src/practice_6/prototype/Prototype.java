package practice_6.prototype;

public class Prototype implements IPrototype {
    private String name;

    public Prototype(String name) {
        this.name = name;
    }

    @Override
    public Prototype clone() {
        return new Prototype(name);
    }

    @Override
    public String toString() {
        return "Prototype{" +
                "name='" + name + '\'' +
                '}';
    }
}
