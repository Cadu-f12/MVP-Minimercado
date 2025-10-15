package vendas;

import vendas.clientes.Cliente;

import java.time.LocalDateTime;

public class Venda {
    private int id;
    private LocalDateTime dataHora;
    private Cliente cliente;
    private ItensVenda itens;
    private double desconto;
    private double valorTotal;

    // Getter e Setter para id
    public int getId() {
        return id;
    }
    public void setId(int id) {
        this.id = id;
    }

    // Getter e Setter para dataHora
    public LocalDateTime getDataHora() {
        return dataHora;
    }
    public void setDataHora(LocalDateTime dataHora) {
        this.dataHora = dataHora;
    }

    // Getter e Setter para cliente
    public Cliente getCliente() {
        return cliente;
    }
    public void setCliente(Cliente cliente) {
        this.cliente = cliente;
    }

    // Getter e Setter para itens
    public ItensVenda getItens() {
        return itens;
    }
    public void setItens(ItensVenda itens) {
        this.itens = itens;
    }

    // Getter e Setter para desconto
    public double getDesconto() {
        return desconto;
    }
    public void setDesconto(double desconto) {
        this.desconto = desconto;
    }

    // Getter e Setter para valorTotal
    public double getValorTotal() {
        return valorTotal;
    }
    public void setValorTotal(double valorTotal) {
        this.valorTotal = valorTotal;
    }
}
