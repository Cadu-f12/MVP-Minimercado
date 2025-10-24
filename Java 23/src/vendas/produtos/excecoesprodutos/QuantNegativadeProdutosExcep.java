package vendas.produtos.excecoesprodutos;

public class QuantNegativadeProdutosExcep extends RuntimeException {
    public QuantNegativadeProdutosExcep(String message) {
        super(message);
    }
}
