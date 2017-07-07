/*
 * Created on 23/04/2005
 *
 * TODO To change the template for this generated file go to
 * Window - Preferences - Java - Code Style - Code Templates
 */
package entidades;

import junit.framework.TestCase;

/**
 * @author yury
 *
 * TODO To change the template for this generated type comment go to
 * Window - Preferences - Java - Code Style - Code Templates
 */
public class IDPedidoTest extends TestCase {

	private String str;
	private IDPedido obj;
	
	/*
	 * @see TestCase#setUp()
	 */
	protected void setUp() throws Exception {
		super.setUp();
	}

	/*
	 * @see TestCase#tearDown()
	 */
	protected void tearDown() throws Exception {
		super.tearDown();
	}

	/**
	 * Constructor for IDPedidoTest.
	 * @param arg0
	 */
	public IDPedidoTest(String arg0) {
		super(arg0);
	}

	public final void testSetIDPedido() {
		
//		Atribui��o correta de Pedido//
		IDPedido obj = new IDPedido();
		str="d123";
		assertEquals("Erro de Atribui��o de quantidade:", obj.setIDPedido(str), Codigo.OK);
		
		// Comprimento menor que o permitido
		str = "";
		assertEquals("Erro de N�O detec��o do comprimento m�nimo:", 
				obj.setIDPedido(str), Codigo.COMPRIMENTO_INVALIDO);
		
		// Comprimento maior que o permitido
		str = "d2893737912873817289 ";
		assertEquals("Erro de N�O detec��o do comprimento m�nimo:", 
				obj.setIDPedido(str), Codigo.COMPRIMENTO_INVALIDO);
		
		// Caracter inv�lido
		str = "qd345,.";
		assertEquals("Erro de N�O detec��o de caractere inv�lido:", 
				obj.setIDPedido(str), Codigo.CARACTER_INVALIDO);
		
	}

	public final void testGetIDPedido() {
		IDPedido obj = new IDPedido();
		str="d123";
		
		obj.setIDPedido(str);
		
//		 Valor lido igual a valor inserido
		assertEquals("Erro, valor lido n�o corresponde a valor inserido:", obj.getIDPedido(), str);
	}

}
