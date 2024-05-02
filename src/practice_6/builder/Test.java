package practice_6.builder;

public class Test {
    public static void main(String[] args) {
        Director director = new Director();

        Builder builder1 = new Builder();
        director.constructProduct1(builder1);
        System.out.println(builder1.getResult());

        Builder builder2 = new Builder();
        director.constructProduct2(builder2);
        System.out.println(builder2.getResult());
    }
}
