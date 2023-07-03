# Adicionando JPA e configurando DataSource

- Primeiro adicionamo o started do JPA em nosso projeto. No nosso arquivo ***pom.xml*** podemos fazer isso:

```xml
<!-- https://mvnrepository.com/artifact/org.springframework.boot/spring-boot-starter-data-jpa -->
<dependency>
    <groupId>org.springframework.boot</groupId>
    <artifactId>spring-boot-starter-data-jpa</artifactId>
</dependency>

```

- Adicionamos a dependency do do Drive do banco de dados conforme com o banco que estamos utilizando

- Configuramos os application.properties. Podemos definir configuração para cada profile e o profile active será o 
carregado para a configuração em runtime.

```properties
#data-sources 
spring.datasource.url=jdbc:db-name://host:port/db-name
spring.datasource.username=username
spring.datasource.password=password
#data-sources
```
