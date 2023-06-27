package com.algaworks.algafoodapi.temp;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;

@Configuration
public class GenericConfig {

    @QualifierCustom(EnumQualifier.PRINTER_EPSON)
    @Autowired
    private Printer printer;

    public GenericConfig() {
        System.out.println("START: " + this.getClass().getSimpleName());
    }

    @Profile("dev")
    @Bean(initMethod = "postConstruct", destroyMethod = "preDestroy")
    public Generic01 generic01() {
        return new Generic01(this.printer);
    }
}
