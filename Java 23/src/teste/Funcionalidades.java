package teste;

import vendas.clientes.*;

import java.util.Scanner;

public class Funcionalidades {

    // Criação de clientes, após isso service.cadastrarCliente()
    public Cliente criarCliente() {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Insira um id: ");
        int id = Integer.parseInt(scanner.nextLine());
        System.out.print("Insira um nome: ");
        String nome = scanner.nextLine();
        System.out.print("Insira um telefone: ");
        String telefone = scanner.nextLine();

        return new ClientePF(id, nome, telefone); // Como padrão todos os clientes criados recebem um nível de fidelidade NULO.
    }

}
