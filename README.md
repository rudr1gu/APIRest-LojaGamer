# Loja Gamer API
## Descrição
A Loja Gamer API é uma aplicação RESTful construída com Spring Boot, que fornece endpoints para gerenciar categorias e produtos de uma loja de jogos. A API oferece funcionalidades para listar, buscar, criar, atualizar e deletar recursos.

A aplicação foi reorganizada para seguir a **Arquitetura Hexagonal (Ports and Adapters)**, separando regras de negócio (casos de uso), contratos (portas) e implementações de infraestrutura (adaptadores).

### Tecnologias Utilizadas
- Java 17
- Spring Boot 3.x
- Hibernate (JPA)
- Banco de Dados (compatível com MySQL)
- Jakarta Validation
- Lombok

## Endpoints
### Produtos

- `GET /produtos` - Lista todos os produtos
- `GET /produtos/{id}` - Retorna um produto específico
- `GET /produtos/nome/{nome}` - Retorna um produto específico pelo nome
- `POST /produtos` - Cria um novo produto
- `PUT /produtos` - Atualiza um produto existente
- `DELETE /produtos/{id}` - Deleta um produto

### Categorias

- `GET /categorias` - Lista todas as categorias
- `GET /categorias/{id}` - Retorna uma categoria específica
- `GET /categorias/nome/{nome}` - Retorna categoria pelo nome
- `POST /categorias` - Cria uma nova categoria
- `PUT /categorias` - Atualiza uma categoria existente
- `DELETE /categorias/{id}` - Deleta uma categoria

## Estrutura (Arquitetura Hexagonal)

```text
src/
└── main/
    ├── java/com/generation/lojagamer/
    │   ├── adapters/
    │   │   ├── in/web/
    │   │   │   ├── CategoriasController.java
    │   │   │   └── ProdutosController.java
    │   │   └── out/persistence/
    │   │       ├── CategoriaPersistenceAdapter.java
    │   │       ├── ProdutoPersistenceAdapter.java
    │   │       ├── SpringDataCategoriaRepository.java
    │   │       └── SpringDataProdutoRepository.java
    │   ├── application/
    │   │   ├── port/
    │   │   │   ├── in/
    │   │   │   │   ├── CategoriaUseCase.java
    │   │   │   │   └── ProdutoUseCase.java
    │   │   │   └── out/
    │   │   │       ├── CategoriaPersistencePort.java
    │   │   │       └── ProdutoPersistencePort.java
    │   │   └── service/
    │   │       ├── CategoriaService.java
    │   │       └── ProdutoService.java
    │   ├── domain/model/
    │   │   ├── Categoria.java
    │   │   └── Produtos.java
    │   └── LojagamerApplication.java
    └── resources/
        └── application.properties
```
