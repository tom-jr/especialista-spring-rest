# Profiles

Podemos Anotar um @Component ou um @Bean com a annotation @Profile("value"). Onde o value é o profile que será ativo
ao start do servidor spring. Quando um @Component/@Bean é anotado com @Profile ele só é instanciado no container do 
spring sé a propriedades **spring.profile.active** tiver o valor conforme o value do @Profile.

```java
@Profile("dev")
@Component
public class Component01 {
    public Component01() {
        
    }
}

@Profile("prod")
@Component
public class Component01 {
    public Component01() {

    }
}

```
application.properties:
```properties
spring.profile.active=dev
```

Podemos passar mais profiles separando por virgula para assim customizar de acordo com nossa necessidade
