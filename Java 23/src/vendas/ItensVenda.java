package vendas;

import vendas.produtos.Produto;

public class ItensVenda {
    private int id;
    private String nome; // Produto.getNome()
    private int quantidade;
    private double preco; // Produto.getPreco() ou quantidade * Produto.getPreco()


    public ItensVenda(int id, String nome, int quantidade, double preco) {
        this.id = id;
        this.nome = nome;
        this.quantidade = quantidade;
        this.preco = preco;
    }
    public ItensVenda(int id) {
        this.id = id;
    }

    // Getter e Setter para id
    public int getId() {
        return id;
    }
    public void setId(int id) {
        this.id = id;
    }

    // Getter e Setter para nome
    public String getNome() {
        return nome;
    }
    public void setNome(Produto produto) {
        this.nome = produto.getNome();
    }

    // Getter e Setter para quantidade
    public int getQuantidade() {
        return quantidade;
    }
    public void setQuantidade(int quantidade) {
        this.quantidade = quantidade;
    }

    // Getter e Setter para preco
    public double getPreco() {
        return preco;
    }
    public void setPreco(double preco) {
        this.preco = preco;
    }
}
