# Pontos de injeção com @Autowired

- Primeira forma de injeção é definindo qual construtor será considerado pelo spring para injeção de suas dependências.
Caso tenha apenas 1 construtor, ele será o construtor utilizado. Mas se existir outro construtor iremos usar a annotation
@Autowired para definir o construtor
```java
@Component
public class Component01 {
    
    private Injection injection;
    private Param param;
    
    @Autowired
    public Component01(Injetion injetion) {
        this.injection = injetion;
    }

    public Component01(Param param) {
        this.param = param;
    }
}
```
- Segunda forma é injetar cada atributo usando o @Autowired no set do atributo a ser injetado 
```java
@Component
public class Component01 {
    
    private Injection injection;
    
    public Component01(Injetion injetion) {
        this.injection = injetion;
    }
    
    @Autowired
    public void setInjection(Injection injection) {
        this.injection = injection;
    }
}
```

- Terceira forma de injeção é adicionando o Autowired na declaração do atributo
```java
@Component
public class Component01 {
    
    @Autowired
    private Injection injection;
    
    public Component01(Injetion injetion) {
        this.injection = injetion;
    }
}
```
