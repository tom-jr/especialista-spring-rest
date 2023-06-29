# Acessando propriedades customizadas com o @Value
podemos criar propriedades customizadas e injeta-las nos componentes

```properties
prop.custom.teste=PROPERTY_CUSTOM
```

```java
@Component
public class Component01 {
    @Value("${prop.custom.teste}")
    private String customProperty;
    
    public Component01 () {
        System.out.println(this.customProperty);
    }
}
```
