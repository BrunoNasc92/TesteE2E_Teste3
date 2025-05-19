# language: pt
@login
Funcionalidade: Login

  Cenário: Login válido
    Dado que o usuário está na página de login do SauceDemo
    Quando ele insere o usuário "standard_user" e senha "secret_sauce"
    E clica no botão de login
    Então ele é redirecionado para a página de produtos
