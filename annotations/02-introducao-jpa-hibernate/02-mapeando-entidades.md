# Mapeando Entidades com o JPA

- Criamos nossa class Java
- Anotamos com o @Entity que define o mapeamento da entidade com uma tabela do banco de dados
- Obrigatoriamente pelo compilador devemos add um atributo que representa a chave primaria da table @Id
- Opcionalmente podemos adicionar a annotation @Column para definir dados da coluna. No exemplo adicionamos as properties
de nome e tamanho.

Entidades(Classes) são tabelas e propriedades são colunas

Assim como a annotation @Column, existe também a annotation @Table que define dados da tabela, como por exemplo o nome
da tabela. Por default uma tabela gerada pelo spring tem o nome da classe em lowerCase. Mas definindo um nome com o
@Table ela fica a nosso critério.
```java
@Entity
@Table(name="entidade")
public class Entidade {
    @Id
    private Long id;
    
    @Column(name="name", length=30)
    private String name;
}
```

- Adicionaremos no arquivo de properties a propriedade do jpa para gerar o ddl(Data Definition Language). Assim as
classes do tipo Java anotadas como entidades serão transpiladas para entidades da database.

- Adicionaremos também uma propriedade para definir a forma com que será gerado o ddl. Essa propriedade é do hibernate
mais precisamente. Ela diz que irá recriar todo o conteúdo cada vez que o servidor reiniciar.
    - create: recria todo o schema
    - update: faz a atualização caso existir modificação. Mas tenta preservar os dados ja salvos.
    - create-drop: recria caso existir schema. Mas ai fim da session deleta todo o schema
    - 
```properties
spring.jpa.generate-ddl=true
spring.jpa.hibernate.ddl-auto=create
```

- Para o mapeamento do Id é interessante adicionar um comportamento automático de inserção de Id. Para que a cada nova
inserção de dados de uma nova row, não tenha a necessidade de informa um id.
 Usaremos a annotation @GeneratedValue(strategy=GenerationType.IDENTITY). O strategy é uma forma de como se inseri o dado
podemos usar outras formas. Outra muito usada é a sequence. Que define uma sequencia que se atualiza automaticamente a
cada inserção de um novo dado.
