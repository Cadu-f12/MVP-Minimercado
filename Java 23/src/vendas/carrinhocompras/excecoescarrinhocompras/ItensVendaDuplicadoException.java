package vendas.carrinhocompras.excecoescarrinhocompras;

public class ItensVendaDuplicadoException extends RuntimeException {
    public ItensVendaDuplicadoException(String message) {
        super(message);
    }
}
