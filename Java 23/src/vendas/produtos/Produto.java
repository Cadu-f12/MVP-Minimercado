package vendas.produtos;

public class Produto {
    int id;
    String nome;
    String codigoBarras;
    double preco;
    double custoMedio;
    int estoque;

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

// Custo Médio
public double getCustoMedio(){
    return this.custoMedio;
}
public void setCustoMedio(Double custoMedio){
    this.custoMedio = custoMedio;
}

// Estoque
public int getEstoque(){
    return this.estoque;
}

public void setEstoque(int estoque){
    this.estoque = estoque;
}


}
