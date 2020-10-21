package adt.stack;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

public class ExceptionStackTest {

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
//		stack2.push(1);
//		stack2.push(2);

	}

	private void getImplementations() {
		// TODO O aluno deve ajustar aqui para instanciar sua implementação
		stack1 = new StackImpl(3);
		stack2 = new StackImpl(6);
		stack3 = null;
	}

	// MÉTODOS DE TESTE
	@Test
	public void testPushPilhaCheia() {
		try {
			stack1.push(new Integer(5));
		} catch (StackOverflowException e) {
			// TODO Auto-generated catch block
			//e.printStackTrace();
		}
	}

	@Test
	public void testPopPilhaVazia() {
		try {
			assertEquals(new Integer(3), stack2.pop());
		} catch (StackUnderflowException e) {
			// TODO Auto-generated catch block
			//e.printStackTrace();
		}
	}
	@Test(expected = StackOverflowException.class)
	public void testPushComErro() throws StackOverflowException {
		stack1.push(new Integer(5)); // levanta excecao apenas se o tamanho nao
										// permitir outra insercao
	}
	@Test(expected = StackUnderflowException.class)
	public void testPopComErro() throws StackUnderflowException {
		stack1.pop();
		stack1.pop();
		stack1.pop();
		assertEquals(new Integer(3), stack1.pop()); // levanta excecao apenas se
													// stack1 for vazia
	}
}