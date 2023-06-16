package com.algaworks.algafoodapi.temp;

import org.springframework.stereotype.Component;

//@Component
public class PrinterHP implements Printer{
    public PrinterHP () {
        System.out.println("START: " + this.getClass().getSimpleName());
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
