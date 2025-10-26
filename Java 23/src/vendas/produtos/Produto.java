package vendas.produtos;

import vendas.clientes.excecoes_clientes.AtributoIncompletoException;
import vendas.produtos.excecoesprodutos.QuantNegativadeProdutosExcep;

import java.util.Objects;

public class Produto {
    private final int id;
    private String nome;
    private String codigoBarras;
    private double preco;
    private int estoque;

    public Produto(int id, String nome, String codigoBarras, double preco, int estoque) {
        this.id = id;
        this.nome = nome;
        this.codigoBarras = codigoBarras;
        this.preco = preco;
        this.estoque = estoque;
    }
    public Produto(int id) {
        this.id = id;
    }
    // Getter & Setter para ID
    public int getId(){
        return this.id;
    }

    // Getter & Setter para Nome
    public String getNome(){
        return this.nome;
    }
    public void setNome(String nome){
        if (Objects.equals(nome, "")) {
            throw new AtributoIncompletoException("ERRO: O campo selecionado não pode estar vazio!");
        }
        this.nome = nome;
    }

    // Getter & Setter para Codigo de Barras
    public String getCodigoBarras(){
        return this.codigoBarras;
    }
    public void setCodigoBarras(String codigoBarras){
        if (Objects.equals(nome, "")) {
            throw new AtributoIncompletoException("ERRO: O campo selecionado não pode estar vazio!");
        }
        this.codigoBarras = codigoBarras;
    }

    // Getter & Setter para Preço
    public double getPrecos(){
        return this.preco;
    }
    public void setPreco(Double  preco){
        if (preco == 0.0) {
            throw new AtributoIncompletoException("ERRO: O preço do produto não pode ser igual a 0!");
        }
            this.preco = preco;
    }

    // Getter & Setter para Estoque
    public int getEstoque(){
        return this.estoque;
    }
    public void setEstoque(int estoque){
        if (estoque < 0) {
            throw new QuantNegativadeProdutosExcep("ERRO: A quantidade de estoque não deve ser negativa!");
        }
        this.estoque = estoque;
    }

    @Override
    public String toString() {
        return "Produto{" +
                "id=" + id +
                ", nome='" + nome + '\'' +
                ", codigoBarras='" + codigoBarras + '\'' +
                ", preco=" + preco +
                ", estoque=" + estoque +
                '}';
    }
}
