package vendas.carrinhocompras.excecoescarrinhocompras;

public class QuantidadeNegativaException extends RuntimeException {
    public QuantidadeNegativaException(String message) {
        super(message);
    }
}
