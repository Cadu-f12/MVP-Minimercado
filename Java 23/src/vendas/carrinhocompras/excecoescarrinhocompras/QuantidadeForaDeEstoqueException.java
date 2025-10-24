package vendas.carrinhocompras.excecoescarrinhocompras;

public class QuantidadeForaDeEstoqueException extends RuntimeException {
    public QuantidadeForaDeEstoqueException(String message) {
        super(message);
    }
}
