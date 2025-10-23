package vendas;

public interface IVendasService {
    // Registra uma venda no sistema
    void registarVenda(Venda venda);

    // Lista as vendas para ser usada fora da classe service
    Venda[] listarVendas();
}
