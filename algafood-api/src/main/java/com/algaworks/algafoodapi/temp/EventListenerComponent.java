package com.algaworks.algafoodapi.temp;

import org.springframework.context.event.EventListener;
import org.springframework.stereotype.Component;

@Component
public class EventListenerComponent {

    @EventListener
    public void eventListener(Event event) {
        System.out.println(event.getArg());
    }
}
