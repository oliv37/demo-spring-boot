package fr.tnframework.autoconfigure;

import fr.tnframework.core.service.LineService;
import org.springframework.boot.autoconfigure.condition.ConditionalOnMissingBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
// @ConditionalOnClass(LineService.class)
public class TnAutoconfiguration {

    @Bean
    @ConditionalOnMissingBean(LineService.class)
    public LineService lineService() {
        return new LineService();
    }

}
