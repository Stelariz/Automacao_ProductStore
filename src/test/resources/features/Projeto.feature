# language: pt
# encoding: utf-8

@productStore
Funcionalidade: Teste de Funcionalidade do site Product Store
 
  @realizarContato
  Cenario: Realizar contato com dados validos
    Dado que o cliente esteja no site
    E acessa o formulario do contato
    E preenche o formulario com <email>, <nome> e <mensagem> 
    Quando clicar no botao de enviar a mensagem
    Entao a mensagem sera enviada
    
    Exemplos: 
      | 		  email		     |  	 nome 		 | 																	mensagem  																			|
      |"projeto@email.com" |"Jake The Dog" | "Ser ruim em alguma coisa e o primeiro passo parar se tornar bom em alguma coisa"|
      
  @removerProduto
  Cenario: Remover um produto qualquer do carrinho de compras
    Dado que o cliente esteja no site
    E possua um produto <produto> no carrinho
    Quando clica no botao de remover o produto <produto> do carrinho
    Entao o produto <produto> e removido
    
    Exemplos:
    | 	 produto   |
    |"MacBook Pro" |

  @realizarPedido
  Cenario: Realizar pedido com sucesso
    Dado que o cliente esteja no site
    E possua um produto <produto> no carrinho
    E clicar em fazer pedido
    Quando preencher o formulario com <nome>, <pais>, <cidade>, <cartao_de_credito>, <mes> e <ano>
    E clicar em comprar
    Entao a compra sera efetivada
    

    Exemplos: 
     |		produto   |  		 nome 		| 		pais		 | 				cidade		  | cartao_de_credito  | mes | ano  |
     |"MacBook Pro" |"Finn Mertens" |"Terra de Ooo"|"Cidade dos ladroes"|     "5550123"			 |"06" |"2050"|
