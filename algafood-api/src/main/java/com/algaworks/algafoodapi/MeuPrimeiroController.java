package com.algaworks.algafoodapi;

import com.algaworks.algafoodapi.temp.Printer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class MeuPrimeiroController {

    @Autowired
    @Qualifier("hp")
    private Printer printer;

//    public MeuPrimeiroController(Printer printer) {
//        System.out.println("START: " + this.getClass().getSimpleName());
//        this.printer = printer;
//    }

    @GetMapping("/hello")
    @ResponseBody
    public String hello() {
        return printer.print("Hello World!!!!");
    }
}
