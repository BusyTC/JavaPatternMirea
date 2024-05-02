package practice_7.composite;

public class Test {
    public static void main(String[] args) {
        Leaf leaf1 = new Leaf("Leaf 1");
        Leaf leaf2 = new Leaf("Leaf 2");
        Leaf leaf3 = new Leaf("Leaf 3");
        Leaf leaf4 = new Leaf("Leaf 4");
        Leaf leaf5 = new Leaf("Leaf 5");
        Composite composite = new Composite();

        composite.add(leaf1);
        composite.add(leaf2);
        composite.add(leaf3);
        System.out.println(composite.getName());

        composite.add(leaf4);
        composite.add(leaf5);
        System.out.println(composite.getName());

        composite.remove(leaf3);
        System.out.println(composite.getName());

        System.out.println(composite.getChild(2).getName());
    }
}
