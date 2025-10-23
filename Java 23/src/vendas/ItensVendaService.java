package vendas;

import vendas.excecoes_vendas.ItensVendaDuplicadoException;

import java.util.HashMap;
import java.util.Map;

public class ItensVendaService {
    private final Map<Integer, ItensVenda> itensVenda;

    public ItensVendaService() {
        this.itensVenda = new HashMap<>();
    }

    public ItensVenda[] listarItensVenda() {
        ItensVenda[] ItensVendaLista = new ItensVenda[this.itensVenda.size()];

        this.itensVenda.values().toArray(ItensVendaLista);

        return ItensVendaLista;
    }

    public double somarItensVenda() {
        ItensVenda[] itensVendaLista = new ItensVenda[this.itensVenda.size()];

        this.itensVenda.values().toArray(itensVendaLista);

        double soma = 0.0;
        for (ItensVenda itensVenda : itensVendaLista) {
            soma += itensVenda.getPrecoTotal();
        }
        return soma;
    }

    public void registrarItensVenda(ItensVenda itensVenda) {
        if (this.itensVenda.containsKey(itensVenda.getId())) {
            throw new ItensVendaDuplicadoException("ERRO: ItensVenda já está registrado!");
        }
        this.itensVenda.put(itensVenda.getId(), itensVenda);
    }
}
