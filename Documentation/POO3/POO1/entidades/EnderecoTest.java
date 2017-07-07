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
public class EnderecoTest extends TestCase {

	private String str;
	private Endereco obj;
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
	 * Constructor for EnderecoTest.
	 * @param arg0
	 */
	public EnderecoTest(String arg0) {
		super(arg0);
	}

	public final void testSetEndereco() {
//		Atribuição correta de Endereco//
		Endereco obj = new Endereco();
		str=" Um produto assim assado ";
		assertEquals("Erro de Atribuição de quantidade:", obj.setEndereco(str), Codigo.OK);
		
		// Comprimento menor que o permitido
		str = "";
		assertEquals("Erro de NÃO detecção do comprimento mínimo:", 
				obj.setEndereco(str), Codigo.COMPRIMENTO_INVALIDO);
		
		// Comprimento maior que o permitido
		str = "Um produto assim assado Um produto assim assado  Um produto assim assado  Um produto assim assado   ";
		assertEquals("Erro de NÃO detecção do comprimento mínimo:", 
				obj.setEndereco(str), Codigo.COMPRIMENTO_INVALIDO);
		
		
		
	}

	public final void testGetEndereco() {
	
		Endereco obj = new Endereco();
		str =" Um produto assim assado ";
		obj.setEndereco(str);
		
//		 Valor lido igual a valor inserido
		assertEquals("Erro, valor lido não corresponde a valor inserido:", obj.getEndereco(), str);
		
	}

}
