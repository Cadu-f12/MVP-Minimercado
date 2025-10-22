package vendas.clientes;

public class ClienteDuplicadoException extends RuntimeException {
    public ClienteDuplicadoException(String message) {
        super(message);
    }
}
