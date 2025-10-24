package vendas;

import vendas.carrinhocompras.ItensVenda;
import vendas.clientes.Cliente;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Arrays;

public class Venda {
    private final int id;
    private final LocalDateTime dataHora;
    private Cliente cliente;
    private ItensVenda[] itens; // ItensService.listarItensVenda()
    private double desconto; // desconto.getDesconto()
    private double valorTotal; // ItensService.somarItensVenda()

    public Venda(int id, Cliente cliente, ItensVenda[] itens, double desconto, double valorTotal) {
        this.id = id;
        this.dataHora = LocalDateTime.now();
        this.cliente = cliente;
        this.itens = itens;
        this.desconto = desconto;
        this.valorTotal = valorTotal - (valorTotal * this.desconto);
    }
    public Venda(int id) {
        this.id = id;
        this.dataHora = LocalDateTime.now();
    }

    // Getter para id
    public int getId() {
        return id;
    }

    // Getter para dataHora
    public LocalDateTime getDataHora() {

        return dataHora;
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

    // toString que formata a data e hora
    @Override
    public String toString() {
        DateTimeFormatter formato = DateTimeFormatter.ofPattern("HH:mm - dd/MM/yyyy ");
        return "Venda{" +
                "id=" + id +
                ", dataHora=" + dataHora.format(formato) +
                ", cliente=" + cliente +
                ", itens=" + Arrays.toString(itens) +
                ", desconto=" + desconto +
                ", valorTotal=" + valorTotal +
                '}';
    }
}
