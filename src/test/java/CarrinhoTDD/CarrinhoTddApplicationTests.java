package CarrinhoTDD;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

@SpringBootTest
class CarrinhoTddApplicationTests {

	@Test

	void carrinhoVazioTemTotalZero() {

		Carrinho carrinho = new Carrinho();

		assertEquals(0.0, carrinho.calcularTotal());

	}

	@Test
	void adicionarItemAumentaTotalPeloPrecoVezesQuantidade() {
		Carrinho carrinho = new Carrinho();
		Produto produto = new Produto(50.0, 2);

		carrinho.adicionarItem(produto, 2);

		assertEquals(100.0, carrinho.calcularTotal());
	}

	@Test
	void naoPodeAdicionarItemEmQuantidadeMaiorQueEstoque() {
		Carrinho carrinho = new Carrinho();
		Produto produto = new Produto(50.0, 2);

		assertThrows(
				EstoqueInsuficienteException.class,
				() -> carrinho.adicionarItem(produto, 3)
		);
	}

	@Test
	void removerItemReduzTotalPeloPrecoVezesQuantidade() {
		Carrinho carrinho = new Carrinho();
		Produto produto = new Produto(50.0, 2);

		carrinho.adicionarItem(produto, 2);
		carrinho.removerItem(produto, 2);

		assertEquals(0.0, carrinho.calcularTotal());
	}

	@Test
	void aplicarCupomValidoReduzTotalPeloPercentual() {
		Carrinho carrinho = new Carrinho();
		Produto produto = new Produto(100.0, 1);
		Cupom cupom = new Cupom(10.0);

		carrinho.adicionarItem(produto, 1);
		carrinho.aplicarCupom(cupom);

		assertEquals(90.0, carrinho.calcularTotal());
	}

	@Test
	void naoPodeAplicarMesmoCupomDuasVezes() {
		Carrinho carrinho = new Carrinho();
		Cupom cupom = new Cupom(10.0);

		carrinho.aplicarCupom(cupom);

		assertThrows(
				CupomJaAplicadoException.class,
				() -> carrinho.aplicarCupom(cupom)
		);
	}

	@Test
	void finalizarCompraComCarrinhoVazioLancaExcecao() {
		Carrinho carrinho = new Carrinho();

		assertThrows(
				CarrinhoVazioException.class,
                carrinho::finalizarCompra
		);
	}

}
