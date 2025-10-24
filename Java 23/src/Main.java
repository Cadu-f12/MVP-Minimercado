import teste.Funcionalidades;
import teste.FuncionalidadesProdutos;
import vendas.clientes.Cliente;
import vendas.clientes.ClientePF;

public class Main {
    public static void main(String[] args) {
//        Funcionalidades func = new Funcionalidades();
//        Cliente cliente = func.criarCliente();
//        System.out.println((ClientePF) cliente);
                FuncionalidadesProdutos produtos = new FuncionalidadesProdutos();

                // 1. Cadastro de produto pelo usuário
                produtos.cadastrarProduto();

                // 2. Listagem de todos os produtos cadastrados
                System.out.println("\n--- Lista de Produtos ---");
                produtos.listarProdutos();

                // 3. Consulta de produto pelo ID
                System.out.println("\n--- Consulta de Produto ---");
                produtos.consultarProduto();

                // 4. Edição de produto
                System.out.println("\n--- Edição de Produto ---");
                produtos.editarProduto();

                // 5. Listagem após edição
                System.out.println("\n--- Lista de Produtos Atualizada ---");
                produtos.listarProdutos();

                // 6. Registro de estoque (entrada / saída / baixa)
                System.out.println("\n--- Registro de Estoque ---");
                produtos.registrarEstoque();

                // 7. Listagem final após registro de estoque
                System.out.println("\n--- Lista Final de Produtos ---");
                produtos.listarProdutos();
            }
        }

