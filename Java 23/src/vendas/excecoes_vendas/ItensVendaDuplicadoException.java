package vendas.excecoes_vendas;

public class ItensVendaDuplicadoException extends RuntimeException {
    public ItensVendaDuplicadoException(String message) {
        super(message);
    }
}
