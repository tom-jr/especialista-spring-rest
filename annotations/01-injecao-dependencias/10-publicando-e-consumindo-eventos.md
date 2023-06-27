# Publicando e consumindo eventos

Podemos injetar uma class para emitir eventos e podemos definir components que leem sejam ouvintes destes events.

```java
@Component
public class Component01 {
    
    @Autowired
    private ApplicationEventPublisher publisher;
    
    public void method() {
        this.publisher.publishEvent(new EventCustom("Emitting event"));
    }
}

public class EventCustom {
    
    private String arg;
    
    public  EventCustom (String arg) {
        this.arg = arg;
    }
    public String getArg() {
        return this.arg;
    }
}

@Component
public class EventListenerComponent {

    @EventListener
    public void listenerEventCustom(EventCustom event) {
        System.out.println(event.getArg());
    }
}
```
