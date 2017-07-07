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
public class PrecoTest extends TestCase {

	private String str;
	private Preco obj;
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
	 * Constructor for PreçoTest.
	 * @param arg0
	 */
	public PrecoTest(String arg0) {
		super(arg0);
	}

	public final void testSetPreco() {
//		Atribuição correta de preço//
		Preco obj = new Preco();
		str="12.3";
		assertEquals("Erro de Atribuição de quantidade:", obj.setPreco(str), Codigo.OK);
		
		// Comprimento menor que o permitido
		str = "";
		assertEquals("Erro de NÃO detecção do comprimento mínimo:", 
				obj.setPreco(str), Codigo.COMPRIMENTO_INVALIDO);
		
		//Comprimento menor que o permitido
		str = "23456.76666666";
		assertEquals("Erro de NÃO detecção do comprimento máximo:", 
				obj.setPreco(str), Codigo.COMPRIMENTO_INVALIDO);
		
		// Caracter inválido
		str = "345,.3";
		assertEquals("Erro de NÃO detecção de caractere inválido:", 
				obj.setPreco(str), Codigo.CARACTER_INVALIDO);
		
		// Formato inválido
		str = "4..5";
		assertEquals("Erro de NÃO detecção de formato inválido:", 
				obj.setPreco(str), Codigo.FORMATO_INVALIDO); 
}

	public final void testGetPreco() {
		Preco obj = new Preco();
		str="12.3";
		obj.setPreco(str);
		
		// Valor lido igual a valor inserido
		assertEquals("Erro, valor lido não corresponde a valor inserido:", obj.getPreco(), str);
		
	}

}
