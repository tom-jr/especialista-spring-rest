# Definindo Bean com @Component

Se quisermos que uma class seja instanciada e gerenciada pelo container do Spring podemos anotá-la como um **@Component
**

Esse processo de instanciação ocorre na inicialização da aplicação.

## Injetando dependência

no Spring, a class gerenciada pelo container de injeção pode ser injetada pelo construtor da class que deseja injetar em
si aquela dependência

```java

@Component // bean gerenciado pelo spring ioc
public class Componente01 {
    // codeBlock
}

@Component
public class Component02 {
    private Componente01 injection;

    public Component02(Componente01 injection) {
        this.injection = injection;
    }
    // codeBlock
}
```

Caso o Component01 fosse implementação de uma interface, e essa interface fosse injetada no component02. O Component01
seria injetado por default devido ser uma implementação da interface. Caso interface não tenha implementação o servidor
não completaria a inicialização.

```java

@Component
public interface Printer {
    String print(String content);
}

@Component
public class PrinterHP implements Printer {
    @Override
    public print(String content) {
        return content;
    }
}

@Component
public class Workspace {

    private final Printer printer;
    
    public Workspace(Printer printer) {
        this.printer = printer;
    }
    
    public String process() {
        return this.printer.print("Content001");
    }
}
```
