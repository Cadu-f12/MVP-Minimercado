package teste;

import vendas.clientes.*;

import java.util.Scanner;

public class Funcionalidades {

    // Criação de cliente
    public Cliente criarCliente(){
        Scanner scanner = new Scanner(System.in);

        System.out.print("Tipo de pessoa\n(1)Pessoa Jurídica\n(2)Pessoa física\n-> ");
        int tipo = scanner.nextInt();

        System.out.print("Digite o seu id\n(obs: pode ser qualquer número): ");
        int id = scanner.nextInt();

        switch (tipo) {
            case 1: // Caso o cliente for CNPJ
                System.out.print("Digite o seu CNPJ: ");
                String cnpj = scanner.nextLine();

                ClientePJ clienteCNPJ = new ClientePJ(id, cnpj);
                clienteCNPJ.setNome("BiancaExpress");
                clienteCNPJ.setTelefone("7896854");
                clienteCNPJ.setCategoria(Categoria.NULO);
                return clienteCNPJ;
            case 2: // Caso o cliente for CPF
                System.out.print("Digite o seu CPF: ");
                String cpf = scanner.nextLine();

                ClientePF clienteCPF = new ClientePF(id, cpf);

                System.out.print("Digite o seu nome: ");
                clienteCPF.setNome("Carlos");
                clienteCPF.setTelefone("6788989");
                clienteCPF.setCategoria(Categoria.NULO);
                return clienteCPF;
            default: // Caso a opção não existir
                System.out.println("OPÇÃO INVÁLIDA");
                return null;
        }
    }

}
