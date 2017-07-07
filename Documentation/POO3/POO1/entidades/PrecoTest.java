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
	 * Constructor for Pre�oTest.
	 * @param arg0
	 */
	public PrecoTest(String arg0) {
		super(arg0);
	}

	public final void testSetPreco() {
//		Atribui��o correta de pre�o//
		Preco obj = new Preco();
		str="12.3";
		assertEquals("Erro de Atribui��o de quantidade:", obj.setPreco(str), Codigo.OK);
		
		// Comprimento menor que o permitido
		str = "";
		assertEquals("Erro de N�O detec��o do comprimento m�nimo:", 
				obj.setPreco(str), Codigo.COMPRIMENTO_INVALIDO);
		
		//Comprimento menor que o permitido
		str = "23456.76666666";
		assertEquals("Erro de N�O detec��o do comprimento m�ximo:", 
				obj.setPreco(str), Codigo.COMPRIMENTO_INVALIDO);
		
		// Caracter inv�lido
		str = "345,.3";
		assertEquals("Erro de N�O detec��o de caractere inv�lido:", 
				obj.setPreco(str), Codigo.CARACTER_INVALIDO);
		
		// Formato inv�lido
		str = "4..5";
		assertEquals("Erro de N�O detec��o de formato inv�lido:", 
				obj.setPreco(str), Codigo.FORMATO_INVALIDO); 
}

	public final void testGetPreco() {
		Preco obj = new Preco();
		str="12.3";
		obj.setPreco(str);
		
		// Valor lido igual a valor inserido
		assertEquals("Erro, valor lido n�o corresponde a valor inserido:", obj.getPreco(), str);
		
	}

}
