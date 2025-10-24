package vendas.clientes;

import vendas.clientes.excecoes_clientes.AtribudoIncompletoException;

import java.util.Objects;

public class ClientePF extends Cliente {
    private String cpf;

    public ClientePF(int id, String nome, String telefone, Categoria categoria, String cpf) {
        super(id, nome, telefone, categoria);
        this.cpf = cpf;
    }
    public ClientePF(int id) {
        super(id);
    }

    // Getter & setter para o CPF
    public String getCpf() {
        return cpf;
    }
    public void setCpf(String cpf) {
        if (Objects.equals(cpf, "")) {
            throw new AtribudoIncompletoException("ERRO: CLIENTE SEM CPF NÃO É PERMITIDO!");
        }
        this.cpf = cpf;
    }

    @Override
    public String toString() {
        return "ClientePF{" +
                "cpf='" + cpf + '\'' +
                "} " + super.toString();
    }
}