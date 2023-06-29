package com.algaworks.algafoodapi.temp;

import org.springframework.beans.factory.annotation.Value;

public class Generic01 {
    private final Printer printer;

    public Generic01(Printer printer){
        System.out.println("START: " + this.getClass().getSimpleName());
        this.printer = printer;
    }

    public String method() {
       return this.printer.print("TESTE");
    }

    private void postConstruct() {
        System.out.println(this.getClass().getSimpleName() + " pós-iniciado");
    }

    public void preDestroy() {
        System.out.println(this.getClass().getSimpleName() + " pre-destruir");
    }
}
