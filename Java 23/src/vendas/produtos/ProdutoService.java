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
    public void editarProdutos(int id, Produto novo) {
        Produto existente = produtos.get(id);
        if (existente != null) {
            existente.setNome(novo.getNome());
            existente.setCodigoBarras(novo.getCodigoBarras());
            existente.setPreco(novo.getPrecos());
            existente.setEstoque(novo.getEstoque());
            produtos.put(id, novo);
        }
    }

    // ==========================================================================================
// REGISTRO NO ESTOQUE -- FUNCIONANDO
    @Override
    public void registroEstoque(int id, int quantidade, String tipo) {
        Produto produto = produtos.get(id);

        if (produto == null) {
            throw new ProdutoNaoEncontradoExcep("Produto não encontrado!");
        }

        switch (tipo.toLowerCase()) {
            case "entrada":
                produto.setEstoque(produto.getEstoque() + quantidade);
                break;

            case "saida":
                if (produto.getEstoque() >= quantidade) {
                    produto.setEstoque(produto.getEstoque() - quantidade);
                    System.out.println("Saída de " + quantidade + " unidades do produto " + produto.getNome() + ".");
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




