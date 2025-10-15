package vendas;

import java.time.LocalDateTime;

public class Venda {
    int id;
    LocalDateTime dataHora;
    Cliente cliente;
    ItensVenda itens;
    double desconto;
    double valorTotal;
}
