package vendas.carrinhoCompras.excecoes_carrinhoCompras;

public class QuantidadeNegativaException extends RuntimeException {
    public QuantidadeNegativaException(String message) {
        super(message);
    }
}
