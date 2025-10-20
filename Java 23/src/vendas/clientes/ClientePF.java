package vendas.clientes;

public class ClientePF extends Cliente {
    private String cpf;

    public ClientePF(int id, String nome, String telefone, Categoria categoria) {
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