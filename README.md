# AgendaCliente
Agenda Cliente Compasso
Cadastrar cliente
POST - http://localhost:8080/clientes
{
    "nome": "Jamil Andrade",
    "sexo": "M",
    "dataNascimento": "24/06/1971",
    "idade": 50,
    "tipo": 1,
    "cidadeId": 1
}

Resultado - http://localhost:8080/clientes/5
***********************************************************
Cadastrar Cidade
POST - http://localhost:8080/cidades
{
    "nome": "Contagem",
    "estadoId": 12
}
*********************************************************
Consultar cidade pelo nome
GET - http://localhost:8080/cidade/nome?value=Belo Horizonte
Resultado:
{
    "id": 1,
    "nome": "Belo Horizonte",
    "estado": {
        "id": 1,
        "nome": "Minas Gerais - MG"
    }
}
*********************************************************
Consultar cidade pelo estado
GET - http://localhost:8080/estados/12/cidades
Resultado:
[
    {
        "id": 1,
        "nome": "Belo Horizonte"
    },
    {
        "id": 5,
        "nome": "Contagem"
    }
]
********************************************************
Consultar cliente pelo nome
GET - http://localhost:8080/clientes/nome?value=Maria Silva
Resultado:
{
    "id": 1,
    "nome": "Maria Silva",
    "sexo": "F",
    "dataNascimento": "20/05/1988",
    "idade": 32,
    "tipo": "PESSOAFISICA",
    "municipio": {
        "id": 1,
        "nome": "Belo Horizonte",
        "estado": {
            "id": 1,
            "nome": "Minas Gerais - MG"
        }
    }
}
*******************************************************
Consultar cliente pelo Id
GET - http://localhost:8080/clientes/1
Resultado:
{
    "id": 1,
    "nome": "Maria Silva",
    "sexo": "F",
    "dataNascimento": "20/05/1988",
    "idade": 32,
    "tipo": "PESSOAFISICA",
    "municipio": {
        "id": 1,
        "nome": "Belo Horizonte",
        "estado": {
            "id": 12,
            "nome": "Minas Gerais - MG"
        }
    }
}
*************************************************************
Remover cliente
DELETE - http://localhost:8080/clientes/3
************************************************************
Alterar o nome do cliente
PUT - http://localhost:8080/clientes/1
{
    "nome" : "Jane Andrade"
}
*******************************
Banco de dados usado para testes H2
