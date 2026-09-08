package CarrinhoTDD;

public class Carrinho {
    private double total;

    public void adicionarItem(Produto produto, int quantidade) {
        total += produto.preco() * quantidade;
    }

    public double calcularTotal() {
        return total;
    }
}
