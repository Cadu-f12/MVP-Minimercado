package vendas.carrinhocompras;

import vendas.carrinhocompras.excecoescarrinhocompras.ItensVendaDuplicadoException;

import java.util.HashMap;
import java.util.Map;

public class CarrinhoDeCompras {
    private final Map<Integer, ItensVenda> itensVenda;

    public CarrinhoDeCompras() {
        this.itensVenda = new HashMap<>();
    }

    /* Metodo que não retorna nada, porém inclui um ItensVenda no "MAP ItensVenda"
    se a venda não for repetida */
    public void registrarItensVenda(ItensVenda itensVenda) {
        if (this.itensVenda.containsKey(itensVenda.getId())) {
            throw new ItensVendaDuplicadoException("ERRO: ItensVenda já está registrado!");
        }
        this.itensVenda.put(itensVenda.getId(), itensVenda);
    }

    /* Metodo que pega todos os itensVenda do "MAP itensVenda"
    fazendo uma cópia para o vetor ItensVenda[] e assim retornando ele */
    public ItensVenda[] listarItensVenda() {
        ItensVenda[] ItensVendaLista = new ItensVenda[this.itensVenda.size()];

        this.itensVenda.values().toArray(ItensVendaLista);

        return ItensVendaLista;
    }

    // Metodo que pega o preço de cada ‘item’ e soma tudo, retornando um valor total da soma
    public double somarItensVenda() {
        ItensVenda[] itensVendaLista = new ItensVenda[this.itensVenda.size()];

        this.itensVenda.values().toArray(itensVendaLista);

        double soma = 0.0;
        for (ItensVenda itensVenda : itensVendaLista) {
            soma += itensVenda.getPrecoTotal();
        }
        return soma;
    }
}
