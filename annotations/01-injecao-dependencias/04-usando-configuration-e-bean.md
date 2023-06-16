# Usando o @Configuration e @Bean

Quando desejamos configurar uma class antes de instancia-la no container spring. Como por exemplo da class PrintEpson:

Podemos verificar que a class PrintEpson agora precisa ter definido uma orientation e informado o valor de capsLk
pare desempenhar suas funções. E como a orientation esta no construtor, se quer ira subir o servidor, pois a class tem
uma dependência não injetada.
```java
@Component
public class PrintEpson implements Print {
    private boolean capsLk;
    private String orientation;
    
    public PrintEpson(String orientation) {
        this. orientation = orientation;
    }
    
    @Override
    public String print(String content) {
        return capsLk ? content.toUpperCase() : content;
    }
}
```

Para solucionar esse problemas nos usaremos o @Configuration e o @Bean

No exemplo abaixo nos criamos uma class de configuração anotando-a com @Configuration. Com essa anotação o spring usará
a class para verificar os @Beans que instanciam components para serem adicionados no container do spring.
No caso do PrintConfig tem um método com @Bean que instancia a class PrintEpson, sendo assim essa instancia é adicionada
no container spring de acordo como configuramos no @Bean. Com isso tiramos a annotation @Component da class PrintEpson e
mesmo assim ela será adicionada no container spring pelo @Bean
```java
import java.beans.BeanProperty;

@Configuration
public class PrintConfig {

    @Bean
    public PrintEpson printEpson() {
        PrintEpson printEpson =  new PrintEpson("portrait");
        printEpson.setCapsLk(true);
        return printEpson;
    }
}
```

No exemplo abaixo estamos criando outro @Bean que tem como dependência uma classe que também é instanciada por outro
@Bean. Caso fizerem parte da mesma class configuration é só chamar o método que instancia a class que queremos.

E se forem de class configuration diferentes, podemos injetar normalmente como fazemos em qualquer lugar.
```java

@Configuration
public class PrintConfig {

    @Bean
    public PrintEpson printEpson() {
        PrintEpson printEpson = new PrintEpson("portrait");
        printEpson.setCapsLk(true);
        return printEpson;
    }

    @Bean
    public Component01 component01() {
        Component01 component01 = new Component01(printEpson());
        return Component01;
    }
}


@Configuration
public class ComponentConfig {

    @BeanProperty
    public Component02 component02(PrintEpson printEpson) {
        Component02 component02 = new Component02(printEpson);
        return Component02;
    }
}
```

