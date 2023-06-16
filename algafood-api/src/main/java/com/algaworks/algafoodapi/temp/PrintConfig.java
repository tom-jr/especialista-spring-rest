package com.algaworks.algafoodapi.temp;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class PrintConfig {

    public PrintConfig() {
        System.out.println("START: " + this.getClass().getSimpleName());
    }

    @Bean
    public PrinterEpson printerEpson() {
        PrinterEpson printerEpson = new PrinterEpson("Landscape");
        printerEpson.setCapsLK(true);
        return printerEpson;
    }
}
