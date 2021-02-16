package calculadora;

import static org.junit.Assert.assertTrue;
import static org.junit.jupiter.api.Assertions.assertThrows;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

@DisplayName("Classes de Testes da Calculadora")
public class CalculadoraTeste {

	private Calculadora calc;
	
	@BeforeEach
	public void inicializa() {
		calc = new Calculadora();
	}
	
	
	@DisplayName("Teste de Soma")
	@Test
	public void testeFuncSoma() {
		int produto = calc.soma(2, 5);
		
		Assertions.assertEquals(7, produto);
	}


	@DisplayName("Teste de Subtração")
	@Test
	public void testeFuncSubtracao() {
		int result = calc.subtracao(6, 3);
		
		Assertions.assertEquals(3, result);
	}
	
	@DisplayName("Teste de Multiplicação")
	@Test
	public void testeFuncMultiplica() {
		int multiplicado = calc.multiplicacao(3, 4);
		assertTrue(multiplicado == 12);
	}

	@DisplayName("Teste de Divisão")
	@Test
	public void testeFuncDivisao() {
		int divresult = calc.divisao(6,2);
		Assertions.assertEquals(3, divresult);
	}

	@DisplayName("Teste de Divisão por Zero")
	@Test
	public void testeFuncDividirPorZeroComAssertThrows() {
		assertThrows(ArithmeticException.class,
				() -> calc.divisao(12, 0));
	}
	

	@DisplayName("Testar o somatório")
	@Test
	public void testFuncSomatorio() {
		int somatorio = calc.somatoria(3);
		Assertions.assertEquals(6, somatorio);
	}
	
	@DisplayName("Testar se o numero é positivo")
	@Test
	public void testFuncEhPositivo() {
		boolean positivo = calc.ehPositivo(10);		
		assertTrue(positivo);
	}
	
	@DisplayName("Comparação de dois números - IGUAIS - MAIOR - MENOR")
	@Test
	public void testFuncComparaNumeros() {
		int compara = calc.compara(2, 2);
		assertTrue(compara == 0);
		int comparaMaior = calc.compara(3, 2);
		assertTrue(comparaMaior == 1);
		int comparaMenor = calc.compara(2, 3);
		assertTrue(comparaMenor == -1);
		
	}
	
	
}
