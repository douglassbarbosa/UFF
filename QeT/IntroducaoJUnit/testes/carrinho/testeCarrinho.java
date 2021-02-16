package carrinho;


import static org.junit.jupiter.api.Assertions.assertThrows;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import produto.Produto;
import produto.ProdutoNaoEncontradoException;

@DisplayName("Testes do carrinho")
public class testeCarrinho {

	private Carrinho carrinho;
	private Produto iPhoneX;
	private Produto iPhone11;
	private Produto iPhone12;

	@BeforeEach
	public void inicializa() {
		carrinho = new Carrinho();
		iPhoneX = new Produto("iPhoneX", 1200.00);
		iPhone11 = new Produto("iPhone11", 5000.00);
		iPhone12 = new Produto("iPhone12", 8000.00);
		carrinho.addItem(iPhoneX);
		carrinho.addItem(iPhone11);
		carrinho.addItem(iPhone12);
	}
	

	@DisplayName("Teste de valor")
	@Test
	public void testeGetValorTotal() {
		double valorTotal = carrinho.getValorTotal();
		Assertions.assertEquals(14200.00, valorTotal);
	}

	@DisplayName("Teste adicionar item ao Carrinho")
	@Test
	public void testeAddItem() {
		Produto iPhone12 = new Produto("iPhone12", 2000.00);
		carrinho.addItem(iPhone12);
		Assertions.assertEquals(4, carrinho.getQtdeItems());
	}

	@DisplayName("Teste quantidade de Itens no Carrinho")
	@Test
	public void testeQetQtdeItems() {
		Assertions.assertEquals(3, carrinho.getQtdeItems());
	}

	@DisplayName("Teste Limpa carrinho")
	@Test
	public void testeEsvazia() {
		carrinho.esvazia();
		Assertions.assertEquals(0, carrinho.getQtdeItems());
	}

	@DisplayName("Teste remover item do Carrinho")
	@Test
	public void testeRemoveItem() {
		try {
			carrinho.removeItem(iPhoneX);
			Assertions.assertEquals(2, carrinho.getQtdeItems());
		} catch (ProdutoNaoEncontradoException e) {
			Assertions.assertEquals("ProdutoNaoEncontradoException", e.getMessage());
		}
	}
	


	@DisplayName("Teste Produto Não Existe | Exception")
	@Test
	public void testeProdutoNaoEncontrado() {
		carrinho.esvazia();
		assertThrows(ProdutoNaoEncontradoException.class, () -> carrinho.removeItem(iPhoneX));
	}
	
}
