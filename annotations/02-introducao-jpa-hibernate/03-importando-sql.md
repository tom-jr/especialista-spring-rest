# Importando SQL com import.sql

Podemos adicionar em nosso dir de resource o arquivo ***import.sql***. Ele executa todo sql inserido nele. Então sempre
que o servidor ser iniciado esse import será executado. Muito interessante para mock de dados.

```postgresql
insert into table_name (attributes) values ('values');
insert into table_name (attributes) values ('values');
```
