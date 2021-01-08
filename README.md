# Movie-API

# Documentação Backend

## Teste

Deverá ser passado no Postman dois parametros na Hearders!

KEY: Content-Type
VALUE: Aplication/Json

## URL´s das API´s

### default path: http://localhost:{port}/api/

###  `/conta`
###  `/filme`
###  `/genero`

url utilizada para buscar os dados de uma entidade.
retorna um HTTPSTATUS 200.

## `conta/{id}`
## `filme/{id}`
## `genero/{id}`

url utilizada para deletar uma entidade utilizando como parametro o Identificador da Entidade.
retorna um HTTPSTATUS 204.

## `/conta`
## `/filme`
## `/genero`

url utilizada para inserir os dados de uma entidade.
retorna um HTTPSTATUS 201.

## `/conta/{id}`
## `/filme/{id}`
## `/genero/{id}`

url utilizada para atualizar os dados de uma entidade.
retorna um HTTPSTATUS 201.

## `cliente/{id}`
## `filme/{id}`
## `genero/{id}`

url utilizada para buscar os dados de uma entidade utilizando como parametro o Identificador da Entidade.
retorna um HTTPSTATUS 200.

## `filme/genero?name={genero}`

url utilizada para filtrar os filmes por genero.
retorna um HTTPSTATUS 200.
