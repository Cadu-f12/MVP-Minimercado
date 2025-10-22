package vendas;

import vendas.clientes.Categoria;
import vendas.excecoes_vendas.CategoriaNulaException;

public class DescontoFidelidade {
    private Categoria categoria;
    private double desconto;

    // Getter e Setter de categoria
    public Categoria getCategoria() {
        return this.categoria;
    }
    public void setCategoria(Categoria categoria) {
        this.categoria = categoria;
    }

    // Getter e Setter de Desconto
    public double getDesconto() {
        return this.desconto;
    }
    public void setDesconto(double desconto) {
        this.desconto = desconto;
    }

    /* Metodo que aplica o desconto baseado no nível de fidelidade (Categoria)
        se a categoria for NULA o metodo dispara uma exception. */
    public void aplicarDesconto() {
        switch (categoria) {
            case NULO:
                throw new CategoriaNulaException("ERRO: A categoria NULA não aplica desconto");
            case BRONZE:
                this.desconto = 0.05;
                break;
            case PRATA:
                this.desconto = 0.07;
                break;
            case OURO:
                this.desconto = 0.10;
                break;
        }
    }
}