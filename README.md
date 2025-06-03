# 🛒 E-commerce – Sistema de Gerenciamento de Pedidos e Produtos  
![Java](https://img.shields.io/badge/java-%23ED8B00.svg?style=for-the-badge&logo=openjdk&logoColor=white)
![Spring](https://img.shields.io/badge/spring-%236DB33F.svg?style=for-the-badge&logo=spring&logoColor=white)
![MySQL](https://img.shields.io/badge/mysql-4479A1.svg?style=for-the-badge&logo=mysql&logoColor=white)

**Java Spring Boot + Spring Data JPA + MySQL**

Bem-vindo ao projeto **E-commerce**, uma aplicação backend desenvolvida com foco em boas práticas, organização e aprendizado avançado com **Spring Boot** e **Spring Data JPA**. Este sistema gerencia usuários, endereços, pedidos, itens de pedido, produtos e tags — representando com fidelidade um cenário real de e-commerce.

---

## 🚀 Objetivo do Projeto

Ao final deste projeto, você terá:

- Domínio das principais funcionalidades do Spring Data JPA;
- Experiência prática com relacionamentos entre entidades (One-to-One, One-to-Many, Many-to-One, Many-to-Many);
- Criação de endpoints RESTful completos com suporte a validações, paginação e filtros;
- Compreensão sólida sobre a arquitetura de projetos backend com foco em escalabilidade e manutenção.

---

## 📌 Regras de Negócio

### 👤 Usuário
- Código UUID
- Nome completo

### 🏠 Endereço de Cobrança
- Rua
- Número
- Complemento
- Relacionamento One-to-One com o Usuário

### 📦 Pedido
- Número do pedido
- Valor total
- Data do pedido
- Relacionamento Many-to-One com o Usuário
- Relacionamento One-to-Many com Itens do Pedido

### 🧾 Item do Pedido
- Valor pago pelo item
- Quantidade
- Relacionamento Many-to-One com Pedido
- Relacionamento Many-to-One com Produto

### 🛍 Produto
- Código do produto
- Nome
- Preço
- Relacionamento Many-to-Many com Tags

### 🏷️ Tag
- Código da tag
- Nome

---

## 📡 Endpoints REST

### 📥 Criar Pedido  
**POST** `/orders`  
**Corpo da Requisição:**
```json
{
  "userId": "e52b2380-8264-4154-8cdf-12ce9bda73b1",
  "items": [
    {
      "productId": 1,
      "quantity": 1
    },
    {
      "productId": 2,
      "quantity": 1
    }
  ]
}
```

---

### 📄 Listar Pedidos  
**GET** `/orders`  
**Resposta:**
```json
{
  "data": [
    {
      "orderId": 1,
      "orderDate": "2025-05-30T23:42:12.413093",
      "userId": "e52b2380-8264-4154-8cdf-12ce9bda73b1",
      "total": 6500.5
    }
  ],
  "pagination": {
    "page": 0,
    "pageSize": 10,
    "totalElements": 1,
    "totalPages": 1
  }
}
```

---

### 🔎 Detalhar Pedido  
**GET** `/orders/{orderId}`  
**Resposta:**
```json
{
  "orderId": 1,
  "total": 6500.5,
  "orderDate": "2025-05-30T23:42:12.413093",
  "user": "e52b2380-8264-4154-8cdf-12ce9bda73b1",
  "items": [
    {
      "salePrice": 4500.5,
      "quantity": 1,
      "product": {
        "productId": 1,
        "productName": "Computer",
        "tags": [
          {
            "tagId": 1,
            "name": "Eletronics"
          }
        ]
      }
    },
    {
      "salePrice": 2000,
      "quantity": 1,
      "product": {
        "productId": 2,
        "productName": "Smartphone",
        "tags": [
          {
            "tagId": 3,
            "name": "Apple"
          },
          {
            "tagId": 1,
            "name": "Eletronics"
          }
        ]
      }
    }
  ]
}
```

---

### ❌ Deletar Usuário  
**DELETE** `/users/{userId}`  
Exemplo:  
`DELETE /users/0afb708c-50d1-4252-bbfc-c98c83198a27`

---

## 🛠️ Tecnologias Utilizadas

- Java 21  
- Spring Boot  
- Spring Data JPA  
- Hibernate  
- MySQL  
- Maven

---

## 🧠 Aprendizados

Durante o desenvolvimento deste projeto, foram colocados em prática:

- Criação e organização de um projeto com Spring Boot  
- Modelagem de banco de dados relacional com JPA  
- Definição de entidades e relacionamentos complexos  
- Criação de repositórios e serviços orientados à regra de negócio  
- Exposição de endpoints RESTful com suporte à validação, paginação e filtros  
- Tratamento de erros e uso de boas práticas de arquitetura

---

## 📂 Estrutura do Projeto

```
src/
 ├── main/
 │   ├── java/com/ecommerce/
 │   │   ├── controller/
 │   │   ├── service/
 │   │   ├── repository/
 │   │   └── entity/
 │   └── resources/
 │       └── application.properties
```

---

## 🤝 Colaboradores

Agradecemos às seguintes pessoas que contribuíram para este projeto:

<table>
  <tr>
    <td align="center">
      <a href="https://github.com/Ital023" title="Github do Ítalo Miranda">
        <img src="https://avatars.githubusercontent.com/u/113559117?v=4" width="100px;" alt="Foto do Ítalo Miranda no GitHub"/><br>
        <sub>
          <b>Ítalo Miranda</b>
        </sub>
      </a>
    </td>
  </tr>
</table>

