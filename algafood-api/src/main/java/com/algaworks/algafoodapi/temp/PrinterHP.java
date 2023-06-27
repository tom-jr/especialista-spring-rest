package com.algaworks.algafoodapi.temp;

import jakarta.annotation.PostConstruct;
import jakarta.annotation.PreDestroy;
import org.springframework.stereotype.Component;

@Component
@QualifierCustom(EnumQualifier.PRINTER_HP)
public class PrinterHP implements Printer{
    public PrinterHP () {
        System.out.println("START: " + this.getClass().getSimpleName());
    }


    @PostConstruct
    public void postConstruct() {
        System.out.println(this.getClass().getSimpleName() + " pós-iniciado");
    }

    @PreDestroy
    public void preDestroy() {
        System.out.println(this.getClass().getSimpleName() + " pre-destruir");
    }

    @Override
    public String print(String content) {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("----------<br>");
        stringBuilder.append(content + "<br>");
        stringBuilder.append("----------<br>");
        stringBuilder.append("Printed by: " + this.getClass().getSimpleName());
        return stringBuilder.toString();
    }
}
