package CarrinhoTDD;

public class Carrinho {
    private double total;
    private Cupom cupomAplicado;

    public void adicionarItem(Produto produto, int quantidade) {
        if (quantidade > produto.estoque()) {
            throw new EstoqueInsuficienteException();
        }

        total += produto.preco() * quantidade;
    }

    public void removerItem(Produto produto, int quantidade) {
        total -= produto.preco() * quantidade;
    }

    public void aplicarCupom(Cupom cupom) {
        if (cupom == cupomAplicado) {
            throw new CupomJaAplicadoException();
        }

        double totalComDesconto = total - total * cupom.percentual() / 100;
        if (totalComDesconto < 0) {
            throw new DescontoInvalidoException();
        }

        total = totalComDesconto;
        cupomAplicado = cupom;
    }

    public void finalizarCompra() {
        if (total == 0.0) {
            throw new CarrinhoVazioException();
        }
    }

    public double calcularTotal() {
        return total;
    }
}
