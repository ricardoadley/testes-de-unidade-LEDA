package testes;

import static org.junit.jupiter.api.Assertions.*;


import org.junit.jupiter.api.Test;


import problems.Floor;
import problems.FloorBinarySearchImpl;

class FloorBinarySearchImplTest {

	private Integer[] vetorTamPar = { 30, 28, 7, 29, 11, 26, 4, 22, 23, 31 };
	private Integer[] vetorTamImpar = { 6, 41, 32, 7, 26, 4, 37, 49, 11, 18, 36 };
	private Integer[] vetorVazio = {};
	private Integer[] vetorValoresRepetidos = { 4, 9, 3, 3, 0, 4, 0, 5, 1, 4 };
	private Integer[] vetorValoresIguais = { 6, 6, 6, 6, 6, 6 };

	public Floor implementation = new FloorBinarySearchImpl();
	
	public void genericTest(Integer[] array, int x, int resultadoEsperado) {
		if(array.length > 0 && array != null) {
			assertEquals(resultadoEsperado, implementation.floor(array, x));
		}else {
			assertEquals(null,implementation.floor(array, x));
		}
	}
	
	@Test
	void testBuscaEmVetorParValor5() {
		genericTest(vetorTamPar,5,4);
	}
	@Test
	void testBuscaEmVetorParValor4() {
		genericTest(vetorTamPar,4,4);
	}
	@Test
	void testBuscaEmVetorParValor24() {
		genericTest(vetorTamPar,24,23);
	}
	@Test
	void testBuscaEmVetorParValor10() {
		genericTest(vetorTamPar,10,7);
	}
	
	@Test
	void testBuscaEmVetorImparValor5() {
		genericTest(vetorTamImpar,5,4);
	}
	@Test
	void testBuscaEmVetorImparValor4() {
		genericTest(vetorTamImpar,4,4);
	}
	@Test
	void testBuscaEmVetorImparValor24() {
		genericTest(vetorTamImpar,24,18);
	}
	@Test
	void testBuscaEmVetorImparValor10() {
		genericTest(vetorTamImpar,10,7);
	}
	@Test
	void testBuscaEmVetorImparValor31() {
		genericTest(vetorTamImpar,31,26);
	}
	@Test
	void testBuscaEmVetorVazioValor10() {
		//o resultado é null
		genericTest(vetorVazio,10,10);
	}
	
	@Test
	void testBuscaEmVetorValoresRepetidosValor7() {
		genericTest(vetorValoresRepetidos,7,5);
	}
	@Test
	void testBuscaEmVetorValoresRepetidosValor4() {
		genericTest(vetorValoresRepetidos,4,4);
	}
	@Test
	void testBuscaEmVetorValoresRepetidosValor0() {
		genericTest(vetorValoresRepetidos,0,0);
	}
	@Test
	void testBuscaEmVetorValoresRepetidosValor10() {
		genericTest(vetorValoresRepetidos,10,9);
	}
	
	@Test
	void testBuscaEmVetorValoresIguaisValor7() {
		genericTest(vetorValoresIguais,7,6);
	}
	@Test
	void testBuscaEmVetorValoresIguaisValor6() {
		genericTest(vetorValoresIguais,6,6);
	}
	@Test
	void testBuscaEmVetorValoresIguaisValor10() {
		genericTest(vetorValoresIguais,10,6);
	}

}
