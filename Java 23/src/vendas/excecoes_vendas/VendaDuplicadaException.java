package vendas.excecoes_vendas;

public class VendaDuplicadaException extends RuntimeException {
    public VendaDuplicadaException(String message) {
        super(message);
    }
}
