package vendas;

import vendas.clientes.Cliente;

import java.time.LocalDateTime;

public class Venda {
    int id;
    LocalDateTime dataHora;
    Cliente cliente;
    ItensVenda itens;
    double desconto;
    double valorTotal;
}
