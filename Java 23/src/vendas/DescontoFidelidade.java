package vendas;

import vendas.clientes.Categoria;

public class DescontoFidelidade {
    private Categoria categoria;
    private double desconto;

    public Categoria getCategoria() {
        return this.categoria;
    }
    public void setCategoria(Categoria categoria) {
        this.categoria = categoria;
    }
    public double getDesconto() {
        return this.desconto;
    }
    public void setDesconto(double desconto) {
        this.desconto = desconto; 
    }
}