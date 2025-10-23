package vendas;

import vendas.produtos.Produto;
// FIZ UMA DEPENDÊNCIA GIGANTESCA ItensVenda -> ItensVendaService -> Venda -> VendaService
public class ItensVenda {
    private final int id;
    private Produto produto;
    private int quantidade;
    private final double precoTotal;

    // Construtor que está calculando o preço total dos itens da venda.
    public ItensVenda(int id, Produto produto, int quantidade) {
        this.id = id;
        this.produto = produto;
        this.quantidade = quantidade;
        this.precoTotal = produto.getPrecos() * this.quantidade;
    }

    // Getter para id
    public int getId() {
        return id;
    }

    // Getter e Setter para produto
    public Produto getProduto() {
        return this.produto;
    }
    public void setProduto(Produto produto) {
        this.produto = produto;
    }

    // Getter e Setter para quantidade
    public int getQuantidade() {
        return quantidade;
    }
    public void setQuantidade(int quantidade) {
        if (quantidade <= 0) {
            throw new IllegalArgumentException("ERRO: quantidade abaixo de zero ou igual a zero");
        }
        this.quantidade = quantidade;
    }

    // Getter para preco
    public double getPrecoTotal() {
        return precoTotal;
    }
}
