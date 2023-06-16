package com.algaworks.algafoodapi.temp;

import org.springframework.stereotype.Component;

@Component
public interface Printer {
    String print(String content);
}
