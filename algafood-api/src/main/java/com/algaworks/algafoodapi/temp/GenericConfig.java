package com.algaworks.algafoodapi.temp;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class GenericConfig {

    public GenericConfig() {
        System.out.println("START: " + this.getClass().getSimpleName());
    }

    @Bean
    public Generic01 generic01(PrinterHP printer) {
        return new Generic01(printer);
    }
}
