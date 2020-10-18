package testes;

import static org.junit.jupiter.api.Assertions.*;

import java.util.Arrays;

import org.junit.jupiter.api.Test;

import orderStatistic.KLargestOrderStatisticsImpl;

class KlargestOrderStatisticsImplsTest {

	private Integer[] vetorTamPar = { 30, 28, 7, 29, 11, 26, 4, 22, 23, 31 };
	private Integer[] vetorTamImpar = { 6, 41, 32, 7, 26, 4, 37, 49, 11, 18, 36 };
	private Integer[] vetorVazio = {};
	private Integer[] vetorValoresRepetidos = { 4, 9, 3, 3, 0, 4, 0, 5, 1, 4 };
	private Integer[] vetorValoresIguais = { 6, 6, 6, 6, 6, 6 };

	public KLargestOrderStatisticsImpl<Integer> implementation = new KLargestOrderStatisticsImpl<>();
	
	public void genericTest(Integer[] array, int k, String resultadoEsperado) {
		Integer [] copy1 = {};
		if(array.length > 0){
			copy1 = Arrays.copyOf(array, array.length);	
		}
		
		Arrays.sort(copy1);
		if(array.length > 0 && k > 0 && k <= array.length) {
			Integer[] saida = implementation.getKLargest(array, k);
			Arrays.sort(saida);
			assertEquals(resultadoEsperado, Arrays.toString(saida));
		}else
			assertEquals("[]",Arrays.toString( implementation.getKLargest(array, k)));
	}
	@Test
	void testVetorTamanhoParNegativoMaioresElementos() {
		genericTest(vetorTamPar,-2,"[]");
	}
	@Test
	void testVetorTamanhoPar7MaioresElementos() {
		genericTest(vetorTamPar,7,"[22, 23, 26, 28, 29, 30, 31]");
	}
	@Test
	void testVetorTamanhoPar11MaioresElementos() {
		genericTest(vetorTamPar,11,"[]");
	}
	@Test
	void testVetorTamanhoPar4MaioresElementos() {
		genericTest(vetorTamPar,4,"[28, 29, 30, 31]");
	}
	@Test
	void testVetorTamanhoPar3MaioresElementos() {
		genericTest(vetorTamPar,3,"[29, 30, 31]");
	}
	@Test
	void testVetorTamanhoPar2MaioresElementos() {
		genericTest(vetorTamPar,2,"[30, 31]");
	}
	@Test
	void testVetorTamanhoParMaiorElemento() {
		genericTest(vetorTamPar,1,"[31]");
	}
	@Test
	void testVetorTamanhoImparNegativoMaioresElementos() {
		genericTest(vetorTamImpar,-2,"[]");
	}
	@Test
	void testVetorTamanhoImpar7MaioresElementos() {
		genericTest(vetorTamImpar,7,"[18, 26, 32, 36, 37, 41, 49]");
	}
	@Test
	void testVetorTamanhoImpar12MaioresElementos() {
		genericTest(vetorTamImpar,12,"[]");
	}
	@Test
	void testVetorTamanhoImpar4MaioresElementos() {
		genericTest(vetorTamImpar,4,"[36, 37, 41, 49]");
	}
	@Test
	void testVetorTamanhoImpar2MaioresElementos() {
		genericTest(vetorTamImpar,2,"[41, 49]");
	}
	@Test
	void testVetorTamanhoImparMaiorElemento() {
		genericTest(vetorTamImpar,1,"[49]");
	}
	@Test
	void testVetorVazio() {
		genericTest(vetorVazio,3,"");
	}
	@Test
	void testVetorValoresRepetidos4MaioresElementos() {
		genericTest(vetorValoresRepetidos,4,"[4, 4, 5, 9]");
	}
	@Test
	void testVetorValoresRepetidos2MaioresElementos() {
		genericTest(vetorValoresRepetidos,2,"[5, 9]");
	}
	@Test
	void testVetorValoresRepetidosMaioresElemento() {
		genericTest(vetorValoresRepetidos,1,"[9]");
	}
	@Test
	void testVetorValoresIguais4MaioresElementos() {
		genericTest(vetorValoresIguais,4,"[6, 6, 6, 6]");
	}
}
