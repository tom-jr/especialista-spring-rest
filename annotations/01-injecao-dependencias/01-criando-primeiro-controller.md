# Primeiro Controller - Spring MVC

para criar um controller em um projeto Spring:

- Criamos uma class
- Anotamos com o @Controller
- criamos um método e anotamos com @GetMapping e @ResponseBody

O @Controller informa ao spring que a class é um controller. Logo o spring 
configura para que essa class receba requisições web e execute métodos conforme 
o path da requisição.

O @GetMapping("/path") é uma anotação que define o tipo de método HTTP. Pode
ou não ter um valor que representa um caminho de acesso ao método
```java
@Controller
public class PrimeiroController {
    
    @GetMapping("/hello")
    @ResponseBody
    public hello() {
        return "Hello World!";
    }
}
```
Para acessar esse método informamos a url do servidor mais o caminho do método:
API esta servida no localhost na porta 8080, logo:
url: http://localhost:8080
o path do método hello é: "/hello"
path: "/hello"

Logo o acesso é feito:
url+path = http://localhost:8080/hello

Assim na requisição a esse resource o retorno do método hello será tratado como
uma resposta de servidor devido a annotation de @ResponseBody e será enviado 
para o navegador como uma resposta.
