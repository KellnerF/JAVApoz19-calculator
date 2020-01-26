package pl.sda.spring.operation;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
class SubstractionPowerOperationConfiguration {

    @Bean
    PowerOperation powerOperation (){return new PowerOperation();}
}
