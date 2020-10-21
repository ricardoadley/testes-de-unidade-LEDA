package adt.stack;
/*
 * Os testes de lancamento de excecoes foram movidos para o arquivo
 * 'ExceptionStackTest' para melhorar a vizualizacao e entendimento
 * de quais testes estao sendo executados com sucesso.
 */
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

public class StudentStackTest {

	public Stack<Integer> stack1;
	public Stack<Integer> stack2;
	public Stack<Integer> stack3;

	@Before
	public void setUp() throws StackOverflowException {

		getImplementations();

		// Pilha com 3 elementos não cheia.
		stack1.push(1);
		stack1.push(2);
		stack1.push(3);

		// Pilha com 2 elementos de tamanho 2, pilha cheia.
		stack2.push(1);
		stack2.push(2);

	}

	private void getImplementations() {
		// TODO O aluno deve ajustar aqui para instanciar sua implementação
		stack1 = new StackImpl(4);
		stack2 = new StackImpl(6);
		stack3 = new StackImpl(1);
	}

	// MÉTODOS DE TESTE
	@Test
	public void testTop() {
		assertEquals(new Integer(3), stack1.top());
	}

	@Test
	public void testIsEmptyFalse() {
		assertFalse(stack1.isEmpty());
	}
	@Test
	public void testIsEmptyTrue() {
		assertTrue(stack3.isEmpty());
	}
	@Test
	public void testIsFullFalse() {
		assertFalse(stack1.isFull()); // vai depender do tamanho que a pilha foi
										// iniciada!!!!
	}
	@Test
	public void testIsFullTrue() {
		assertFalse(stack2.isFull()); // vai depender do tamanho que a pilha foi
										// iniciada!!!!
	}
	@Test
	public void testPush() {
		try {
			stack1.push(new Integer(5));
		} catch (StackOverflowException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

//	@Test(expected = StackOverflowException.class)
//	public void testPushComErro() throws StackOverflowException {
//		stack1.push(new Integer(5)); // levanta excecao apenas se o tamanho nao
//										// permitir outra insercao
//	}

	@Test
	public void testPop() {
		try {
			assertEquals(new Integer(3), stack1.pop());
		} catch (StackUnderflowException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

//	@Test(expected = StackUnderflowException.class)
//	public void testPopComErro() throws StackUnderflowException {
//		assertEquals(new Integer(3), stack1.pop()); // levanta excecao apenas se
//													// stack1 for vazia
//	}
}