package vendas.produtos;

import vendas.clientes.Cliente;

import java.util.HashMap;
import java.util.Map;

public class ProdutoService implements IProdutoService{
    private final Map<Integer, Produto> produtos = new HashMap<>();

// ==========================================================================================
// CADASTRO DE PRODUTOS
    @Override
    public void cadastroProduto(Produto produto) {
        produtos.put(produto.getId(), produto);
        System.out.println("Produto " + produto.getNome() + " cadastrado com sucesso!");
    }

    @Override
    public void listaProdutos() {
        for (Produto p : produtos.values()) {
            System.out.println("ID: " + p.getId() +
                    " | Nome: " + p.getNome() +
                    " | Código de Barras: " + p.getCodigoBarras() +
                    " | Preço: R$" + p.getPrecos() +
                    " | Custo Médio: R$" + p.getCustoMedio() +
                    " | Estoque: " + p.getEstoque());
        }
    }
// ==========================================================================================
// CONSULTA DE PRODUTO
    @Override
    public void consultaProdutos(int id) {
            Produto consulta = produtos.get(id);
            if (consulta != null) {
                System.out.println("=== Produto Encontrado ===");
                System.out.println("ID: " + consulta.getId());
                System.out.println("Nome: " + consulta.getNome());
                System.out.println("Código de Barras: " + consulta.getCodigoBarras());
                System.out.println("Preço: R$" + consulta.getPrecos());
                System.out.println("Custo Médio: R$" + consulta.getCustoMedio());
                System.out.println("Estoque: " + consulta.getEstoque());
            } else {
                System.out.println("Produto com ID " + id + " não encontrado.");
            }
        }

// ==========================================================================================
// EDIÇÃO DE UM PRODUTO

    @Override
    public void editarProdutos(int id, Produto novo) {
        Produto existente = produtos.get(id);

        if (existente != null) {
            existente.setNome(novo.getNome());
            existente.setCodigoBarras(novo.getCodigoBarras());
            existente.setPreco(novo.getPrecos());
            existente.setCustoMedio(novo.getCustoMedio());
            existente.setEstoque(novo.getEstoque());
            System.out.println("Produto " + existente.getNome() + " atualizado com sucesso!");
        } else {
            System.out.println("Produto com ID " + id + " não encontrado.");
        }
    }
}

