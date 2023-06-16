# Ioc Container
Utilizado para injeção de dependências. Quando iniciamos um servidor Spring o Ioc
instancia todos os beans

**Beans** São objetos gerenciados pelo container Spring. Beans ou dependencies.
Beans podem ser injetados em outros beans gerenciados pelo container. Podendo 
existir cadeias de injeção, onde Bean01 injeta Bean02 que injeta Bean03.
