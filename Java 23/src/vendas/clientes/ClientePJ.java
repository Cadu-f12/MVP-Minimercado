package vendas.clientes;

public class ClientePJ extends Cliente {
    private String cnpj;

    public ClientePJ(int id, String nome, String telefone, Categoria categoria) {
        super(id, nome, telefone, categoria);
    }

    // Getter & setter para CNPJ
    public String getCnpj() {
        return cnpj;
    }
    public void setCnpj(String cnpj) {
        this.cnpj = cnpj;
    }
}