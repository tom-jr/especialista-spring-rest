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


## Utilizando Component para definir grupo de Properties

```java

@Component
@ConfigurationPropery("property.prefixe")
public class GroupProperties {

    private String propOne = "default value";
    private String propTwo;

    public String getPropOne() {
        return propOne;
    }

    public String getPropTwo() {
        return propTwo;
    }
}

@Component
public class Component01 {
    @Autowired
    private GroupProperties properties;

    public Component01() {
        System.out.println(this.properties.getPropOne());
    }
}

```
valores das propriedades no application.properties
```properties
property.prefixe.prop-one = One
property.prefixe.prop-two = Two

```

Interessante add essa dep para poder ter o autocomplete quando for definir a property no application.property

```xml

<dependency>
    <groupId>org.springframework.boot</groupId>
    <artifactId>spring-boot-configuration-processor</artifactId>
    <optional>true</optional>
</dependency>
```
