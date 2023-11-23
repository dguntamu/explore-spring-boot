package explore.spring.boot.explore.autoconfiguration;

import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Component;

@Component
public class Professer {
    @Bean("emp")
    public Professer professer(){
        return new Professer();
    }
}
