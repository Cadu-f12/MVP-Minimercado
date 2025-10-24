package vendas.excecoesvendas;

public class VendaDuplicadaException extends RuntimeException {
    public VendaDuplicadaException(String message) {
        super(message);
    }
}
