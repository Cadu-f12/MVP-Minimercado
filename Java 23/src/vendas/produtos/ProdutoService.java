package vendas.produtos;

import vendas.produtos.excecoesprodutos.ProdutoNaoEncontradoExcep;
import vendas.produtos.excecoesprodutos.QuantNegativadeProdutosExcep;
import vendas.produtos.excecoesprodutos.TipoDeRegistroInexistenteExcep;

import java.util.HashMap;
import java.util.Map;

public class ProdutoService implements IProdutoService {
    private final Map<Integer, Produto> produtos;

    public ProdutoService() {
        this.produtos = new HashMap<>();
    }

    // ==========================================================================================
// CADASTRO DE PRODUTOS -- FUNCIONANDO
    @Override
    public void cadastroProduto(Produto produto) {
        produtos.put(produto.getId(), produto);
    }

    @Override
    public Produto[] listarProdutos() { // FUNCIONANDO
        Produto[] listarProdutos = new Produto[produtos.size()];
        produtos.values().toArray(listarProdutos);
        return listarProdutos;
    }

    // ==========================================================================================
// CONSULTA DE PRODUTO -- FUNCIONANDO
    @Override
    public Produto consultaProdutos(int id) {
        if (!this.produtos.containsKey(id)){
            throw new ProdutoNaoEncontradoExcep("Produto não existente na lista!");
        }
        return this.produtos.get(id);
    }

// ==========================================================================================
// EDIÇÃO DE UM PRODUTO -- FUNCIONANDO

    @Override
    public void editarProdutos(Produto novoProduto) {
        if (!this.produtos.containsKey(novoProduto.getId())) {
            throw new ProdutoNaoEncontradoExcep("ERRO: Cliente não existe no sistema");
        }
        produtos.put(novoProduto.getId(), novoProduto);
    }

    // ==========================================================================================
// REGISTRO NO ESTOQUE -- FUNCIONANDO
    @Override
    public void registroEstoque(int id, int quantidade, String tipo) {
        Produto produto = produtos.get(id);

        if (produto == null) {
            throw new ProdutoNaoEncontradoExcep("Produto não encontrado!");
        }
        if (quantidade < 0) {
            throw new QuantNegativadeProdutosExcep("A quantidade de entrada ou saída deve ser positiva!");
        }

        switch (tipo.toLowerCase()) {
            case "entrada":
                produto.setEstoque(produto.getEstoque() + quantidade);
                break;
            case "saida":
                if (produto.getEstoque() >= quantidade) {
                    produto.setEstoque(produto.getEstoque() - quantidade);
                } else {
                    throw new QuantNegativadeProdutosExcep("Saída do estoque não pode ser negativa!");
                }
                break;
            case "baixa":
                produto.setEstoque(0);
                break;
            default:
                throw new TipoDeRegistroInexistenteExcep("O registro no estoque deve ser do tipo Entrada, Saída ou Baixa");
        }
    }
}




