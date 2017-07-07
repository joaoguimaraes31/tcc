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
public class IDProdutoTest extends TestCase {

	private String str;
	private IDProduto obj;
	
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
	 * Constructor for IDProdutoTest.
	 * @param arg0
	 */
	public IDProdutoTest(String arg0) {
		super(arg0);
	}

	public final void testSetIDProduto() {
//		Atribui��o correta de Produto//
		IDProduto obj = new IDProduto();
		str="p123";
		assertEquals("Erro de Atribui��o de quantidade:", obj.setIDProduto(str), Codigo.OK);
		
		// Comprimento menor que o permitido
		str = "";
		assertEquals("Erro de N�O detec��o do comprimento m�nimo:", 
				obj.setIDProduto(str), Codigo.COMPRIMENTO_INVALIDO);
		
		// Comprimento maior que o permitido
		str = "p2893737912873817289 ";
		assertEquals("Erro de N�O detec��o do comprimento m�nimo:", 
				obj.setIDProduto(str), Codigo.COMPRIMENTO_INVALIDO);
		
		// Caracter inv�lido
		str = "pd345,.";
		assertEquals("Erro de N�O detec��o de caractere inv�lido:", 
				obj.setIDProduto(str), Codigo.CARACTER_INVALIDO);
		
	}

	public final void testGetIDProduto() {
		IDProduto obj = new IDProduto();
		str="p123";
		
		obj.setIDProduto(str);
		
//		 Valor lido igual a valor inserido
		assertEquals("Erro, valor lido n�o corresponde a valor inserido:", obj.getIDProduto(), str);
	}

}
