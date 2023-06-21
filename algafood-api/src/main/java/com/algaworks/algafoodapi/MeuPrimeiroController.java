package com.algaworks.algafoodapi;

import com.algaworks.algafoodapi.temp.EnumQualifier;
import com.algaworks.algafoodapi.temp.Generic01;
import com.algaworks.algafoodapi.temp.Printer;
import com.algaworks.algafoodapi.temp.QualifierCustom;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class MeuPrimeiroController {

    @Autowired
    @QualifierCustom(EnumQualifier.PRINTER_EPSON)
    private Printer printer;

    @Autowired
    private Generic01 generic01;

//    public MeuPrimeiroController(Printer printer) {
//        System.out.println("START: " + this.getClass().getSimpleName());
//        this.printer = printer;
//    }

    @GetMapping("/hello")
    @ResponseBody
    public String hello() {
        System.out.println(this.generic01.method());
        return printer.print("Hello World!!!!");
    }
}
