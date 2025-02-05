# Shopping Online

API para simulação de um e-commerce.

## Tecnologias Utilizadas

- Java 17
- Spring Boot 3.4.2
- H2 Database
- Maven

## Estrutura do Projeto

- `src/main/java/com/online/shopping`: Contém o código fonte principal da aplicação.
  - `controllers`: Contém os controladores REST.
  - `dtos`: Contém os Data Transfer Objects.
  - `exceptions`: Contém as classes de exceção.
  - `mappers`: Contém os mapeadores de entidades.
  - `models`: Contém as entidades JPA.
  - `repositories`: Contém os repositórios JPA.
  - `services`: Contém as classes de serviço.
- `src/main/resources`: Contém os recursos da aplicação, como o arquivo `application.properties`.
- `src/test/java/com/online/shopping`: Contém os testes da aplicação.

## Endpoints

### Clientes

- `POST /clientes`: Cria um novo cliente.
- `GET /clientes/{cpf}`: Retorna os detalhes de um cliente pelo CPF.
- `GET /clientes`: Retorna todos os clientes.
- `PATCH /clientes/{cpf}`: Atualiza o email de um cliente.
- `DELETE /clientes/{id}`: Deleta um cliente pelo ID.

### Produtos

- `POST /produtos`: Cria um novo produto.
- `GET /produtos`: Retorna todos os produtos.
- `DELETE /produtos/{id}`: Deleta um produto pelo ID.

### Compras

- `POST /compras`: Cria uma nova compra.

## Como Executar

1. Clone o repositório:
   ```sh git clone git@github.com:Dev-GabCosta/shopping-online.git```
2. Navegue até o diretório do projeto:
cd shopping
3. Execute o projeto usando Maven:
./mvnw spring-boot:run
4. Acesse a aplicação em http://localhost:8080.
Banco de Dados
A aplicação utiliza o banco de dados H2 em memória. Para acessar o console do H2, vá para http://localhost:8080/h2-console e use as seguintes credenciais:
- Driver Class: org.h2.Driver
- JDBC URL: jdbc:h2:mem:testdb
- User Name: sa
- Password: (deixe em branco)
Autor
Gabriel Costa