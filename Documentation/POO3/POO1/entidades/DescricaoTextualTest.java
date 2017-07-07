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
public class DescricaoTextualTest extends TestCase {

	private String str;
	private DescricaoTextual obj;
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
	 * Constructor for Descri��oTextualTest.
	 * @param arg0
	 */
	public DescricaoTextualTest(String arg0) {
		super(arg0);
	}

	public final void testSetDescricaoTextual() {
		
		//Atribui��o correta de Descri��o Textual//
		DescricaoTextual obj = new DescricaoTextual();
		str=" Um produto assim assado ";
		assertEquals("Erro de Atribui��o de quantidade:",obj.setDescricaoTextual(str), Codigo.OK);
		
		// Comprimento menor que o permitido
		str = "";
		assertEquals("Erro de N�O detec��o do comprimento m�nimo:", 
				obj.setDescricaoTextual(str), Codigo.COMPRIMENTO_INVALIDO);
		
		// Comprimento maior que o permitido
		str = "Um produto assim assado Um produto assim assado  Um produto assim assado  Um produto assim assado   ";
		assertEquals("Erro de N�O detec��o do comprimento m�nimo:", 
				obj.setDescricaoTextual(str), Codigo.COMPRIMENTO_INVALIDO);
		
	}

	public final void testGetDescricaoTextual() {
		
		DescricaoTextual obj = new DescricaoTextual();
		str=" Um produto assim assado ";
		obj.setDescricaoTextual(str);
		
//		 Valor lido igual a valor inserido
		assertEquals("Erro, valor lido n�o corresponde a valor inserido:", obj.getDescricaoTextual(), str);
		
	}

}
