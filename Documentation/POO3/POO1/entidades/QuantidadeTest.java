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
public class QuantidadeTest extends TestCase {

	 private String str;
	 private Quantidade obj;

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
	 * Constructor for QuantidadeTest.
	 * @param arg0
	 */
	public QuantidadeTest(String arg0) {
		super(arg0);
	}

	public final void testSetQuantidade() {
		
		//Atribuição correta de quantidade//
		Quantidade obj = new Quantidade();
		str="123";
		assertEquals("Erro de Atribuição de quantidade:", obj.setQuantidade(str), Codigo.OK);
		
		// Comprimento menor que o permitido
		str = "";
		assertEquals("Erro de NÃO detecção do comprimento mínimo:", 
				obj.setQuantidade(str), Codigo.COMPRIMENTO_INVALIDO);
		
		// Valor maior que o permitido
		str = "9234599";
		assertEquals("Erro de NÃO detecção do limite máximo:", 
				obj.setQuantidade(str), Codigo.NUMERO_MUITO_GRANDE);
		
		// Caracter inválido
		str = "qd345,.";
		assertEquals("Erro de NÃO detecção de caractere inválido:", 
				obj.setQuantidade(str), Codigo.CARACTER_INVALIDO);
	}
	

	public final void testGetQuantidade() {
		Quantidade obj = new Quantidade();
		str="123";
		obj.setQuantidade(str);
		
		// Valor lido igual a valor inserido
		assertEquals("Erro, valor lido não corresponde a valor inserido:", obj.getQuantidade(), str);
		
		
	}


}
