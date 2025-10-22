package vendas;

import vendas.clientes.Cliente;

import java.time.LocalDateTime;

public class Venda {
    private final int id;
    private LocalDateTime dataHora;
    private Cliente cliente;
    private ItensVenda[] itens;
    private double desconto; // DescontoFidelidade.getDesconto()
    private double valorTotal; // Soma(itens);

    public Venda(int id, LocalDateTime dataHora, Cliente cliente, ItensVenda[] itens, double desconto, double valorTotal) {
        this.id = id;
        this.dataHora = dataHora;
        this.cliente = cliente;
        this.itens = itens;
        this.desconto = desconto;
        this.valorTotal = valorTotal;
    }
    public Venda(int id) {
        this.id = id;
    }

    // Getter e Setter para id
    public int getId() {
        return id;
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
    public ItensVenda[] getItens() {
        return this.itens;
    }
    public void setItens(ItensVenda[] itens) {
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
