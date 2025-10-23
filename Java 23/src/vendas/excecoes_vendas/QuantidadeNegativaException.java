package vendas.excecoes_vendas;

public class QuantidadeNegativaException extends RuntimeException {
    public QuantidadeNegativaException(String message) {
        super(message);
    }
}
