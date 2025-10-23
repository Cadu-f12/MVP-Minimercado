package vendas.produtos;

import vendas.clientes.Cliente;

public interface IProdutoService {
    void cadastroProduto(Produto produto);
    void listaProdutos();
    void consultaProdutos(int id);
    void editarProdutos(int id, Produto novo);
    void registroEstoque(int id, int quantidade, String tipo);

}
