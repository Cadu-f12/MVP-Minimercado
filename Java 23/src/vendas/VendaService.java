package vendas;

import vendas.excecoes_vendas.VendaDuplicadaException;

import java.util.HashMap;
import java.util.Map;

public class VendaService {
    private final Map<Integer, Venda> vendas;

    public VendaService() {
        this.vendas = new HashMap<>();
    }

    public void registarVenda(Venda venda) {
        if (vendas.containsKey(venda.getId())) {
            throw new VendaDuplicadaException("ERRO: Está venda já está no sistema!");
        }
        vendas.put(venda.getId(), venda);
    }
    public Venda[] listarVendas() {
        Venda[] listaVendas = new Venda[vendas.size()];

        vendas.values().toArray(listaVendas);

        return listaVendas;
    }
}