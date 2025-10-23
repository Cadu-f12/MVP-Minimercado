package vendas;

import vendas.excecoes_vendas.VendaDuplicadaException;

import java.util.HashMap;
import java.util.Map;

public class VendaService {
    private final Map<Integer, Venda> vendas;

    public VendaService() {
        this.vendas = new HashMap<>();
    }

    /* Metodo que não retorna nada, porém inclui uma Venda no "MAP vendas"
    se a venda não for repetida */
    public void registarVenda(Venda venda) {
        if (vendas.containsKey(venda.getId())) {
            throw new VendaDuplicadaException("ERRO: Está venda já está no sistema!");
        }
        vendas.put(venda.getId(), venda);
    }
    /* Metodo que pega todas as vendas do "MAP vendas"
    fazendo uma cópia para o vetor Venda[] e assim retornando ele */
    public Venda[] listarVendas() {
        Venda[] listaVendas = new Venda[vendas.size()];

        vendas.values().toArray(listaVendas);

        return listaVendas;
    }
}