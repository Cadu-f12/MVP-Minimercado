package vendas.produtos.excecoesprodutos;

public class ProdutoDuplicadoExcep extends RuntimeException {
    public ProdutoDuplicadoExcep(String message) {
        super(message);
    }
}
