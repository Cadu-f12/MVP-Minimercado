package vendas.carrinhoCompras;

public interface InItensVendaService {

    // Registra itensVenda no sistema
    void registrarItensVenda(ItensVenda itensVenda);

    // Lista os itensVenda para ser usado
    ItensVenda[] listarItensVenda();

    // Soma o preço de cada ‘Item’ para ser usado
    double somarItensVenda();
}
