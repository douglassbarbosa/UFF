package produto;

import static org.junit.Assert.assertNotSame;
import static org.junit.Assert.assertTrue;
import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class ProdutoTeste {

	Produto celular;
	
	@BeforeEach
	public void inicializa() {
		celular = new Produto("Iphone 20", 12000.00);		
		
	}
	
	@Test
	public void testeCriarProduto() {
		Assertions.assertAll("celular",
				() -> assertEquals("Iphone 20", celular.getNome()),
				() -> assertTrue(12000.00 == celular.getPreco())
				);
	}
	
	@Test
	private void testeProdutosIguai() {
		Produto celular2 = new Produto("s20PlUs", 8000.00);
		
		assertNotSame(celular, celular2);

	}
}
