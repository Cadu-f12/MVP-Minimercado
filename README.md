# Trabalho acadêmico: MVP-Minimercado
O projeto MVP Minimercado foi desenvolvido para representar, de forma prática,
o funcionamento de um sistema simples de minimercado, aplicando conceitos fundamentais de 
orientação a objetos e estruturação modular de código.

O sistema foi construído com base em três domínios principais: 
_**clientes**, **produtos** e **vendas**._ 
Cada domínio possui suas próprias classes de  serviços e exceções, permitindo que o código 
seja organizado e de fácil manutenção.

Na parte de clientes, o programa permite cadastrar pessoas físicas e jurídicas, 
listar todos os clientes cadastrados e consultar informações de um cliente específico pelo seu ID. 
As regras de negócio tratam situações como dados incompletos ou clientes duplicados, 
por meio de exceções personalizadas.

O módulo de produtos oferece funções de cadastro, listagem e consulta de produtos, 
além de controle de estoque e validações contra produtos repetidos ou inexistentes. 
Já o setor de vendas faz o registro das transações realizadas, relacionando clientes e produtos, 
e mantém um histórico das vendas efetuadas.

O sistema é executado em modo console, com menus interativos que permitem 
ao usuário escolher as ações desejadas. Essa interface textual simplifica os 
testes e demonstra de forma direta o fluxo de funcionamento do minimercado, 
desde o cadastro de um cliente até o registro de uma venda.

Durante o desenvolvimento, foram aplicados diversos princípios como de encapsulamento, 
herança, polimorfismo e abstração. Além disso, o projeto faz uso de coleções do Java, 
como  ArrayList e Has Map, para armazenar e manipular os dados em memória.

