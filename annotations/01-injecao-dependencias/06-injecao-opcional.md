# Injeção opcional
É Possível realizar uma injeção de forma opcional utilizando o @Autowired 

```java
@Component
public class Component01 {
    
    @Autowired(required = false)
    private Injection injection;
    
}
```
