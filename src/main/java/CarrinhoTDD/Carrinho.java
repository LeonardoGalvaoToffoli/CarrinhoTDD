package CarrinhoTDD;

public class Carrinho {
    private double total;

    public void adicionarItem(Produto produto, int quantidade) {
        if (quantidade > produto.estoque()) {
            throw new EstoqueInsuficienteException();
        }

        total += produto.preco() * quantidade;
    }

    public void removerItem(Produto produto, int quantidade) {
        total -= produto.preco() * quantidade;
    }

    public double calcularTotal() {
        return total;
    }
}
