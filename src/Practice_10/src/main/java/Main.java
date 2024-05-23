import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class Main {
    public static void main(String[] args) {
        ApplicationContext context = new AnnotationConfigApplicationContext(BeanConfig.class);
        try {
            Magican magican = (Magican) context.getBean(args[0].toLowerCase());
            magican.doMagic();
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }
}