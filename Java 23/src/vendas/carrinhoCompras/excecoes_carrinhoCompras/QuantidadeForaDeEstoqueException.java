package vendas.carrinhoCompras.excecoes_carrinhoCompras;

public class QuantidadeForaDeEstoqueException extends RuntimeException {
    public QuantidadeForaDeEstoqueException(String message) {
        super(message);
    }
}
