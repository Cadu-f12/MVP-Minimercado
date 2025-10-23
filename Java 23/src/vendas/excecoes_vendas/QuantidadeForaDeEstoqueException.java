package vendas.excecoes_vendas;

public class QuantidadeForaDeEstoqueException extends RuntimeException {
    public QuantidadeForaDeEstoqueException(String message) {
        super(message);
    }
}
