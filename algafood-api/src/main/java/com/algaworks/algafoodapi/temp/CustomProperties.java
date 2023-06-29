package com.algaworks.algafoodapi.temp;

import lombok.Getter;
import lombok.Setter;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

@Component
@Getter
@Setter
@ConfigurationProperties("custom.property")
public class CustomProperties {

    private String propertyOne;
    private String propertyTwo;
}
