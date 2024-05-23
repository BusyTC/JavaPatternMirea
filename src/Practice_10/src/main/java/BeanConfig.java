import org.springframework.beans.support.PagedListHolder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class BeanConfig {
    @Bean("voldemort")
    public Magican voldemort() {
        return new Voldemort();
    }

    @Bean("harrypotter")
    public Magican harrypotter() {
        return new HarryPotter();
    }

    @Bean("ronweesly")
    public Magican ronweesly() {
        return new RonWeesly();
    }
}
