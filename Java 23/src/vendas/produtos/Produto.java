package vendas.produtos;

public class Produto {
    int id;
    String nome;
    String codigoBarras;
    double preco;
    int estoque;

    public Produto(int id, String nome, String codigoBarras, double preco, int estoque) {
        this.id = id;
        this.nome = nome;
        this.codigoBarras = codigoBarras;
        this.preco = preco;
        this.estoque = estoque;
    }

    // ID
public int getId(){
    return this.id;
}
public void setId(int id){
    this.id = id;
}

// Nome
public String getNome(){
    return this.nome;
}
public void setNome(String nome){
    this.nome = nome;
}

// Codigo de Barras
public String getCodigoBarras(){
    return this.codigoBarras;
}
public void setCodigoBarras(String codigoBarras){
    this.codigoBarras = codigoBarras;
}

// Preço
public double getPrecos(){
    return this.preco;
}
public void setPreco(Double  preco){
    this.preco = preco;
}

// Estoque
public int getEstoque(){
    return this.estoque;
}
public void setEstoque(int estoque){
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
