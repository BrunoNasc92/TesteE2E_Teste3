# language: pt
@chakout
Funcionalidade: Fluxo de compra

  Cenário: Finalizar compra com sucesso
    Dado que o usuário está logado no SauceDemo
    Quando ele adiciona um produto ao carrinho
    E acessa o carrinho de compras
    E clica em "Checkout"
    E preenche o formulário com nome "João", sobrenome "Silva" e CEP "12345-678"
    E finaliza a compra
    Então ele deve ver a mensagem "Thank you for your order!"

