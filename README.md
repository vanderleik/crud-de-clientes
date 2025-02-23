# Desafio CRUD de clientes

### Formação Desenvolvedor Moderno
### Módulo: Back end
### Capítulo: API REST, camadas, CRUD, exceções, validações

## Desafio CRUD de clientes

<p>Este projeto é um desafio de programação do curso Java Spring Profissional, do DevSuperior.
Trata-se de uma aplicação Spring Boot, que utiliza banco de dados em memória H2 e implementa um CRUD(L) de clientes.</p>

<p>A lista de nomes pré configurada no projeto se refere aos personagens e atores/atrizes da série The Office. Os CPFs 
foram gerados de forma aleatória utilizando o Microsoft Excel através da fórmula:</p>

=SEERRO(TEXTO(ALEATÓRIOENTRE(0;999);"000")&"."&TEXTO(ALEATÓRIOENTRE(0;999);"000")&"."&TEXTO(ALEATÓRIOENTRE(0;999);"000")&"-00";"erro")

## Regras específicas de funcionamento do sistema:
* Nome: não pode ser vazio
* Data de nascimento: não pode ser data futura

## Comportamento esperado:
* Busca por id retorna cliente existente
*  Busca por id retorna 404 para cliente inexistente
*  Busca paginada retorna listagem paginada corretamente
*  Inserção de cliente insere cliente com dados válidos
*  Inserção de cliente retorna 422 e mensagens customizadas com dados inválidos
*  Atualização de cliente atualiza cliente com dados válidos
*  Atualização de cliente retorna 404 para cliente inexistente
*  Atualização de cliente retorna 422 e mensagens customizadas com dados inválidos
*  Deleção de cliente deleta cliente existente
*  Deleção de cliente retorna 404 para cliente inexistente

## ESPECIFICAÇÃO - Sistema CLIENTE:
<p>O sistema construído gerencia as informações dos clientes de uma empresa.
Cada cliente possui nome, cpf, renda e data de nascimento.</p>

## Tecnologias Utilizadas
- Java
- Spring Boot
- JPA / Hibernate
- Maven
- H2 Database
- Bean Validation

### Executando a Aplicação
Para executar a aplicação, utilize o Maven para compilar e rodar o projeto:
```bash
mvn spring-boot:run
```

### Acesso ao Banco de Dados
Para acessar o banco de dados H2, acesse o endereço:
```bash
http://localhost:8080/h2-console
```
- JDBC URL: jdbc:h2:mem:testdb
- User Name: sa
- Password: 

### Endpoints
- POST /clients: insere um novo cliente
- GET /clients: busca todos os clientes paginados 
- GET /clients/{id}: busca um cliente por id
- PUT /clients/{id}: atualiza um cliente
- DELETE /clients/{id}: deleta um cliente
