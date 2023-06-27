# LifeCycle Beans

Nos podemos adicionar métodos de lifecycle nos beans ou componentes. Para que podemos executar funções apos a 
inicialização do Bean/Component e momento antes de destruir o Bean/Component

Formas:
- @PosConstruct, @PreDestroy. O Component que tenha métodos com está annotations ira executar conforme a anotação. Onde
o método anotado como PostConstructor irá executar logo após a inicialização do Bean/Component e o @PreDestroy irá 
executar momento antes da destruição do Bean Component.

```java
@Component
public class Component01 {
    @PostConstruct
    public void postConstruct() {
//        code-block
    }

    @PreDestroye
    public void preDestroy() {
//        code-block
    }
}
```

- @Bean(initMethod ="methodName", destroyMethod="methodName"). Utilizado em classes de configuração. Onde o Bean de
inicialização é preenchido com as properties de initMethod e destroyMethod. Assim os métodos referenciados assumiram os
papeis definidos.

```java

@Configuration
public class ConfigBeans() {

    @Bean(initMethod = "postConstruct", destroyMethod = "preDestroy")
    public Component01 component01Bean() {
        return new Component01();
    }
}

@Component
public class Component01 {
    
    public void postConstruct() {
        //code-block
    }
    
    public void preDestroy() {
        //code-block
    }
}
```
