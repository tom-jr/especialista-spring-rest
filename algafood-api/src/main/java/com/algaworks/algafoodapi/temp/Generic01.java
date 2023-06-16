package com.algaworks.algafoodapi.temp;

public class Generic01 {
    private final Printer printer;

    public Generic01(Printer printer){
        System.out.println("START: " + this.getClass().getSimpleName());
        this.printer = printer;
    }
}
