package CarrinhoTDD;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import static org.junit.jupiter.api.Assertions.assertEquals;

@SpringBootTest
class CarrinhoTddApplicationTests {

	@Test

	void carrinhoVazioTemTotalZero() {

		Carrinho carrinho = new Carrinho();

		assertEquals(0.0, carrinho.calcularTotal());

	}

}
