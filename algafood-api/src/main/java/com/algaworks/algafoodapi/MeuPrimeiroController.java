package com.algaworks.algafoodapi;

import com.algaworks.algafoodapi.domain.models.Cozinha;
import com.algaworks.algafoodapi.jpa.CadastroCozinha;
import com.algaworks.algafoodapi.temp.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.ApplicationEventPublisher;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

@Controller
public class MeuPrimeiroController {

    @Autowired
    @QualifierCustom(EnumQualifier.PRINTER_EPSON)
    private Printer printer;

    @Autowired
    private CadastroCozinha cadastroCozinha;

    @Autowired
    private Generic01 generic01;

    @Value("${prop.custom.teste}")
    private String customProperty;

    @Autowired
    private CustomProperties customProperties;

    @Autowired
    private ApplicationEventPublisher applicationEventPublisher;

    @GetMapping("/hello")
    @ResponseBody
    public String hello() {
        System.out.println(this.generic01.method());
        System.out.println("Propriedade acessada com @Value = " + this.customProperty);
        System.out.println("Propriedade acessada com Component CustomProperties = " +
                this.customProperties.getPropertyOne());

        this.applicationEventPublisher.publishEvent(new Event("Evento Lançado pela class:" +
                this.getClass().getSimpleName()));
        return printer.print("Hello World!!!!");
    }

    @GetMapping("/cozinhas")
    @ResponseBody
    List<Cozinha> buscarCozinha() {
        return cadastroCozinha.consultarCozinha();
    }

}
