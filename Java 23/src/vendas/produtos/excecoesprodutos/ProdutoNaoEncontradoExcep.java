package vendas.produtos.excecoesprodutos;

public class ProdutoNaoEncontradoExcep extends RuntimeException {
    public ProdutoNaoEncontradoExcep(String message) {
        super(message);
    }
}
