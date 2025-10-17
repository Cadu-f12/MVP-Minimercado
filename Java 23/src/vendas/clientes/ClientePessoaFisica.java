package vendas.clientes;

public class ClientePessoaFisica extends Cliente {
    private String cpf;

    public ClientePessoaFisica(int id, String nome, String telefone, Categoria categoria) {
        super(id, nome, telefone, categoria);
    }

    // Getter & setter para o CPF
    public String getCpf() {
        return cpf;
    }
    public void setCpf(String cpf) {
        this.cpf = cpf;
    }
}
