#language: pt
Funcionalidade: Primeiro teste de API para validação de status code
    Cenario: Listar usuários cadastrados com sucesso em API ServeRest
    Dado que acesso a API ServeRest
    Quando executar a requisição para consultar com endpoint "/usuarios"
    Então devo retornar o status code 200
    E devo retornar os usuários cadastrados