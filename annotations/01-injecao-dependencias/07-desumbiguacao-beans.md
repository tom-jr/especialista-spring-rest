# Beans Ambiguous
Quando temos um component com uma injeção de dependência e no container do spring existem múltiplos components para tal
injeção é lançado erro pelo spring.
Existem Algumas ações que o Spring nos recomenda para resolver tal problema

- **Refatorar a injeção**
Fazer com que a propriedade injetada seja uma list. Assim toda e qualquer injeção disponível será injetada.
```java
@Component
public class Component01 {
    @Autowired
    private List<Injection> injectionList;
}
```

- **@Primary**
Podemos definir um de nossos Components como primary para quando houver casos de vários
componentes de uma mesma implementações existam. Assim o spring dará prioridade em injetar o 
component anotado como @Primary

```java
@Component
public interface Injection {
    void method();
}

@Component
public class InjectionImpl1 implements Injection {
    @Override
    void method() {
        //codeBlock
    }
}

@Component
@Primary
public class InjectionImpl2 implements Injection {
    @Override
    void method() {
        //codeBlock
    }
}
```

- **@Qualifier**
Com o qualifier podemos definir os components com seus qualifies respectivos assim podemos definir em cada injeção o 
qualifier referente a qual implementação desejamos injetar em cada caso.

```java
@Component
public interface Injection {
    void method();
}

@Component
@Qualifier("in01")
public class InjectionImpl1 implements Injection {
    @Override
    void method() {
        //codeBlock
    }
}

@Component
@Qualifier("in02")
public class InjectionImpl2 implements Injection {
    @Override
    void method() {
        //codeBlock
    }
}

@Component
public class Generic {
    
    @Autowired
    @Qualifier("in01")
    private Injection injection;
}
```

Os beans criados em alguma class de configuração também podem ser anotados com o @Qualifier, assim podem ser selecionados
em uma injeção para especificar que aquela instanciação do bean será a utilizada

```java
import java.beans.BeanProperty;

@Component
public interface Injection {
    void method();
}

public class InjectionImpl1 implements Injection {
    @Override
    void method() {
        //codeBlock
    }
}

public class InjectionImpl2 implements Injection {
    @Override
    void method() {
        //codeBlock
    }
}

@Configuration
public class InjectionConfiguration {

    @Bean
    @Qualifier("in01")
    InjectionImpl1 impl1() {
        return new InjectionImpl1();
    }

    @Bean
    @Qualifier("in02")
    InjectionImpl1 impl2() {
        return new InjectionImpl2();
    }
}

@Component
public class Generic {

    @Autowired
    @Qualifier("in02")
    private Injection injection;
}
```


- **Annotation customizada**
Podemos customizar nossos qualifiers criando um enum que será o novo identificador. Então criamos uma annotation
e definimos o enum como value. O exemplo se torna auto explicativo

```java
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;

public enum EnumQualifier {
    INJECT_01, INJECT_02;
}

@Qualifier
@Retention(RetentionPolicy.RUNTIME)
public @interface QualifierCustom {
    EnumQualifier value();
}

@Component
public interface Inject {
    void method();
}

@QualifierCustom(EnumQualifier.INJECT_01)
@Component
public class InjectImpl1 implements Inject {
    @Override
    void method() {
//        codeBlock
    }
}

@QualifierCustom(EnumQualifier.INJECT_02)
@Component
public class InjectImpl2 implements Inject {
    @Override
    void method() {
//        codeBlock
    }
}

@Component
public class Main {
    
    @Autowired
    @QualifierCustom(EnumQualifier.INJECT_01)
    private Inject inject;
    
    public void  methodMain() {
        this.inject.method();
    }
}
```
