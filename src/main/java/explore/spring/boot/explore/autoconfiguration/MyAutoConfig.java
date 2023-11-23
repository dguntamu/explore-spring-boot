package explore.spring.boot.explore.autoconfiguration;

import org.springframework.boot.autoconfigure.AutoConfiguration;
import org.springframework.boot.autoconfigure.condition.ConditionalOnBean;
import org.springframework.boot.autoconfigure.condition.ConditionalOnClass;
import org.springframework.context.annotation.Bean;

@AutoConfiguration
public class MyAutoConfig {

    //@ConditionalOnClass(Professer.class)
    @ConditionalOnBean(name = "emp")
    @Bean
    public College college(){
        return new College();
    }
}
