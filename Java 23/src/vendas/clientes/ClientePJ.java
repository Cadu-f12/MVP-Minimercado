package vendas.clientes;

import vendas.clientes.excecoes_clientes.AtribudoIncompletoException;

import java.util.Objects;

public class ClientePJ extends Cliente {
    private String cnpj;

    public ClientePJ(int id, String nome, String telefone, Categoria categoria, String cnpj) {
        super(id, nome, telefone, categoria);
        this.cnpj = cnpj;
    }
    public ClientePJ(int id) {
        super(id);
    }

    // Getter & setter para CNPJ
    public String getCnpj() {
        return cnpj;
    }
    public void setCnpj(String cnpj) {
        if (Objects.equals(cnpj, "")) {
            throw new AtribudoIncompletoException("ERRO: CLIENTE SEM CNPJ NÃO É PERMITIDO!");
        }
        this.cnpj = cnpj;
    }

    // Getter & Setter de CNPJ para a classe mãe
    @Override
    public String getDocumento() {
        return this.cnpj;
    }
    @Override
    public void setDocumento(String cpfCnpj) {
        if (Objects.equals(cpfCnpj, "")) {
            throw new AtribudoIncompletoException("ERRO: CLIENTE SEM CPF/CNPJ NÃO É PERMITIDO!");
        }
        this.cnpj = cpfCnpj;
    }

    @Override
    public String toString() {
        return "ClientePJ{" +
                "cnpj='" + cnpj + '\'' +
                "} " + super.toString();
    }
}