package vendas.produtos;

import vendas.clientes.Cliente;

public interface IProdutoService {
    void cadastroProduto(Produto produto);
    Produto[] listarProdutos();
    Produto consultaProdutos(int id);
    void editarProdutos(Produto novoProduto);
    void registroEstoque(int id, int quantidade, String tipo);

}
