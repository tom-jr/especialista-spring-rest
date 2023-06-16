package com.algaworks.algafoodapi.temp;

import lombok.Getter;
import lombok.Setter;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Component;

//@Component
//@Primary
@Getter
@Setter
public class PrinterEpson implements Printer {

    private boolean capsLK;
    private String orientation;
    public PrinterEpson(String orientation) {
        System.out.println("START: " + this.getClass().getSimpleName());
        this.orientation = orientation;
    }

    @Override
    public String print(String content) {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("----------<br>");
        stringBuilder.append(capsLK ? content.toUpperCase() : content);
        stringBuilder.append("<br>");
        stringBuilder.append("----------<br>");
        stringBuilder.append("Printed by: " + this.getClass().getSimpleName() + "<br>");
        stringBuilder.append("Orientation: "+ this.orientation);
        return stringBuilder.toString();
    }
}
